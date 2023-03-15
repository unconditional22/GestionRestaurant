/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.CategorieDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Categorie;

/**
 *
 * @author kabor
 */
public class CategorieServlet extends HttpServlet {

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
        
        CategorieDao catdao = new CategorieDao();
        
        if(request.getParameter("enregistrer")!=null){
            String nomCat = request.getParameter("nomCat");
            
            Categorie cat = new Categorie(nomCat);
            catdao.enregistrer(cat);
            response.sendRedirect(request.getContextPath()+"/vue/liste_categorie.jsp");
        }
        
        //supprimer
        if(request.getParameter("ids")!=null) {
            int idCat = Integer.parseInt(request.getParameter("ids"));
            Categorie cat = new Categorie();
            cat.setIdCat(idCat);
            catdao.supprimer(cat);
            response.sendRedirect(request.getContextPath()+"/vue/liste_categorie.jsp");
        }
        
        //modifier
        if(request.getParameter("idm")!=null) {
            int idCat = Integer.parseInt(request.getParameter("idm"));
            Categorie cat = catdao.recherche(idCat);
            request.setAttribute("categorie", cat);
            request.getRequestDispatcher("/vue/categorie.jsp").forward(request, response);
        }
        
        if(request.getParameter("modifier")!=null){
            int idCat = Integer.parseInt(request.getParameter("idCat"));
            String nomCat = request.getParameter("nomCat");
            
            Categorie cat = new Categorie(nomCat);
            catdao.modifier(cat, idCat);
            response.sendRedirect(request.getContextPath()+"/vue/liste_categorie.jsp");
        }
        
        //liste des categories
        List<Categorie> categories = catdao.liste();
        request.setAttribute("categories", categories);
        request.getRequestDispatcher("/vue/liste_categorie.jsp").forward(request, response);


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
     * Returns a short description of the servlcat.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
