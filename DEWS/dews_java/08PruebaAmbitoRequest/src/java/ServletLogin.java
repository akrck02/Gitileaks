
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ServletLogin extends HttpServlet {
    
    
     private void dibujaForm(HttpServletRequest request, HttpServletResponse response, PrintWriter out){
            out.println("<form method='post' action='ServletChekLogin'>");            
            out.println("<input type='submit' name='submit' value='ENTRAR' />");           
            out.println("<input type='text' name='nombre' value='' />");           
            out.println("</form>");
    }
     
     private void dibujaErrores(HttpServletRequest request, HttpServletResponse response, PrintWriter out){
            if (request.getAttribute("error")!=null){
                out.println(request.getAttribute("error"));
                out.println("Nombre erroneo: " + request.getParameter("nombre"));
            }
    }
    
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
            
            dibujaErrores(request,response,out);
            dibujaForm(request, response, out);
            out.println("</body>");
            out.println("</html>");
        }
        
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        if (request.getAttribute("error")!=null){
            doGet(request,response);
        }
       
    }

    
}
