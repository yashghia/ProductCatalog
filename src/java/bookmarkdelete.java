/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import catalogbeans.bookmarksbean;
import catalogbeans.categorybean;
import catalogbeans.productbean;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author real-team
 */
@WebServlet(urlPatterns = {"/bookmarkdelete"})
public class bookmarkdelete extends HttpServlet {


  
   
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         PrintWriter out = response.getWriter();
         HttpSession session =request.getSession(true);
         String username=(String)session.getAttribute("username");
        String productid = request.getParameter("productid");

        bookmarksbean bookmark = new bookmarksbean();
        bookmark.setProductid(productid);
      bookmark.setUsername(username);
        int count = bookmark.delete();
   
       out.println("Bookmark Removed");
      
    }
//

}
