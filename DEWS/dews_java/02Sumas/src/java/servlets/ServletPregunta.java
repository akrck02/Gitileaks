/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import beans.Correccion;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author dw2
 */
public class ServletPregunta extends HttpServlet {
    
    
    

    private int[] numsAzar(){
         //Crea 2 nums aleatorios entre 1 y 100 distintos        
        
         int liminf=Integer.parseInt(this.getInitParameter("num1"));
         int limsup=Integer.parseInt(this.getInitParameter("num2"));
         
         
        int[] nums=new int[2];
        nums[0]= liminf + (int)( Math.random()* (limsup-liminf+1));
        do{
            nums[1]=liminf + (int)( Math.random()* (limsup-liminf + 1));            
        } while (nums[1]==nums[0]);
        
        return nums;
    }   
    
    
    private void dibujarFormSuma(PrintWriter out){
        
        int[] nums=numsAzar();
        String pregunta=nums[0] + " + " + nums[1] + "?";
        int rptaOK=nums[0] + nums[1];
        int rptaMal1=rptaOK + 1;
        int rptaMal2=rptaOK - 1;        
        
        out.println("<form method='post' action='ServletPregunta'>");        
        out.println("<label> " + pregunta + "</label>");
        out.println("<input type='radio' name='rpta' value='"+ rptaOK+"' checked/>" + rptaOK);
        out.println("<input type='radio' name='rpta' value='"+ rptaMal1+"'/>" + rptaMal1);
        out.println("<input type='radio' name='rpta' value='"+ rptaMal2+"'/>" + rptaMal2);
        out.println("<input type='hidden' name='num1' value='"+nums[0]+"' />");
        out.println("<input type='hidden' name='num2' value='"+nums[1]+"' />");
        out.println("<input type='submit' name='submitrpta' value='RESPONDER' />" );
        out.println("</form>");        
        
    }
    
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
         response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ServletPregunta</title>");            
            out.println("</head>");
            out.println("<body>");            
       
            if (request.getAttribute("correccion")!=null){
                Correccion c=(Correccion)request.getAttribute("correccion");
                 if (c.isCorrecta())
                     out.println("<p>Rpta anterior correcta</p>");
                 else
                     out.println("<p>Rpta anterior mal: CORRECTA ES: " + c.getNum_correcto()+"</p>");
            }
              
            
            dibujarFormSuma(out);
            
            
            
            out.println("</body>");
            out.println("</html>");
        }
      
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
       
        if (request.getParameter("submitrpta")!=null){
           int num1=Integer.parseInt(request.getParameter("num1"));
           int num2=Integer.parseInt(request.getParameter("num2"));           
           int rpta=Integer.parseInt(request.getParameter("rpta"));
           
           Correccion c;
           if (rpta==num1+num2){               
                c=new Correccion(true,rpta);
           }
           else{
                 c=new Correccion(false,rpta);          
           }       
           request.setAttribute("correccion", c);
           doGet(request,response); 
            
        }
        
        
       
    }

   

}
