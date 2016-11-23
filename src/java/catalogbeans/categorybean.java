package catalogbeans;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class categorybean {

    private String categoryid, categoryname;

    public categorybean() {
    }


    public String getCategoryid() {
        return categoryid;
    }

    public void setCategoryid(String categoryid) {
        this.categoryid = categoryid;
    }

    public String getCategoryname() {
        return categoryname;
    }

    public void setCategoryname(String categoryname) {
        this.categoryname = categoryname;
    }
//function to save category    

    public int save() {
        PreparedStatement statement = null;
        Connection con = null;
        int chk = 0;
        try {
            con = DataConnection.getConnection();
            String query = "insert into category values(?,?)";
            statement = con.prepareStatement(query);
            statement.setString(1, "0");
            statement.setString(2, categoryname);
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

    //function to modify category
    public int modify() {
        PreparedStatement statement = null;
        Connection con = null;
        int chk = 0;
        try {
            con = DataConnection.getConnection();
            String query = "update category set categoryname=? where categoryid=?";
            statement = con.prepareStatement(query);
            statement.setString(1, categoryname);
            statement.setString(2, categoryid);
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
            String query = "delete from category where categoryid=?";
            statement = con.prepareStatement(query);
            statement.setString(1, categoryid);
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
        ArrayList categorydata = new ArrayList();
        PreparedStatement statement = null;
        Connection con = null;
        ResultSet resultset = null;

        try {
            con = DataConnection.getConnection();
            String query = "select * from category";
            statement = con.prepareStatement(query);

            resultset = statement.executeQuery();
            while (resultset.next()) {
                categorybean category = new categorybean();
                category.categoryid = resultset.getString("categoryid");
                category.categoryname = resultset.getString("categoryname");
                categorydata.add(category);
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
        return categorydata;
    }

    //function to get category
    public boolean search(String code) {
        boolean flag = false;
        PreparedStatement statement = null;
        Connection con = null;
        ResultSet resultset = null;

        try {
            con = DataConnection.getConnection();
            String query = "select * from category where categoryid=?";
            statement = con.prepareStatement(query);
            statement.setString(1,code);
  
            resultset = statement.executeQuery();
            if (resultset.next()) {
                categoryname = resultset.getString("categoryname");
                System.out.println(categoryname);
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
