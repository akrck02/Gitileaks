<%-- 
    Document   : pag3_trabajadores
    Created on : 17-dic-2018, 15:44:21
    Author     : lamenda
--%>

<%@page import="beans.Trabajador"%>
<%@page import="beans.Telefonomovil"%>
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
                Empresa e=(Empresa)session.getAttribute("empresa");
                if (e==null)
                    response.sendRedirect("pag3_empresa.jsp");
             %>
             
             <%        
                 // es otra página (pag3_contratar.jsp) la que procesa el formulario y le deja preparado a esta el resultado
                 // de la última contratación: un atributo de request con el Trabajador contratado/no contratado
                 // un parámetro con mensaje de error si no se ha podido contratar
                 
                if (request.getAttribute("ultimo_trabajador")!=null){
                    Trabajador ultimo_trab=(Trabajador)request.getAttribute("ultimo_trabajador");
                    if (request.getParameter("error_contratar")!=null)
                        out.println (request.getParameter("error_contratar") + " " + ultimo_trab.getNombre() + " no contratado");
                    else
                        out.println (ultimo_trab.getNombre() + " contratado");                    
                }
             %>             
             
             <%	
                if (request.getParameter("submit_trabajar_empresa")!=null){
                    e.trabajar();                    
               }
            %>             
             
        <%-- DATOS EMPRESA (sesion) y sus trabajadores --%>
       
            <table cellpadding="3"  >              
                <tr bgcolor="cccccc">
                       <td colspan="5">
                           Empresa:<%=e.getNombre()%>  
                           , beneficio: <%=e.getBeneficio()%>€
                           , max trabajadores: <%=e.getTrabajadores().length %>
                       </td>          
                </tr>         
                
                <tr bgcolor="#bbbbbb"><td colspan="5" align="center">TRABAJADORES DE LA EMPRESA</td></tr>
                <tr><td>NOMBRE</td><td>DNI</td><td>DINERO</td><td>TELEF</td><td>BATERIA</td></tr>
                <%
                    for (int i=0; i < e.getCantTrab(); i++){
                            Trabajador trab=e.getTrabajadores()[i];
                            out.print("<tr>");
                            out.print("<td>" + trab.getNombre()+"</td>");
                            out.print("<td>" + trab.getDni() +"</td>");		
                            out.print("<td>" + trab.getDinero() +"</td>");
                            out.print("<td>" + ((Telefonomovil)trab.getMovil()).getNumero() +"</td>");
                            out.print("<td>" + ((Telefonomovil)trab.getMovil()).getBateria() +"</td>");
                            out.print("</tr>");
                    }
                %>                
            </table>
                
            </br></br>
            
        
        <%-- FORMULARIO nuevo trabajador y trabajar --%>
	
            <form method="post" action="pag3_contratar.jsp">
		<table>
                    <tr bgcolor="#bbbbbb">
                        <td colspan="2"> NUEVO TRABAJADOR:</td>
                    </tr>
                    <tr>
                        <td> Nombre: <input type="text" name="nombre" /></td>
                        <td> Dni: <input type="text" name="dni" /></td>
                    </tr>
                    <tr>
                        <td> Telefono: <input type="text" name="numero" /></td>
                        <td> Bateria: <input type="text" name="bateria" /></td>
                    </tr>

                    <tr>
                        <td colspan="2" style="text-align: center">
                            <input type="submit" name="submit_nuevotrab" value="Añadir trabajador"/></td>
                    </tr>
                    <tr>
                        <td colspan="2" style="text-align: center">
                            <input type="submit" name="submit_trabajar_empresa" value="Trabajar"/></td>
                    </tr>
                </table>
            </form>
    </body>
</html>
