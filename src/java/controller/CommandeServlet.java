/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import dao.ClientDao;
import dao.CommandeDao;
import dao.MenuDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Client;
import model.Commande;
import model.Menu;

/**
 *
 * @author kabor
 */
public class CommandeServlet extends HttpServlet {

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
       
        CommandeDao comdao = new CommandeDao();
        
        if(request.getParameter("enregistrer")!=null){
            SimpleDateFormat d = new SimpleDateFormat("yyyy-MM-dd");
            
            
            Date dateCommande = d.parse(request.getParameter("dateCommande"));
            int quantiteCommande = Integer.parseInt(request.getParameter("quantiteCommande"));
            int totalCommande = Integer.parseInt(request.getParameter("totalCommande"));
            int idClient = Integer.parseInt(request.getParameter("idClient"));
            int idMenu = Integer.parseInt(request.getParameter("idMenu"));

            Commande com = new Commande(dateCommande, quantiteCommande, totalCommande, idClient, idMenu);
            comdao.enregistrer(com);
            response.sendRedirect(request.getContextPath()+"/vue/liste_commande.jsp");
        }
        
        //supprimer
        if(request.getParameter("ids")!=null) {
            int idCommande = Integer.parseInt(request.getParameter("ids"));
            Commande com = new Commande();
            com.setIdCommande(idCommande);
            comdao.supprimer(com);
            response.sendRedirect(request.getContextPath()+"/vue/liste_commande.jsp");
        }
        
        //modifier
        if(request.getParameter("idm")!=null) {
            int idCommande = Integer.parseInt(request.getParameter("idm"));
            Commande com = comdao.recherche(idCommande);
            request.setAttribute("commande", com);
            request.getRequestDispatcher("/vue/commande.jsp").forward(request, response);
        }
        
        if(request.getParameter("modifier")!=null){
            SimpleDateFormat d = new SimpleDateFormat("yyyy-MM-dd");
            
            int idCommande = Integer.parseInt(request.getParameter("idCommande"));
            

            Date dateCommande = d.parse(request.getParameter("dateCommande"));            
            int quantiteCommande = Integer.parseInt(request.getParameter("quantiteCommande"));
            int totalCommande = Integer.parseInt(request.getParameter("totalCommande"));
            int idClient = Integer.parseInt(request.getParameter("idClient"));
            int idMenu = Integer.parseInt(request.getParameter("idMenu"));
            
            Commande com = new Commande(dateCommande, quantiteCommande, totalCommande, idClient, idMenu);
            comdao.modifier(com, idCommande);
            response.sendRedirect(request.getContextPath()+"/vue/liste_commande.jsp");
        }
        
        //liste des Commandes
       //List<Commande> Commandes = comdao.liste();
        //request.setAttribute("Commandes", Commandes);
        //request.getRequestDispatcher("/vue/liste_commande.jsp").forward(request, response);
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
        
            MenuDao mendao = new MenuDao();
            List<Menu> menus = mendao.liste();
            request.setAttribute("menus", menus);
            
            ClientDao cltdao = new ClientDao();
            List<Client> clients = cltdao.liste();
            request.setAttribute("clients", clients);
            
            request.getRequestDispatcher("/vue/commande.jsp").forward(request, response);

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
            Logger.getLogger(CommandeServlet.class.getName()).log(Level.SEVERE, null, ex);
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
