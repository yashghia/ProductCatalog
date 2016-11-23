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

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
  </head>

  <body>

    <div class="container" >

        <form class="form-signin" id="dataForm">
         
        <h2 class="form-signin-heading">Login</h2>
        <label for="inputEmail" class="sr-only">Username</label>
        <input type="text" id="inputEmail" class="form-control" placeholder="Username" name="username" required autofocus>
        <label for="inputPassword" class="sr-only">Password</label>
        <input type="password" id="inputPassword" class="form-control" name="password" placeholder="Password" required>
       <!-- <div class="checkbox">
          <label>
            <input type="checkbox" value="remember-me"> Remember me
          </label>
        </div>-->
          <button class="btn  btn-primary " type="submit">Sign in</button>
          <a class="btn btn-group btn-success "  onclick="create_account()">Register</a>
           <a href="index.jsp" class="btn btn-group btn-danger " >Home </a>
           <p style="margin-top: 10px;"><a href="forgetpassword.jsp" class="btn btn-group btn-info " >Forgot Password </a></p>
           
        <b><span id="msg"></span></b>
      </form>
    </div> <!-- /container -->


    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <script src="js/ie10-viewport-bug-workaround.js"></script>
    
    <script src="js/jquery.min.js" type="text/javascript"></script>
     <script src="js/jquery.validate.min.js" type="text/javascript"></script>
    <script>
    function create_account(){
        location.href="registration.jsp";
    }     
        
           $(document).ready(function() {
                                                           
                                                       
    $("#dataForm").validate(
        {  
            
    submitHandler: function(form) {
            theUrl = 'checkuserlogin';
            var params = $(form).serialize();

            $.ajax ({
                type: "POST",
                url: theUrl,
                data: params,
                processData: false,
                async: false,
                success: function(result) {
                    if($.trim(result)=="1")
                       window.open("main.jsp","_self");
                   else{
                     $("#msg").html("Incorrect Username Or Password");
                   }
                }
            });
        }
    });
    
     });
        </script>
  </body>
</html>
