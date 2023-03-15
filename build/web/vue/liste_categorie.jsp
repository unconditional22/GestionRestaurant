<%-- 
    Document   : liste_categorie
    Created on : Mar 10, 2023, 4:44:06 PM
    Author     : kabor
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.List"%>
<%@page import="model.Categorie"%>
<%@page import="dao.CategorieDao"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Liste Categories</title>
    </head>
    <body>
        <%@ include file="head.jsp" %>
        <% 
        CategorieDao catdao = new CategorieDao();
        List<Categorie> tb = catdao.liste();
        request.setAttribute("list", tb);
        %>
        <fieldset>
            <legend>Liste Des Categories</legend>
            <table border="1" width="100%">

                <thead>
                    <tr>
                        <th>N°</th>
                        <th>Nom</th>
                        <th>Action</th> 
                    </tr>
                </thead>

                <tbody>
                    <c:forEach items="${list}" var="cat" varStatus="statut">
                        <tr>
                            <td>${statut.count}</td>
                            <td>${cat.nomCat}</td>
                            <td>
                                <a href="${pageContext.request.contextPath}/CategorieServlet?ids=${cat.idCat}">Supprimer</a>
                                <a href="${pageContext.request.contextPath}/CategorieServlet?idm=${cat.idCat}">Modifier</a>

                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            
            </table>  
        </fieldset> 
        <button><a href="${pageContext.request.contextPath}/vue/categorie.jsp">Ajouter</a></button>
        
        <%@ include file="foot.jsp" %>
    </body>
</html>
