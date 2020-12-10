<%-- 
    Document   : index
    Created on : 27-nov-2020, 13:00:44
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
        <h1>Nuevo mensaje</h1>
        <form action="ServletAniadirMensaje" method="post">
            Emisor <input type="text" name="emisor"  />
            Mensaje <input type="text" name="texto"  />
            <input type="submit" name="submit" value="Añadir mensaje" /> 
            
        </form>
    </body>
</html>
