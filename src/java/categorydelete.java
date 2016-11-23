/*
 * To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import catalogbeans.categorybean;
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
@WebServlet(urlPatterns = {"/categorydelete"})
public class categorydelete extends HttpServlet {


  
   
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         PrintWriter out = response.getWriter();
       
        String categoryid = request.getParameter("categoryid");

        categorybean category = new categorybean();
        category.setCategoryid(categoryid);

        int count = category.delete();
   
        if(count==1){
        response.sendRedirect("admin/categoryshowall.jsp");
        }
      
    }
//

}
