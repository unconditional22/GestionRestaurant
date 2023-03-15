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
@Entity(name="inventaire")
@Table(name="inventaire")
public class Inventaire implements Serializable{
   @Id @GeneratedValue
   private int idInvent;
   private String nomInvent;
   private int niveauInvent;
   private int minimumInvent;
   private int provisionInvent;
   private String uniteInvent;

    public Inventaire() {
    }

    public Inventaire(int idInvent, String nomInvent, int niveauInvent, int minimumInvent, int provisionInvent, String uniteInvent) {
        this.idInvent = idInvent;
        this.nomInvent = nomInvent;
        this.niveauInvent = niveauInvent;
        this.minimumInvent = minimumInvent;
        this.provisionInvent = provisionInvent;
        this.uniteInvent = uniteInvent;
    }

    public Inventaire(String nomInvent, int niveauInvent, int minimumInvent, int provisionInvent, String uniteInvent) {
        this.nomInvent = nomInvent;
        this.niveauInvent = niveauInvent;
        this.minimumInvent = minimumInvent;
        this.provisionInvent = provisionInvent;
        this.uniteInvent = uniteInvent;
    }

    public int getIdInvent() {
        return idInvent;
    }

    public void setIdInvent(int idInvent) {
        this.idInvent = idInvent;
    }

    public String getNomInvent() {
        return nomInvent;
    }

    public void setNomInvent(String nomInvent) {
        this.nomInvent = nomInvent;
    }

    public int getNiveauInvent() {
        return niveauInvent;
    }

    public void setNiveauInvent(int niveauInvent) {
        this.niveauInvent = niveauInvent;
    }

    public int getMinimumInvent() {
        return minimumInvent;
    }

    public void setMinimumInvent(int minimumInvent) {
        this.minimumInvent = minimumInvent;
    }

    public int getProvisionInvent() {
        return provisionInvent;
    }

    public void setProvisionInvent(int provisionInvent) {
        this.provisionInvent = provisionInvent;
    }

    public String getUniteInvent() {
        return uniteInvent;
    }

    public void setUniteInvent(String uniteInvent) {
        this.uniteInvent = uniteInvent;
    }

    
   
}
