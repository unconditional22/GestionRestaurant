/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.ArrayList;
import java.util.List;
import model.Employee;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author kabor
 */
public class EmployeeDao extends Dao<Employee>{

    @Override
    public Employee recherche(int id) {
        //recherche
	Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Employee employee = (Employee) session.get(Employee.class, id);
        transaction.commit();
        session.close();
        return employee;
    }

    @Override
    public void enregistrer(Employee emp) {
        //enregistrer
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(emp);
        transaction.commit();
        session.close();
    }

    @Override
    public void modifier(Employee emp, int id) {
        //update
	Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Employee emps = (Employee) session.load(Employee.class, id);
        emps.setUsernameEmp(emp.getUsernameEmp());
        emps.setPasswordEmp(emp.getPasswordEmp());
        emps.setProfileEmp(emp.getProfileEmp());
        session.update(emps);
        transaction.commit();
        session.close();
    }

    @Override
    public void supprimer(Employee emp) {
        //delete
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(emp);
        transaction.commit();
        session.close();
    }

    @Override
    public List<Employee> liste() {
        //liste
	 List<Employee> listemp = new ArrayList();
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query query = session.createQuery("from employee");
        listemp = query.list();
        return listemp;
    }
    
    //Method Connexion
    /*public boolean connexion(String usernameEmp, String passwordEmp) {
        boolean b = false;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query query = session.createQuery("from employee where usernameEmp=:usernameEmp and passwordEmp=:passwordEmp");
        query.setParameter("usernameEmp", usernameEmp);
        query.setParameter("passwordEmp", passwordEmp);
        if(query.uniqueResult()!=null){
            b = true;
        }
        return b;
    }*/
    
    //Method Connexion
    public Employee connexion(String usernameEmp, String passwordEmp) {
        Employee b = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query query = session.createQuery("from employee where usernameEmp=:usernameEmp and passwordEmp=:passwordEmp");
        query.setParameter("usernameEmp", usernameEmp);
        query.setParameter("passwordEmp", passwordEmp);
        //query.setParameter("profileEmp", profileEmp);
        if(query.uniqueResult()!=null){
            b = (Employee) query.uniqueResult();
        }
        return b;
    }
    
}
