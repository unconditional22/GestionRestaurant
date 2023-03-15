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
@Entity(name="employee")
@Table(name="employee")
public class Employee implements Serializable{
    @Id @GeneratedValue
    private int idEmp;
    private String usernameEmp;
    private String passwordEmp;
    private String profileEmp;

    public Employee() {
    }

    public Employee(int idEmp, String usernameEmp, String passwordEmp, String profileEmp) {
        this.idEmp = idEmp;
        this.usernameEmp = usernameEmp;
        this.passwordEmp = passwordEmp;
        this.profileEmp = profileEmp;
    }

    public Employee(String usernameEmp, String passwordEmp, String profileEmp) {
        this.usernameEmp = usernameEmp;
        this.passwordEmp = passwordEmp;
        this.profileEmp = profileEmp;
    }

    public int getIdEmp() {
        return idEmp;
    }

    public void setIdEmp(int idEmp) {
        this.idEmp = idEmp;
    }

    public String getUsernameEmp() {
        return usernameEmp;
    }

    public void setUsernameEmp(String usernameEmp) {
        this.usernameEmp = usernameEmp;
    }

    public String getPasswordEmp() {
        return passwordEmp;
    }

    public void setPasswordEmp(String passwordEmp) {
        this.passwordEmp = passwordEmp;
    }

    public String getProfileEmp() {
        return profileEmp;
    }

    public void setProfileEmp(String profileEmp) {
        this.profileEmp = profileEmp;
    }
    
    
}
