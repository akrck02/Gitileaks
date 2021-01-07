<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
       
        <p>Página de prueba JSTL</p>
        <c:if test="${param.usuario!=null}">
            <p>Hola ${param.usuario} ! </p>       
        </c:if>
        
            
        <c:choose>
                <c:when test="${ Math.random()>0.5 }" >
                    <p>Te ha tocado la primitiva</p>
                </c:when>
                <c:otherwise>
                    <p>No te ha tocado</p>
                </c:otherwise>
                
        </c:choose>    
    </body>
</html>
