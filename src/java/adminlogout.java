
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
@WebServlet(urlPatterns = {"/adminlogout"})
public class adminlogout extends HttpServlet {

    String productname, categoryid, image, status, description, price;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
HttpSession session=request.getSession(true);
session.invalidate();
response.sendRedirect("admin/adminlogin.jsp");

    }

}
