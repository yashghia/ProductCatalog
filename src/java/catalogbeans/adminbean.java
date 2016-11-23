/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package catalogbeans;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author sunny
 */
public class adminbean {

    private String username, password;



    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    //function to check valid login
    public boolean validLogin() {
        boolean flag = false;
        PreparedStatement statement = null;
        Connection con = null;
        ResultSet resultset = null;

        try {
            con = DataConnection.getConnection();
            String query = "select * from admin where username=? and password=?";
            statement = con.prepareStatement(query);
            statement.setString(1, username);
            statement.setString(2, password);
            resultset = statement.executeQuery();
            if (resultset.next()) {
               
                flag = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //close preparedstatement
            if (statement != null) {
                try {
                    statement.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            //close connection
            if (con != null) {
                try {
                    con.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
            //close resultset
            if (resultset != null) {
                try {
                    resultset.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        }
        return flag;
    }

}
