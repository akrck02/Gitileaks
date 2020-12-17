<%-- 
    Document   : 01pruebas
    Created on : 15-dic-2020, 10:36:38
    Author     : dw2
--%>






<%@page import="java.io.IOException"%>
<%@page import="java.util.Date"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    
    
    <%!
        private int accesos=0;
        
        private  boolean esBisiesto(int anio) {

            if ((anio%400==0) || (anio%4==0 && anio%100!=0))
                return true;       
           return false;
        }

        private void verSumatorio (int num,JspWriter out){
            int sumatorio=0;
            try{
                out.println("<p>Sumatorio de " + num + " = ");
                for (int cont=num; cont>0; cont--){
                    sumatorio=sumatorio+cont;
                    out.println(cont + " + ");
                }
                out.println("0 =" + sumatorio + "</p>");
            }
            catch (Exception e){
            }
        }

        
        
    %>
    
    
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <ul>
            <li> Fecha actual: <%= new Date() %></li>
            <li> Remote IP <%= request.getRemoteAddr()  %></li>
            <li> Id de sesión <%= session.getId()  %></li>
            <li>
                Parámetro:                
                <%= (request.getParameter("saludo")==null)? "sin param": request.getParameter("saludo") %>
            </li>
            <li>
                <%  if  (Math.random()<0.5)
                {   
                %>                    
                        <p>Que pases un buen día</p>
                 
                 <%
                  }
                  else
                  {
                  %>  
                        <p>Dios te maldiga...</p>
                  <%
                   }
                  %>

            </li>
            <li>
                <%
                   if (Math.random()<0.001)
                        out.println("<p>Te va a tocar la primitiva");
                   else
                        out.println("<p>No te va a tocar la primitiva");
                 %>
            </li>
            <li>
                <%
                    if (esBisiesto(2300)){
                        out.println("<p>Año actual es bisiesto</p>");
                    }
                %>
            </li>
            <li>
                <% 
                    verSumatorio(7,out);
                    verSumatorio(20,out);
                %>
                
            </li>
            
            <%
                accesos++;
                out.println("<p>Accesos a:" + request.getRequestURI() + ": " + accesos+"</p>");
                %>
            
            
        </ul>
        
    </body>
</html>
