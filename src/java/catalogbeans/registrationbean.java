package catalogbeans;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class registrationbean {

    private String name, contact, email, username, password,salt;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

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

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

//function to save category    
    public int save() {
        PreparedStatement statement = null;
        Connection con = null;
        int chk = 0;
        try {
            con = DataConnection.getConnection();
            String query = "insert into registration values(?,?,?,?,?,?)";
            statement = con.prepareStatement(query);
            statement.setString(1, name);
            statement.setString(2, contact);
            statement.setString(3, email);
            statement.setString(4, username);
            statement.setString(5, password);
             statement.setString(6, salt);

            chk = statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            if (statement != null) {
                try {
                    statement.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (con != null) {
                try {
                    con.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }

        }
        return chk;
    }

 

    //function to delete category
    public int delete() {
        PreparedStatement statement = null;
        Connection con = null;
        int chk = 0;
        try {
            con = DataConnection.getConnection();
            String query = "delete from registration where username=?";
            statement = con.prepareStatement(query);
            statement.setString(1, username);
            chk = statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            if (statement != null) {
                try {
                    statement.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (con != null) {
                try {
                    con.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }

        }
        return chk;
    }

    //function to get all category
    public ArrayList showAll() {
        ArrayList registrationdata = new ArrayList();
        PreparedStatement statement = null;
        Connection con = null;
        ResultSet resultset = null;

        try {
            con = DataConnection.getConnection();
            String query = "select * from registration";
            statement = con.prepareStatement(query);

            resultset = statement.executeQuery();
            while (resultset.next()) {
                registrationbean registration = new registrationbean();
                registration.name = resultset.getString("name");
                registration.contact = resultset.getString("contact");
                registration.email = resultset.getString("email");
                registration.username = resultset.getString("username");
                registration.password = resultset.getString("password");
                registrationdata.add(registration);
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
        return registrationdata;
    }

    //function to check valid login
    public boolean validLogin() {
        boolean flag = false;
        PreparedStatement statement = null;
        Connection con = null;
        ResultSet resultset = null;

        try {
            con = DataConnection.getConnection();
            
            String query = "select * from registration where username=?";
            statement = con.prepareStatement(query);
            statement.setString(1, username);
            resultset = statement.executeQuery();
            if (resultset.next()) {
             
                salt=resultset.getString("salt");
            }
            
                String encodedpassword = PasswordUtil.chkHashAndSaltPassword(password,salt);
            
          query = "select * from registration where username=? and password=?";
            statement = con.prepareStatement(query);
            statement.setString(1, username);
            statement.setString(2, encodedpassword);
            resultset = statement.executeQuery();
            if (resultset.next()) {
                flag = true;
                email = resultset.getString("email");
                name = resultset.getString("name");
                contact = resultset.getString("contact");
           

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

    public boolean searchbyemail() {
        boolean flag = false;
        PreparedStatement statement = null;
        Connection con = null;
        ResultSet resultset = null;
        try {
            con = DataConnection.getConnection();
            String query = "select * from registration where email =?";
            statement = con.prepareStatement(query);
            statement.setString(1, email);
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
    public boolean search() {
        boolean flag = false;
        PreparedStatement statement = null;
        Connection con = null;
        ResultSet resultset = null;
        try {
            con = DataConnection.getConnection();
            String query = "select * from registration where username=?";
            statement = con.prepareStatement(query);
            statement.setString(1, username);
            resultset = statement.executeQuery();
            if (resultset.next()) {
                flag = true;
                email = resultset.getString("email");
                name = resultset.getString("name");
                contact = resultset.getString("contact");
                password = resultset.getString("password");
              
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

    public int changePassword() {
        boolean flag = false;
        PreparedStatement statement = null;
        Connection con = null;

        int count = 0;
        try {
            con = DataConnection.getConnection();
            String query = "update registration set password=?,salt=? where username=?";
            statement = con.prepareStatement(query);
            statement.setString(1, password);
             statement.setString(2, salt);
            statement.setString(3, username);
            count = statement.executeUpdate();
            System.out.println(count + " " + password + " " + username);

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

        }
        return count;
    }
    
    
    
}
