/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import beans.Cuenta;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ServletCuenta6 extends HttpServlet {

    @Override
    public void init() throws ServletException {
        super.init(); //To change body of generated methods, choose Tools | Templates.
        
        ArrayList <String> vetados=new ArrayList <String>();
        vetados.add("paco");
        vetados.add("ana mari");
        vetados.add("Julio Gil");
        vetados.add("luisito");
        this.getServletContext().setAttribute("vetados", vetados);
    }

   
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
        
        
        if (request.getParameter("submitcuenta")==null)
            response.sendRedirect("pag6_nuevacuenta.jsp");
        else{
            ArrayList<String> errores=new  ArrayList<String>();
          
            String titular=request.getParameter("titular");
            if ( ((ArrayList<String>)this.getServletContext().getAttribute("vetados")).contains(titular)   ){
                errores.add(titular + " no puede crear cuentas");
                titular="";
            }                
                       
            float saldo=0;
            try{                
                saldo=Float.parseFloat(request.getParameter("saldo"));       
                if (saldo<0){
                    errores.add("Saldo inicial no válido");
                    saldo=0;
                }
                    
            }
            catch(NumberFormatException e){
              errores.add("Saldo inicial no válido");
            }
            
            Cuenta c=new Cuenta(titular,saldo);
            if (errores.size()>0){
                request.setAttribute("errores", errores);         
                request.setAttribute("cuenta", c);
                request.getRequestDispatcher("pag6_nuevacuenta.jsp").forward(request, response);
            }
            else{             
                request.getSession().setAttribute("cuenta", c);
                response.sendRedirect("pag6_movimientos.jsp");
            }
        }
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
