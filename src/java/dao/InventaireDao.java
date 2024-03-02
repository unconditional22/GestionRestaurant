/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.ArrayList;
import java.util.List;
import model.Inventaire;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author kabor
 */
public class InventaireDao extends Dao<Inventaire>{

    @Override
    public Inventaire recherche(int id) {
         //recherche
	Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Inventaire inventaire = (Inventaire) session.get(Inventaire.class, id);
        transaction.commit();
        session.close();
        return inventaire;
    }

    @Override
    public void enregistrer(Inventaire inv) {
        //enregistrer
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(inv);
        transaction.commit();
        session.close();
    }

    @Override
    public void modifier(Inventaire inv, int id) {
        //update
	Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Inventaire invs = (Inventaire) session.load(Inventaire.class, id);
        invs.setNomInvent(inv.getNomInvent());
        invs.setNiveauInvent(inv.getNiveauInvent());
        invs.setMinimumInvent(inv.getMinimumInvent());
        invs.setProvisionInvent(inv.getProvisionInvent());
        invs.setUniteInvent(inv.getUniteInvent());
        session.update(invs);
        transaction.commit();
        session.close();
    }

    @Override
    public void supprimer(Inventaire inv) {
        //delete
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(inv);
        transaction.commit();
        session.close();
    }


    @Override
    public List<Inventaire> liste() {
        //liste
	 List<Inventaire> listinv = new ArrayList();
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query query = session.createQuery("from inventaire");
        listinv = query.list();
        return listinv;
    }
    
        /*public Inventaire getIngredientById(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("from nomInvent where idInvent=:id");
        query.setParameter("id", id);
        Inventaire ingredient = (Inventaire) query.uniqueResult();
        transaction.commit();
        session.close();
        return ingredient;
        }*/
        
        public String getIngredientNameById(int id) {
    Session session = HibernateUtil.getSessionFactory().openSession();
    Transaction transaction = session.beginTransaction();
    Query query = session.createQuery("select nomInvent from Inventaire where idInvent=:id");
    query.setParameter("id", id);
    String ingredientName = (String) query.uniqueResult();
    transaction.commit();
    session.close();
    return ingredientName;
}

}
