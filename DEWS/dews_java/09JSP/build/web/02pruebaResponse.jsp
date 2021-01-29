<%-- 
    Document   : 02pruebaResponse
    Created on : 15-dic-2020, 11:10:50
    Author     : dw2
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            
            if (request.getParameter("formato")!=null && 
                    request.getParameter("formato").equalsIgnoreCase("excel"))
                    response.setContentType("application/vnd.ms-excel");
            else
                    response.setContentType("text/html");
        %>
        
        
        <table>
            <tr>
                <td>AAA</td>
                 <td>BBB</td>
                  <td>CCC</td>
            </tr>
            <tr>
                <td>DDD</td>
                <td>EEE</td>
                <td>FFF</td>
            </tr>
            
        </table>
    </body>
</html>
