package servlets;

import beans.Alumno;
import beans.Impartidor;
import dao.Dao;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ServletLogin extends HttpServlet {
   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        
    } 

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.sendRedirect("index.jsp");
    } 

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        HttpSession session = request.getSession();
        if(!session.isNew()){
            session.invalidate();
            session = request.getSession();
        }
        
        if(request.getParameter("loginComoAlumno") != null){
            Alumno alumno = Dao.loginAlumno(request.getParameter("usuario"), request.getParameter("password")); 
            if(alumno == null){
                //ERROR EN EL LOGIN
                response.sendRedirect("index.jsp");
            }else{
                session.setAttribute("usuario", alumno);
                session.setAttribute("tipo", "alumno");
                
                session.setAttribute("actividades_actuales", Dao.actividadesParticipa(alumno));
                session.setAttribute("actividades_disponibles", Dao.actividadesLibresNoParticipa(alumno));
                
                response.sendRedirect("alumno.jsp");
            }
        }
        else if(request.getParameter("loginComoImpartidor") != null){
            try{
                Impartidor impartidor = Dao.loginImpartidor(Integer.parseInt(request.getParameter("usuario")), request.getParameter("password"));
                if(impartidor == null){
                    //ERROR EN EL LOGIN
                    response.sendRedirect("index.jsp");
                }else{
                    session.setAttribute("usuario", impartidor);
                    session.setAttribute("tipo", "impartidor");

                    session.setAttribute("actividades", Dao.actividadesImpartidor(impartidor));
                    
                    response.sendRedirect("impartidor.jsp");
                }
            } catch(NumberFormatException e){
                //Identificador incorrecto
                response.sendRedirect("index.jsp");
            }
           
        }
        else{
            response.sendRedirect("index.jsp");
        }
    }
}
