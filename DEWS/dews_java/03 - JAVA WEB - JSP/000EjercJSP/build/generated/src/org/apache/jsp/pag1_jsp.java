package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.io.IOException;
import java.util.Date;

public final class pag1_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {


            void tabla(JspWriter out, int numero) // throws IOException
            {
                for (int i = 1; i <= 10; i++)
                try{
                    out.print(numero + " x " + i + " = " + numero*i+"<br>");
                } 
                catch (IOException ioe){ioe.printStackTrace();}
            }
            
             //   int accesos=0;
        

            int accesos=0;

        
  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(1);
    _jspx_dependants.add("/pagincluida_directiva.jsp");
  }

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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Página pruebas</title>\n");
      out.write("        ");
      out.write("\n");
      out.write("        \n");
      out.write("        ");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("      \n");
      out.write("        ");
      out.write("\n");
      out.write("        <H2>Expresiones JSP</H2>\n");
      out.write("        <UL>\n");
      out.write("            <LI>Fecha actual: ");
      out.print( new Date() );
      out.write("\n");
      out.write("            <LI>Su máquina: ");
      out.print( request.getRemoteHost() );
      out.write("\n");
      out.write("            <LI>Su ID de sesión: ");
      out.print( session.getId() );
      out.write("\n");
      out.write("            <LI>El parámetro <CODE>nombre</CODE>:  ");
      out.print( request.getParameter("nombre") );
      out.write("\n");
      out.write("        </UL>\n");
      out.write("   \n");
      out.write("        \n");
      out.write("    <p>\n");
      out.write("        ");
 if (Math.random() < 0.5) {
      out.write("\n");
      out.write("                <b>Que tenga un buen día</b>\n");
      out.write("        ");
 } else 
            out.println("<u>Que tenga mucha suerte "+ request.getParameter("nombre") +"</u>");
        
      out.write("\n");
      out.write("    </p>\n");
      out.write("    \n");
      out.write("    ");
      out.write("\n");
      out.write("        ");

        tabla(out, 7);
        out.print("<p>");
        tabla(out, 4);       
        
      out.write("\n");
      out.write("\n");
      out.write("    ");
      out.write("\n");
      out.write("    <p>\n");
      out.write("            ");
      out.print( ++accesos + " accesos a esta página"   );
      out.write(".   \n");
      out.write("    </p>\n");
      out.write("\n");
      out.write("    \n");
      out.write("    \n");
      out.write("    ");
      out.write("\n");
      out.write("    <p>\n");
      out.write("      ");
 
        String formato = request.getParameter("formato");
        // Si el parámetro no existe se eleva un NullPointerException --> incluimos directiva errorPage
        if (formato!=null){
            if (formato.equals("excel")) {
                response.setContentType("application/vnd.ms-excel");               
            } else {
                response.setContentType("text/plain");
            }
        }       
     
      out.write("    \n");
      out.write("      \n");
      out.write("      \n");
      out.write("      <TABLE BORDER=1>\n");
      out.write("        <TR><TH></TH><TH>Peras<TH>Manzanas\n");
      out.write("        <TR><TH>Primer trimestre<TD>2307<TD>4706\n");
      out.write("        <TR><TH>Segundo trimestre<TD>2982<TD>5104\n");
      out.write("        <TR><TH>Tercer trimestre<TD>3011<TD>5220\n");
      out.write("        <TR><TH>Cuarto trimestre<TD>3055<TD>5287\n");
      out.write("      </TABLE>\n");
      out.write("    </p>\n");
      out.write("    \n");
      out.write("    \n");
      out.write("    ");
      out.write("\n");
      out.write("    ");
      out.write("\n");
      out.write("    ");
      out.write("\n");
      out.write("    ");
      out.write("\n");
      out.write("      ");
      out.write("\n");
      out.write("    ");
 String colorparr="red"; 
      out.write("\n");
      out.write("    ");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("       \n");
      out.write("       \n");
      out.write("        <p style=\"color:");
      out.print( colorparr);
      out.write("\"> Parrafo de página incluida con directiva include </p>\n");
      out.write("        \n");
      out.write("\n");
      out.write("\n");
      out.write("    ");
      out.write("\n");
      out.write("      \n");
      out.write("    \n");
      out.write("     ");
      out.write("\n");
      out.write("    ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "circulo.jsp", out, false);
      out.write("\n");
      out.write("    \n");
      out.write("      \n");
      out.write("     \n");
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
