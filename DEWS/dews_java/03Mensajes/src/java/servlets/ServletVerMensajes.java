
package servlets;

import beans.AlmacenMensajes;
import beans.Mensaje;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ServletVerMensajes extends HttpServlet {

    private void verMensajes(PrintWriter out){
       
            ArrayList<Mensaje> lstMens=AlmacenMensajes.getMensajes();
            
            Mensaje me=null;
            out.println(me.getTexto());
            
            out.println("<table>");
            out.println("<tr><th>Emisor</th><th>Mensaje</th><th>A favor</th><th>En contra</th></tr>");
            
            int i=0;
            Iterator it=lstMens.iterator();
            while (it.hasNext()){
                   Mensaje m=(Mensaje)it.next();
                   out.println("<tr>");
                        out.println("<td>"+ m.getEmisor() + "</td>");
                        out.println("<td>"+ m.getTexto() + "</td>");
                        out.println("<td>"+ m.getaFavor() + "</td>");
                        out.println("<td>"+ m.getEnContra() + "</td>");                   
                        
                        String enlace1="ServletVerMensajes?posicion="+i + "&afavor";
                        out.println("<td><a href='"+ enlace1+"'>Votar a favor</a></td>");
                        
                        String enlace2="ServletVerMensajes?posicion="+i + "&encontra";
                        out.println("<td><a href='"+ enlace2+"'>Votar a favor</a></td>");                        
                   out.println("</tr>");
                   i++;
            }
            out.println("</table>");
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {       
        
        if (request.getParameter("posicion")!=null){            
                int i=Integer.parseInt(request.getParameter("posicion"));            
                ArrayList<Mensaje> lstMens=AlmacenMensajes.getMensajes();
                
                if (request.getParameter("afavor")!=null)                           
                    lstMens.get(i).unoMasAFavor();  
                if (request.getParameter("encontra")!=null)                           
                    lstMens.get(i).unoMasEnContra();                
        }        
        
        
        
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ServletVerMensajes</title>");            
            out.println("</head>");
            out.println("<body>");
            
            verMensajes(out);
            
            out.println("</body>");
            out.println("</html>");
        }
        
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    

}
