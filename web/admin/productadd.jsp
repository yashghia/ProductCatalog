
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

            <form class="form-signin"  id="dataForm" enctype="multipart/form-data" method="post">
                <h2 class="form-signin-heading">Add Product</h2>

                <label >Product Name</label><br>
                <input type="text" name="productname" id="inputEmail" class="form-control" placeholder="product Name" required autofocus><br/>
                <label >Category</label><br>
                <select name="category" class="form-control">
                    <%
                        categorybean category = new categorybean();
                        ArrayList data = category.showAll();

                        Iterator x = data.iterator();
                        while (x.hasNext()) {
                            category = (categorybean) x.next();


                    %>
                    <option value="<%=category.getCategoryid()%>"><%=category.getCategoryname()%></option>
                    <%
                        }

                    %>
                </select>
                <label>Price</label><br>
                <input type="text" name="price" id="inputEmail" class="form-control" placeholder="price" required autofocus>
                <label>Image</label><br>
                <input type="file" name="image">
                <label >Description</label><br>
                <textarea name="description" cols="60" placeholder="Description"></textarea>
                <br><br>
                <button class="btn btn-lg btn-primary" type="submit">Save</button>
            </form>
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
        <script src="../js/jquery.min.js" type="text/javascript"></script>
        <script src="../js/jquery.validate.min.js" type="text/javascript"></script>
        <script>

            $(document).ready(function() {


                $("#dataForm").validate(
                        {
                            submitHandler: function(form) {
                                theUrl = '../productsave';
                                var params = new FormData(form);

                                $.ajax({
                                    type: "POST",
                                    url: theUrl,
                                    data: params,
                                    processData: false,
                                    async: false,
                                    contentType: false,
                                    success: function(result) {
                                        alert("Data Saved");
                                        
                                    }
                                });
                            }
                        });

            });
        </script>
    </body>
</html>