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

    <title>Signin Template for Bootstrap</title>

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
        <h2 class="form-signin-heading">Sign up form</h2>
       
        <input type="text" id="inputEmail" class="form-control" placeholder="Enter Name" name="user" required autofocus>
    
        <input type="text" id="inputPassword" class="form-control number" name="contact" placeholder="Enter Contact Number" required>
           
        <input type="text" id="inputEmail" class="form-control email required" placeholder="Enter Email-id" name="emailid" required autofocus>
  
        <input type="text" id="inputPassword" name="username" class="form-control" placeholder="Enter Username" required>
<input type="password" id="inputPassword" class="form-control" placeholder="Enter Password" name="password" required>
         <input type="password" id="inputPassword" class="form-control" placeholder="Re-Enter Password" required>
       
       <!-- <div class="checkbox">
          <label>
            <input type="checkbox" value="remember-me"> Remember me
          </label>
        </div>-->
        <button class="btn btn-lg btn-primary btn-block" type="submit">Sign Up</button>
           <button class="btn btn-lg btn-primary btn-block" type="button" id="b1" onclick="navigate()">Sign In</button>
    
      </form>

    </div> <!-- /container -->


    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <script src="../js/ie10-viewport-bug-workaround.js"></script>
          <script src="../js/jquery.min.js" type="text/javascript"></script>
        <script src="../js/jquery.validate.min.js" type="text/javascript"></script>
        <script>
            function navigate(){
            location.href="userlogin.jsp";
            
        }</script>
    <script>
        
            $(document).ready(function() {


                $("#dataForm").validate(
                        {
                            submitHandler: function(form) {
                                theUrl = '../usersave';
                            var params = $(form).serialize();
                                $.ajax({
                                    type: "POST",
                                    url: theUrl,
                                    data: params,
                                    processData: false,
                                    async: false,
                                  
                                    success: function(result) {
                                        if($.trim(result)=="1")
                                        alert("Registered Successfully");
                           
                                    }
                                });
                            }
                         
                        });
                        
                        
                         
            });
        </script>
  </body>
</html>
