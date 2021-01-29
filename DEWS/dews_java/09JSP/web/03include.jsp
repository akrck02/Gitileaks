<%-- 
    Document   : 03include
    Created on : 15-dic-2020, 11:18:34
    Author     : dw2
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <p> Comienzo página general</p>
        <% String colorparrafo="red"; %>
        
        <%@include file="03incluido.jsp" %>
        <p>Final página general</p>
        
    </body>
</html>
