/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import catalogbeans.productbean;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.DiskFileUpload;
import org.apache.commons.fileupload.FileItem;

/**
 *
 * @author real-team
 */
@WebServlet(urlPatterns = {"/productupdate"})
public class productupdate extends HttpServlet {
    String productid,productname, categoryid, image, status, description, price;
    HttpServletRequest request;
void getformdata(){
 try {
            ServletContext x = this.getServletContext();
            String path = x.getRealPath("/images");
          
            System.out.println(path+" path");
            DiskFileUpload p = new DiskFileUpload();
            List q = p.parseRequest(request);
            Iterator z = q.iterator();
            while (z.hasNext()) {
                FileItem f = (FileItem) z.next();
                if (f.isFormField() == true) {
                    //non-file data
        
                    String h = f.getFieldName();
                    String data = f.getString();
                    if (h.equalsIgnoreCase("productid")) {
                        productid = data;
                    }  else if (h.equalsIgnoreCase("productname")) {
                        productname = data;
                     
                    } else if (h.equalsIgnoreCase("category")) {
                        categoryid = data;
                    } else if (h.equalsIgnoreCase("price")) {
                        price = data;
                    } else if (h.equalsIgnoreCase("description")) {
                        description = data;
                    }
                    else if (h.equalsIgnoreCase("status")) {
                        System.out.println("status "+status);
                        status = data;
                    }
                } else {
                    //file data
                    String filename = f.getName();
                    if (filename != null && filename.length() > 0) {
                        File g = new File(filename);

                        filename = g.getName();

                        //creating unique file name
                        long w = System.currentTimeMillis();
                        filename = w + filename;
                        System.out.println("path "+path+" file "+filename);
                        //upload file
                        File t = new File(path, filename);
                        f.write(t);
                        if (f.getFieldName().equals("image")) {
                            System.out.println("images "+image);
                            image = filename;
                        }
                    }

                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

}
  
   
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
     throws ServletException, IOException {
this.request=request;
     getformdata();
     int chk=0;
        productbean product = new productbean();
        product.setProductid(productid);
        product.setCategoryid(categoryid);
        product.setDescription(description);
        product.setImage(image);
        product.setPrice(price);
        product.setStatus(status);
        product.setProductname(productname);
        
        if(image==null)
            chk=1;
        
       
        int count = product.modify(chk);
        
        if(count==1){
response.sendRedirect("admin/showproducts.jsp?categoryid="+categoryid);
        }
      
    }
//

}
