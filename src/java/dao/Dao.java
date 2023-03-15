/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;

/**
 *
 * @author kabor
 */
public abstract class Dao<T> {
    
    //Recherche
    public abstract T recherche (int id);
    
    //Inserer
    public abstract void enregistrer (T obj);
    
    //Modifier
    public abstract void modifier (T obj, int id);
    
    //Supprimer
    public abstract void supprimer (T obj);
    
    //liste
    public abstract List<T>liste();
    
}
