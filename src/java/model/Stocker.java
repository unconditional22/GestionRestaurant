/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author kabor
 */
@Entity(name="stocker")
@Table(name="stocker")
public class Stocker implements Serializable{
    @Id @GeneratedValue
    private int idStocker;
    private int idMenu;
    private int idInvent;
    private int quantiteStocker;
    private String uniteStocker;

    public Stocker() {
    }

    public Stocker(int idStocker, int idMenu, int idInvent, int quantiteStocker, String uniteStocker) {
        this.idStocker = idStocker;
        this.idMenu = idMenu;
        this.idInvent = idInvent;
        this.quantiteStocker = quantiteStocker;
        this.uniteStocker = uniteStocker;
    }

    public Stocker(int idMenu, int idInvent, int quantiteStocker, String uniteStocker) {
        this.idMenu = idMenu;
        this.idInvent = idInvent;
        this.quantiteStocker = quantiteStocker;
        this.uniteStocker = uniteStocker;
    }

    public int getIdStocker() {
        return idStocker;
    }

    public void setIdStocker(int idStocker) {
        this.idStocker = idStocker;
    }

    public int getIdMenu() {
        return idMenu;
    }

    public void setIdMenu(int idMenu) {
        this.idMenu = idMenu;
    }

    public int getIdInvent() {
        return idInvent;
    }

    public void setIdInvent(int idInvent) {
        this.idInvent = idInvent;
    }

    public int getQuantiteStocker() {
        return quantiteStocker;
    }

    public void setQuantiteStocker(int quantiteStocker) {
        this.quantiteStocker = quantiteStocker;
    }

    public String getUniteStocker() {
        return uniteStocker;
    }

    public void setUniteStocker(String uniteStocker) {
        this.uniteStocker = uniteStocker;
    }
    
    
}
