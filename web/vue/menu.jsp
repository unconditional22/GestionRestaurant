<%-- 
    Document   : menu
    Created on : Mar 10, 2023, 4:44:22 PM
    Author     : kabor
--%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.Categorie"%>
<%@page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Menus</title>
        <link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <%@ include file="head.jsp" %>
        <fieldset>
            <legend>Ajouter un Menu</legend>
        
                <form action="${pageContext.request.contextPath}/MenuServlet" method="post">
                     
                    <div>
                        <label>Nom: </label>
                        <input type="text" name="nomMenu" value="${menu.nomMenu}" size="30"/>
                    </div>

                    <div>
                        <label>Prix: </label>
                        <input type="number" name="prixMenu" value="${menu.prixMenu}" size="30"/>
                    </div>

                    <div>
                        <label>Categorie: </label>
                        <select name="idCat">
                            <c:forEach var="categorie" items="${categories}">
                                <option value="${categorie.idCat}">${categorie.nomCat}</option>
                            </c:forEach>
                        </select>
                    </div>                  
                    
                    <div>
                        <label>&nbsp;</label>
                        <c:if test="${menu==null}">
                            <input type="submit" name="enregistrer" value="Enregistrer"/>
                        </c:if>
                            
                        <c:if test="${menu!=null}">
                            <input type="hidden" name="idMenu" value="${menu.idMenu}" size="30"/>
                            <input type="submit" name="modifier" value="Modifier"/>
                        </c:if>
                        
                    </div>
                </form>
        </fieldset>
                    <button><a href="${pageContext.request.contextPath}/vue/categorie.jsp">Ajouter Une Nouvelle Categorie</a></button>
        <%@ include file="foot.jsp" %>
    </body>
</html>
