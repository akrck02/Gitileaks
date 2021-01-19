
package servlets;

import beans.Libro;
import dao.GestorBD;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ServletInsertar8 extends HttpServlet {

    
     
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
           GestorBD gbd=new GestorBD();
            ArrayList<Libro> libros=gbd.libros();
            request.getSession().setAttribute("libros",libros);
            request.getSession().setAttribute("mapaautores", gbd.mapaautores());
            
            request.getRequestDispatcher("pag8_insertlibro.jsp").forward(request, response);
     
    }
    
    

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
        if (request.getParameter("submitinsertar")==null){
            doGet(request,response);
        }
        else{
            try{
                String titulo=request.getParameter("titulo");
                int paginas=Integer.parseInt(request.getParameter("paginas"));
                String genero=request.getParameter("genero");
                int idautor=Integer.parseInt(request.getParameter("idautor"));     

                Libro libro=new Libro();
                libro.setGenero(genero);
                libro.setIdautor(idautor);
                libro.setPaginas(paginas);
                libro.setTitulo(titulo);

                GestorBD gbd=new GestorBD();
                boolean insertado=gbd.insertarLibro(libro);

                if (!insertado){                
                    request.setAttribute("errorinsercion", "Libro ya existente para ese autor");
                    request.setAttribute("libroerroneo", libro);                    
                }
                else{              
                    //O volvemos a dejar en la sesión todos los libros
                    //o más óptimo: añadimos al atributo de sesión el libro recién añadido
                     /*
                        ArrayList<Libro> librosautor=gbd.librosDeAutor(Integer.parseInt(request.getParameter("idautor")));
                        request.getSession().setAttribute("librosautor",librosautor);
                    */
                    ((ArrayList<Libro>)request.getSession().getAttribute("libros")).add(libro);
                }
            }
            catch(NumberFormatException e){
                request.setAttribute("errorinsercion", "Datos erroneos");
            }
            request.getRequestDispatcher("pag8_insertlibro.jsp").forward(request, response);
        }
    }
  
}
