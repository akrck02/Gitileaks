
package servlets;

import beans.Libro;
import dao.GestorBD;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ServletLibros extends HttpServlet {

   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ServletLibros</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ServletLibros at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      
        GestorBD gbd=new GestorBD();
        request.getSession().setAttribute("libros",gbd.libros());        
        request.getSession().setAttribute("mapaautores", gbd.autores());
        
        //response.sendRedirect("libros.jsp");
        request.getRequestDispatcher("libros.jsp").forward(request, response);
        
        
        
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        if (request.getParameter("submitInsertarLibro")!=null){
            try{
                String titulo=request.getParameter("titulo");
                int paginas=Integer.parseInt(request.getParameter("paginas"));
                String genero=request.getParameter("genero");
                int idautor=Integer.parseInt(request.getParameter("idautor"));

                Libro l=new Libro(titulo, paginas, genero, idautor);
                GestorBD gbd=new GestorBD();
                gbd.insertarLibro(l);
            }
            catch(NumberFormatException e){
                request.setAttribute("errorinsercion", "Introduce datos correctos");
              
            }
        }
        
        doGet(request, response);
       
    }

   
}
