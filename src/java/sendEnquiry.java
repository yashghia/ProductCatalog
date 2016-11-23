/*
* To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import catalogbeans.*;
import java.io.IOException;
import java.io.PrintWriter;
import javax.mail.Session;
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
@WebServlet(urlPatterns = {"/sendEnquiry"})
public class sendEnquiry extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        try {
            PrintWriter out = response.getWriter();
         
            response.setContentType("text/html");
            //get product name
            String productid = request.getParameter("productid1");
             String enquiry =request.getParameter("t1");
             
             
            productbean product = new productbean();
            product.search(productid);
           
            String productname = product.getProductname();
            System.out.println("product "+product+" "+productname);
            HttpSession session = request.getSession(true);
            registrationbean registration = new registrationbean();
            //get userdata
            String username = (String) session.getAttribute("username");
            if(username!=null){
            registration.setUsername(username);
            registration.search();
            String useremailid = registration.getEmail();
            String name = registration.getName();
            String contact = registration.getContact();
            String adminemailid = "dev@realinfotech.in";
            String sender = "Product catalog";
            
            String message = "User's Enquiry"+"\n";
            message += "Email-id: " + useremailid + " \n" + "Username: " + username + "\n " + "Name: " + name + " \n" + "Product " + productname;
            
            message+="\nEnquiry: "+enquiry;
            boolean flag = MailFunctions.msgSend(sender, adminemailid, "Enquiry", message);
            
            
            
            message="Hello, \n\nYou have sent enquiry for "+productname+".\n\nWe will get back to your response soon.\n\nThanks,\nSupport Team";
            
            boolean flag2=MailFunctions.msgSend(sender, useremailid, "Enquiry", message);
            System.out.println(flag);
           
            if (flag == true) {
                
                out.println("Enquiry Sent");
            }
            else
            {
                out.println("Enquiry not Sent");
            }
            }
            else{
          out.println("1");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
