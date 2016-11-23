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

        <div class="container" >

            <form class="form-signin" id="dataForm">
                <h2 class="form-signin-heading">Sign up form</h2>

                <input type="text" id="inputEmail" class="form-control" placeholder="Enter Name" name="user" required >
                <input type="text" id="contact" class="form-control number required"  name="contact" placeholder="Enter Contact Number" >
                <input type="text" id="inputEmail" class="form-control email required" placeholder="Enter Email-id" name="emailid"  >
                <input type="text" id="inputPassword" name="username" class="form-control required" placeholder="Enter Username" >
                <input type="password" id="password" class="form-control required" style="margin-bottom: 0px" placeholder="Enter Password" name="password" >
                <input type="password" id="password2" class="form-control required" placeholder="Re-Enter Password" name="password2">
      
                <button class="btn  btn-primary " type="submit">Sign Up</button>
                <a class="btn btn-group btn-success "  href="userlogin.jsp"  >Sign In</a>
          
              
                

              
<a href="index.jsp" class="btn btn-group btn-danger " >Home </a><br/>
<b>   <span id="msg"> </span></b>

     
                
                
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
                            //jquery rules
                            rules:
                                    {
                                        contact:
                                                {
                                                    maxlength: 10,
                                                    minlength:10
                                                },
                                        password:
                                                {
                                                    equalTo: "#password2"
                                                }
                                    },
                            messages:
                                    {
                                        contact:
                                                {
                                                    maxlength: "Invalid Phone Number"
                                                },
                                        password2:
                                                {
                                                    equalTo: "Passwords does not match"
                                                }
                                    },
                            submitHandler: function(form) {
                                theUrl = 'usersave';
                                var params = $(form).serialize();
                             
                                $.ajax({
                                    type: "POST",
                                    url: theUrl,
                                    data: params,
                                    processData: false,
                                    async: false,
                                    /*******************/
                                     beforeSend: function() {
                                     $("#msg").html("Saving Data...");

                                        },
                                          /*******************/
                                    success: function(result) {
                                         $("#msg").html("");
                                        if ($.trim(result) == "2") {
                                            
                                           alert("Registered Successfully.");
                                             location.href = "userlogin.jsp";
                                              
                                        } else if($.trim(result) == "1")
                                            $("#msg").html("Username Already Exist");
                                         else if($.trim(result) == "0")
                                            $("#msg").html("Emailid Already Exist");
                                        else if($.trim(result) == "4") {
                                           
                                              alert("Registered successfully.Email not sent");
                                                 location.href = "userlogin.jsp";
                                        }
                                    }
                                });
                            }

                        });
            });
        </script>
    </body>
</html>
