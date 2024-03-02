<%-- 
    Document   : liste_vente
    Created on : Mar 10, 2023, 5:17:43 PM
    Author     : kabor
--%>
<%@page import="model.Commande"%>
<%@page import="dao.CommandeDao"%>
<%@page import="model.Menu"%>
<%@page import="dao.MenuDao"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.List"%>
<%@page import="model.Vente"%>
<%@page import="dao.VenteDao"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Liste Vente</title>
    </head>
    <body>
        <%@ include file="head.jsp" %>
        <% 
        VenteDao vntdao = new VenteDao();
        List<Vente> tbv = vntdao.liste();
        request.setAttribute("list", tbv);
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
        
        <% 
        CommandeDao cmddao = new CommandeDao();
        List<Commande> tbc = cmddao.liste();
        request.setAttribute("listCom", tbc);
        %>
        
        <fieldset>
            <legend>Liste Des Ventes</legend>
            <div class="ibox">
                    <div class="ibox-body">
                        <div class="table-responsive">
            <table border="1" width="100%" class="table">

                <thead>
                    <tr>
                        <th>N°</th>
                        <th>Date Vente</th>
                        <th>Total</th>
                        <th>Commande</th>
                        <th>Menu</th>
                        <th>Client</th>
                        <th>Action</th> 
                    </tr>
                </thead>

                <tbody>
                    <c:forEach items="${list}" var="vt" varStatus="statut">
                        <tr>
                            <td>${statut.count}</td>
                            <td>${vt.dateVente}</td>
                            <td>${vt.totalVente}</td>
                            
                            <td><c:forEach items="${listCom}" var="mn"> <c:if test= "${vt.idCommande eq mn.idCommande}"> ${mn.dateCommande} </c:if> </c:forEach></td>
                            
                            <td><c:forEach items="${listMenu}" var="mn"> <c:if test= "${vt.idMenu eq mn.idMenu}"> ${mn.nomMenu} </c:if> </c:forEach></td>
                            
                            <td><c:forEach items="${listClient}" var="mn"> <c:if test= "${vt.idClient eq mn.idClient}"> ${mn.nomClient} </c:if> </c:forEach></td>

                            <td>
                                <a href="${pageContext.request.contextPath}/VenteServlet?ids=${vt.idVente}">Supprimer</a>
                                <a href="${pageContext.request.contextPath}/VenteServlet?idm=${vt.idVente}">Modifier</a>

                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            
            </table>  
                        </div>
                    </div>
            </div>
        </fieldset> 
        <button><a href="${pageContext.request.contextPath}/VenteServlet">Ajouter</a></button>
        <%@ include file="foot.jsp" %>
    </body>
</html>
