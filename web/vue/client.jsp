<%-- 
    Document   : client
    Created on : Mar 10, 2023, 4:07:32 PM
    Author     : kabor
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Client</title>
        <link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <%@ include file="head.jsp" %>
        <fieldset>
            <legend>Clients</legend>
        
                <form action="${pageContext.request.contextPath}/ClientServlet" method="post">
                    
                    <div>
                        <label>Nom: </label>
                        <input type="text" name="nomClient" value="${client.nomClient}" size="30"/>
                    </div>

                    <div>
                        <label>Prenom: </label>
                        <input type="text" name="prenomClient" value="${client.prenomClient}" size="30"/>
                    </div>

                    <div>
                        <label>Email: </label>
                        <input type="email" name="emailClient" value="${client.emailClient}" size="30"/>
                    </div>
                    
                    <div>
                        <label>Telephone: </label>
                        <input type="tel" name="telClient" value="${client.telClient}" size="30"/>
                    </div>
                    
                    <div>
                        <label>Ville: </label>
                        <input type="text" name="villeClient" value="${client.villeClient}" size="30"/>
                    </div>

                    <div>
                        <label>&nbsp;</label>
                        <c:if test="${client==null}">
                            <input type="submit" name="enregistrer" value="Enregistrer"/>
                        </c:if>
                            
                        <c:if test="${client!=null}">
                            <input type="hidden" name="idClient" value="${client.idClient}" size="30"/>
                            <input type="submit" name="modifier" value="Modifier"/>
                        </c:if>
                        
                    </div>
                </form>
        </fieldset>
        <%@ include file="foot.jsp" %>
    </body>
</html>
