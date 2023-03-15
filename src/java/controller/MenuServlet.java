/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.CategorieDao;
import dao.MenuDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Categorie;
import model.Menu;

/**
 *
 * @author kabor
 */
public class MenuServlet extends HttpServlet {

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
        
        MenuDao mendao = new MenuDao();
        
        if(request.getParameter("enregistrer")!=null){
            String nomMenu = request.getParameter("nomMenu");
            float prixMenu = Float.parseFloat(request.getParameter("prixMenu"));
            int idCat = Integer.parseInt(request.getParameter("idCat"));
            
            Menu men = new Menu(nomMenu, prixMenu, idCat);
            mendao.enregistrer(men);
            response.sendRedirect(request.getContextPath()+"/vue/liste_menu.jsp");
        }
        
        //supprimer
        if(request.getParameter("ids")!=null) {
            int idMenu = Integer.parseInt(request.getParameter("ids"));
            Menu men = new Menu();
            men.setIdMenu(idMenu);
            mendao.supprimer(men);
            response.sendRedirect(request.getContextPath()+"/vue/liste_menu.jsp");
        }
        
        //modifier
        if(request.getParameter("idm")!=null) {
            int idMenu = Integer.parseInt(request.getParameter("idm"));
            Menu men = mendao.recherche(idMenu);
            request.setAttribute("menu", men);
            request.getRequestDispatcher("/vue/menu.jsp").forward(request, response);
        }
        
        if(request.getParameter("modifier")!=null){
            int idMenu = Integer.parseInt(request.getParameter("idMenu"));
            String nomMenu = request.getParameter("nomMenu");
            float prixMenu = Float.parseFloat(request.getParameter("prixMenu"));
            int idCat = Integer.parseInt(request.getParameter("idCat"));
            
            Menu men = new Menu(nomMenu, prixMenu, idCat);
            mendao.modifier(men, idMenu);
            response.sendRedirect(request.getContextPath()+"/vue/liste_menu.jsp");
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
        
            CategorieDao catDao = new CategorieDao();
            List<Categorie> categories = catDao.liste();
            request.setAttribute("categories", categories);

            MenuDao mendao = new MenuDao();
            int idMenu = Integer.parseInt(request.getParameter("idm"));
            Menu men = mendao.recherche(idMenu);
            request.setAttribute("menu", men);

            request.getRequestDispatcher("/vue/menu.jsp").forward(request, response);

            System.out.println("Number of categories: " + categories.size());
            for (Categorie categorie : categories) {
                System.out.println(categorie.getIdCat() + " " + categorie.getNomCat());
            }

//            MenuDao mendao = new MenuDao();
//            CategorieDao catDao = new CategorieDao();
//            List<Categorie> categories = catDao.liste();
//            request.setAttribute("categories", categories);
//
//            String idmParam = request.getParameter("idm");
//            int idMenu = 0; // default value
//            if (idmParam != null && !idmParam.isEmpty()) {
//                idMenu = Integer.parseInt(idmParam);
//            }
//            Menu men = mendao.recherche(idMenu);
//            request.setAttribute("menu", men);
//
//            request.getRequestDispatcher("/vue/menu.jsp").forward(request, response);
//
//            System.out.println("Number of categories: " + categories.size());
//            for (Categorie categorie : categories) {
//                System.out.println(categorie.getIdCat() + " " + categorie.getNomCat());
//            }


        
        
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
