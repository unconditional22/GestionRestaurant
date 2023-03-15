/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.EmployeeDao;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Employee;

/**
 *
 * @author kabor
 */
public class EmployeeServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        EmployeeDao empdao = new EmployeeDao();
        
        if(request.getParameter("enregistrer")!=null){
            String usernameEmp = request.getParameter("usernameEmp");
            String passwordEmp = request.getParameter("passwordEmp");
            String profileEmp = request.getParameter("profileEmp");
            
            Employee emp = new Employee(usernameEmp, passwordEmp, profileEmp);
            empdao.enregistrer(emp);
            response.sendRedirect(request.getContextPath()+"/vue/liste_employee.jsp");
        }
        
        //supprimer
        if(request.getParameter("ids")!=null) {
            int idEmp = Integer.parseInt(request.getParameter("ids"));
            Employee emp = new Employee();
            emp.setIdEmp(idEmp);
            empdao.supprimer(emp);
            response.sendRedirect(request.getContextPath()+"/vue/liste_employee.jsp");
        }
        
        //modifier
        if(request.getParameter("idm")!=null) {
            int idEmp = Integer.parseInt(request.getParameter("idm"));
            Employee emp = empdao.recherche(idEmp);
            request.setAttribute("employee", emp);
            request.getRequestDispatcher("/vue/employee.jsp").forward(request, response);
        }
        
        if(request.getParameter("modifier")!=null){
            int idEmp = Integer.parseInt(request.getParameter("idEmp"));
            String usernameEmp = request.getParameter("usernameEmp");
            String passwordEmp = request.getParameter("passwordEmp");
            String profileEmp = request.getParameter("profileEmp");
            
            Employee emp = new Employee(usernameEmp, passwordEmp, profileEmp);
            empdao.modifier(emp, idEmp);
            response.sendRedirect(request.getContextPath()+"/vue/liste_employee.jsp");
        }
        
        //Connexion
       if(request.getParameter("connexion")!=null){
        String usernameEmp = request.getParameter("usernameEmp");
        String passwordEmp = request.getParameter("passwordEmp");
        boolean b = empdao.connexion(usernameEmp, passwordEmp);
        if(b==true){
            response.sendRedirect(request.getContextPath()+"/vue/liste_employee.jsp");
        }
        else{
            response.sendRedirect(request.getContextPath()+"index.jsp");
        }
    }
       
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
