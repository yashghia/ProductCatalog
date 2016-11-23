/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import catalogbeans.productbean;
import catalogbeans.registrationbean;
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
 * @author Dell-pc
 */
@WebServlet(urlPatterns = {"/contactus"})
public class contactus extends HttpServlet {
   protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        try {
            PrintWriter out=response.getWriter();
            String message="";
           String firstname=request.getParameter("first-name");
           String lastname=request.getParameter("surname");
           String emailid=request.getParameter("email");
           String phone=request.getParameter("phone");
           String msg=request.getParameter("message");
            String to_admin = "realtest998@gmail.com";
            String sender = "User";
            message += "Email-id: " + emailid + "\n" + "Name: " + firstname+" "+lastname + "\n" + "Phone Number: " + phone + "\n" + "Message " + msg;
            boolean flag = MailFunctions.msgSend(sender, to_admin, "Enquiry", message);
            System.out.println(flag);
            if (flag == true) {
                
                out.println("1");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
