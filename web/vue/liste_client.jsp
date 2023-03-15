<%-- 
    Document   : liste_client
    Created on : Mar 10, 2023, 4:07:44 PM
    Author     : kabor
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.List"%>
<%@page import="model.Client"%>
<%@page import="dao.ClientDao"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Liste Clients</title>
    </head>
    <body>
        <%@ include file="head.jsp" %>
        <% 
        ClientDao cltdao = new ClientDao();
        List<Client> tb = cltdao.liste();
        request.setAttribute("list", tb);
        %>
        <fieldset>
            <legend>Liste Des Clients</legend>
            <table border="1" width="100%">

                <thead>
                    <tr>
                        <th>N°</th>
                        <th>Nom</th>
                        <th>Prenom</th>
                        <th>Email</th>
                        <th>Tel</th>
                        <th>Ville</th>
                        <th>Action</th> 
                    </tr>
                </thead>

                <tbody>
                    <c:forEach items="${list}" var="cli" varStatus="statut">
                        <tr>
                            <td>${statut.count}</td>
                            <td>${cli.nomClient}</td>
                            <td>${cli.prenomClient}</td>
                            <td>${cli.emailClient}</td>
                            <td>${cli.telClient}</td>
                            <td>${cli.villeClient}</td>
                            <td>
                                <a href="${pageContext.request.contextPath}/ClientServlet?ids=${cli.idClient}">Supprimer</a>
                                <a href="${pageContext.request.contextPath}/ClientServlet?idm=${cli.idClient}">Modifier</a>

                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            
            </table>  
        </fieldset> 
        <button><a href="${pageContext.request.contextPath}/vue/client.jsp">Ajouter</a></button>
        <%@ include file="foot.jsp" %>
    </body>
</html>
