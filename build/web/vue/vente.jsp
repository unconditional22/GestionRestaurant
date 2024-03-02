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
            <legend>Les Ventes</legend>
        
                <form action="${pageContext.request.contextPath}/VenteServlet" method="post">
                    
                    <div>
                        <label>Date Vente: </label>
                        <input type="text" name="dateVente" value="${vente.dateVente}" size="30"/>
                    </div>

                    <div>
                        <label>Total: </label>
                        <input type="number" name="totalVente" value="${vente.totalVente}" size="30"/>
                    </div>
                    
                    <div>
                        <label>Commande: </label>
                        <select name="idCommande">
                            <option>Choisir</option>
                            <c:forEach var="commande" items="${commandes}">
                                <option value="${commande.idCommande}">${commande.dateCommande}</option>
                            </c:forEach>
                        </select>
                    </div> 
                    
                    <div>
                        <label>Menu: </label>
                        <select name="idMenu">
                            <option>Choisir</option>
                            <c:forEach var="menu" items="${menus}">
                                <option value="${menu.idMenu}">${menu.nomMenu}</option>
                            </c:forEach>
                        </select>
                    </div> 

                    <div>
                        <label>Client: </label>
                        <select name="idClient">
                            <option>Choisir</option>
                            <c:forEach var="client" items="${clients}">
                                <option value="${client.idClient}">${client.nomClient}</option>
                            </c:forEach>
                        </select>
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
