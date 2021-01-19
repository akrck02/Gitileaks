<%-- 
    Document   : ilegales
    Created on : 19-dic-2018, 23:32:18
    Author     : lamenda
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
          
        
        
        <ul>
        <c:forEach items="${applicationScope.vetados}" var="vetado">
            <li> ${vetado}
            </li>
        </c:forEach>
        </ul>
        
        <form method="post"> 
            Nombre de usuario a vetar: <input type="text" name="cliente" />
             <input type="submit" name="submitvetar" value="VETAR" />
        </form>
    </body>
</html>
