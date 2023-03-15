<%-- 
    Document   : liste_inventaire
    Created on : Mar 10, 2023, 5:39:57 PM
    Author     : kabor
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.List"%>
<%@page import="model.Inventaire"%>
<%@page import="dao.InventaireDao"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Liste Inventaire</title>
    </head>
    <body>
        <%@ include file="head.jsp" %>
        <% 
        InventaireDao indao = new InventaireDao();
        List<Inventaire> tb = indao.liste();
        request.setAttribute("list", tb);
        %>
        <fieldset>
            <legend>Liste Des Inventaires</legend>
            <table border="1" width="100%">

                <thead>
                    <tr>
                        <th>N°</th>
                        <th>Nom</th>
                        <th>Niveau</th>
                        <th>Minimum</th>
                        <th>Provision</th>
                        <th>Unite</th>
                        <th>Action</th> 
                    </tr>
                </thead>

                <tbody>
                    <c:forEach items="${list}" var="inv" varStatus="statut">
                        <tr>
                            <td>${statut.count}</td>
                            <td>${inv.nomInvent}</td>
                            <td>${inv.niveauInvent}</td>
                            <td>${inv.minimumInvent}</td>
                            <td>${inv.provisionInvent}</td>
                            <td>${inv.uniteInvent}</td>
                            <td>
                                <a href="${pageContext.request.contextPath}/InventaireServlet?ids=${inv.idInvent}">Supprimer</a>
                                <a href="${pageContext.request.contextPath}/InventaireServlet?idm=${inv.idInvent}">Modifier</a>

                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            
            </table>  
        </fieldset> 
        <button><a href="${pageContext.request.contextPath}/vue/inventaire.jsp">Ajouter</a></button>
        <%@ include file="foot.jsp" %>
    </body>
</html>
