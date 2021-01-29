
<%@page import="java.util.Iterator"%>
<%@page import="java.util.HashMap"%>
<%
                out.println("<h2>TU CARRO</h2>");
                out.println("<ul>");
                HashMap<String,Integer> mapacompra =( HashMap<String,Integer> )session.getAttribute("mapacompra");
               
                Iterator it=mapacompra.keySet().iterator();
                while (it.hasNext()){
                    String producto=(String) it.next();
                    int cantidad=((Integer)mapacompra.get(producto)).intValue();
                    out.println ("<li><b>" + producto.toUpperCase() + ":</b>" + cantidad + " unidades</li>");
                }
               out.println("</ul>");
             %> 

