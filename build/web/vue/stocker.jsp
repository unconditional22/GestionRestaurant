<%-- 
    Document   : stocker
    Created on : Mar 10, 2023, 5:40:09 PM
    Author     : kabor
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Stocker</title>
        <link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <%@ include file="head.jsp" %>
        <fieldset>
            <legend>Formulaire Des Stocks</legend>
        
                <form action="${pageContext.request.contextPath}/StockerServlet" method="post">
                    
                    <div>
                        <label>Menu: </label>
                        <input type="text" name="idMenu" value="${stocker.idMenu}" size="30"/>
                    </div>

                    <div>
                        <label>Inventaire: </label>
                        <input type="text" name="idInvent" value="${stocker.idInvent}" size="30"/>
                    </div>

                    <div>
                        <label>Quantite: </label>
                        <input type="number" name="quantiteStocker" value="${stocker.quantiteStocker}" size="30"/>
                    </div>
                    
                    <div>
                        <label>Unite: </label>
                        <input type="text" name="uniteStocker" value="${stocker.uniteStocker}" size="30"/>
                    </div>

                    <div>
                        <label>&nbsp;</label>
                        <c:if test="${stocker==null}">
                            <input type="submit" name="enregistrer" value="Enregistrer"/>
                        </c:if>
                            
                        <c:if test="${stocker!=null}">
                            <input type="hidden" name="idStocker" value="${stocker.idStocker}" size="30"/>
                            <input type="submit" name="modifier" value="Modifier"/>
                        </c:if>
                        
                    </div>
                </form>
        </fieldset>
        <%@ include file="foot.jsp" %>
    </body>
</html>
