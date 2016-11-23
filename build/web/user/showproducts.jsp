
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

        <title>Address Book</title>

        <!-- Bootstrap core CSS -->
        <link href="../css/bootstrap.min.css" rel="stylesheet">

        <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
        <link href="../css/ie10-viewport-bug-workaround.css" rel="stylesheet">

        <!-- Custom styles for this template -->
        <link href="../css/starter-template.css" rel="stylesheet">

        <!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
        <!--[if lt IE 9]><script src="../../assets/js/ie8-responsive-file-warning.js"></script><![endif]-->
        <script src="../js/ie-emulation-modes-warning.js"></script>

        <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
        <!--[if lt IE 9]>
          <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
          <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
        <![endif]-->
    </head>

    <body>
        <%@include file="header.jsp" %>


        <div class="container-fluid">
            <div class="row">

                <div class="col-sm-9 col-md-10  main">
                 
              
                    <!-- <h2 class="sub-header">Section title</h2>-->
                    <div class="table-responsive">
                        <table class="table table-striped">
                            <thead>
                                <tr>
                                    
                                    <th>Product</th>
                                    
                                    <th>Image</th>
                                    
                                    <th>Status</th>
                                     <th>Select</th>

                                </tr>
                            </thead>
                            <tbody>
                                <%
                              String categoryid=  request.getParameter("categoryid");
                                      String image="";
                                    productbean product = new productbean();
                                    product.setCategoryid(categoryid);
                                    ArrayList product_data = product.productsByCategory();
                                    Iterator x1 = product_data.iterator();
                                    while (x1.hasNext()) {
                                        product = (productbean) x1.next();
                                           image=product.getImage();
                                       

                                %>


                                <tr>
                                    <td><%=product.getProductname()%></td>
                                    <td><img src="../images/<%=image%>" width="150px" height="150px"/></td>
                                    <td><%=product.getStatus()%></td>
                                    <td><a href="productdetails.jsp?productid=<%=product.getProductid()%>">View Details</a></td>
                                 
                                </tr>
                                <%
                                    }

                                %>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>



        <!-- /.container -->


        <!-- Bootstrap core JavaScript
        ================================================== -->
        <!-- Placed at the end of the document so the pages load faster -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>');</script>
        <script src="../js/bootstrap.min.js"></script>
        <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
        <script src="../js/ie10-viewport-bug-workaround.js"></script>
    </body>
</html>