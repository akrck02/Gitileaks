/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import beans.Persona;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ServletInicio2 extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ServletInicio2</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ServletInicio2 at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HashMap<Persona,List<Persona>> mapaAmigos=new HashMap<Persona,List<Persona>>();
        
        ArrayList<Persona> lst1=new ArrayList<Persona>();
        lst1.add(new Persona("Juan",5,null) );
        lst1.add(new Persona("Ana",50,null) );
        lst1.add(new Persona("Jon",51,null) );
        
        ArrayList<Persona> lst2=new ArrayList<Persona>();
        lst2.add(new Persona("Ibon",25,null) );
        lst2.add(new Persona("Hector",20,null) );
     
        
        
        mapaAmigos.put(new Persona("Nerea",25,null),lst1 );
        mapaAmigos.put(new Persona("Javier",27,null),lst2 );
        
        request.setAttribute("mapaAmigos", mapaAmigos);
        
                
        request.getRequestDispatcher("tablaAmigos.jsp").forward(request, response);
        
        
       
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    
   
}
