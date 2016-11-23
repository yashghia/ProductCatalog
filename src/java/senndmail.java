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
@WebServlet(urlPatterns = {"/sendmail"})
public class senndmail extends HttpServlet {


  
   
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         PrintWriter out = response.getWriter();
        
        String categoryid = request.getParameter("productid");

        productbean product = new productbean();
        product.setCategoryid(categoryid);

        int count = product.delete();
   
        if(count==1){
        response.sendRedirect("admin/productshowall.jsp");
        }
      
    }
//

}
