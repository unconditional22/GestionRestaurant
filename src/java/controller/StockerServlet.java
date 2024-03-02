/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.InventaireDao;
import dao.MenuDao;
import dao.StockerDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Inventaire;
import model.Menu;
import model.Stocker;

/**
 *
 * @author kabor
 */
public class StockerServlet extends HttpServlet {

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
        
        StockerDao stkdao = new StockerDao();
        
        /*if(request.getParameter("enregistrer")!=null){
            int idMenu = Integer.parseInt(request.getParameter("idMenu"));
            int idInvent = Integer.parseInt(request.getParameter("idInvent"));
            int quantiteStocker = Integer.parseInt(request.getParameter("quantiteStocker"));
            String uniteStocker = request.getParameter("uniteStocker");
            
            Stocker stk = new Stocker(idMenu, idInvent, quantiteStocker, uniteStocker);
            stkdao.enregistrer(stk);
            response.sendRedirect(request.getContextPath()+"/vue/liste_stocker.jsp");
        }*/
        
        /****if(request.getParameter("enregistrer")!=null){
        int idMenu = Integer.parseInt(request.getParameter("idMenu"));
        String[] idInventArray = request.getParameterValues("idInvent");
        int quantiteStocker = Integer.parseInt(request.getParameter("quantiteStocker"));
        String uniteStocker = request.getParameter("uniteStocker");

        for (String id : idInventArray) {
            int idInvent = Integer.parseInt(id);
            Stocker stk = new Stocker(idMenu, idInvent, quantiteStocker, uniteStocker);
            stkdao.enregistrer(stk);
        }

        response.sendRedirect(request.getContextPath()+"/vue/liste_stocker.jsp");
    }****/
        
        if(request.getParameter("enregistrer")!=null){
        int idMenu = Integer.parseInt(request.getParameter("idMenu"));
        String[] idInventArray = request.getParameterValues("idInvent");
        String quantiteStockerInput = request.getParameter("quantiteStocker");
        String uniteStocker = request.getParameter("uniteStocker");

        List<Integer> quantiteStockerList = new ArrayList<>();
        String[] quantities = quantiteStockerInput.split(",");
        for (String quantity : quantities) {
            int quantite = Integer.parseInt(quantity.trim());
            quantiteStockerList.add(quantite);
        }

        int index = 0;
        for (String id : idInventArray) {
            int idInvent = Integer.parseInt(id);
            int quantiteStocker = quantiteStockerList.get(index);
            Stocker stk = new Stocker(idMenu, idInvent, quantiteStocker, uniteStocker);
            stkdao.enregistrer(stk);
            index++;
        }

        response.sendRedirect(request.getContextPath()+"/vue/liste_stocker.jsp");
    }

        //supprimer
        if(request.getParameter("ids")!=null) {
            int idStocker = Integer.parseInt(request.getParameter("ids"));
            Stocker stk = new Stocker();
            stk.setIdStocker(idStocker);
            stkdao.supprimer(stk);
            response.sendRedirect(request.getContextPath()+"/vue/liste_stocker.jsp");
        }
        
        //modifier
        if(request.getParameter("idm")!=null) {
            int idStocker = Integer.parseInt(request.getParameter("idm"));
            Stocker stk = stkdao.recherche(idStocker);
            request.setAttribute("stocker", stk);
            request.getRequestDispatcher("/vue/stocker.jsp").forward(request, response);
        }
        
        if(request.getParameter("modifier")!=null){
            int idStocker = Integer.parseInt(request.getParameter("idStocker"));
            int idMenu = Integer.parseInt(request.getParameter("idMenu"));
            int idInvent = Integer.parseInt(request.getParameter("idInvent"));
            int quantiteStocker = Integer.parseInt(request.getParameter("quantiteStocker"));
            String uniteStocker = request.getParameter("uniteStocker");
            
            Stocker stk = new Stocker(idMenu, idInvent, quantiteStocker, uniteStocker);
            stkdao.modifier(stk, idStocker);
            response.sendRedirect(request.getContextPath()+"/vue/liste_stocker.jsp");
        }
        
        
        //////TEST
        
        /*if(request.getParameter("modifier")!=null){
        int idStocker = Integer.parseInt(request.getParameter("idStocker"));
        int idMenu = Integer.parseInt(request.getParameter("idMenu"));
        String[] idInventArray = request.getParameterValues("idInvent");
        String quantiteStockerInput = request.getParameter("quantiteStocker");
        String uniteStocker = request.getParameter("uniteStocker");

        List<Integer> quantiteStockerList = new ArrayList<>();
        String[] quantities = quantiteStockerInput.split(",");
        for (String quantity : quantities) {
            int quantite = Integer.parseInt(quantity.trim());
            quantiteStockerList.add(quantite);
        }

        int index = 0;
        for (String id : idInventArray) {
            int idInvent = Integer.parseInt(id);
            int quantiteStocker = quantiteStockerList.get(index);
            Stocker stk = new Stocker(idMenu, idInvent, quantiteStocker, uniteStocker);
            stkdao.modifier(stk, idStocker);
            index++;
        }

        response.sendRedirect(request.getContextPath()+"/vue/liste_stocker.jsp");
    }*/
        
        
               /****  // Retrieve the stocker object using its ID
        int idStocker = Integer.parseInt(request.getParameter("idStocker"));
        Stocker stk = stkdao.getStockerById(idStocker);

        // Get the ID of the menu and inventaire associated with the stocker
        int idMenu = stk.getIdMenu();
        int idInvent = stk.getIdInvent();

        // Set the selected values of the corresponding select options
        request.setAttribute("selectedMenu", idMenu);
        request.setAttribute("selectedInventaire", idInvent);****/
        
        
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
        
            MenuDao mendao = new MenuDao();
            List<Menu> menus = mendao.liste();
            request.setAttribute("menus", menus);
            
            InventaireDao invdao = new InventaireDao();
            List<Inventaire> invents = invdao.liste();
            request.setAttribute("invents", invents);
            
            request.getRequestDispatcher("/vue/stocker.jsp").forward(request, response);
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
