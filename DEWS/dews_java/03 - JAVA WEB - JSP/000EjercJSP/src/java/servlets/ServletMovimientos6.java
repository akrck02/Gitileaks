/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import beans.Cuenta;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class ServletMovimientos6 extends HttpServlet {

  
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ServletMovimientos6</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ServletMovimientos6 at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       doPost(request, response);
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
         if ( (request.getParameter("submitingresar")==null) && (request.getParameter("submitgastar")==null))
            response.sendRedirect("pag6_movimientos.jsp");
         else{
              HttpSession s=request.getSession();
              if (s.getAttribute("cuenta")==null)
                  response.sendRedirect("pag6_nuevacuenta.jsp");
              else{
                   Cuenta c=(Cuenta)s.getAttribute("cuenta");
                   if (request.getParameter("submitingresar")!=null){
                       c.ingresar(Integer.parseInt(request.getParameter("cantidad")));
                   }
                   if (request.getParameter("submitgastar")!=null){
                       if (!c.gastar(Integer.parseInt(request.getParameter("cantidad"))))
                           request.setAttribute("error", "La cuenta sólo dispone de " + c.getSaldo() + "€");
                   }
                   request.getRequestDispatcher("pag6_movimientos.jsp").forward(request, response);
              }
              
             
             
         }
    }

   
}
