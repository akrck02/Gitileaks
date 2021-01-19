<%-- 
    Document   : pag2
    Created on : 16-dic-2018, 18:16:45
    Author     : lamenda
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page  errorPage="pag2_errores.jsp?error=Deben ser datos numéricos!!" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
        
        <%
            
        if (request.getParameter("resolver")!=null){
            
            int a=Integer.parseInt(request.getParameter("a"));
            int b=Integer.parseInt(request.getParameter("b"));
            int c=Integer.parseInt(request.getParameter("c"));
            
         
           
            
            if (a==0) {
        %>
                <jsp:include page="pag2_errores.jsp">
                    <jsp:param name="error" value="No es una ecuación de segundo grado" />
                </jsp:include>
        <%        
            }
            else if ( (b*b - 4*a*c)< 0){
        %>
                <jsp:include page="pag2_errores.jsp">
                    <jsp:param name="error" value="Soluciones imaginarias" />
                </jsp:include>
        <%        
            }
            else{
                double x1=(-b + Math.sqrt(b*b -4*a*c))/(2*a);
                double x2=(-b - Math.sqrt(b*b -4*a*c))/(2*a);
        %>
                <jsp:include page="pag2_soluciones.jsp">
                       <jsp:param name="x1" value="<%=x1%>" />
                       <jsp:param name="x2" value="<%=x2%>" />
                </jsp:include>
        <%        
            }
        }
        
        %>
        
        <form method="post" value="Enviar" action="<%= request.getRequestURI()  %>">
             <input type="text" name="a" /> x2 + <input type="text" name="b" />x + <input type="text" name="c" /> = 0
             <input type="submit" name="resolver" value="Resolver" />
        </form>
    </body>
</html>
