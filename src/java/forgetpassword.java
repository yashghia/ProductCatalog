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


@WebServlet(urlPatterns = {"/forgetpassword"})
public class forgetpassword extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        try{
         PrintWriter out = response.getWriter();

        String username = request.getParameter("username");
        registrationbean registration =new registrationbean();
        registration.setUsername(username);
        
       String pass1=username.substring(0,2)+"@"+String.valueOf((int)(Math.random()*10000)+10000);
       
       String pass2=PasswordUtil.hashAndSaltPassword(pass1);
 
       String salt=PasswordUtil.saltx;
           registration.setSalt(salt);

     registration.setPassword(pass2);
     registration.changePassword();
     registration.search();
     
  
   String emailid=registration.getEmail();
        
   String message="Hello,\n\nYour new Password is :\n"+pass1+"\n\nThanks,\n\nSupport Team"+"--"+pass2;

 boolean flag= MailFunctions.msgSend("Product Catalog", emailid, "Password Reset", message);
if(flag){
    out.println("1");
}
 
    }catch(Exception e){
            e.printStackTrace();
        }
    }
//

}
