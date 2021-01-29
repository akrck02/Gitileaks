<%-- 
    Document   : nuevaempresa
    Created on : 16-dic-2020, 10:31:05
    Author     : dw2
--%>

<%@page import="java.util.HashSet"%>
<%@page import="beans.Empresa"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
        <%
            
           if (application.getAttribute("todasempresas")==null)
                application.setAttribute("todasempresas", new HashSet<Empresa>());
           HashSet<Empresa> todasEmpresas=(HashSet<Empresa>)application.getAttribute("todasempresas");
            
            
            if (request.getParameter("submitEmpresa")!=null){
                try{
                    String nombre=request.getParameter("nombre");
                    float beneficio=Float.parseFloat(request.getParameter("beneficio"));
                    int maxtrab=Integer.parseInt(request.getParameter("maxtrab"));

                    Empresa e=new Empresa(nombre, beneficio, maxtrab);
                    if (todasEmpresas.contains(e)){
                           request.setAttribute("error", new Exception("Empresa ya existente"));
        %>
                            <jsp:include page="nuevaempresa_error.jsp" />
        <%
                        
                    }
                    else{
                            session.setAttribute("empresa", e); 
                            todasEmpresas.add(e);
                    }
                }
                catch (NumberFormatException e){
                    request.setAttribute("error", e);
        %>
                    <jsp:include page="nuevaempresa_error.jsp" />
        <%
                }
            }
        
        
            if (request.getAttribute("noempresa")!=null){
                out.println("<p>"+request.getAttribute("noempresa") + "</p>");
            }

        
        %>
        
        <h2>NUEVA EMPRESA</h2>
        
        <form method="post" action="<%= request.getRequestURI()    %>">
            <table>
                <tr>
                    <td>Nombre</td>
                    <td><input type="text" name="nombre" /></td>
                </tr>   
                <tr>
                    <td>Beneficio</td>
                    <td><input type="text" name="beneficio" /></td>
                </tr>   
                <tr>
                    <td>Maximo trabajadores</td>
                    <td><input type="text" name="maxtrab" /></td>
                </tr> 
                 <tr>
                     <td colspan="2" style="text-align: center">
                         <input type="submit" name="submitEmpresa" value="Crear Empresa" />
                     </td>
                  
                </tr> 
            </table>
        </form>
            
            
        <%
            if (session.getAttribute("empresa")!=null){
                out.println("<p><a href='trabajadores.jsp'>Ver Trabajadores</a></p>");
                out.println("<p>"+ session.getAttribute("empresa")+"</p>");
            }
        %>
    </body>
</html>
