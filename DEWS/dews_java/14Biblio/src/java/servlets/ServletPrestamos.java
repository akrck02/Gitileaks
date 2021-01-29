
package servlets;

import beans.Prestamo;
import dao.DaoBiblio;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ServletPrestamos extends HttpServlet {

  
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ServletPrestamos</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ServletPrestamos at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {       
        
        
       request.getSession().setAttribute("mapaPrestamos",DaoBiblio.mapaPrestamos());
       request.getSession().setAttribute("libros",DaoBiblio.libros());
       request.getSession().setAttribute("mapa",DaoBiblio.mapCantidadPrestamos());
       response.sendRedirect("prestamos.jsp");
               
        
        
    }
   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      
        if (request.getParameter("submit")!=null){
            
            String[] strIds=request.getParameterValues("idlibros");
            if (strIds!=null){  //Controlar algún checkbox marcado
                int[] ids=new int[strIds.length];
                for (int i=0; i<ids.length; i++){
                    ids[i]=Integer.parseInt(strIds[i]);
                }                
                DaoBiblio.prestarVariosLibros(ids);
            }
        }       
        
        doGet(request,response);
    }

  
}
