/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.ArrayList;
import java.util.List;
import model.Menu;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author kabor
 */
public class MenuDao extends Dao<Menu>{

    @Override
    public Menu recherche(int id) {
        //recherche
	Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Menu menu = (Menu) session.get(Menu.class, id);
        transaction.commit();
        session.close();
        return menu;
    }

    @Override
    public void enregistrer(Menu men) {
        //enregistrer
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(men);
        transaction.commit();
        session.close();
    }

    @Override
    public void modifier(Menu men, int id) {
         //update
	Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Menu mens = (Menu) session.load(Menu.class, id);
        mens.setNomMenu(men.getNomMenu());
        mens.setPrixMenu(men.getPrixMenu());
        mens.setIdCat(men.getIdCat());
        session.update(mens);
        transaction.commit();
        session.close();
    }

    @Override
    public void supprimer(Menu men) {
        //delete
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(men);
        transaction.commit();
        session.close();
    }

    @Override
    public List<Menu> liste() {
        //liste
	 List<Menu> listmen = new ArrayList();
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query query = session.createQuery("from menu");
        listmen = query.list();
        return listmen;
    }
    
}
