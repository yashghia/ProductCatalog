/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import catalogbeans.categorybean;
import catalogbeans.productbean;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author real-team
 */
@WebServlet(urlPatterns = {"/productdelete"})
public class productdelete extends HttpServlet {


  
   
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         PrintWriter out = response.getWriter();
        
        String productid = request.getParameter("productid");

        productbean product = new productbean();
        product.setProductid(productid);
          product.search(productid);
          String categoryid=product.getCategoryid();
        int count = product.delete();
       
        if(count==1){
             System.out.println("done");
     response.sendRedirect("admin/showproducts.jsp?categoryid="+categoryid);
        }
      
    }
//

}
