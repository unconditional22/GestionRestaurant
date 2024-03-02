/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.ClientDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Client;

/**
 *
 * @author kabor
 */
public class ClientServlet extends HttpServlet {

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
        
        ClientDao cltdao = new ClientDao();
        
        if(request.getParameter("enregistrer")!=null){
            String nomClient = request.getParameter("nomClient");
            String prenomClient = request.getParameter("prenomClient");
            String emailClient = request.getParameter("emailClient");
            String telClient = request.getParameter("telClient");
            String villeClient = request.getParameter("villeClient");
            
            Client clt = new Client(nomClient, prenomClient, emailClient, telClient, villeClient);
            cltdao.enregistrer(clt);
            response.sendRedirect(request.getContextPath()+"/vue/liste_client.jsp");
        }
        
        //supprimer
        if(request.getParameter("ids")!=null) {
            int idClient = Integer.parseInt(request.getParameter("ids"));
            Client clt = new Client();
            clt.setIdClient(idClient);
            cltdao.supprimer(clt);
            response.sendRedirect(request.getContextPath()+"/vue/liste_client.jsp");
        }
        
        //modifier
        if(request.getParameter("idm")!=null) {
            int idClient = Integer.parseInt(request.getParameter("idm"));
            Client clt = cltdao.recherche(idClient);
            request.setAttribute("client", clt);
            request.getRequestDispatcher("/vue/client.jsp").forward(request, response);
        }
        
        if(request.getParameter("modifier")!=null){
            int idClient = Integer.parseInt(request.getParameter("idClient"));
            String nomClient = request.getParameter("nomClient");
            String prenomClient = request.getParameter("prenomClient");
            String emailClient = request.getParameter("emailClient");
            String telClient = request.getParameter("telClient");
            String villeClient = request.getParameter("villeClient");
            
            Client clt = new Client(nomClient, prenomClient, emailClient, telClient, villeClient);
            cltdao.modifier(clt, idClient);
            response.sendRedirect(request.getContextPath()+"/vue/liste_client.jsp");
        }
        
         //liste des clients
         List<Client> clients = cltdao.liste();
        request.setAttribute("clients", clients);
        //request.getRequestDispatcher("/vue/liste_client.jsp").forward(request, response);
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
        
        ClientDao cltdao = new ClientDao();
        List<Client> clients = cltdao.liste();
        request.setAttribute("clients", clients);
        //request.getRequestDispatcher("/vue/client.jsp").forward(request, response);
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
