<%@page import="catalogbeans.bookmarksbean"%>
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
        <link href="css/bootstrap.min.css" rel="stylesheet">

        <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
        <link href="css/ie10-viewport-bug-workaround.css" rel="stylesheet">
        <link href="css/custom.css" rel="stylesheet">
        <!-- Custom styles for this template -->
        <link href="css/starter-template.css" rel="stylesheet">

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
        <%@include file="header.jsp" %>
 

        <div class="container-fluid">
            <div class="row" style="margin-top: 20px;">

                <div class="col-md-6  center-content">
    
                     <%   String productid = request.getParameter("productid");
                                        String image = "";
                                        productbean product = new productbean();

                                        product.search(productid);
                                        image = product.getImage();
                                            
                                    %>


                    
                <div class="panel panel-primary">
                    <div class="panel-heading "><%=product.getProductname()%></div>
                         <div class="panel-body ">
                           
                              <div class="row" >

                <div class="col-md-4 ">
                         
                <img src="images/<%=image%>" width="150px" height="150px" class="center-block"/><br>
                </div>
                 <div class="col-md-8 ">
                <h4>$<%=product.getPrice()%></h4>
                 <h4><%=product.getStatus()%></h4>
                 <%
                 
                     if(nn!=null)
                     {
                 
                         bookmarksbean bookmark=new bookmarksbean();
                         bookmark.setUsername(nn);
                         bookmark.setProductid(productid);
                         boolean t=bookmark.checkBookMark();
                         if(t==true)
                         {
                         %>
                          <button class="btn  btn-success "  id="b2" >Remove Bookmark</button>
                         <% 
                         }
                         else
                         {
                           %>
                            <button class="btn  btn-success "  id="b1" >Add Bookmark</button>
                           <%
                         }
                 %>
                 
               
                 <%}
                     else
                     {
                         out.println("<span style='color:red';>Please <a href='userlogin.jsp'>sign in</a> to add bookmark and send enquiry</span>");
                     }
                        %>
                 <span id="s1"></span>
                  </div>
               
                         
                         </div>
                 
                   <div class="row">

                       
                <div class="col-md-12 ">
                    <p align="justify"> <%=product.getDescription()%></p>
                   
                  </div>
               
                         
                         </div>
                          <%
                 
                     if(nn!=null)
                     {
                 
                 %>
                  <div class="row " style="margin-top: 20px;">

                <div class="col-md-12 ">
                     <div class="panel panel-success">
                    <div class="panel-heading ">Send Enquiry</div>
                         <div class="panel-body ">
                    <form  name="f1" id="dataForm">
                        <input type="hidden" value="<%=productid%>" id="productid" name="productid1">
        <textarea  class="form-control" placeholder="Write Your Enquiry" cols="5" id="t1" name="t1"></textarea><br/>
                                            <button class="btn  btn-danger " id="b3" >Send Enquiry</button>
                                            <b>  <span id="span_tag"></span></b>
    </form>
                             </div></div>
                 
                 
                </div>
                      
                      
                  </div>
                         
                 <%
    }
%>     
                         
                 
               </div>
                             
                             
                             
                             
                             
                             
                             
                             
                    <!-- <h2 class="sub-header">Section title</h2>-->
                 
                </div>
            </div>
        </div>
        </div>

        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
        <script src="js/ie10-viewport-bug-workaround.js"></script>

        <script src="js/jquery.validate.min.js" type="text/javascript"></script>
   
        <script>

            $(document).ready(function() {



                $("#b1").click(function() {
                    var product = $("#productid").val();
                    theUrl = 'bookmarksave';

                    $.ajax({
                        type: "POST",
                        url: theUrl,
                        data: "productid1=" + product,
                        processData: false,
                        async: false,
                        success: function(result) {
                         alert(result);
                         location.reload();
                         }
                    });

                });




 $("#b2").click(function() {
                    var product = $("#productid").val();
                    theUrl = 'bookmarkdelete';

                    $.ajax({
                        type: "GET",
                        url: theUrl,
                        data: "productid=" + product,
                        processData: false,
                        async: false,
                        success: function(result) {
                           
                           alert(result);
                        location.reload();

                        }
                    });

                });



                $("#dataForm").validate(
                        {
                            submitHandler: function(form) {
                                theUrl = 'sendEnquiry';
                                var params = $(form).serialize();
                               $("#span_tag").html("Sending Enquiry....");
                                $.ajax({
                                    type: "GET",
                                    url: theUrl,
                                    data: params,
                                    processData: false,
                                    async: false,
                                    success: function(result) {
                                        if($.trim(result)==1){
                                           alert("Login to continue");
                                           location.href="userlogin.jsp";
                                        }
                                        else{
                                         $("#span_tag").html(result);
                                          $("#t1").val("");
                                    }
                                    }
                                });
                            }
                        });
            });
function reset(){
   
var data=document.getElementById("t1");
data.innerHTML=" ";
}

        </script>
    </body>
</html>