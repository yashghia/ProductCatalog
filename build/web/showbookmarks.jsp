
<%@page import="catalogbeans.bookmarksbean"%>
<%@page import="catalogbeans.productbean"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>
<%@page import="catalogbeans.categorybean"%>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
        <meta name="description" content="">
        <meta name="author" content="">
        <link rel="icon" href="cs/favicon.ico">

        <title>Product Catalog</title>

        <!-- Bootstrap core CSS -->
        <link href="css/bootstrap.min.css" rel="stylesheet">

        <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
        <link href="css/ie10-viewport-bug-workaround.css" rel="stylesheet">
        <link href="css/custom.css" rel="stylesheet">
        <!-- Custom styles for this template -->
        <link href="css/starter-template.css" rel="stylesheet">

        <!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
        <!--[if lt IE 9]><script src="../../assets/js/ie8-responsive-file-warning.js"></script><![endif]-->
        <script src="js/ie-emulation-modes-warning.js"></script>

        <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
        <!--[if lt IE 9]>
          <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
          <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
        <![endif]-->
    </head>

    <body>
         
                          
        <%@include file="header.jsp" %>
        <%@include file="protect.jsp"%>

        <div class="container-fluid">
            
            <div class="row" style="margin-top: 20px;">
   <div class="col-sm-9 col-md-10 center-content">
    
                    <!-- <h2 class="sub-header">Section title</h2>-->
                    <div class="panel panel-primary">
                         <div class="panel-heading">Products</div>
    <div class="panel-body">
                    
        
        
        
                                <%
                                
                            int count=0;
                               String username=(String)session.getAttribute("username");
                                bookmarksbean bookmark = new bookmarksbean();
                                  
                                    bookmark.setUsername(username);
                                    ArrayList bookmark_data = bookmark.showBookmark();
                                    Iterator i1 = bookmark_data.iterator();
                                    while (i1.hasNext()) {
                                        bookmark = (bookmarksbean) i1.next();
                                        String productid=bookmark.getProductid();
                                        
                                         productbean product = new productbean();

                                        product.search(productid);
                                      String  image = product.getImage();
                                       
                                        
                                        
                                  %>

                    <%
                                 if(count%4==0)  
             {
%>        
<div class="row">
    
    <%
             }
                 %>
            <div class="col-md-3" >    
               <div class="panel panel-success">
                         <div class="panel-heading text-center"><%=product.getProductname()%></div>
                         <div class="panel-body text-center">
                             
                         
                <img src="images/<%=image%>" width="150px" height="150px" class="center-block"/><br>
                
                <h4>$<%=product.getPrice()%></h4>
                <a href="productdetails.jsp?productid=<%=productid%>" class="btn btn-success">View Details</a>
                         
                         </div>
               </div>
            </div>
                         
                         
                       
                 
                   <%
                    if((count+1)%4==0 || (count+1)==bookmark_data.size()) 
             {
%>        
</div> 
    
    <%
             }
                    
                      count++;  
                      
                 %>
                 
                               
                                <%
                                    }
                        

                                    %>
                              
               </div>
  </div>        
   </div>
                                    
            </div>
        </div>
                                    
       
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>');</script>
        <script src="js/bootstrap.min.js"></script>
        <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
        <script src="js/ie10-viewport-bug-workaround.js"></script>
    </body>
</html>