<%-- 
    Document   : trabajadores
    Created on : 16-dic-2020, 10:49:13
    Author     : dw2
--%>

<%@page import="beans.Movil"%>
<%@page import="beans.Trabajador"%>
<%@page import="beans.Empresa"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%
    if (session.getAttribute("empresa")==null){
                request.setAttribute("noempresa", "Debes crear una empresa....");
%>
                <jsp:forward page="nuevaempresa.jsp"/>                  
                    
<%
    }
    Empresa e=(Empresa)session.getAttribute("empresa");

    if (request.getParameter("trabajarE")!=null)
        e.trabajar();

    if (request.getParameter("trabajarT")!=null){
        int i=Integer.parseInt(request.getParameter("trabajarT"));
        e.getTrabajadores()[i].trabajar();
    }


    String errorCrearTrabajador=null;

    if (request.getParameter("submitTrabajador")!=null){
        String nombre=request.getParameter("nombre");
        String dni=request.getParameter("dni");
        String numero=request.getParameter("numero");
        int bateria=Integer.parseInt(request.getParameter("bateria"));

        Trabajador t=new Trabajador();
        t.setNombre(nombre);
        t.setDni(dni);
        t.setDinero(0);
        Movil m=new Movil();
        m.setNumero(numero);
        m.setBateria(bateria);
        t.setMovil(m);

        if (!e.contratar(t))
            errorCrearTrabajador="La empresa no admite más trabajadores";
    }

    

%>



<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
        <%
            out.println("<p>"+e.toString()+"</p>");
            
            if (errorCrearTrabajador!=null)
                out.println("<p>"+errorCrearTrabajador+"</p>");
            
                
            Trabajador[] trabajadores=e.getTrabajadores();
            out.println("<table>");
            out.println("<tr><th>Nombre</th><th>DNI</th><th>Dinero</th><th>Móvil</th><th>Batería</th><th>Trabajar</th></tr>");
            for (int i=0; i <e.getTrabActuales(); i++){
                Trabajador t=trabajadores[i];
                out.println("<tr>");
                out.println("<td>"+t.getNombre()+"</td>");
                out.println("<td>"+t.getDni()+"</td>");
                out.println("<td>"+t.getDinero()+"</td>");
                out.println("<td>"+t.getMovil().getNumero()+"</td>");
                out.println("<td>"+t.getMovil().getBateria()+"</td>");
                String enlace=request.getRequestURI() + "?trabajarT="+i;
                out.println("<td><a href='"+enlace+"'>TRABAJAR</a></td>");
                out.println("</tr>");
            }          

            out.println("</table>");
            


        %>
        
        
         <h2>NUEVO TRABAJADOR</h2>
        <form method="post" action="<%= request.getRequestURI()  %>">
            <table>
                <tr>
                    <td>Nombre</td>
                    <td><input type="text" name="nombre" /></td>
                </tr>
                <tr>
                    <td>DNI</td>
                    <td><input type="text" name="dni" /></td>
                </tr>
                <tr>
                    <td>Número móvil</td>
                    <td><input type="text" name="numero" /></td>
                </tr>
                 <tr>
                    <td>Bateria</td>
                    <td><input type="text" name="bateria" /></td>
                </tr>
                <tr>
                     <td colspan="2" style="text-align: center">
                         <input type="submit" name="submitTrabajador" value="Añadir trabajador" />
                     </td>
                  
                </tr> 
            </table>
        </form>
            
        <p><a href="<%= request.getRequestURI() + "?trabajarE" %>">TRABAJAR</a></p>    
            
            
    </body>
</html>
