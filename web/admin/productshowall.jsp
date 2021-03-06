
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
                    <h1 class="page-header">Product List</h1>
                    <a href="productadd.jsp">Add New product</a>
                    <!-- <h2 class="sub-header">Section title</h2>-->
                    <div class="table-responsive">
                        <table class="table table-striped">
                            <thead>
                                <tr>
                                    <th>S.No.</th>
                                    <th>Product</th>
                                    <th>Category</th>
                                    <th>Price</th>
                                    <th>Image</th>
                                    <th>Description</th>
                                    <th>Status</th>
                                    <th colspan="2" align="center">Select</th>

                                </tr>
                            </thead>
                            <tbody>
                                <%
                                      String image="";
                                    productbean product = new productbean();
                                    ArrayList data = product.showAll();
                                    Iterator x = data.iterator();
                                    while (x.hasNext()) {
                                        product = (productbean) x.next();
                                           image=product.getImage();
                                       

                                %>


                                <tr>

                                    <td><%=product.getProductid()%></td>
                                    <td><%=product.getProductname()%></td>
                                    <td><%=product.getCategoryid()%></td>
                                    <td><%=product.getPrice()%></td>
                                    <td><img src="../images/<%=image%>" width="150px" height="150px"/></td>
                                    <td><%=product.getDescription()%></td>
                                    <td><%=product.getStatus()%></td>
                                    <td><a href="productmodify.jsp?productid=<%=product.getProductid()%>">Modify</a></td>
                                    <td><a href="../productdelete?productid=<%=product.getProductid()%>">Delete</a></td>
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