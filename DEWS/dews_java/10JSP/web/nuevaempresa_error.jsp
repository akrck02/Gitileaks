<%
    if (request.getAttribute("error")!=null){
            Exception e=(Exception)request.getAttribute("error");
            if (request.getAttribute("error") instanceof NumberFormatException){                    
                    out.println("<p>Los campos deben ser del tipo adecuado"+e.getMessage()+ "</p>");   
            }
            else{
                out.println("<p>"+ e.getMessage()+  "</p>");
            }
        
          
                  
    }
%>