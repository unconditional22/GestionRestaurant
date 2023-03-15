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
@Entity(name="menu")
@Table(name="menu")
public class Menu implements Serializable{
    @Id @GeneratedValue
    private int idMenu;
    private String nomMenu;
    private float prixMenu;
    private int idCat;

    public Menu() {
    }

    public Menu(int idMenu, String nomMenu, float prixMenu, int idCat) {
        this.idMenu = idMenu;
        this.nomMenu = nomMenu;
        this.prixMenu = prixMenu;
        this.idCat = idCat;
    }

    public Menu(String nomMenu, float prixMenu, int idCat) {
        this.nomMenu = nomMenu;
        this.prixMenu = prixMenu;
        this.idCat = idCat;
    }

    public int getIdMenu() {
        return idMenu;
    }

    public void setIdMenu(int idMenu) {
        this.idMenu = idMenu;
    }

    public String getNomMenu() {
        return nomMenu;
    }

    public void setNomMenu(String nomMenu) {
        this.nomMenu = nomMenu;
    }

    public float getPrixMenu() {
        return prixMenu;
    }

    public void setPrixMenu(float prixMenu) {
        this.prixMenu = prixMenu;
    }

    public int getIdCat() {
        return idCat;
    }

    public void setIdCat(int idCat) {
        this.idCat = idCat;
    }
    
    
}
