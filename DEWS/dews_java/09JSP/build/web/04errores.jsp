
<%
    
    if (request.getParameter("error")!=null){
    
        String strA=request.getParameter("a");
        String strB=request.getParameter("b");
        String strC=request.getParameter("c");
        String error=request.getParameter("error").toUpperCase();
        
        out.println("La ecuacion " + strA + "x2" + " + " + strB + "x" + strC + "=0: " +error);
    
    }
%>

