
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ServletForm extends HttpServlet {

    private void dibujaFormArriba(HttpServletRequest request, HttpServletResponse response, PrintWriter out){
            out.println("<form method='post' action='"+request.getRequestURI()+"'>");            
            out.println("<input type='submit' name='submitNumero' value='Generar campos' />");
            out.println("<label>con</label>");
            out.println("<input type='number' name='numero' value='5' />");
            out.println("<label>alimentos</label>");
            out.println("</form>");
    }
    
    
    private void dibujaFormAbajo(HttpServletRequest request, HttpServletResponse response, 
                    PrintWriter out){
          int cantidad=Integer.parseInt(request.getParameter("numero"));
        
          out.println("<form method='post' action='ServletGrabar'>");
          out.println("<table>");
          out.println("<tr><th>Num</th><th>Comida</th><th>Precio</th></tr>");
          for (int cont=1; cont<=cantidad; cont++){
              out.println("<tr>");
              out.println("<td>Comida " + cont + "</td>");
              out.println("<td><input type='text' name='nombres' /></td>");
              out.println("<td><input type='number' name='precios' value='1' /></td>");              
              out.println("</tr>");
          }
          out.println("</table>");
          out.println("<input type='submit' name='submitGrabar' value='CREAR FICHERO DE COMIDAS' />");
         
          out.println("</form>");
           
          
    }
   
//    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
         response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ServletForm</title>");            
            out.println("</head>");
            out.println("<body>");
            
            dibujaFormArriba(request, response, out);
             
            out.println("</body>");
            out.println("</html>");
        }
        
        
        
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        if (request.getParameter("submitNumero")!=null){
            
                response.setContentType("text/html;charset=UTF-8");
           try (PrintWriter out = response.getWriter()) {
               /* TODO output your page here. You may use following sample code. */
               out.println("<!DOCTYPE html>");
               out.println("<html>");
               out.println("<head>");
               out.println("<title>Servlet ServletForm</title>");            
               out.println("</head>");
               out.println("<body>");

               dibujaFormArriba(request, response, out);
               dibujaFormAbajo(request, response,out);

               out.println("</body>");
               out.println("</html>");
        }
        
            
            
            
            
        }
        
    }

    

}
