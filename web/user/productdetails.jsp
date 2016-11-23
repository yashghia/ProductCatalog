
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

                            </thead>
                            <tbody>
                                <%
                                String productid = request.getParameter("productid");
                                    String image = "";
                                    productbean product = new productbean();

                                    product.search(productid);
                                    image = product.getImage();

                                %>

                                <tr>
                                    <td><%=product.getProductname()%></td>
                                </tr>
                                <tr><td> <input type="hidden" value="<%=productid%>" id="productid" name="productid"></td></tr>
                                <tr>
                                    <td>
                                        <img src="../images/<%=image%>" align="left" width="100px" height="100px">
                                        <p>
                                            Description<br/>
                                            <%=product.getDescription()%><br/>
                                            Price:&nbsp;
                                            <%=product.getPrice()%><br/>
                                            Status:&nbsp;
                                            <%=product.getStatus()%>
                                        </p>
                                    </td>
                                </tr>
                                <tr><td> <button class="btn btn-lg btn-primary "  id="b1">Add Bookmark</button>
                                        <button class="btn btn-lg btn-primary " onclick="displayform()" >Send Enquiry</button>
                                    </td></tr>
                                <tr>
                                    <td>
                            <form class="hide" name="f1" id="f1">
                                <textarea></textarea><br/>
                                 <button class="btn btn-lg btn-primary " id="b2" >Send </button>
                            </form>
                                    </td>
                                </tr>

                                <tr><td> <span id="s1"><b></b></span></td></tr>

                            </tbody>
                        </table>

                    </div>
                </div>
            </div>
        </div>

        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>');</script>
        <script src="../js/bootstrap.min.js"></script>
        <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
        <script src="../js/ie10-viewport-bug-workaround.js"></script>

        <script src="../js/jquery.min.js" type="text/javascript"></script>
        <script src="../js/jquery.validate.min.js" type="text/javascript"></script>
        <script>
            function displayform(){
         var  form_tag= document.getElementById("f1");
            form_tag.className="show";
            }
        </script>
        <script>

            $(document).ready(function() {



                $("#b1").click(function() {
                    var product = $("#productid").val();
                    theUrl = '../bookmarksave';

                    $.ajax({
                        type: "POST",
                        url: theUrl,
                        data: "productid1=" + product,
                        processData: false,
                        async: false,
                        success: function(result) {
                            $("#s1").html(result);

                        }
                    });

                });
                
                            $("#b2").click(function() {
                                
                        alert("executed");
                              theUrl = '../sendEnquiry';

                    $.ajax({
                        type: "POST",
                        url: theUrl,
                        data: "productid1=" + product,
                        processData: false,
                        async: false,
                        success: function(result) {
                            $("#s1").html(result);

                        }
                    });
                });
            });


        </script>
    </body>
</html>