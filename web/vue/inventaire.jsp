<%-- 
    Document   : inventaire
    Created on : Mar 10, 2023, 5:39:47 PM
    Author     : kabor
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Inventaire</title>
        <link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <%@ include file="head.jsp" %>
        <fieldset>
            <legend>Formulaire Des Inventaires</legend>
        
                <form action="${pageContext.request.contextPath}/InventaireServlet" method="post">
                    
                    <div>
                        <label>Nom: </label>
                        <input type="text" name="nomInvent" value="${inventaire.nomInvent}" size="30"/>
                    </div>

                    <div>
                        <label>Niveau: </label>
                        <input type="number" name="niveauInvent" value="${inventaire.niveauInvent}" size="30"/>
                    </div>

                    <div>
                        <label>Minimum: </label>
                        <input type="number" name="minimumInvent" value="${inventaire.minimumInvent}" size="30"/>
                    </div>
                    
                    <div>
                        <label>Provision: </label>
                        <input type="number" name="provisionInvent" value="${inventaire.provisionInvent}" size="30"/>
                    </div>

                    <div>
                        <label>Unite: </label>
                        <input type="text" name="uniteInvent" value="${inventaire.uniteInvent}" size="30"/>
                    </div>

                    <div>
                        <label>&nbsp;</label>
                        <c:if test="${inventaire==null}">
                            <input type="submit" name="enregistrer" value="Enregistrer"/>
                        </c:if>
                            
                        <c:if test="${inventaire!=null}">
                            <input type="hidden" name="idInvent" value="${inventaire.idInvent}" size="30"/>
                            <input type="submit" name="modifier" value="Modifier"/>
                        </c:if>
                        
                    </div>
                </form>
        </fieldset>
        <%@ include file="foot.jsp" %>
    </body>
</html>
