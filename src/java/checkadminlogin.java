/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import catalogbeans.PasswordUtil;
import catalogbeans.*;
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
@WebServlet(urlPatterns = {"/checkadminlogin"})
public class checkadminlogin extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        PrintWriter out = response.getWriter();
       HttpSession session=request.getSession(true);
        String username = request.getParameter("username");
        String password = request.getParameter("password");
    
        adminbean admin = new adminbean();
        admin.setUsername(username);
        admin.setPassword(password);
        
        boolean flag = admin.validLogin();
        if (flag) {
      
            out.println("1");
            session.setAttribute("adminuser", username);
            
        } else {
            out.println("0");
        }
    }
//

}
