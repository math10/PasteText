package com.math10.pastetext.service;

import java.util.List;

import com.math10.pastetext.model.PasteText;

public interface PasteTextService {
	PasteText findById(int id);

	PasteText findByName(String name);

	void savePasteText(PasteText pasteText);

	List<PasteText> findAllPasteText();

}
