package com.frostyFox.controller;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class GenericDAO<T> {
    public void save(SessionFactory sf, T entity){

        Transaction tx = null;
        try (Session session = sf.openSession()) {
            tx = session.beginTransaction();
            session.persist(entity);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            throw new RuntimeException("Failed to save entity : " + e.getMessage(), e);
        }
    }

    public T find(SessionFactory sf, Class<T> entity, int index){
        Session session = null;
        try {
            session = sf.openSession();
        } catch (HibernateException e) {
            throw new RuntimeException("Failed to find entity with ID" + index + ":" + e.getMessage(),e);
        } finally {
            if (session!=null){
                session.close();
            }
        }
        return session.find(entity, index);
    }
}
