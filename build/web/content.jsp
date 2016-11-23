 <%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>
<%@page import="catalogbeans.productbean"%>
<div class="container">

      <div class="starter-template">
      <div class="container-fluid">
            
            <div class="row" style="margin-top: 20px;">
   <div class="col-sm-9 col-md-10 center-content">
    
                    <!-- <h2 class="sub-header">Section title</h2>-->
                    <div class="panel panel-primary">
                         <div class="panel-heading">Products</div>
    <div class="panel-body">
                    
        
        
        
                                <%
                            int count=0;
                   
                                      String image="";
                                    productbean product = new productbean();
                               
                                    ArrayList product_data = product.showAll();
                                    
                                    Iterator x1 = product_data.iterator();
                                    while (x1.hasNext()) {
                                        product = (productbean) x1.next();
                                        image=product.getImage();
                                  %>

                    <%
                                 if(count%4==0)  
             {
%>        
<div class="row">
    
    <%
             }
                 %>
            <div class="col-md-3" >    
               <div class="panel panel-success">
                         <div class="panel-heading text-center"><%=product.getProductname()%></div>
                         <div class="panel-body text-center">
                             
                         
                <img src="images/<%=image%>" width="150px" height="150px" class="center-block"/><br>
                
                <h4>$<%=product.getPrice()%></h4>
                <a href="productdetails.jsp?productid=<%=product.getProductid()%>" class="btn btn-success">View Details</a>
                         
                         </div>
               </div>
            </div>
                         
                         
                       
                 
                   <%
                    if((count+1)%4==0 || (count+1)==product_data.size()) 
             {
%>        
</div> 
    
    <%
             }
                    
                      count++;  
                      
                 %>
                 
                               
                                <%
                                    }
                        

                                    %>
                              
               </div>
  </div>        
   </div>
                                    
            </div>
        </div>
      </div>

    </div><!-- /.container -->