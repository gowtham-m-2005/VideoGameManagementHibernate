package com.frostyFox.controller;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class GenericDAO<T> {
    public void save(SessionFactory sf, T entity){
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

        session.persist(entity);

        tx.commit();
        session.close();
    }

    public T find(SessionFactory sf, Class<T> entity, int index){
        Session session = sf.openSession();
        return session.find(entity, index);
    }
}
