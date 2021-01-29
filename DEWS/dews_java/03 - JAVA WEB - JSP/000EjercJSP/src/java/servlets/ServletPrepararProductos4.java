/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ServletPrepararProductos4 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
        ArrayList<String> productos;
        if (request.getParameter("categoria")==null){
            productos=this.productosCategoria("todas");
        }
        else{
            productos=this.productosCategoria(request.getParameter("categoria"));
        }
        
        request.getSession().setAttribute("productos", productos);
        request.getRequestDispatcher("pag4_compra.jsp").forward(request, response);        
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request,response);
    }


    
    private ArrayList<String> productosCategoria(String categoria ){
        
        ArrayList<String> prods=new ArrayList<String>();
        String nomfich=this.getServletContext().getRealPath(  this.getInitParameter("fichproductos"));
        try {
            BufferedReader br=new BufferedReader(new FileReader(nomfich));
            String linea=br.readLine();
            while (linea!=null){
                //System.out.println("Linea leida: " + linea);
                String[] partes=linea.split(";");
                if (categoria.equals("todas"))
                     prods.add(partes[1]);                 
                else if (partes[0].equals(categoria))
                      prods.add(partes[1]);              
                
                linea=br.readLine();
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ServletPrepararProductos4.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ServletPrepararProductos4.class.getName()).log(Level.SEVERE, null, ex);
        }
        return prods;
        
    }
}
