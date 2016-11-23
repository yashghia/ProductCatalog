/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import catalogbeans.PasswordUtil;
import catalogbeans.categorybean;
import catalogbeans.registrationbean;
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
@WebServlet(urlPatterns = {"/usersave"})
public class usersave extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        boolean flag=false;
     PrintWriter out = response.getWriter();
        try {
       

            String name = request.getParameter("user");
            
             String username = request.getParameter("username");
            String contact = request.getParameter("contact");
            String user_emailid = request.getParameter("emailid");
            String password = request.getParameter("password");
            
            registrationbean registration = new registrationbean();
            registration.setContact(contact);
            registration.setEmail(user_emailid);
            registration.setName(name);
            String encodedpassword=PasswordUtil.hashAndSaltPassword(password);
            registration.setPassword(encodedpassword);
             String salt=PasswordUtil.saltx;
            registration.setSalt(salt);
            registration.setUsername(username);
               boolean flag2=false;
           boolean flag1=registration.searchbyemail();
           if(flag1==true)
           {
           out.println("0");//emailid already exist
           }
           else{
          flag2=registration.search();
           if(flag2==true)
            {
           out.println("1");//username already exist
            }
           }
           if(!flag1&!flag2){
           //code will be exected only username and emailid does not exist
            int count = registration.save();
     String message = "Hello,\n\nCongratulations!\n\nYou have registered successfully.\n\nYour login details are below\n\n"+"Username: " + username + "\n" + "Password: " + password+"\n\nThanks,\nSupport Team";
            flag = MailFunctions.msgSend("Real Infotech", user_emailid, "Registration confirmation", message);

            if (count != 0) {
                out.println("2");
                  if(!flag)
                    out.println("4");
            } 
           }
      
        } catch (Exception e) {
        if(!flag)
                    out.println("4");
        }
    }
//

}
