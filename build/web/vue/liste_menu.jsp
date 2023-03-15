<%-- 
    Document   : liste_menu
    Created on : Mar 10, 2023, 4:44:32 PM
    Author     : kabor
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.List"%>
<%@page import="model.Menu"%>
<%@page import="dao.MenuDao"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Liste Des Menu</title>
    </head>
    <body>
        <%@ include file="head.jsp" %>
        <% 
        MenuDao mendao = new MenuDao();
        List<Menu> tb = mendao.liste();
        request.setAttribute("list", tb);
        %>
        <fieldset>
            <legend>Liste Des Menu</legend>
            <table border="1" width="100%">

                <thead>
                    <tr>
                        <th>N°</th>
                        <th>Nom</th>
                        <th>Prix</th>
                        <th>Categorie</th>
                        <th>Action</th> 
                    </tr>
                </thead>

                <tbody>
                    <c:forEach items="${list}" var="men" varStatus="statut">
                        <tr>
                            <td>${statut.count}</td>
                            <td>${men.nomMenu}</td>
                            <td>${men.prixMenu}</td>
                            <td>${men.idCat}</td>
                            <td>
                                <a href="${pageContext.request.contextPath}/MenuServlet?ids=${men.ide}">Supprimer</a>
                                <a href="${pageContext.request.contextPath}/MenuServlet?idm=${men.ide}">Modifier</a>

                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            
            </table>  
        </fieldset> 
        <button><a href="${pageContext.request.contextPath}/vue/menu.jsp">Ajouter</a></button>
        <%@ include file="foot.jsp" %>
    </body>
</html>
