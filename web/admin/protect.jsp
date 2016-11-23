<%
   String adminuserchkx=(String)session.getAttribute("adminuser");
    if(adminuserchkx==null)
        response.sendRedirect("adminlogin.jsp");
    
    
    %>