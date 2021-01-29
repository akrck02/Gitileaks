package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.ArrayList;
import beans.Imagen;
import java.io.File;

public final class pag5_005fvisorimagenes_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {


            ArrayList<Imagen> imagenesDeCarpeta(String nomcarpeta){
              
             ArrayList<Imagen> imagenes=new ArrayList<Imagen>();
             
              File fCarpe=new File(this.getServletContext().getRealPath(nomcarpeta));
              String[] entradas=fCarpe.list();
              for (String entrada: entradas){
                  if (entrada.endsWith(".jpg") ){
                      String rutaImagen="img/" + entrada;
                      long tamanio=new File(fCarpe.getPath() + "/" + entrada).length();    
                      String entradaSinExtension=entrada.substring(0, entrada.indexOf(".jpg"));
                      Imagen im=new Imagen(rutaImagen, entradaSinExtension, tamanio );
                      imagenes.add(im);
                  }
              }
              return imagenes;
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        \n");
      out.write("         ");
      out.write("\n");
      out.write("         ");

            
             ArrayList<Imagen> imags=imagenesDeCarpeta("img");
         
      out.write("\n");
      out.write("         \n");
      out.write("          ");

            String imagenElegida=null;  
            String tamanio=null;
            if (request.getParameter("submitimagen")!=null){
                imagenElegida=request.getParameter("imagen");
                for (Imagen img: imags){
                    if (img.getRuta().equals(imagenElegida)){
                        tamanio=img.strTamanio();
                        break;
                    }
                }
            }
         
      out.write("\n");
      out.write("         \n");
      out.write("         <form>       \n");
      out.write("                   <table style=\"border: 2px solid #000000; \"   >   \n");
      out.write("                        <tr>\n");
      out.write("                            <td>\n");
      out.write("                  Imagen: <select name=\"imagen\">\n");
      out.write("                            ");
 for (Imagen im: imags) 
                            {  
                                String seleccionada="";
                                 if ((imagenElegida!=null) && (imagenElegida.equals(im.getRuta())))
                                    seleccionada="selected";                            
                            
                            
      out.write("\n");
      out.write("                                <option value=\"");
      out.print( im.getRuta() );
      out.write('"');
      out.write(' ');
      out.print( seleccionada );
      out.write('>');
      out.write(' ');
      out.print( im.getNombre() );
      out.write(" </option>\n");
      out.write("                         ");
 }   
      out.write("\n");
      out.write("                            </select>\n");
      out.write("                           </td>\n");
      out.write("                  \n");
      out.write("                   \n");
      out.write("                   ");
 
                        String checked300="checked";
                        String checked400="";
                        String checked500="";                      
                        if ((imagenElegida!=null) && request.getParameter("tamanio").equals("300"))
                                    checked300="checked";
                        if ((imagenElegida!=null) && request.getParameter("tamanio").equals("400"))
                                    checked400="checked";
                        if ((imagenElegida!=null) && request.getParameter("tamanio").equals("500"))
                                    checked500="checked";
                   
      out.write("\n");
      out.write("                   <td>\n");
      out.write("                   Tamaño: \n");
      out.write("                   <input type='radio' name=\"tamanio\" value=\"300\" ");
      out.print( checked300   );
      out.write(" /> 300 px\n");
      out.write("                   <input type='radio' name=\"tamanio\" value=\"400\" ");
      out.print( checked400   );
      out.write("/> 400 px\n");
      out.write("                   <input type='radio' name=\"tamanio\" value=\"500\" ");
      out.print( checked500   );
      out.write("/> 500 px\n");
      out.write("                   </td>\n");
      out.write("                   <td>\n");
      out.write("                   <input type='submit' name=\"submitimagen\" value=\"VER IMAGEN\" />\n");
      out.write("                   </td>\n");
      out.write("                   </tr>\n");
      out.write("                   <table>  \n");
      out.write("         </form>           \n");
      out.write("           </br></br></br>  \n");
      out.write("                   \n");
      out.write("         ");
 if (imagenElegida!=null)    {     
      out.write("\n");
      out.write("                <table>\n");
      out.write("                   <tr>\n");
      out.write("                         <td>  <b>Tamaño </b> </td>\n");
      out.write("                         <td> ");
      out.print( tamanio   );
      out.write(" </td>\n");
      out.write("                   </tr>\n");
      out.write("                   <tr>\n");
      out.write("                       <td colspan='2'><img src='");
      out.print( imagenElegida );
      out.write("' width=\"");
      out.print( request.getParameter("tamanio") );
      out.write("\" /> </td>   \n");
      out.write("                   </tr>\n");
      out.write("                </table>\n");
      out.write("          ");
  }   
      out.write("\n");
      out.write("           \n");
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
