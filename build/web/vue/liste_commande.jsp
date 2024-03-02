<%-- 
    Document   : liste_commande
    Created on : Mar 10, 2023, 5:17:25 PM
    Author     : kabor
--%>
<%@page import="model.Menu"%>
<%@page import="dao.MenuDao"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.List"%>
<%@page import="model.Commande"%>
<%@page import="dao.CommandeDao"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Liste Commandes</title>
    </head>
    <body>
        <%@ include file="head.jsp" %>
        <% 
        CommandeDao cmddao = new CommandeDao();
        List<Commande> tbc = cmddao.liste();
        request.setAttribute("list", tbc);
        %>
        
        <% 
        MenuDao mendao = new MenuDao();
        List<Menu> menu = mendao.liste();
        request.setAttribute("listMenu", menu);
        %>
        
        <% 
        ClientDao c = new ClientDao();
        List<Client> clt = c.liste();
        request.setAttribute("listClient", clt);
        %>
       
         
        <fieldset>
            <legend>Liste Des Commandes</legend>
            <div class="ibox">
                    <div class="ibox-body">
                        <div class="table-responsive">
            <table border="1" width="100%" class="table">

                <thead>
                    <tr>
                        <th>N°</th>
                        <th>Date</th>
                        <th>Quantite</th>
                        <th>Total</th>
                        <th>Client</th>
                        <th>Menu</th>
                        <th>Action</th> 
                    </tr>
                </thead>

                <tbody>
                    <c:forEach items="${list}" var="com" varStatus="statut">
                        <tr>
                            <td>${statut.count}</td>
                            <td>${com.dateCommande}</td>
                            <td>${com.quantiteCommande}</td>
                            <td>${com.totalCommande}</td>
                            
                            <td><c:forEach items="${listClient}" var="mn"> <c:if test= "${com.idClient eq mn.idClient}"> ${mn.nomClient} </c:if> </c:forEach></td>

                            <td><c:forEach items="${listMenu}" var="mn"> <c:if test= "${com.idMenu eq mn.idMenu}"> ${mn.nomMenu} </c:if> </c:forEach></td>

                            <td>
                                <a href="${pageContext.request.contextPath}/CommandeServlet?ids=${com.idCommande}">Supprimer</a>
                                <a href="${pageContext.request.contextPath}/CommandeServlet?idm=${com.idCommande}">Modifier</a>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            
            </table> 
                        </div>
                    </div>
            </div>
        </fieldset> 
        <button><a href="${pageContext.request.contextPath}/CommandeServlet">Ajouter</a></button>
        <%@ include file="foot.jsp" %>
    </body>
</html>
