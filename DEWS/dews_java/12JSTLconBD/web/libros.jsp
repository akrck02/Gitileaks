
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
    
    <c:if test="${sessionScope.libros==null}" >
        <jsp:forward page="ServletLibros"/>
    </c:if>
        
    <c:forEach items="${sessionScope.libros}" var="libro">
        <p><a href="libros.jsp?idlibro=${libro.idlibro}">${libro.titulo}</a>
        <c:if test="${param.idlibro==libro.idlibro}">
            &nbsp; GENERO: ${libro.genero}
        </c:if>
        </p>
    </c:forEach>
            
    <h2>INSERTAR NUEVO LIBRO</h2>
    <form method="post" action="ServletLibros">
        Titulo: <input type="text" name="titulo" value="${param.titulo}"/>
        Páginas: <input type="text" name="paginas" value="${param.paginas}"/>
        Género: <input type="text" name="genero" value="${param.genero}"/>
        Autor: <select name="idautor">
            <c:forEach items="${sessionScope.mapaautores}" var="par">                
                <option value="${par.key}">${par.value.nombre}</option>
            </c:forEach>            
              </select>
        <input type="submit" name="submitInsertarLibro" value="INSERTAR LIBRO" />
    </form>
    
    <c:if test="${requestScope.errorinsercion!=null}">
        <p>${requestScope.errorinsercion}</p>
    </c:if>
    
    </body>
    
</html>
