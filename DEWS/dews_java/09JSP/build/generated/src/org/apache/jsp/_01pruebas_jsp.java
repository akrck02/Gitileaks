package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.io.IOException;
import java.util.Date;

public final class _01pruebas_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {


        private  boolean esBisiesto(int anio) {

            if ((anio%400==0) || (anio%4==0 && anio%100!=0))
                return true;       
           return false;
        }

        private void verSumatorio (int num,JspWriter out){
            int sumatorio=0;
            try{
                out.println("Sumatorio de " + num + " = ");
                for (int cont=num; cont>=0; cont--){
                    sumatorio=sumatorio+cont;
                    out.println(cont + " + ");
                }
                out.println("=" + sumatorio);
            }
            catch (Exception e){
            }
        }

        
        
    
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
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    \n");
      out.write("    \n");
      out.write("    ");
      out.write("\n");
      out.write("    \n");
      out.write("    \n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <ul>\n");
      out.write("            <li> Fecha actual: ");
      out.print( new Date() );
      out.write("</li>\n");
      out.write("            <li> Remote IP ");
      out.print( request.getRemoteAddr()  );
      out.write("</li>\n");
      out.write("            <li> Id de sesión ");
      out.print( session.getId()  );
      out.write("</li>\n");
      out.write("            <li>\n");
      out.write("                Parámetro:                \n");
      out.write("                ");
      out.print( (request.getParameter("saludo")==null)? "sin param": request.getParameter("saludo") );
      out.write("\n");
      out.write("            </li>\n");
      out.write("            <li>\n");
      out.write("                ");
  if  (Math.random()<0.5)
                {   
                
      out.write("                    \n");
      out.write("                        <p>Que pases un buen día</p>\n");
      out.write("                 \n");
      out.write("                 ");

                  }
                  else
                  {
                  
      out.write("  \n");
      out.write("                        <p>Dios te maldiga...</p>\n");
      out.write("                  ");

                   }
                  
      out.write("\n");
      out.write("\n");
      out.write("            </li>\n");
      out.write("            <li>\n");
      out.write("                ");

                   if (Math.random()<0.001)
                        out.println("<p>Te va a tocar la primitiva");
                   else
                        out.println("<p>No te va a tocar la primitiva");
                 
      out.write("\n");
      out.write("            </li>\n");
      out.write("            <li>\n");
      out.write("                ");

                    if (esBisiesto(2300)){
                        out.println("<p>Año actual es bisiesto</p>");
                    }
                
      out.write("\n");
      out.write("            </li>\n");
      out.write("            <li>\n");
      out.write("                ");
 
                    verSumatorio(7,out);
                    verSumatorio(20,out);
                
      out.write("\n");
      out.write("                \n");
      out.write("            </li>\n");
      out.write("            \n");
      out.write("            \n");
      out.write("        </ul>\n");
      out.write("        \n");
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
