<%@page import="beans.Empresa"%>
<%@page import="beans.Trabajador"%>
<%@page import="beans.Telefonomovil"%>
<%

                Empresa e=(Empresa)(session.getAttribute("empresa"));
   
                if (request.getParameter("submit_nuevotrab")!=null){ 
                    Telefonomovil telef=new Telefonomovil(request.getParameter("numero"), Integer.parseInt(request.getParameter("bateria")));
                    Trabajador trab=new Trabajador(request.getParameter("nombre"),request.getParameter("dni"),telef); 
                    request.setAttribute("ultimo_trabajador", trab);
                    if (!e.contratar(trab)){                        
%>
                        <jsp:forward page="pag3_trabajadores.jsp" >
                            <jsp:param name="error_contratar" value="Empresa no admite más trabajadores"/>
                        </jsp:forward>
<%                  }              
                    else{
%>
                         <jsp:forward page="pag3_trabajadores.jsp" />
<%                         
                    }
                }
                else{
%>
                    <jsp:forward page="pag3_trabajadores.jsp" />
<%                   
                }
%>


