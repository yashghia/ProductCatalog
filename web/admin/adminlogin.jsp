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
    <link href="../css/bootstrap.min.css" rel="stylesheet">

    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <link href="../css/ie10-viewport-bug-workaround.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="../css/signin.css" rel="stylesheet">

    <!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
    <!--[if lt IE 9]><script src="../../assets/js/ie8-responsive-file-warning.js"></script><![endif]-->
    <script src="../js/ie-emulation-modes-warning.js"></script>

 
  </head>

  <body>

    <div class="container" >

        <form class="form-signin" id="dataForm">
        <h2 class="form-signin-heading">Admin Login</h2>
     
        <input type="text" id="inputEmail" class="form-control" placeholder="Username" name="username" required autofocus>
    
        <input type="password" id="inputPassword" class="form-control" name="password" placeholder="Password" required>
  
        <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
           
      </form>

    </div> <!-- /container -->


    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <script src="../js/ie10-viewport-bug-workaround.js"></script>
    
    <script src="../js/jquery.min.js" type="text/javascript"></script>
     <script src="../js/jquery.validate.min.js" type="text/javascript"></script>
    <script>
        
           $(document).ready(function() {
                                                           
                                                       
    $("#dataForm").validate(
        {  
            
    submitHandler: function(form) {
            theUrl = '../checkadminlogin';
            var params = $(form).serialize();

            $.ajax ({
                type: "POST",
                url: theUrl,
                data: params,
                processData: false,
                async: false,
                success: function(result) {
                    if($.trim(result)=="1")
                       window.open("index.jsp","_self");
                   else{
                       alert("invalid login");
                   }
                }
            });
        }
    });
    
     });
        </script>
  </body>
</html>
