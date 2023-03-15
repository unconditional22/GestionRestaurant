/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.ArrayList;
import java.util.List;
import model.Vente;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author kabor
 */
public class VenteDao extends Dao<Vente>{

    @Override
    public Vente recherche(int id) {
        //recherche
	Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Vente vente = (Vente) session.get(Vente.class, id);
        transaction.commit();
        session.close();
        return vente;
    }

    @Override
    public void enregistrer(Vente vnt) {
         //enregistrer
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(vnt);
        transaction.commit();
        session.close();
    }

    @Override
    public void modifier(Vente vnt, int id) {
        //update
	Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Vente vnts = (Vente) session.load(Vente.class, id);
        vnts.setDateVente(vnt.getDateVente());
        vnts.setTotalVente(vnt.getTotalVente());
        vnts.setIdCommande(vnt.getIdCommande());
        vnts.setIdMenu(vnt.getIdMenu());
        vnts.setIdClient(vnt.getIdClient());
        session.update(vnts);
        transaction.commit();
        session.close();
    }

    @Override
    public void supprimer(Vente vnt) {
        //delete
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(vnt);
        transaction.commit();
        session.close();
    }

    @Override
    public List<Vente> liste() {
        //liste
	 List<Vente> listvnt = new ArrayList();
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query query = session.createQuery("from vente");
        listvnt = query.list();
        return listvnt;
    }
    
}
