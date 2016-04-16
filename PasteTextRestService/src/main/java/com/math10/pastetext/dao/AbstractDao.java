package com.math10.pastetext.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.math10.pastetext.model.PasteText;
 
public abstract class AbstractDao {
 
    @Autowired
    private SessionFactory sessionFactory;
 
    protected Session getSession() {
        return sessionFactory.getCurrentSession();
    }
    
    protected Session getOpenSession() {
        return sessionFactory.openSession();
    }
    
 
    public void persist(Object entity) {
        getSession().persist((PasteText)entity);
    }
 
    public void delete(Object entity) {
        getSession().delete(entity);
    }
}