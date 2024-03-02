<%-- 
    Document   : commande
    Created on : Mar 10, 2023, 5:17:14 PM
    Author     : kabor
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Commande</title>
        <link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <%@ include file="head.jsp" %>
        <fieldset>
            <legend>Passer Une Commande</legend>
        
                <form action="${pageContext.request.contextPath}/CommandeServlet" method="post">
                    
                    <div>
                        <label>Date: </label>
                        <input type="text" name="dateCommande" value="${commande.dateCommande}" size="30"/>
                    </div>

                    <div>
                        <label>Quantite: </label>
                        <input type="number" name="quantiteCommande" value="${commande.quantiteCommande}" size="30"/>
                    </div>

                    <div>
                        <label>Total: </label>
                        <input type="number" name="totalCommande" value="${commande.totalCommande}" size="30"/>
                    </div>
                   
                    
                    <div>
                        <label>Client: </label>
                        <select name="idClient">
                            <c:forEach var="client" items="${clients}">
                                <option value="${client.idClient}">${client.nomClient}</option>
                            </c:forEach>
                        </select>
                    </div> 
                    
                    <div>
                        <label>Menu: </label>
                        <select name="idMenu">
                            <c:forEach var="menu" items="${menus}">
                                <option value="${menu.idMenu}">${menu.nomMenu}</option>
                            </c:forEach>
                        </select>
                    </div> 
                         

                    <div>
                        <label>&nbsp;</label>
                        <c:if test="${commande==null}">
                            <input type="submit" name="enregistrer" value="Enregistrer"/>
                        </c:if>
                            
                        <c:if test="${commande!=null}">
                            <input type="hidden" name="idCommande" value="${commande.idCommande}" size="30"/>
                            <input type="submit" name="modifier" value="Modifier"/>
                        </c:if>
                        
                    </div>
                </form>
        </fieldset>
        <%@ include file="foot.jsp" %>
    </body>
</html>
