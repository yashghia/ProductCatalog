           <%@include file="protect.jsp" %>


<nav class="navbar navbar-inverse navbar-fixed-top">
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="#">Admin Panel</a>
        </div>
        <div id="navbar" class="collapse navbar-collapse">
          <ul class="nav navbar-nav">
   
            <li><a href="categoryshowall.jsp">Category</a></li>
            <li><a href="productadd.jsp">New Product</a></li>
  
              <li><a href="usershowall.jsp">View Users</a></li>
                <li><a href="../adminlogout">Logout</a></li>
          </ul>
        </div><!--/.nav-collapse -->
      </div>
    </nav>