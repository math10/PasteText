package com.math10.pastetext.bo.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.math10.pastetext.bo.interfaces.PasteTextBo;
import com.math10.pastetext.dao.interfaces.PasteTextDao;
import com.math10.pastetext.model.PasteText;

@Service("pasteTextBo")
@Transactional
public class PasteTextBoImp implements PasteTextBo {
	
	@Autowired(required=true)
	@Qualifier("pasteTextRepository")
	PasteTextDao pasteTextDao;
	
	public void setStockDao(PasteTextDao pasteTextDao) {
		this.pasteTextDao = pasteTextDao;
	}

	public void save(PasteText pasteText){
		pasteTextDao.save(pasteText);
	}
	
	public void update(PasteText pasteText){
		pasteTextDao.update(pasteText);
	}
	
	public void delete(PasteText pasteText){
		pasteTextDao.delete(pasteText);
	}
	
	public PasteText findByPasteTextId(String id){
		return pasteTextDao.findByPasteTextId(id);
	}

	public List<PasteText> findAll() {
		// TODO Auto-generated method stub
		return pasteTextDao.findAll();
	}

	public Integer findMaxId() {
		// TODO Auto-generated method stub
		return pasteTextDao.findMaxId();
	}
}
