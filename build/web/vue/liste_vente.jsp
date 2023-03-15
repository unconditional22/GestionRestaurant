<%-- 
    Document   : liste_vente
    Created on : Mar 10, 2023, 5:17:43 PM
    Author     : kabor
--%>
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
        List<Vente> tb = vntdao.liste();
        request.setAttribute("list", tb);
        %>
        <fieldset>
            <legend>Liste Des Ventes</legend>
            <table border="1" width="100%">

                <thead>
                    <tr>
                        <th>N°</th>
                        <th>Date</th>
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
                            <td>${vt.idCommande}</td>
                            <td>${vt.idMenu}</td>
                            <td>${vt.idClient}</td>
                            <td>
                                <a href="${pageContext.request.contextPath}/VenteServlet?ids=${vt.idVente}">Supprimer</a>
                                <a href="${pageContext.request.contextPath}/VenteServlet?idm=${vt.idVente}">Modifier</a>

                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            
            </table>  
        </fieldset> 
        <%@ include file="foot.jsp" %>
    </body>
</html>
