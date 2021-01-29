

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>PRESTAMOS</h1>
        <form action="ServletPrestamos" method="post">
        <table>           
        <tr><th></th><th>Titulo</th><th>Genero</th><th>Paginas</th><th>Préstamos</th></tr>
        <c:forEach items="${sessionScope.libros}" var="libro">
            <tr>
                <td><input type="checkbox" name="idlibros" value="${libro.idlibro}"/> </td>
                <td>${libro.titulo}</td>
                <td>${libro.genero}</td>
                <td>${libro.paginas} páginas</td>
                <td>
                    <c:choose>
                        <c:when test="${sessionScope.mapa.get(libro.idlibro) eq 0}">
                            SIN PRESTAMOS
                        </c:when>
                        <c:otherwise>
                            <a href='prestamos.jsp?idlibro=${libro.idlibro}'>${sessionScope.mapa.get(libro.idlibro)} veces prestado </a>
                            <c:if test="${param.idlibro==libro.idlibro}" >
                                <table>                                    
                                <tr><th>Fecha</th><th>Fecha devolucion</th></tr>
                                <c:forEach items="${sessionScope.mapaPrestamos.get(libro.idlibro)}" var="prestamo" >
                                    <tr>
                                        <td>${prestamo.strFecha()}</td>
                                        <td>
                                            <c:if test="${prestamo.fechaDev==null}">
                                                Sin devolver
                                            </c:if>
                                            <c:if test="${prestamo.fechaDev!=null}">
                                               ${prestamo.strFechaDev()}
                                            </c:if>
                                            
                                        </td>
                                    </tr>
                                </c:forEach>
                                </table>   
                                
                            </c:if>
                        
                        
                        </c:otherwise>
                    </c:choose>
                    
                    
                    
                </td>
            </tr>
        </c:forEach>
        <tr>
            <td colspan="4">
              <input type="submit" name="submit" value="TOMAR PRESTADOS" />  
            </td>
        </tr>               
        </table>   
        </form>
        

    </body>
</html>
