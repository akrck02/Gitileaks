<%-- 
    Document   : pag5_visorimagenes
    Created on : 19-dic-2018, 17:02:39
    Author     : lamenda
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="beans.Imagen"%>
<%@page import="java.io.File"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
         <%!
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
             
        %>
         <%
            
             ArrayList<Imagen> imags=imagenesDeCarpeta("img");
         %>
         
          <%
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
         %>
         
         <form>       
                   <table style="border: 2px solid #000000; "   >   
                        <tr>
                            <td>
                  Imagen: <select name="imagen">
                            <% for (Imagen im: imags) 
                            {  
                                String seleccionada="";
                                 if ((imagenElegida!=null) && (imagenElegida.equals(im.getRuta())))
                                    seleccionada="selected";                            
                            
                            %>
                                <option value="<%= im.getRuta() %>" <%= seleccionada %>> <%= im.getNombre() %> </option>
                         <% }   %>
                            </select>
                           </td>
                  
                   
                   <% 
                        String checked300="checked";
                        String checked400="";
                        String checked500="";                      
                        if ((imagenElegida!=null) && request.getParameter("tamanio").equals("300"))
                                    checked300="checked";
                        if ((imagenElegida!=null) && request.getParameter("tamanio").equals("400"))
                                    checked400="checked";
                        if ((imagenElegida!=null) && request.getParameter("tamanio").equals("500"))
                                    checked500="checked";
                   %>
                   <td>
                   Tamaño: 
                   <input type='radio' name="tamanio" value="300" <%= checked300   %> /> 300 px
                   <input type='radio' name="tamanio" value="400" <%= checked400   %>/> 400 px
                   <input type='radio' name="tamanio" value="500" <%= checked500   %>/> 500 px
                   </td>
                   <td>
                   <input type='submit' name="submitimagen" value="VER IMAGEN" />
                   </td>
                   </tr>
                   <table>  
         </form>           
           </br>
                   
         <% if (imagenElegida!=null)    {     %>
                <table>
                   <tr>
                         <td>  <b>Tamaño </b> </td>
                         <td> <%= tamanio   %> </td>
                   </tr>
                   <tr>
                       <td colspan='2'><img src='<%= imagenElegida %>' width="<%= request.getParameter("tamanio") %>" /> </td>   
                   </tr>
                </table>
          <%  }   %>
           
    </body>
</html>
