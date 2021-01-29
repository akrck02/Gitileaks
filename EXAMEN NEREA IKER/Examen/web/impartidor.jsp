<%@page import="java.util.HashMap"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.TreeMap"%>
<%@page import="beans.Alumno"%>
<%@page import="beans.Actividad"%>
<%@page import="java.util.ArrayList"%>
<%@page import="beans.Impartidor"%>
<%@page import="dao.Dao"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%!
    SimpleDateFormat formateador = new SimpleDateFormat("dd-MM-yyyy");
    public String formatDate(Date d){
        return formateador.format(d);
    }
%>
<%
    if(session.getAttribute("tipo") == null || !session.getAttribute("tipo").equals("impartidor")){
        response.sendRedirect("index.jsp");
    }
    else{
        Impartidor impartidor = (Impartidor) session.getAttribute("usuario");
        ArrayList<Actividad> actividades = (ArrayList<Actividad>) session.getAttribute("actividades");
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>IMPARTIDOR</title>
    </head>
    <body>
        <h1>IMPARTIDOR</h1>
        <h2><%= impartidor %></h2>
        <table>
            <%
            for(Actividad act : actividades){
                if(request.getParameter("info") != null && Integer.parseInt(request.getParameter("info")) == act.getId()){
                    out.println("<tr style='background-color: grey'>");
                }
                else{
                   out.println("<tr>");  
                }
                    out.println("<td>" + act.getNombre() + "</td>");
                    out.println("<td><a href='impartidor.jsp?info=" + act.getId() + "'>ASISTENCIA</a></td>");
                out.println("</tr>");
            }
            %>
        </table>
        <br>
        <%
            try{
                if(request.getParameter("info") != null){
                    int id = Integer.parseInt(request.getParameter("info"));
                    out.println("<table>");
                        out.println("<tr>");
                            out.println("<th>Nombre</th>");
                            out.println("<th>Telefono</th>");
                            out.println("<th>Email</th>");
                            out.println("<th>Última asistencia</th>");
                            out.println("<th>Tipo de aviso</th>");
                        out.println("</tr>");
                        
                        HashMap<Alumno, Date>  mapaAlumnos = Dao.mapaAsistenciaActividad(id);
                        for(Alumno alum : mapaAlumnos.keySet()){
                            out.println("<form action='ServletAvisos' method='POST'");
                            out.println("<input type='hidden' name='dni' value='" + alum.getDni() + "'>");
                            out.println("<tr>");
                                out.println("<td>" + alum.getNombre() + "</td>");
                                out.println("<td><input type='text' name='telefono' value='" + alum.getTelefono() + "'></td>");
                                out.println("<td><input type='text' name='email' value='" + alum.getEmail()+ "'></td>");
                                if(mapaAlumnos.get(alum) == null){
                                    out.println("<td>Todavía no hay datos de asistencia!</td>");
                                }else{
                                    out.println("<td>" + formatDate(mapaAlumnos.get(alum)) + "</td>");
                                }
                                
                                out.println("<td>");
                                    out.println("Email <input type='radio' name='aviso' value='email' checked>");
                                    out.println("Teléfono <input type='radio' name='aviso' value='telefono'>");
                                out.println("</td>");
                                out.println("<td><input type='submit' name='avisar' value='AVISAR'></td>");
                            out.println("</tr>");
                            out.println("</form>");
                        }
                    out.println("</table>");
                   
                } 
            }catch(NumberFormatException e){}
            
        %>
    </body>
</html>
<%
}
%>