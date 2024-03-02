/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.ArrayList;
import java.util.List;
import model.Inventaire;
import model.Stocker;
import model.Menu;
import dao.MenuDao;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;


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

    
    
    /*public Stocker getStockerById(int id) {
    Session session = HibernateUtil.getSessionFactory().openSession();
    Transaction transaction = session.beginTransaction();
    Query query = session.createQuery("select s.quantiteStocker, s.uniteStocker, i.nomInvent from Stocker s join s.inventaire i where s.idStocker=:id");
    query.setParameter("id", id);
    Object[] result = (Object[]) query.uniqueResult();
    Stocker stocker = new Stocker();
    stocker.setIdStocker(id);
    stocker.setQuantiteStocker((Integer) result[0]);
    stocker.setUniteStocker((String) result[1]);
    Inventaire inventaire = new Inventaire();
    inventaire.setNomInvent((String) result[2]);
    stocker.setIdInvent((Integer) result[2]);
    transaction.commit();
    session.close();
    return stocker;
    }*/
    
    public Stocker getStockerById(int id) {
    Session session = HibernateUtil.getSessionFactory().openSession();
    Transaction transaction = session.beginTransaction();
    Query query = session.createQuery("select s from Stocker s join fetch s.inventaire i where s.idStocker=:id");
    query.setParameter("id", id);
    Stocker stocker = (Stocker) query.uniqueResult();
    transaction.commit();
    session.close();
    return stocker;
    }

    public List<Object[]> getStocks() {
    Session session = HibernateUtil.getSessionFactory().openSession();
    Transaction transaction = session.beginTransaction();
    Query query = session.createQuery("select s.idStocker, i.nomInvent, s.quantiteStocker, s.uniteStocker from Stocker s, Inventaire i where s.idInvent = i.idInvent");
    List<Object[]> stocks = query.list();
    transaction.commit();
    session.close();

    return stocks;
    }
    
}
