package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class pag6_005fcrear_005fprimitiva_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <form action=\"ServletCuenta6\" method=\"post\">\n");
      out.write("            <table cellpadding=\"3\"  >\n");
      out.write("                <tr bgcolor=\"cccccc\" style=\"text-align: center\" >\n");
      out.write("                   \n");
      out.write("                        <td bgcolor=\"cccccc\" colspan=\"6\"><h3>PRIMITIVA</h3></td>\n");
      out.write("                        \n");
      out.write("                </tr>\n");
      out.write("                <tr bgcolor=\"cccccc\">\n");
      out.write("                        <td > Día </td>\n");
      out.write("                        <td><input type=\"text\" name=\"dia\" value=\"\" ></td>\n");
      out.write("                        <td > Mes </td>\n");
      out.write("                        <td><input type=\"text\" name=\"mes\" value=\"\" ></td>\n");
      out.write("                        <td > Año </td>\n");
      out.write("                        <td><input type=\"text\" name=\"anio\" value=\"\" ></td>\n");
      out.write("                </tr>\n");
      out.write("                <tr bgcolor=\"cccccc\">\n");
      out.write("                        <td >Saldo inicial</td>\n");
      out.write("                        <td><input type=\"text\" name=\"saldo\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${requestScope.cuenta.saldo}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\"></td>\n");
      out.write("                </tr>\n");
      out.write("               \n");
      out.write("                <tr>\n");
      out.write("                        <td colspan=\"6\" bgcolor=\"222222\"><p align=\"center\">\n");
      out.write("                                <input type=\"submit\" value=\"Crear Primitiva\" name=\"submitcuenta\"></p>\n");
      out.write("                        </td>\n");
      out.write("                </tr>\n");
      out.write("            </table>\n");
      out.write("        </form>\n");
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
