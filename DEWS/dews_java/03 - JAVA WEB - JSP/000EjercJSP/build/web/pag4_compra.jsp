<%-- 
    Document   : pag4_compra
    Created on : 19-dic-2018, 15:53:11
    Author     : lamenda
--%>

<%@page import="java.util.HashMap"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
         
         <%
             if (session.getAttribute("mapacompra")==null){
                 session.setAttribute("mapacompra", new HashMap<String,Integer>());
             }
             HashMap<String,Integer> mapacompra=(HashMap<String,Integer>)session.getAttribute("mapacompra");
             out.println(mapacompra);
             if (request.getParameter("submitcompra")!=null){
                 int nuevacantidad=1;
                 if (mapacompra.containsKey(request.getParameter("producto"))){
                     nuevacantidad=mapacompra.get(request.getParameter("producto"))+1;                   
                 }
                
                 mapacompra.put(request.getParameter("producto"),nuevacantidad);                 
               
             }


         %>

         <table>
            
            <%
              
                 ArrayList<String> productos=( ArrayList<String>)session.getAttribute("productos");
               
                 out.println("<tr><th>PRODUCTO</th><th>PEDIR</th><th></th></tr>");
                 for (String producto: productos){
                     out.println("<form method='post' action='" + request.getRequestURI() +"'>");
                     out.println("<tr>");
                     out.println("<td>"+ producto + "</td>");
                     out.println("<input type='hidden' name='producto' value='"+producto+"' />");
                     out.println("<td><input type='submit' name='submitcompra' value='Adquirir unidad' /></td>");
                     out.println("<td>");
                     if (mapacompra.containsKey(producto)){
                         out.println(mapacompra.get(producto) + " unidades");
                     }                     
                     out.println("</td>");
                     out.println("</tr>");    
                     out.println("</form>");
                 }
             %> 
            </table>
             <jsp:include page="pag4_carro.jsp"  />
            
        
        
    </body>
</html>
