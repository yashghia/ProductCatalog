/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import catalogbeans.bookmarksbean;
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
 * @author Dell-pc
 */
@WebServlet(urlPatterns = {"/remove_bookmark"})
public class remove_bookmark extends HttpServlet {

     protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String bookmarkid = request.getParameter("bookmarkid");

        bookmarksbean bookmark = new bookmarksbean();
        bookmark.setBookmarkid(bookmarkid);
int count=bookmark.delete();
        
        response.sendRedirect("user/showbookmarks.jsp");
       
    }
//

}
