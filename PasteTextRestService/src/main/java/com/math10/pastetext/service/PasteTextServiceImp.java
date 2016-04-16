package com.math10.pastetext.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.math10.pastetext.model.PasteText;

@Service("pasteText")
@Transactional
public class PasteTextServiceImp implements PasteTextService{
	private static final AtomicLong counter = new AtomicLong();
	
	static List<PasteText>pasteTextList;
	
	static{
		pasteTextList = new ArrayList<PasteText>();
	}

	public PasteText findById(int id) {
		// TODO Auto-generated method stub
		for(PasteText x : pasteTextList){
			if(x.getId() == id){
				return x;
			}
		}
		return null;
	}

	public PasteText findByName(String name) {
		// TODO Auto-generated method stub
		for(PasteText x : pasteTextList){
			if(x.getUserName().equals(name)){
				return x;
			}
		}
		return null;
	}

	public void savePasteText(PasteText pasteText) {
		// TODO Auto-generated method stub
		//pasteText.setId(counter.incrementAndGet());
		pasteTextList.add(pasteText);
	}


	public List<PasteText> findAllPasteText() {
		// TODO Auto-generated method stub
		return pasteTextList;
	}
	

}
