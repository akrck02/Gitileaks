package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.HashSet;
import java.util.ArrayList;
import beans.Empresa;

public final class pag3_005fempresa_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        \n");
      out.write("        ");

         	if (application.getAttribute("noms_empresas")==null)
                    application.setAttribute("noms_empresas", new HashSet<String>());
            
            
                if (request.getParameter("submitempresa")!=null){
                    boolean errorCrearEmpresa=false;
                    String nombre=request.getParameter("nombre");                    
                    double beneficio; int trab;
                    try{
                        trab=Integer.parseInt(request.getParameter("trab"));
                        beneficio=Double.parseDouble(request.getParameter("beneficio"));                       
                        
                       //Solo creamos la empresa (en sesion) si no hay otra con el mismo nombre en el contexto                       
                        if  ( !((HashSet)application.getAttribute("noms_empresas")).contains(nombre))  {
                             session.setAttribute("empresa",new Empresa(nombre, beneficio,trab));
                             ((HashSet)application.getAttribute("noms_empresas")).add(nombre);
                             out.println("<p>Empresa "+ ((Empresa)session.getAttribute("empresa")).getNombre() +" creada</p>");
                             out.println("<p><a href='pag3_trabajadores.jsp'>Añadir trabajadores</a></p>");
                        }     
                        else{
                          out.println("<p>Debes introducir datos de la empresa correctamente "
                                 + "y no ser una empresa existente</p>");
                        }
                    }
                    catch (NumberFormatException e){
                          out.println("<p>Debes introducir datos de la empresa correctamente </p>");
                    }    
                }
                
                Empresa e=(Empresa)session.getAttribute("empresa");
                
               

        
      out.write("\n");
      out.write("        \n");
      out.write("        \n");
      out.write("       <form action=\"");
      out.print( request.getRequestURI()  );
      out.write("\" method=\"post\">\n");
      out.write("            <table cellpadding=\"3\"  >\n");
      out.write("                <tr bgcolor=\"cccccc\">\n");
      out.write("                        <td bgcolor=\"cccccc\" colspan=\"2\"><h3>NUEVA EMPRESA</h3></td>\n");
      out.write("                </tr>\n");
      out.write("                <tr bgcolor=\"cccccc\">\n");
      out.write("                        <td > Nombre:</td>\n");
      out.write("                        <td><input type=\"text\" name=\"nombre\" value=\"");
      out.print((e==null)?"":e.getNombre());
      out.write("\"></td>\n");
      out.write("                </tr>\n");
      out.write("                <tr bgcolor=\"cccccc\">\n");
      out.write("                        <td >Beneficio:</td>\n");
      out.write("                        <td><input type=\"text\" name=\"beneficio\" value=\"");
      out.print( (e==null)?0:e.getBeneficio());
      out.write(" \"></td>\n");
      out.write("                </tr>\n");
      out.write("                 <tr bgcolor=\"cccccc\">\n");
      out.write("                        <td >Max de trabajadores:</td>\n");
      out.write("                        <td><input type=\"text\" name=\"trab\" value=\"");
      out.print( (e==null)?0:e.getTrabajadores().length );
      out.write("\"/></td>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                        <td colspan=\"2\" bgcolor=\"222222\"><p align=\"center\">\n");
      out.write("                                <input type=\"submit\" value=\"Crear empresa\" name=\"submitempresa\"></p>\n");
      out.write("                        </td>\n");
      out.write("                </tr>\n");
      out.write("            </table>\n");
      out.write("        </form>\n");
      out.write("\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
