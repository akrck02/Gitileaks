
 <%        
           
  int a=Integer.parseInt(request.getParameter("a"));
  int b=Integer.parseInt(request.getParameter("b"));
  int c=Integer.parseInt(request.getParameter("c"));
   double x1=Double.parseDouble(request.getParameter("x1"));
   double x2=Double.parseDouble(request.getParameter("x2"));

    out.println ("<p>Soluciones de " + a + "x<sup>2</sup> + " + b + "x + " + c +" =0</p>");
    out.println ("<p>x1=" + x1 +"</p>");
    out.println ("<p>x2=" + x2 +"</p>");

 %>