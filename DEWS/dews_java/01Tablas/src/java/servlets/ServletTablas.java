
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ServletTablas extends HttpServlet {
    
    private int cuantasTablas;

    @Override
    public void init() throws ServletException {
        super.init(); 
        cuantasTablas=0;
        System.err.println("En metodo init, cuantasTablas=0");
    }
    
    private static void verTablaNum(int num, PrintWriter out){        
        for (int fact=1; fact<=10; fact++){
            out.println("<p>");
            out.println(num + " x " + fact + " = " + (num*fact));
            out.println("</p>");
        }
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
        
        
        
        
      
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            
            
            
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ServletTablas</title>");            
            out.println("</head>");
            out.println("<body>");            
            
            if (request.getParameter("num")!=null){
               int num=Integer.parseInt(request.getParameter("num"));
                verTablaNum(num,out);    
                cuantasTablas++;
            }
            else{           
                for (int cont=1; cont<=10; cont++){
                    out.print("<p><a href='ServletTablas?num=" + cont + "'>Tabla del " + cont + "</a></p>");
                }     
            }
            
            
            out.println("<i>Se han mostrado un total de " + this.cuantasTablas + "tablas</i>");
            out.println("</body>");
            out.println("</html>");
        }
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    
   

}
