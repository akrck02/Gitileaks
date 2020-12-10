
package servlets;

import beans.Comida;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ServletGrabar extends HttpServlet {

    
    private boolean crearFichComidas (String[] nombres, int[] precios) throws FileNotFoundException{
        String nomfich=this.getServletContext().getInitParameter("ficherocomidas");
        String url=this.getServletContext().getRealPath(nomfich);        
        
        try {
            ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream(url));
            for (int i=0; i<nombres.length; i++){
                Comida comida=new Comida(nombres[i],precios[i]);
                oos.writeObject(comida);
            }
            oos.writeObject(null);
            oos.close();
        } 
        catch (IOException ex) {
            return false;
        }
        catch (Exception ex){
            return false;
        }
        return true;
    }
   
    protected void escribir(HttpServletRequest request, HttpServletResponse response, String texto)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ServletGrabar</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>"+texto+"</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        if (request.getParameter("submitGrabar")!=null){
            
            String[] nombres=request.getParameterValues("nombres");
            String[] strPrecios=request.getParameterValues("precios");
            int[] precios=new int[strPrecios.length];
            for (int i=0; i<strPrecios.length; i++){
                try{
                    precios[i]=Integer.parseInt(strPrecios[i]);
                }
                catch (NumberFormatException e){
                    precios[i]=0;
                }
            }
            
           if (crearFichComidas(nombres, precios))
               escribir(request, response, "Fichero creado");
           else    
               escribir(request, response, "Fichero NO creado");
            
        }
        
    }

    
}
