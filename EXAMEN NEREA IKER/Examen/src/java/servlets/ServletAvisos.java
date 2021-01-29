package servlets;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletAvisos extends HttpServlet {
    
    private String FILE_PATH = "avisos.txt";
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        
    } 

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.sendRedirect("impartidor.jsp");
    } 

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        if(request.getParameter("avisar") == null){
            response.sendRedirect("impartir.jsp");
        }
        else{
            String medio = (request.getParameter("aviso").equals("email")) ? request.getParameter("email"): request.getParameter("telefono");
            String dni = request.getParameter("dni");
            
            try{
                FileWriter fw = new FileWriter(getServletContext().getRealPath(FILE_PATH),true);
                fw.write(dni + " " + medio+ "\n");
                fw.close();
            }
            catch(IOException e){
                e.printStackTrace();
            }
        }
        
        response.sendRedirect("impartidor.jsp");
    }
}
