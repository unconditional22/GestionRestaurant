/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.ArrayList;
import java.util.List;
import model.Client;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author kabor
 */
public class ClientDao extends Dao<Client>{

    @Override
    public Client recherche(int id) {
        //recherche
	Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Client client = (Client) session.get(Client.class, id);
        transaction.commit();
        session.close();
        return client;
    }

    @Override
    public void enregistrer(Client cli) {
        //enregistrer
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(cli);
        transaction.commit();
        session.close();
    }

    @Override
    public void modifier(Client cli, int id) {
        //update
	Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Client clis = (Client) session.load(Client.class, id);
        clis.setNomClient(cli.getNomClient());
        clis.setPrenomClient(cli.getPrenomClient());
        clis.setEmailClient(cli.getEmailClient());
        clis.setTelClient(cli.getTelClient());
        clis.setVilleClient(cli.getVilleClient());
        session.update(clis);
        transaction.commit();
        session.close();
    }

    @Override
    public void supprimer(Client cli) {
        //delete
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(cli);
        transaction.commit();
        session.close();
    }

    @Override
    public List<Client> liste() {
         //liste
	 List<Client> listclis = new ArrayList();
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query query = session.createQuery("from client");
        listclis = query.list();
        return listclis;
    }
    
}
