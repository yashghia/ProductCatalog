/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import catalogbeans.productbean;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.*;

/**
 *
 * @author real-team
 */
@WebServlet(urlPatterns = {"/productsave"})
public class productsave extends HttpServlet {

    String productname, categoryid, image="blank.jpg", status, description, price;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        try {
            ServletContext x = this.getServletContext();
            String path = x.getRealPath("/images");

            System.out.println(path + " path");
            DiskFileUpload p = new DiskFileUpload();
            List q = p.parseRequest(request);
            Iterator z = q.iterator();
            while (z.hasNext()) {
                FileItem f = (FileItem) z.next();
                if (f.isFormField() == true) {
                    //non-file data
                    System.out.println("executed");
                    String h = f.getFieldName();
                    String data = f.getString();
                    if (h.equalsIgnoreCase("productname")) {
                        productname = data;
                    } else if (h.equalsIgnoreCase("category")) {
                        categoryid = data;
                        System.out.println(categoryid + " cccc");
                    } else if (h.equalsIgnoreCase("price")) {
                        price = data;
                    } else if (h.equalsIgnoreCase("description")) {
                        description = data;
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
                        System.out.println("path " + path + " file " + filename);
                        //upload file
                        File t = new File(path, filename);
                        f.write(t);
                        if (f.getFieldName().equals("image")) {
                            image = filename;
                        }
                    }
                    

                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        productbean product = new productbean();
        product.setProductname(productname);
        product.setCategoryid(categoryid);
        product.setDescription(description);
        product.setImage(image);
        product.setPrice(price);
        int count = product.save();
        if (count != 0) {
            out.println("1");
        } else {
            out.println("0");
        }
    }

//
}
