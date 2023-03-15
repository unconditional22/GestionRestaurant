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
@Entity(name="vente")
@Table(name="vente")
public class Vente implements Serializable{
    @Id @GeneratedValue
    private int idVente;
    private Date dateVente;
    private int totalVente;
    private int idCommande;
    private int idMenu;
    private int idClient;

    public Vente() {
    }

    public Vente(int idVente, Date dateVente, int totalVente, int idCommande, int idMenu, int idClient) {
        this.idVente = idVente;
        this.dateVente = dateVente;
        this.totalVente = totalVente;
        this.idCommande = idCommande;
        this.idMenu = idMenu;
        this.idClient = idClient;
    }

    public Vente(Date dateVente, int totalVente, int idCommande, int idMenu, int idClient) {
        this.dateVente = dateVente;
        this.totalVente = totalVente;
        this.idCommande = idCommande;
        this.idMenu = idMenu;
        this.idClient = idClient;
    }

    public int getIdVente() {
        return idVente;
    }

    public void setIdVente(int idVente) {
        this.idVente = idVente;
    }

    public Date getDateVente() {
        return dateVente;
    }

    public void setDateVente(Date dateVente) {
        this.dateVente = dateVente;
    }

    public int getTotalVente() {
        return totalVente;
    }

    public void setTotalVente(int totalVente) {
        this.totalVente = totalVente;
    }

    public int getIdCommande() {
        return idCommande;
    }

    public void setIdCommande(int idCommande) {
        this.idCommande = idCommande;
    }

    public int getIdMenu() {
        return idMenu;
    }

    public void setIdMenu(int idMenu) {
        this.idMenu = idMenu;
    }

    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }
    
    
}
