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
        <h3>Comprueba apuestas del 12/11/2018</h3>
        
        <table cellpadding="3"  style="border: 2px solid #000000; width: 300 " >
                <tr>
                        <td > <b>Nombre </b></td>
                        <td ><input type="text" name="nombre" value='Juan Carlos Gil'></td>                        
                </tr>
                <tr>
                        <td > <b>Administración Nº </b></td>
                        <td ><input type="text" name="nombre" value='124'></td>                        
                </tr>
                 <tr>
                       
                   
                        
                </tr>
                <tr>                       
                    <td colspan="2" >
                        <table >
                            <tr style="text-align: center">
                                <td colspan='6'><b>Introduce 6 números</b></td>
                            </tr>
                             <tr>
                                 <td><input type="text" name="nombre" size="3" value="1"></td>
                                 <td><input type="text" name="nombre" size="3" value="2"></td>
                                  <td><input type="text" name="nombre" size="3" value="4"></td>
                                   <td><input type="text" name="nombre" size="3" value="26"></td>
                                    <td><input type="text" name="nombre" size="3" value="43"></td>
                                     <td><input type="text" name="nombre" size="3" value="47"></td>
                            </tr>
                            <tr style="text-align: center">
                                <td colspan='6'><b>Introduce reintegro: </b><input type="text" name="nombre" size="3" value="5"></td>
                            </tr>
                           
                             <tr style="text-align: center">
                                <td colspan='6'> <input type="submit" value="COMPROBAR" name="submitcuenta"></td>
                            </tr>
                             <tr style="text-align: center">
                                 <td colspan='6'> <h4>Apuesta de Juan Carlos Gil, admon 124, aciertos: 25  36. Sin reintegro</h4></td>
                            </tr>
                            
                        </table>
                    </td>
                        
                </tr>
                              
               
            </table>
        
    </body>
</html>
