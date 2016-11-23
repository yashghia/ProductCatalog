/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

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
@WebServlet(urlPatterns = {"/checkuserlogin"})
public class checkuserlogin extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession(true);
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        
     
        
    
        registrationbean registration = new registrationbean();
        registration.setUsername(username);
        
        
        registration.setPassword(password);
        
        
        boolean flag = registration.validLogin();
        if (flag) {

            session.setAttribute("username", username);

            out.println("1");
        } else {
            out.println("0");
        }
    }
//

}
