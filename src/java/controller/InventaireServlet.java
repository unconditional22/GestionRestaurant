/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.InventaireDao;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Inventaire;

/**
 *
 * @author kabor
 */
public class InventaireServlet extends HttpServlet {

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
        InventaireDao invdao = new InventaireDao();
        
        if(request.getParameter("enregistrer")!=null){
            String nomInvent = request.getParameter("nomInvent");
            int niveauInvent = Integer.parseInt(request.getParameter("niveauInvent"));
            int minimumInvent = Integer.parseInt(request.getParameter("minimumInvent"));
            int provisionInvent = Integer.parseInt(request.getParameter("provisionInvent"));    
            String uniteInvent = request.getParameter("uniteInvent");
            
            Inventaire inv = new Inventaire(nomInvent, niveauInvent, minimumInvent, provisionInvent, uniteInvent);
            invdao.enregistrer(inv);
            response.sendRedirect(request.getContextPath()+"/vue/liste_inventaire.jsp");
        }
        
        //supprimer
        if(request.getParameter("ids")!=null) {
            int idInvent = Integer.parseInt(request.getParameter("ids"));
            Inventaire inv = new Inventaire();
            inv.setIdInvent(idInvent);
            invdao.supprimer(inv);
            response.sendRedirect(request.getContextPath()+"/vue/liste_inventaire.jsp");
        }
        
        //modifier
        if(request.getParameter("idm")!=null) {
            int idInvent = Integer.parseInt(request.getParameter("idm"));
            Inventaire inv = invdao.recherche(idInvent);
            request.setAttribute("inventaire", inv);
            request.getRequestDispatcher("/vue/inventaire.jsp").forward(request, response);
        }
        
        if(request.getParameter("modifier")!=null){
            int idInvent = Integer.parseInt(request.getParameter("idInvent"));
            String nomInvent = request.getParameter("nomInvent");
            int niveauInvent = Integer.parseInt(request.getParameter("niveauInvent"));
            int minimumInvent = Integer.parseInt(request.getParameter("minimumInvent"));
            int provisionInvent = Integer.parseInt(request.getParameter("provisionInvent"));    
            String uniteInvent = request.getParameter("uniteInvent");
            
            Inventaire inv = new Inventaire(nomInvent, niveauInvent, minimumInvent, provisionInvent, uniteInvent);
            invdao.modifier(inv, idInvent);
            response.sendRedirect(request.getContextPath()+"/vue/liste_inventaire.jsp");
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
