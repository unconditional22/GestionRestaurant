/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author kabor
 */

@Entity(name="commande")
@Table(name="commande")
public class Commande implements Serializable{
   @Id @GeneratedValue
   private int idCommande;
   private Date dateCommande;
   private int quantiteCommande;
   private int totalCommande;
   private int idClient;
   private int idMenu;

    public Commande() {
    }

    public Commande(int idCommande, Date dateCommande, int quantiteCommande, int totalCommande, int idClient, int idMenu) {
        this.idCommande = idCommande;
        this.dateCommande = dateCommande;
        this.quantiteCommande = quantiteCommande;
        this.totalCommande = totalCommande;
        this.idClient = idClient;
        this.idMenu = idMenu;
    }

    public Commande(Date dateCommande, int quantiteCommande, int totalCommande, int idClient, int idMenu) {
        this.dateCommande = dateCommande;
        this.quantiteCommande = quantiteCommande;
        this.totalCommande = totalCommande;
        this.idClient = idClient;
        this.idMenu = idMenu;
    }

    public int getIdCommande() {
        return idCommande;
    }

    public void setIdCommande(int idCommande) {
        this.idCommande = idCommande;
    }

    public Date getDateCommande() {
        return dateCommande;
    }

    public void setDateCommande(Date dateCommande) {
        this.dateCommande = dateCommande;
    }

    public int getQuantiteCommande() {
        return quantiteCommande;
    }

    public void setQuantiteCommande(int quantiteCommande) {
        this.quantiteCommande = quantiteCommande;
    }

    public int getTotalCommande() {
        return totalCommande;
    }

    public void setTotalCommande(int totalCommande) {
        this.totalCommande = totalCommande;
    }

    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    public int getIdMenu() {
        return idMenu;
    }

    public void setIdMenu(int idMenu) {
        this.idMenu = idMenu;
    }

    
   
   
}
