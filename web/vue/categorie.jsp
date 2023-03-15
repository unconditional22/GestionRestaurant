<%-- 
    Document   : categorie
    Created on : Mar 10, 2023, 4:43:55 PM
    Author     : kabor
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Categorie</title>
        <link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <%@ include file="head.jsp" %>
        <fieldset>
            <legend>Formulaire Des Categories</legend>
        
                <form action="${pageContext.request.contextPath}/CategorieServlet" method="post">
                    
                    <div>
                        <label>Nom: </label>
                        <input type="text" name="nomCat" value="${categorie.nomCat}" size="30"/>
                    </div>

                    <div>
                        <label>&nbsp;</label>
                        <c:if test="${categorie==null}">
                            <input type="submit" name="enregistrer" value="Enregistrer"/>
                        </c:if>
                            
                        <c:if test="${categorie!=null}">
                            <input type="hidden" name="idCat" value="${categorie.idCat}" size="30"/>
                            <input type="submit" name="modifier" value="Modifier"/>
                        </c:if>
                        
                    </div>
                </form>
        </fieldset>
        <%@ include file="foot.jsp" %>
    </body>
</html>
