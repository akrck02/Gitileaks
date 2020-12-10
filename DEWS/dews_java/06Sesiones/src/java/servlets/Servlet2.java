
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class Servlet2 extends HttpServlet {

   
      
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
       
        
        HttpSession s=request.getSession();
        
        if (request.getParameter("fin")!=null && request.getParameter("fin").equals("si")){
            s.invalidate();  
            s=request.getSession();
        }
        
        //if (s.getAttribute("nombre")==null){
        //    response.sendRedirect("index.html");
        //}
        //else{
            
            long t1=s.getCreationTime();
            Date d1=new Date(t1);
            
            long t2=s.getLastAccessedTime();
            Date d2=new Date(t2);
            
            Date dDif=new Date(t2-t1);
            
        
            response.setContentType("text/html;charset=UTF-8");
            try (PrintWriter out = response.getWriter()) {
                /* TODO output your page here. You may use following sample code. */
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Servlet Servlet2</title>");            
                out.println("</head>");
                out.println("<body>");
              //  out.println("<h1>Buenos dias "+ s.getAttribute("nombre")+ "</h1>");
                out.println("<p>Tu id de sesion es "+ s.getId() + "</p>");
                out.println("<p>Sesion creada en "+ d1.toString()+ "</p>");
                out.println("<p>Sesion accedida por ultima vez en " + d2.toString()+ "</p>");
                out.println("<p>Llevas conectado " + dDif.getMinutes() + " " + dDif.getSeconds() + "</p>");
                
                String enlaceNoFin=request.getRequestURI() + "?fin=no";
                out.println("<p><a href='"+ enlaceNoFin    +"'>Refrescar</a></p>");
                
                String enlaceFin=request.getRequestURI() + "?fin=si";
                out.println("<p><a href='"+ enlaceFin    +"'>Acabar sesión</a></p>");
                
                
                out.println("</body>");
                out.println("</html>");
            }
        //}
        
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

   

}
