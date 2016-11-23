
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


        <div class="col-md-4 center-content" >

            <form class="form-signin"  id="dataForm" enctype="multipart/form-data" action="../productupdate" method="post">
                <h2 class="form-signin-heading">Add Product</h2>
                <%
                    String productid = request.getParameter("productid");
                    productbean product = new productbean();
                    product.search(productid);
                    String categoryid = product.getCategoryid();
                    String images = product.getImage();
                %>
                <label>Product Name</label><br>
                <input type="hidden" name="productid" value="<%=productid%>">
                <input type="text" name="productname" id="inputEmail" class="form-control" placeholder="product Name" required autofocus value="<%=product.getProductname()%>">
                <label >Category</label><br>
                <select name="category" class="form-control">
                    <%
                        String selected = "";
                        categorybean category = new categorybean();
                        ArrayList data = category.showAll();
                        Iterator x = data.iterator();
                        while (x.hasNext()) {
                            selected = "";
                            category = (categorybean) x.next();

                            if (categoryid.equals(category.getCategoryid())) {
                                selected = "selected";
                                System.out.println("category id " + categoryid + " " + category.getCategoryid());
                            }


                    %>
                    <option value="<%=category.getCategoryid()%>" <%=selected%>><%=category.getCategoryname()%></option>
                    <%
                        }

                    %>
                </select><br/>
                <label >Price</label><br>
                <input type="text" name="price" id="inputEmail" class="form-control" placeholder="price" required autofocus value="<%=product.getPrice()%>">
<br/>
                <label >Image</label><br>
                <img src="../images/<%=images%>" width="50px" height="50px"/>
                <input type="file" name="image"/>
             
                <label>Status</label>
                <input type="radio" name="status" value="Available" <%=product.getStatus().equals("Available") ? "checked" : ""%>>Available
                <input type="radio" name="status" value="Not Available" <%=product.getStatus().equals("Not Available") ? "checked" : ""%>>Not Available<br/>
                <label >Description</label><br>
                <textarea name="description" cols="60" ><%=product.getDescription()%></textarea>
                <br><br>
                <button class="btn btn-lg btn-primary" type="submit">Update</button>
            </form>
        </div> 



        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>');</script>
        <script src="../js/bootstrap.min.js"></script>
        <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
        <script src="../js/ie10-viewport-bug-workaround.js"></script>

        <script src="../js/jquery.min.js" type="text/javascript"></script>
        <script src="../js/jquery.validate.min.js" type="text/javascript"></script>

    </body>
</html>