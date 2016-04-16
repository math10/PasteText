package com.math10.pastetext.dao.interfaces;

import java.util.List;

import com.math10.pastetext.model.PasteText;

public interface PasteTextDao {
	void save(PasteText pasteText);
	void update(PasteText pasteText);
	void delete(PasteText pasteText);
	PasteText findByPasteTextId(String id);
	List<PasteText> findAll();
	Integer findMaxId();
}
