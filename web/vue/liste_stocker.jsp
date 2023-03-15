<%-- 
    Document   : liste_stocker
    Created on : Mar 10, 2023, 5:40:17 PM
    Author     : kabor
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.List"%>
<%@page import="model.Stocker"%>
<%@page import="dao.StockerDao"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Liste Stocker</title>
    </head>
    <body>
        <%@ include file="head.jsp" %>
        <% 
        StockerDao stdao = new StockerDao();
        List<Stocker> tb = stdao.liste();
        request.setAttribute("list", tb);
        %>
        <fieldset>
            <legend>Liste Des Stockers</legend>
            <table border="1" width="100%">

                <thead>
                    <tr>
                        <th>N°</th>
                        <th>Menu</th>
                        <th>Inventaire</th>
                        <th>Quantite</th>
                        <th>Unite</th>
                        <th>Action</th> 
                    </tr>
                </thead>

                <tbody>
                    <c:forEach items="${list}" var="st" varStatus="statut">
                        <tr>
                            <td>${statut.count}</td>
                            <td>${st.idMenu}</td>
                            <td>${st.idInvent}</td>
                            <td>${st.quantiteStocker}</td>
                            <td>${st.uniteStocker}</td>
                            <td>
                                <a href="${pageContext.request.contextPath}/StockerServlet?ids=${st.idStocker}">Supprimer</a>
                                <a href="${pageContext.request.contextPath}/StockerServlet?idm=${st.idStocker}">Modifier</a>

                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            
            </table>  
        </fieldset> 
        <%@ include file="foot.jsp" %>
    </body>
</html>
