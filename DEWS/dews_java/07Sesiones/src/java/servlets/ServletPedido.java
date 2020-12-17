package servlets;



import beans.Comida;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class ServletPedido extends HttpServlet {
    
    @Override
    public void init() throws ServletException {
        
        
        HashMap<String,Comida>  mapComidas=new HashMap<String,Comida>();
        
        //Cargar mapa con asociaciones nombre --> Objeto Comida
        ObjectInputStream ois=null;
        try {
           
            String ruta=getServletContext().getRealPath(getServletContext().getInitParameter("ficherocomidas"));
            ois = new ObjectInputStream(
                    new FileInputStream(ruta));            
            Comida comida=(Comida)ois.readObject();
            while (comida!=null){                
                mapComidas.put(comida.getNombre(), comida);
                comida=(Comida)ois.readObject();
            }          
            
            ois.close();
        } catch (IOException ex) {
            
        } catch (ClassNotFoundException ex) {
           
        } finally {
           
        }
        
        //Establacer mapa como atributo de la aplicacion        
        this.getServletContext().setAttribute("mapComidas", mapComidas);
    }    
    
    private void verTablaPedido(PrintWriter out, HttpServletRequest request){        
        
        HashMap<String,Comida>  mapComidas=
                (HashMap<String,Comida>)this.getServletContext().getAttribute(("mapComidas"));
         
        HttpSession s=request.getSession();
        ArrayList<Comida>lstComidaSesion=(ArrayList<Comida>)s.getAttribute("pedido");
        
        out.println("<table>");
        Iterator<String> it=mapComidas.keySet().iterator();
        
        while (it.hasNext()){
            String nombre=it.next();
            Comida comida=mapComidas.get(nombre);
            
            String enlace=request.getRequestURI()+ "?nombre=" +nombre;
            out.println("<tr>");
            out.println("<td>"+ nombre + "</td>");
            out.println("<td>"+ comida.getPrecio() + "</td>");
            if (!lstComidaSesion.contains(comida))
                out.println("<td><a href='"+ enlace  +"'>Enlace</a></td>");
            else{
                out.println("<td>PEDIDO</td>");
            }
            out.println("</tr>");
        }       
        out.println("</table>");
    }
        
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HashMap<String,Comida>  mapComidas=
                (HashMap<String,Comida>)this.getServletContext().getAttribute(("mapComidas"));
       
        HttpSession s=request.getSession();
        if (s.getAttribute("pedido")==null){
            s.setAttribute("pedido", new ArrayList<Comida>());
        }
        
        ArrayList<Comida> lstComidaSesion= (ArrayList<Comida>)s.getAttribute("pedido");        
        if (request.getParameter("nombre")!=null){            
            lstComidaSesion.add(mapComidas.get(request.getParameter("nombre")));
            
        }
        
        
        
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ServletPedido</title>");            
            out.println("</head>");
            out.println("<body>");
            
            verTablaPedido(out, request);
            
            out.println("</body>");
            out.println("</html>");
        }
        
        
        
       
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

   

}
