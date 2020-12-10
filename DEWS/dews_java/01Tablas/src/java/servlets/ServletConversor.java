
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ServletConversor extends HttpServlet {
    
    private final static String[] MONEDAS=new String[]{"$","Yenes","Libras"}; 

    private static float convertir (float cantidad, String moneda){
        
        float conversion=0;
        switch (moneda){            
            case "$":   conversion= cantidad * 1.19f;
                        break;                        
            case "Yenes": conversion= cantidad * 124;                
                            break;
            case "Libras":conversion= cantidad * 0.89f;
        }
        return conversion;        
    }
    
    
    
    private void dibujarForm(PrintWriter out,HttpServletRequest request){
        
        String cantidadR="";
        if (request.getParameter("cantidad")!=null)
            cantidadR=request.getParameter("cantidad");
        
        
        String monedaR="";
        if (request.getParameter("moneda")!=null)
            monedaR=request.getParameter("moneda");
        
        out.println("<form method='post' action='"+ request.getRequestURI() +"'>");
        out.println("<label>Introduce cantidad</label>");
        out.println("<input type='text' name='cantidad' value='"+ cantidadR +"'/>");
        out.println("<label>Introduce cantidad</label>");
        out.println("<select name='moneda'>");
        for ( String moneda: MONEDAS){  
            String selected="";
            if (moneda.equals(monedaR))
                selected="selected";
            
            out.println("<option value='" + moneda  + "'  "+ selected+">"+moneda+"</option>");
        }  
        out.println("</select>");
        out.println("<input type='submit' name='submitconvertir' value='CONVERTIR' />");    
        out.println("</form>");
        
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
            out.println("<title>Servlet ServletConversor</title>");            
            out.println("</head>");
            out.println("<body>");
            
            dibujarForm(out,request); 
            
            out.println("</body>");
            out.println("</html>");
        }
       
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        boolean convertido=false;
        float conversion=0;
        if (request.getParameter("submitconvertir")!=null){
            try{
                float cantidad=Float.parseFloat(request.getParameter("cantidad"));
                String moneda=request.getParameter("moneda");     
                conversion=convertir(cantidad, moneda);
                convertido=true;
            }
            catch (NumberFormatException e){                
            }
        } 
        
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ServletConversor</title>");            
            out.println("</head>");
            out.println("<body>");
            
            dibujarForm(out,request); 
            if (convertido)
                out.println("<p>" + conversion + " " + request.getParameter("moneda") + "</p>");
            else
                out.println("<p>Conversion no realizada</p>");                
            
            out.println("</body>");
            out.println("</html>");
        }
    }
    
   
}
