<%-- 
    Document   : vente
    Created on : Mar 10, 2023, 5:17:34 PM
    Author     : kabor
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Vente</title>
        <link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <%@ include file="head.jsp" %>
        <fieldset>
            <legend>Formulaire Des Ventes</legend>
        
                <form action="${pageContext.request.contextPath}/VenteServlet" method="post">
                    
                    <div>
                        <label>Date: </label>
                        <input type="text" name="dateVente" value="${vente.dateVente}" size="30"/>
                    </div>

                    <div>
                        <label>Total: </label>
                        <input type="number" name="totalVente" value="${vente.totalVente}" size="30"/>
                    </div>

                    <div>
                        <label>Commande: </label>
                        <input type="text" name="idCommande" value="${vente.idCommande}" size="30"/>
                    </div>
                    
                    <div>
                        <label>Menu </label>
                        <input type="text" name="idMenu" value="${vente.idMenu}" size="30"/>
                    </div>
                    
                    <div>
                        <label>Client: </label>
                        <input type="text" name="idClient" value="${vente.idClient}" size="30"/>
                    </div>

                    <div>
                        <label>&nbsp;</label>
                        <c:if test="${vente==null}">
                            <input type="submit" name="enregistrer" value="Enregistrer"/>
                        </c:if>
                            
                        <c:if test="${vente!=null}">
                            <input type="hidden" name="idVente" value="${vente.idVente}" size="30"/>
                            <input type="submit" name="modifier" value="Modifier"/>
                        </c:if>
                        
                    </div>
                </form>
        </fieldset>
        <%@ include file="foot.jsp" %>
    </body>
</html>
