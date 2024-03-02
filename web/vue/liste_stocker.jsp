<%-- 
    Document   : liste_stocker
    Created on : Mar 10, 2023, 5:40:17 PM
    Author     : kabor
--%>
<%@page import="dao.MenuDao"%>
<%@page import="model.Menu"%>
<%@page import="model.Inventaire"%>
<%@page import="dao.InventaireDao"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.List"%>
<%@page import="model.Stocker"%>
<%@page import="dao.StockerDao"%>

<%@ page import="dao.InventaireDao" %>
<%
  InventaireDao dao = new InventaireDao();
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Liste Stocks</title>
    </head>
    <body>
        <%@ include file="head.jsp" %>
        <% 
        StockerDao stdao = new StockerDao();
        List<Stocker> tbs = stdao.liste();
        request.setAttribute("list", tbs);
        %>
       
        <% 
        MenuDao mendao = new MenuDao();
        List<Menu> menu = mendao.liste();
        request.setAttribute("listMenu", menu);
        %>
        
        <% 
        InventaireDao indao = new InventaireDao();
        List<Inventaire> tbi = indao.liste();
        request.setAttribute("listInvent", tbi);
        %>

        <fieldset>
            <legend>Liste Des Stocks</legend>
            <div class="ibox">
                    <div class="ibox-body">
                        <div class="table-responsive">
            <table border="1" width="100%" class="table">

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
                            
                            <td><c:forEach items="${listMenu}" var="mn"> <c:if test= "${st.idMenu eq mn.idMenu}"> ${mn.nomMenu} </c:if> </c:forEach></td>
                            
                            <td><c:forEach items="${listInvent}" var="mn"> <c:if test= "${st.idInvent eq mn.idInvent}"> ${mn.nomInvent} </c:if> </c:forEach></td>

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
                        </div>
                    </div>
            </div>
        </fieldset> 
        <button><a href="${pageContext.request.contextPath}/StockerServlet">Ajouter</a></button>
        <%@ include file="foot.jsp" %>
    </body>
</html>
