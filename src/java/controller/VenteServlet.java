/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.VenteDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Vente;

/**
 *
 * @author kabor
 */
public class VenteServlet extends HttpServlet {

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
            throws ServletException, IOException, ParseException {
        
        VenteDao vendao = new VenteDao();
        
        if(request.getParameter("enregistrer")!=null){
            SimpleDateFormat d = new SimpleDateFormat("yyyy-MM-dd");
            
            Date dateVente = d.parse(request.getParameter("dateVente"));
            int totalVente = Integer.parseInt(request.getParameter("totalVente"));
            int idCommande = Integer.parseInt(request.getParameter("idCommande"));
            int idMenu = Integer.parseInt(request.getParameter("idMenu"));
            int idClient = Integer.parseInt(request.getParameter("idClient"));
            
            Vente ven = new Vente(dateVente, totalVente, idCommande, idMenu, idClient);
            vendao.enregistrer(ven);
            response.sendRedirect(request.getContextPath()+"/vue/liste_vente.jsp");
        }
        
        //supprimer
        if(request.getParameter("ids")!=null) {
            int idVente = Integer.parseInt(request.getParameter("ids"));
            Vente ven = new Vente();
            ven.setIdVente(idVente);
            vendao.supprimer(ven);
            response.sendRedirect(request.getContextPath()+"/vue/liste_vente.jsp");
        }
        
        //modifier
        if(request.getParameter("idm")!=null) {
            int idVente = Integer.parseInt(request.getParameter("idm"));
            Vente ven = vendao.recherche(idVente);
            request.setAttribute("vente", ven);
            request.getRequestDispatcher("/vue/vente.jsp").forward(request, response);
        }
        
        if(request.getParameter("modifier")!=null){
            SimpleDateFormat d = new SimpleDateFormat("yyyy-MM-dd");
            
            int idVente = Integer.parseInt(request.getParameter("idVente"));
            
            Date dateVente = d.parse(request.getParameter("dateVente"));
            int totalVente = Integer.parseInt(request.getParameter("totalVente"));
            int idCommande = Integer.parseInt(request.getParameter("idCommande"));
            int idMenu = Integer.parseInt(request.getParameter("idMenu"));
            int idClient = Integer.parseInt(request.getParameter("idClient"));
            
            Vente ven = new Vente(dateVente, totalVente, idCommande, idMenu, idClient);
            vendao.modifier(ven, idVente);
            response.sendRedirect(request.getContextPath()+"/vue/liste_vente.jsp");
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
        try {
            processRequest(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(VenteServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(VenteServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
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
