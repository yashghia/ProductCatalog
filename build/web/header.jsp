    

<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>
<%@page import="catalogbeans.categorybean"%>
<nav class="navbar navbar-inverse navbar-fixed-top">
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
            <a class="navbar-brand" href="#">
                <%
                    String nn=(String)session.getAttribute("username");
                    
                    String muser="User";
                    if(nn!=null){
                        muser=nn;
%>
 Welcome <%=muser%>
<% 
                    }  else{%>
                  Product Catalog
                   <%     
                    }
                    %>
                   
               
            </a>
        </div>
        <div id="navbar" class="collapse navbar-collapse">
          <ul class="nav navbar-nav">
           
        <%
                  categorybean category=new categorybean();
                  ArrayList data=  category.showAll();
                  Iterator x=data.iterator();
                  while(x.hasNext())
                  {
                  category=(categorybean)  x.next();
                  
                          
                      %>
               <li><a href="showproducts.jsp?categoryid=<%=category.getCategoryid()%>"><%=category.getCategoryname()%></a></li>
                      <%
                           }
                      
                      %>

               <li><a href="searchproduct.jsp">Search</a></li> 
                    <li><a href="contactus.jsp">Contact Us</a></li>
               <%
                  
               if(nn!=null)
               {
                  
               %>
                    <li><a href="changepassword.jsp">Change Password</a></li> 
               <li><a href="showbookmarks.jsp">View Bookmarks</a></li>
          
               <li><a href="userlogout">Logout</a></li>
               <%
               }
               else{
                   %>
            <li>   <a href="userlogin.jsp">User Login</a>
                   <li>   <a href="admin/adminlogin.jsp">Admin Login</a>
               <%
               }
                   %>
               
               
          </ul>
        </div>
      </div>
    </nav>