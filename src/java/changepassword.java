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


@WebServlet(urlPatterns = {"/changepassword"})
public class changepassword extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        try{
         PrintWriter out = response.getWriter();

        String username = request.getParameter("username");
        String password = request.getParameter("password1");
              String encodedpassword=  PasswordUtil.hashAndSaltPassword(password);
        registrationbean registration =new registrationbean();
        registration.setUsername(username);
        registration.setPassword(encodedpassword);
          String salt=PasswordUtil.saltx;
           registration.setSalt(salt);
        
      int c=  registration.changePassword();
if(c!=0){
out.println("1");
}
else{
out.println("0");
}

        }catch(Exception e){
            e.printStackTrace();
        }
    }
//

}
