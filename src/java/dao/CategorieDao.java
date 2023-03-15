/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.ArrayList;
import java.util.List;
import model.Categorie;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author kabor
 */
public class CategorieDao extends Dao<Categorie>{

    @Override
    public Categorie recherche(int id) {
        //recherche
	Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Categorie categorie = (Categorie) session.get(Categorie.class, id);
        transaction.commit();
        session.close();
        return categorie;
    }

    @Override
    public void enregistrer(Categorie cat) {
        //enregistrer
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(cat);
        transaction.commit();
        session.close();
    }

    @Override
    public void modifier(Categorie cat, int id) {
        //update
	Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Categorie cats = (Categorie) session.load(Categorie.class, id);
        cats.setNomCat(cat.getNomCat());
        session.update(cats);
        transaction.commit();
        session.close();
    }

    @Override
    public void supprimer(Categorie cat) {
        //delete
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(cat);
        transaction.commit();
        session.close();
    }

    @Override
    public List<Categorie> liste() {
        //liste
	 List<Categorie> listcats = new ArrayList();
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query query = session.createQuery("from categorie");
        listcats = query.list();
        return listcats;
    }
    
}
