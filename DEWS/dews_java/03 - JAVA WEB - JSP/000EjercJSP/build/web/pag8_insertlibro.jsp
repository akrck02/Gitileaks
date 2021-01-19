<%-- 
    Document   : insertlibro
    Created on : 20-dic-2018, 7:57:59
    Author     : pei4
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
      
        <c:if test="${sessionScope.libros==null}">
            <jsp:forward page="ServletInsertar8" />
        </c:if>
        
        
        <c:forEach items="${sessionScope.libros}" var="libro">            
            <p><a href="pag8_insertlibro.jsp?idlibro=${libro.idlibro}">${libro.titulo}</a></p>
                <c:if test="${libro.idlibro==param.idlibro}">
                    <p>
                        Género: ${libro.genero}, Páginas: ${libro.paginas}
                    </p>
                </c:if>            
        </c:forEach>    
        
        <h3>INSERTA NUEVO LIBRO</h3>
            
        <form action="ServletInsertar8" method="post">
            Titulo:  <input type="text" name="titulo" size="4" />
            Páginas:  <input type="text" name="paginas" value="${libroerroneo.paginas}" size="2"/>           
            Género:  <input type="text" name="genero" value="${libroerroneo.genero}" size="4" />
            Autor: <select name="idautor" >
                        <c:forEach items="${sessionScope.mapaautores}" var="par_autor">       
                             <option value="${par_autor.key}">${par_autor.value}</option>
                        </c:forEach>  
                    </select>
            <input type="submit" value="INSERTAR LIBRO" name="submitinsertar" />
        </form>
         <p>${requestScope.errorinsercion}   </p>
    </body>
</html>
