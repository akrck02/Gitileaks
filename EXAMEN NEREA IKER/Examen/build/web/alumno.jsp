<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<c:if test="${sessionScope.tipo != 'alumno'}">
    <c:redirect url="index.jsp"/>
</c:if>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>APARTADO ALUMNO</h1>
        <h2> Socio: ${sessionScope.usuario.nombre} ${sessionScope.usuario.apellidos} </h2>
        <br>
        <h3>ACTIVIDADES ASIGNADAS</h3>
        <table>
            <tr>
                <th>ACTIVIDAD</th>
                <th>PRECIO</th>
                <th>IMPARTIDOR</th>
            </tr>
            <c:forEach items="${sessionScope.actividades_actuales}" var="actividad">
                <tr>
                    <td>${actividad.nombre}</td>
                    <td>${actividad.coste} €</td>
                    <td>${actividad.impartidor}</td>
                </tr>
            </c:forEach>
        </table>
        <br>
        <h3>NUEVAS INSCRIPCIONES</h3>
        <table>
            <tr>
                <th>ACTIVIDAD</th>
                <th>IMPARTIDOR</th>
                <th>APUNTARSE</th>
            </tr>
            <c:forEach items="${sessionScope.actividades_disponibles}" var="actividad">
                <tr>
                    <td>${actividad.nombre}</td>
                    <td>${actividad.impartidor}</td>
                    <td>
                        <c:choose>
                            <c:when test="${sessionScope.apuntados != null && sessionScope.apuntados.contains(actividad.id)}">
                                 <a href="ServletInscripcion?id=${actividad.id}&accion=anular" style="background-color: grey">ANULAR</a>
                            </c:when>
                            <c:otherwise>
                                <a href="ServletInscripcion?id=${actividad.id}&accion=apuntar">APUNTARSE</a>
                            </c:otherwise>
                        </c:choose>
                    </td>
                </tr>
            </c:forEach>
        </table>
        <c:if test="${sessionScope.apuntados.size() > 0}">
            <h3><a href="ServletInscripcion?finalizar=true">GUARDAR LAS ${sessionScope.apuntados.size()} NUEVAS INSCRIPCIONES</a></h3>
        </c:if>
    </body>
</html>
