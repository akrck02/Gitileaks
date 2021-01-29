
package servlets;

import beans.Persona;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ServletInicio extends HttpServlet {

   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ServletInicio</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ServletInicio at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        ArrayList<Persona> personas=new ArrayList<Persona>();
        
        personas.add(new Persona("Jon",20, new String[]{"Cocina","Tenis"}));
        personas.add(new Persona("Ander",20, new String[]{"Programar","Baloncesto","Tele"}));
        personas.add(new Persona("Ibai",20, new String[]{"Baile","Gastronomia","Pintura"}));
        
        request.getSession().setAttribute("personas", personas);
        
        response.sendRedirect("listaPersonas.jsp");
        
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

   
   
}
