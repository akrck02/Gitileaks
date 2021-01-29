package servlets;

import beans.Alumno;
import dao.Dao;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ServletInscripcion extends HttpServlet {
   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        
    } 

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        if(request.getParameter("finalizar")!= null || (request.getParameter("id") != null && request.getParameter("accion") != null)){

            HttpSession session = request.getSession();
            if(session.getAttribute("apuntados") == null){
                session.setAttribute("apuntados", new ArrayList<Integer>());
            }
            
            ArrayList<Integer> apuntados = (ArrayList<Integer>) session.getAttribute("apuntados");
            
            try{
                if(request.getParameter("finalizar") != null){
                    
                    Alumno a = (Alumno) session.getAttribute("usuario");
                    System.out.println("AAAAAAAAAAAAAAAAAAAA");
                    System.out.println(a.getNombre());
                    Dao.inscribir(a, apuntados);

                    session.setAttribute("actividades_actuales", Dao.actividadesParticipa(a));
                    session.setAttribute("actividades_disponibles", Dao.actividadesLibresNoParticipa(a));
                    
                    session.removeAttribute("apuntados");
                }
                else if(request.getParameter("accion").equals("apuntar")){
                    int id = Integer.parseInt(request.getParameter("id"));
                    if(!apuntados.contains(id))
                        apuntados.add(id);
                }
                else if(request.getParameter("accion").equals("anular")){
                    apuntados.remove(new Integer(Integer.parseInt(request.getParameter("id"))));
                }
            }catch(NumberFormatException e){
            }
        }
        response.sendRedirect("alumno.jsp");
    } 

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        
    }
}
