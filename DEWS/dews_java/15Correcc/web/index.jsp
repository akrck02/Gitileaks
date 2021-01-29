<%-- 
    Document   : prueba
    Created on : 21-ene-2021, 10:06:40
    Author     : dw2
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <% String saludo="hasdfola";
            session.setAttribute("saludo", saludo);         
        %>
        
         <c:if test="${sessionScope.saludo == 'hola'}">
            <p>hola</p>
        </c:if>
       
    </body>
</html>
