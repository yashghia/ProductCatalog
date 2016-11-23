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
@WebServlet(urlPatterns = {"/categorysave"})
public class categorysave extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         PrintWriter out = response.getWriter();

        String categoryname = request.getParameter("categoryname");
        categorybean category = new categorybean();
        category.setCategoryname(categoryname);
        int count = category.save();
        if (count != 0) {
            out.println("1");
        } else {
            out.println("0");
        }
    }
//

}
