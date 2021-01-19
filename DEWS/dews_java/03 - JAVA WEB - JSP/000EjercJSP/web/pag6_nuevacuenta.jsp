<%-- 
    Document   : pag5_nuevacuenta
    Created on : 19-dic-2018, 20:15:15
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
        
        <c:forEach items="${requestScope.errores}" var="error">
            <p style="color: red; ">            ${error}       </p>
        </c:forEach>
         <form action="ServletCuenta6" method="post">
            <table cellpadding="3"  >
                <tr bgcolor="cccccc" style="text-align: center" >
                   
                        <td bgcolor="cccccc" colspan="2"><h3>NUEVA CUENTA</h3></td>
                        
                </tr>
                <tr bgcolor="cccccc">
                        <td > Titular </td>
                        <td><input type="text" name="titular" value="${requestScope.cuenta.titular}" ></td>
                </tr>
                <tr bgcolor="cccccc">
                        <td >Saldo inicial</td>
                        <td><input type="text" name="saldo" value="${requestScope.cuenta.saldo}"></td>
                </tr>
               
                <tr>
                        <td colspan="2" bgcolor="222222"><p align="center">
                                <input type="submit" value="Crear Cuenta Corriente" name="submitcuenta"></p>
                        </td>
                </tr>
            </table>
        </form>
    </body>
</html>
