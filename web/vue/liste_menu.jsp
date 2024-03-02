<%-- 
    Document   : liste_menu
    Created on : Mar 10, 2023, 4:44:32 PM
    Author     : kabor
--%>
<%@page import="model.Categorie"%>
<%@page import="dao.CategorieDao"%>
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
        List<Menu> tbm = mendao.liste();
        request.setAttribute("list", tbm);
        %>
        
        <% 
        CategorieDao catdao = new CategorieDao();
        List<Categorie> tbcat = catdao.liste();
        request.setAttribute("listCat", tbcat);
        %>
        
        <fieldset>
            <legend>Liste Des Menus</legend>
                <div class="ibox">
                    <div class="ibox-body">
                        <div class="table-responsive">
            <table border="1" width="100%" class="table">

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
                            <td><c:forEach items="${listCat}" var="mn"> <c:if test= "${men.idCat eq mn.idCat}"> ${mn.nomCat} </c:if> </c:forEach></td>
                            <td>
                                <a href="${pageContext.request.contextPath}/MenuServlet?ids=${men.idMenu}">Supprimer</a>
                                <a href="${pageContext.request.contextPath}/MenuServlet?idm=${men.idMenu}">Modifier</a>

                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            
            </table>  
        </div>
    </div>
</div>
            
        </fieldset> 
        <button><a href="${pageContext.request.contextPath}/MenuServlet">Ajouter</a></button>
        <%@ include file="foot.jsp" %>
    </body>
</html>
