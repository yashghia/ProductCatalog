<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
        <meta name="description" content="">
        <meta name="author" content="">
        <link rel="icon" href="../../favicon.ico">

        <title>Product Catalog</title>

        <!-- Bootstrap core CSS -->
        <link href="css/bootstrap.min.css" rel="stylesheet">

        <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
        <link href="css/ie10-viewport-bug-workaround.css" rel="stylesheet">

        <!-- Custom styles for this template -->
        <link href="css/signin.css" rel="stylesheet">

        <!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
        <!--[if lt IE 9]><script src="../../assets/js/ie8-responsive-file-warning.js"></script><![endif]-->
        <script src="js/ie-emulation-modes-warning.js"></script>

  
    </head>

    <body>
        <%@include file="header.jsp" %>
            <%@include file="protect.jsp"%>
        <div class="container" >

            <form class="form-signin" id="dataForm" name="dataForm">
                <h2 class="form-signin-heading">Change Password</h2>
                <%                    String username = (String) session.getAttribute("username");
                %>
                <input type="text" id="inputEmail" class="form-control" placeholder="Enter Username" name="username" required autofocus value="<%=username%>" readonly="">

                <input type="password" id="password1" class="form-control" name="password1" placeholder="Enter Password" required>
                <input type="password" id="password2" class="form-control" name="password2" placeholder="Re-Enter Password" required>
        

                <button class="btn btn-group btn-danger" type="submit">Change password </button>
                <br/> <b><span id="msg"></span></b> 
            </form>

        </div> <!-- /container -->


        <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
        <script src="js/ie10-viewport-bug-workaround.js"></script>

        <script src="js/jquery.min.js" type="text/javascript"></script>
        <script src="js/jquery.validate.min.js" type="text/javascript"></script>
        <script>


            $(document).ready(function() {


                $("#dataForm").validate(
                        {
                            rules:
                                    {
                                        password1:
                                                {
                                                    equalTo: "#password2"
                                                }
                                    },
                            submitHandler: function(form) {
                                theUrl = 'changepassword';
                                var params = $(form).serialize();

                                $.ajax({
                                    type: "POST",
                                    url: theUrl,
                                    data: params,
                                    processData: false,
                                    async: false,
                                    success: function(result) {
                                        if ($.trim(result) == "1")
                                        {
                                            alert("password changed successfully!!");
                                            window.open("main.jsp", "_self");

                                        }

                                    }
                                });
                            }
                        });

            });
        </script>
    </body>
</html>
