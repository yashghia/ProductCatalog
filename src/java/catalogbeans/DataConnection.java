/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package catalogbeans;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author real-team
 */
public class DataConnection {
    
     public static Connection getConnection() throws SQLException, ClassNotFoundException {
        String connectionUrl = "jdbc:mysql://localhost/productcatalog";
        Connection con;
        Class.forName("com.mysql.jdbc.Driver");
        con = DriverManager.getConnection(connectionUrl,"root","");
        return con;
    }
    
    
}
