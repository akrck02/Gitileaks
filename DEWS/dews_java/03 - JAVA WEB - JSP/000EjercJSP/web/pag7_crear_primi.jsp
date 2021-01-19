<%-- 
    Document   : pag6_crear_primitiva
    Created on : 20-dic-2018, 0:22:33
    Author     : lamenda
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="ServletCuenta6" method="post">
            <table cellpadding="3"  >
                <tr bgcolor="222222" style="text-align: center" >
                   
                        <td bgcolor="cccccc" colspan="6"><h3>PRIMITIVA</h3></td>
                        
                </tr>
                <tr bgcolor="cccccc">
                        <td > Día </td>
                        <td><input type="text" name="dia" value="3" ></td>
                        <td > Mes </td>
                        <td><input type="text" name="mes" value="11" ></td>
                        <td > Año </td>
                        <td><input type="text" name="anio" value="2018" ></td>
                </tr>
                 <tr bgcolor="cccccc">
                        <td colspan="6"> <b>Números: </b>2 - 3 - 25 - 26 - 30 - 36  <b>Reintegro:</b> 0 </td>                       
                </tr>
                 <tr bgcolor="cccccc"  style="text-align: center">
                        <td colspan="6"> <a href="">COMPROBAR APUESTAS</a> </td>                       
                </tr>
                              
                <tr>
                        <td colspan="6" bgcolor="222222"><p align="center">
                                <input type="submit" value="Crear Primitiva" name="submitcuenta"></p>
                        </td>
                </tr>
            </table>
        </form>
    </body>
</html>
