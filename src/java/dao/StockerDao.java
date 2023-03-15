/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.ArrayList;
import java.util.List;
import model.Stocker;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author kabor
 */
public class StockerDao extends Dao<Stocker>{

    @Override
    public Stocker recherche(int id) {
        //recherche
	Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Stocker stocker = (Stocker) session.get(Stocker.class, id);
        transaction.commit();
        session.close();
        return stocker;
    }

    @Override
    public void enregistrer(Stocker stk) {
        //enregistrer
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(stk);
        transaction.commit();
        session.close();
    }

    @Override
    public void modifier(Stocker stk, int id) {
        //update
	Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Stocker stks = (Stocker) session.load(Stocker.class, id);
        stks.setIdMenu(stk.getIdMenu());
        stks.setIdInvent(stk.getIdInvent());
        stks.setQuantiteStocker(stk.getQuantiteStocker());
        stks.setUniteStocker(stk.getUniteStocker());
        session.update(stks);
        transaction.commit();
        session.close();
    }

    @Override
    public void supprimer(Stocker stk) {
        //delete
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(stk);
        transaction.commit();
        session.close();
    }

    @Override
    public List<Stocker> liste() {
        //liste
	 List<Stocker> liststk = new ArrayList();
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query query = session.createQuery("from stocker");
        liststk = query.list();
        return liststk;
    }
    
}
