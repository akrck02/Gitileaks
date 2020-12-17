

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
public class ServletChekLogin extends HttpServlet {

  
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ServletChekLogin</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Login correcto con nombre "+request.getParameter("nombre")+"</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (request.getParameter("submit")!=null){
            
            String nombre=request.getParameter("nombre");
            //Nombres validos de login empiezan en a
            
            
            if (nombre.charAt(0)!='a' && nombre.charAt(0)!='A'){
                //response.sendRedirect("ServletLogin");
                request.setAttribute("error", "Error login");
                request.getRequestDispatcher("ServletLogin").forward(request, response);                
            }
            else{
                doGet(request, response);
            }
        }
    }

    

}
