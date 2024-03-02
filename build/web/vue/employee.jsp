<%-- 
    Document   : employee
    Created on : Mar 10, 2023, 4:06:49 PM
    Author     : kabor
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Employee</title>
        <link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet" type="text/css"/> 
    </head>
    <body>
        <%@ include file="head.jsp" %>
        <fieldset>
            <legend>Employees</legend>
        
                <form action="${pageContext.request.contextPath}/EmployeeServlet" method="post">
                    
                    <div>
                        <label>Username: </label>
                        <input type="text" name="usernameEmp" value="${employee.usernameEmp}" size="30"/>
                    </div>

                    <div>
                        <label>Password: </label>
                        <input type="password" name="passwordEmp" value="${employee.passwordEmp}" size="30"/>
                    </div>
                    
                    <div>
                        <label>Profile: </label>
                        <select name="profileEmp">
                            <option></option>
                            <option value="Manager" ${employee.profileEmp == "Manager" ? "selected" : ""}>Manager</option>
                            <option value="Chef" ${employee.profileEmp == "Chef" ? "selected" : ""}>Chef</option>
                            <option value="Admin" ${employee.profileEmp == "Admin" ? "selected" : ""}>Admin</option>
                        </select>
                    </div>


                    <div>
                        <label>&nbsp;</label>
                        <c:if test="${employee==null}">
                            <input type="submit" name="enregistrer" value="Enregistrer"/>
                        </c:if>
                            
                        <c:if test="${employee!=null}">
                            <input type="hidden" name="idEmp" value="${employee.idEmp}" size="30"/>
                            <input type="submit" name="modifier" value="Modifier"/>
                        </c:if>
                        
                    </div>
                </form>
        </fieldset>
        <%@ include file="foot.jsp" %>
    </body>
</html>
