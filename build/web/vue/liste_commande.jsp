<%-- 
    Document   : liste_commande
    Created on : Mar 10, 2023, 5:17:25 PM
    Author     : kabor
--%>
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
        List<Commande> tb = cmddao.liste();
        request.setAttribute("list", tb);
        %>
        <fieldset>
            <legend>Liste Des Commandes</legend>
            <table border="1" width="100%">

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
                            <td>${com.idClient}</td>
                            <td>${com.idMenu}</td>
                            <td>
                                <a href="${pageContext.request.contextPath}/CommandeServlet?ids=${com.idCommande}">Supprimer</a>
                                <a href="${pageContext.request.contextPath}/CommandeServlet?idm=${com.idCommande}">Modifier</a>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            
            </table>  
        </fieldset> 
        <%@ include file="foot.jsp" %>
    </body>
</html>
