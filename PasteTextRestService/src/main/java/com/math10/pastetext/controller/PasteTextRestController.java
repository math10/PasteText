package com.math10.pastetext.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.math10.pastetext.bo.interfaces.PasteTextBo;
import com.math10.pastetext.model.PasteText;

@RestController
public class PasteTextRestController {

	@Autowired(required = true)
	@Qualifier("pasteTextBo")
	PasteTextBo pasteTextBo;
	// -------------------Retrieve All
	// pasteTexts--------------------------------------------------------

	@RequestMapping(value = "/text/", method = RequestMethod.GET)
	public ResponseEntity<List<PasteText>> listAllpasteTexts() {
		System.out.println("Text");
		List<PasteText> pasteTexts = pasteTextBo.findAll();
		if (pasteTexts == null) {
			return new ResponseEntity<List<PasteText>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<PasteText>>(pasteTexts, HttpStatus.OK);
	}

	@RequestMapping(value = "/text/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<PasteText> getPasteText(@PathVariable("id") long id) {
		System.out.println("Fetching Text with id " + id);
		PasteText pasteText = pasteTextBo.findByPasteTextId(String.valueOf(id));
		if (pasteText == null) {
			System.out.println("User with id " + id + " not found");
			return new ResponseEntity<PasteText>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<PasteText>(pasteText, HttpStatus.OK);
	}

	// -------------------Create a
	// User--------------------------------------------------------

	@RequestMapping(value = "/text/", method = RequestMethod.POST)
	public ResponseEntity<PasteText> createPasteText(@RequestBody PasteText pasteText, UriComponentsBuilder ucBuilder) {
		System.out.println("Creating Text " + pasteText.getUserName());
		pasteTextBo.save(pasteText);
		pasteText.setId(pasteTextBo.findMaxId());

		// HttpHeaders headers = new HttpHeaders();
		// headers.setLocation(ucBuilder.path("/text/{id}").buildAndExpand(pasteText.getId()).toUri());
		return getPasteText(pasteText.getId());
	}

}
