package com.math10.pastetext.dao.implementation;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.math10.pastetext.dao.AbstractDao;
import com.math10.pastetext.dao.interfaces.PasteTextDao;
import com.math10.pastetext.model.PasteText;

@Repository("pasteTextRepository")
public class PasteTextDaoImp extends AbstractDao implements PasteTextDao {

	public void save(PasteText pasteText) {
		Session session = getOpenSession();
		Transaction transaction = session.beginTransaction();
		session.save(pasteText);
		transaction.commit();
		session.close();
	}

	public void update(PasteText pasteText) {
		getSession().update(pasteText);
	}

	public void delete(PasteText pasteText) {

	}

	public PasteText findByPasteTextId(String id) {
		Criteria criteria = getSession().createCriteria(PasteText.class);
		criteria.add(Restrictions.eq("id", Integer.parseInt(id)));
		return (PasteText) criteria.uniqueResult();
	}

	public List<PasteText> findAll() {
		Criteria criteria = getSession().createCriteria(PasteText.class);
		return (List<PasteText>) criteria.list();
	}

	public Integer findMaxId() {
		// TODO Auto-generated method stub
		Criteria criteria = getSession().createCriteria(PasteText.class);
		criteria.setProjection(Projections.max("id"));
		return (Integer) criteria.uniqueResult();
	}

}
