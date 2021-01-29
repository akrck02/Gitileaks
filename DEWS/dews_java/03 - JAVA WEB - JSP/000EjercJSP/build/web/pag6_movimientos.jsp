<%-- 
    Document   : pag6_movimientos
    Created on : 19-dic-2018, 20:47:57
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
        
             
        <c:choose>
            
            <c:when test="${sessionScope.cuenta==null}">
                <jsp:forward page="pag6_nuevacuenta.jsp" />
            </c:when>
            <c:otherwise>
                <form method="post" action="ServletMovimientos6" >
                 <table cellpadding="3"  >
                     <tr bgcolor="cccccc" style="text-align: center">
                            <td bgcolor="cccccc" colspan="2"><h3>MOVIMIENTOS</h3></td>
                    </tr>
                    <tr bgcolor="cccccc">
                            <td > Titular </td>
                            <td><label>${sessionScope.cuenta.titular}</label> </td>
                    </tr>
                    <tr bgcolor="cccccc">
                            <td >Saldo actual</td>
                              <td><label>${sessionScope.cuenta.saldo}</label> </td>
                    </tr>
                    <tr bgcolor="cccccc">
                            <td >CANTIDAD</td>
                            <td><input type="text" name="cantidad" ></td>
                    </tr>
                    <tr>
                            <td colspan="2" bgcolor="222222"><p align="center">
                                    <input type="submit" value="INGRESAR" name="submitingresar">
                                    <input type="submit" value="GASTAR" name="submitgastar"></p>
                            </td>
                    </tr>
                    <c:if test="${requestScope.error!=null}">
                        <tr>
                            <td colspan="2" ><p align="center">
                                    ${requestScope.error}
                            </td>
                        </tr>
                    </c:if>
                </table>
                    </form>
                
                
            </c:otherwise>
            
        </c:choose>
      
            
        
    </body>
</html>
