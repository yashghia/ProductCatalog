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
          <a class="navbar-brand" href="#">Product Catalog</a>
        </div>
        <div id="navbar" class="collapse navbar-collapse">
          <ul class="nav navbar-nav">
            <li class="active"><a href="#">Home</a></li>
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
               
               <li><a href="showbookmarks.jsp">View Bookmarks</a></li>
               <li><a href="userlogin.jsp">Contact Us</a></li>
               <li><a href="userlogin.jsp">Logout</a></li>
          </ul>
        </div><!--/.nav-collapse -->
      </div>
    </nav>