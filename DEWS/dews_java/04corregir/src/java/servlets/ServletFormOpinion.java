/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author dw2
 */
public class ServletFormOpinion extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ServletFormOpinion</title>");            
            out.println("</head>");
            out.println("<body>");
                if(request.getParameter("error")!=null){
                    out.println("<p style='color:red'><strong>Error: <strong>No ha rellenado o seleccionado todos los campos obligatorios</p>");
                }
                out.println("<form action='ServletFormOpinion' method='post'>");
                    out.println("<label for='nombre'><strong>Nombre: </strong></label>");
                    out.println("<input type='text' name='nombre' id='nombre'/>");
                    out.println("<br/>");
                    out.println("<br/>");
                    out.println("<label for='apellidos'><strong>Apellidos: </strong></label>");
                    out.println("<input type='text' name='apellidos' id='apellidos'/>");
                    out.println("<br/>");
                    out.println("<br/>");
                    out.println("<label><strong>Opinión que le ha merecido este sitio web</strong></label><br/>");
                    out.println("<input type='radio' name='opinion' id='buena' value='B'/>");
                    out.println("<label for='buena'>Buena</label>");
                    out.println("<br/>");
                    out.println("<input type='radio' name='opinion' id='regular' value='R'/>");
                    out.println("<label for='regular'>Regular</label>");
                    out.println("<br/>");
                    out.println("<input type='radio' name='opinion' id='mala' value='M'/>");
                    out.println("<label for='mala'>Mala</label>");
                    out.println("<br/>");
                    out.print("<br/>");
                    out.print("<br/>");
                    out.println("<label>Comentarios</label>");
                    out.println("<br/>");
                    out.println("<textarea name='comentarios' rows='10' cols='40'></textarea>");
                    out.println("<br/>");
                    out.println("<br/>");
                    out.println("<label><strong>Tus secciones favoritas</strong></label><br/>");
                    
                    BufferedReader br=new BufferedReader(new FileReader(request.getServletContext().getRealPath("secciones.txt")));
                    String linea=br.readLine();
                    while(linea!=null){
                        out.println("<input type='checkbox' name='secciones' id='"+linea+"' value='"+linea+"'/>");
                        out.println("<label for='"+linea+"'>"+linea+"</label>");
                        out.println("<br/>");
                        linea=br.readLine();
                    }
                    br.close();
                    
                    
                    out.println("<br/>");
                    out.println("<br/>");
                    out.println("<input type='submit' name='submit' value='Enviar opinión'/>");
                
                
                
                
                
                out.println("</form>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if((request.getParameter("nombre").equals(""))
            ||(request.getParameter("apellidos").equals(""))
            ||(request.getParameter("opinion")==null)){
            response.sendRedirect("ServletFormOpinion?error");
        }
        else{
            String op=request.getParameter("opinion");
            if(request.getParameter("opinion").equals("B")){
                try(FileWriter fw=new FileWriter(request.getServletContext().getRealPath("seccionesfavoritas.txt"), true)){
                    String escribir=request.getParameter("nombre")+" "+request.getParameter("apellidos")+": ";
                    String[] strarr=request.getParameterValues("secciones");
                    for(int i=0; i<strarr.length;i++){
                        if(i!=strarr.length-1)
                            escribir+=strarr[i]+", ";
                        else
                            escribir+=strarr[i]+"\n";
                    }
                    fw.append(escribir);
                    
                }
            }
        }
    }


}
