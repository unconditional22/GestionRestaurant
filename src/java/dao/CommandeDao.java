/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.ArrayList;
import java.util.List;
import model.Commande;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author kabor
 */
public class CommandeDao extends Dao<Commande>{

    @Override
    public Commande recherche(int id) {
        //recherche
	Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Commande commande = (Commande) session.get(Commande.class, id);
        transaction.commit();
        session.close();
        return commande;
    }

    @Override
    public void enregistrer(Commande cmd) {
        //enregistrer
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(cmd);
        transaction.commit();
        session.close();
    }

    @Override
    public void modifier(Commande cmd, int id) {
        //update
	Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Commande cmds = (Commande) session.load(Commande.class, id);
        cmds.setDateCommande(cmd.getDateCommande());
        cmds.setQuantiteCommande(cmd.getQuantiteCommande());
        cmds.setTotalCommande(cmd.getTotalCommande());
        cmds.setIdClient(cmd.getIdClient());
        cmds.setIdMenu(cmd.getIdMenu());
        session.update(cmds);
        transaction.commit();
        session.close();
    }

    @Override
    public void supprimer(Commande cmd) {
        //delete
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(cmd);
        transaction.commit();
        session.close();
    }

    @Override
    public List<Commande> liste() {
        //liste
	 List<Commande> listcmd = new ArrayList();
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query query = session.createQuery("from commande");
        listcmd = query.list();
        return listcmd;
    }
    
}
