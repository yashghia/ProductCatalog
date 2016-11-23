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
        <link href='css/custom.css' rel='stylesheet' type='text/css'>

    </head>

    <body>

        <%@include file="header.jsp" %>

        <div class="container-fluid">

            <div class="row ">

                <div class="col-lg-8 col-lg-offset-2 style-1" >

                    <h1>Contact Us</h1>


                    <form id="dataForm" method="post"  role="form">

                        <div class="messages"></div>

                        <div class="controls">

                            <div class="row">
                                <div class="col-md-6">
                                    <div class="form-group">
                                        <label for="form_name">First Name *</label>
                                        <input id="first-name" type="text" name="first-name" class="form-control" placeholder="Please enter your firstname *" required="required" data-error="Firstname is required.">
                                        <div class="help-block with-errors"></div>
                                    </div>
                                </div>
                                <div class="col-md-6">
                                    <div class="form-group">
                                        <label for="form_lastname">Lastname *</label>
                                        <input id="surname" type="text" name="surname" class="form-control" placeholder="Please enter your lastname *" required="required" data-error="Lastname is required.">
                                        <div class="help-block with-errors"></div>
                                    </div>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-6">
                                    <div class="form-group">
                                        <label for="form_email">Email *</label>
                                        <input id="email" type="email" name="email" class="form-control" placeholder="Please enter your email Id*" required="required" data-error="Valid email is required.">
                                        <div class="help-block with-errors"></div>
                                    </div>
                                </div>
                                <div class="col-md-6">
                                    <div class="form-group">
                                        <label for="form_phone">Phone*</label>
                                        <input id="phone" type="tel" name="phone" class="form-control" placeholder="Please enter your phone Number">
                                        <div class="help-block with-errors"></div>
                                    </div>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-12">
                                    <div class="form-group">
                                        <label for="form_message">Message *</label>
                                        <textarea id="message" name="message" class="form-control" placeholder="Message for me *" rows="4" required="required" data-error="Please,leave us a message."></textarea>
                                        <div class="help-block with-errors"></div>
                                    </div>
                                </div>
                                <div class="col-md-10">
                                    <input type="submit" class="btn btn-lg btn-primary" value="Send message">
                                    <b><span id="msg"></span></b>  
                                </div>


                            </div>

                        </div>

                    </form>

                </div><!-- /.8 -->

            </div> <!-- /.row-->

        </div> <!-- /.container-->

        <script src="js/jquery.min.js" type="text/javascript"></script>
        <script src="js/jquery.validate.min.js" type="text/javascript"></script>
        <script>

            $(document).ready(function() {


                $("#dataForm").validate(
                        {
                            rules:
                                    {
                                        phone:
                                                {
                                                    maxlength: 10,
                                                    minlength: 10
                                                }

                                    },
                            messages:
                                    {
                                        contact:
                                                {
                                                    maxlength: "Invalid Phone Number"
                                                }

                                    },
                            submitHandler: function(form) {
                                theUrl = 'contactus';
                                var params = $(form).serialize();

                                $.ajax({
                                    type: "POST",
                                    url: theUrl,
                                    data: params,
                                    processData: false,
                                    async: false,
                                    beforeSend: function() {
                                        $("#msg").html("Please Wait... We are sending Your message.");

                                    },
                                    success: function(result) {
                                        $("#msg").val("Thanks For Contacting Us!!!");
                                        $("#name").val("");
                                        $("#surname").val("");
                                        $("#email").val("");
                                        $("#phone").val("");
                                        $("#message").val("");

                                    }
                                });
                            }
                        });

            });
        </script>
    </body>
</html>

