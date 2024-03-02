<%-- 
    Document   : liste_employee
    Created on : Mar 10, 2023, 4:07:07 PM
    Author     : kabor
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.List"%>
<%@page import="model.Employee"%>
<%@page import="dao.EmployeeDao"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Liste Employees</title>
    </head>
    <body>
        <%@ include file="head.jsp" %>
        <% 
        EmployeeDao empdao = new EmployeeDao();
        List<Employee> tbemp = empdao.liste();
        request.setAttribute("list", tbemp);
        %>
        <fieldset>
            <legend>Liste Des Employees</legend>
            <div class="ibox">
                    <div class="ibox-body">
                        <div class="table-responsive">
            <table border="1" width="100%" class="table">

                <thead>
                    <tr>
                        <th>N°</th>
                        <th>Username</th>
                        <th>Password</th>
                        <th>Profile</th>
                        <th>Action</th> 
                    </tr>
                </thead>

                <tbody>
                    <c:forEach items="${list}" var="emp" varStatus="statut">
                        <tr>
                            <td>${statut.count}</td>
                            <td>${emp.usernameEmp}</td>
                            <td>${emp.passwordEmp}</td>
                            <td>${emp.profileEmp}</td>
                            <td>
                                <a href="${pageContext.request.contextPath}/EmployeeServlet?ids=${emp.idEmp}">Supprimer</a>
                                <a href="${pageContext.request.contextPath}/EmployeeServlet?idm=${emp.idEmp}">Modifier</a>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            
            </table> 
                        </div>
                    </div>
            </div>
        </fieldset> 
        <button><a href="${pageContext.request.contextPath}/vue/employee.jsp">Ajouter</a></button>
        <%@ include file="foot.jsp" %>
    </body>
</html>
