<%-- 
    Document   : pag1
    Created on : 16-dic-2018, 16:55:02
    Author     : lamenda
--%>

<%@page import="java.io.IOException"%>
<%@page import="java.util.Date"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Página pruebas</title>
        <%!
            void tabla(JspWriter out, int numero) // throws IOException
            {
                for (int i = 1; i <= 10; i++)
                try{
                    out.print(numero + " x " + i + " = " + numero*i+"<br>");
                } 
                catch (IOException ioe){ioe.printStackTrace();}
            }
            
             //   int accesos=0;
        %>
        
        <%!
            int accesos=0;

        %>


    </head>
    <body>
      
        <%--------------------  OBJETOS IMPLICITOS ---------------------------%>
        <H2>Expresiones JSP</H2>
        <UL>
            <LI>Fecha actual: <%= new Date() %>
            <LI>Su máquina: <%= request.getRemoteHost() %>
            <LI>Su ID de sesión: <%= session.getId() %>
            <LI>El parámetro <CODE>nombre</CODE>:  <%= request.getParameter("nombre") %>
        </UL>
   
        
    <p>
        <% if (Math.random() < 0.5) {%>
                <b>Que tenga un buen día</b>
        <% } else 
            out.println("<u>Que tenga mucha suerte "+ request.getParameter("nombre") +"</u>");
        %>
    </p>
    
    <%--------------------  Métodos del servlet ---------------------------%>
        <%
        tabla(out, 7);
        out.print("<p>");
        tabla(out, 4);       
        %>

    <%--------------------  Atributos del servlet ---------------------------%>
    <p>
            <%= ++accesos + " accesos a esta página"   %>.   
    </p>

    
    
    <%--------------------  Distintos tipos de response: excel, html ---------------------------%>
    <p>
      <% 
        String formato = request.getParameter("formato");
        // Si el parámetro no existe se eleva un NullPointerException 
        //--> incluimos directiva errorPage
        if (formato!=null){
            if (formato.equals("excel")) {
                response.setContentType("application/vnd.ms-excel");               
            } else {
                response.setContentType("text/plain");
            }
        }       
     %>    
      
      
      <TABLE BORDER=1>
        <TR><TH></TH><TH>Peras<TH>Manzanas
        <TR><TH>Primer trimestre<TD>2307<TD>4706
        <TR><TH>Segundo trimestre<TD>2982<TD>5104
        <TR><TH>Tercer trimestre<TD>3011<TD>5220
        <TR><TH>Cuarto trimestre<TD>3055<TD>5287
      </TABLE>
    </p>
    
    
    <%--------------------  Diferencia directiva/acción include ---------------------------%>
    <%-----------  Directiva: incluye el código antes de compilarse el servlet: tiene acceso a variables de la ppal -------%>
    <%-----------  Acción: se incluye la salida de la página incluida -----
    Si la incluidda es dinámica, se le envía el request, se ejecuta, y el resultado de la ejecución se incluye en la response de la JSP principal.--%>
    <%-----------  Directiva: más pensada para contenidos estáticos, pies, cabeceras, plantillas -------%>
      <%-----------  Acción: más pensada para contenido dinámico. Para hacer parte de la labor de la principal -------%>
    <% String colorparr="red"; %>
    <%@include  file="pag1incluida_directiva.jsp" %>
    <%-- <jsp:include page="pag1incluida_accion.jsp" /> --%>
      
    
     <%--------------------  Página incluida forma parte de la request de la principal: tiene acceso a sus parámetros ---------------------------%>
    <jsp:include page="pag1_circulo.jsp" />
    
     
    </body>
</html>
