/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import catalogbeans.*;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.commons.fileupload.*;

/**
 *
 * @author real-team
 */
@WebServlet(urlPatterns = {"/bookmarksave"})
public class bookmarksave extends HttpServlet {

    String productname, categoryid, image, status, description, price;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        System.out.println("executed");
        String productid = request.getParameter("productid1");
        Date date = new Date();
        SimpleDateFormat form = new SimpleDateFormat("dd/MM/yyyy");
        HttpSession session = request.getSession(true);
        String username = (String) session.getAttribute("username");
        System.out.println(username);
        String bookmarkdate = form.format(date);
        bookmarksbean bookmark = new bookmarksbean();
        bookmark.setProductid(productid);
        bookmark.setUsername(username);
        bookmark.setDateofbookmark(bookmarkdate);
        System.out.println(username+" "+productid);
 
           int count = bookmark.save();
       out.println("Bookmark Added");
            
            
         

    }

}
