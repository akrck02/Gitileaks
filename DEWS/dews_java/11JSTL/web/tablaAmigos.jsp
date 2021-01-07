
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
    <c:choose>
        <c:when test="${requestScope.mapaAmigos==null}">
            <jsp:forward page="ServletInicio2"/>            
        </c:when>
        <c:otherwise>
            <table>
            <tr><th>NOMBRE</th><th>DESCRIPCION</th><th>LISTA DE AMIGOS</th></tr>
            <c:forEach items="${requestScope.mapaAmigos}" var="par">
                <tr>
                    <td>${par.key.nombre}</td>
                    <td>${par.key.caracteristas()}</td>
                    <td>
                        <c:forEach items="${par.value}" var="persona_amigo" varStatus="estado" >
                            ${estado.index + 1} ${persona_amigo.nombre} &nbsp;
                        </c:forEach>
                    </td>
                    
                </tr>     
                
            </c:forEach>
            </table>
            
            
        </c:otherwise>
              
        
        
        
    </c:choose>
    </body>
</html>
