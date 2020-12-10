
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ServletLogin extends HttpServlet {

    
   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
             response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ServletLogin</title>");            
            out.println("</head>");
            out.println("<body>");  
            
            
            if (request.getParameter("errorlogin")!=null)
                out.println("<p>Error de login</p>");
           //if (request.getAttribute("error")!=null) 
           //    out.println("<p>Error de login</p>");
           
           
            out.println("<form method='post' action='ServletRedir2'>");
            out.println("<label>Introduce password de acceso</label>");
            out.println("<input type='text' name='pass' />");            
            out.println("<input type='submit' name='submitlogin' value='ENTRAR' />");
            out.println("</form>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        doGet(request,response);
       
    }

   

}
