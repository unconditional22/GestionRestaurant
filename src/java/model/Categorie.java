/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author kabor
 */
@Entity(name="categorie")
@Table(name="categorie")
public class Categorie implements Serializable{
    @Id @GeneratedValue
    private int idCat;
    private String nomCat;

    public Categorie() {
    }

    public Categorie(int idCat, String nomCat) {
        this.idCat = idCat;
        this.nomCat = nomCat;
    }

    public Categorie(String nomCat) {
        this.nomCat = nomCat;
    }

    public int getIdCat() {
        return idCat;
    }

    public void setIdCat(int idCat) {
        this.idCat = idCat;
    }

    public String getNomCat() {
        return nomCat;
    }

    public void setNomCat(String nomCat) {
        this.nomCat = nomCat;
    }
    
    
}
