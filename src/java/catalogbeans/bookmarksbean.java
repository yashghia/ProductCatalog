package catalogbeans;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class bookmarksbean {

    private String bookmarkid, username, productid, dateofbookmark;

    public String getBookmarkid() {
        return bookmarkid;
    }

    public void setBookmarkid(String bookmarkid) {
        this.bookmarkid = bookmarkid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getProductid() {
        return productid;
    }

    public void setProductid(String productid) {
        this.productid = productid;
    }

    public String getDateofbookmark() {
        return dateofbookmark;
    }

    public void setDateofbookmark(String dateofbookmark) {
        this.dateofbookmark = dateofbookmark;
    }

//function to save category    
    public int save() {
        PreparedStatement statement = null;
        Connection con = null;
        int chk = 0;
        try {
            con = DataConnection.getConnection();
            String query = "insert into bookmarks values(?,?,?,?)";
            statement = con.prepareStatement(query);
            statement.setString(1, "0");
            statement.setString(2, username);
            statement.setString(3, productid);
            statement.setString(4, dateofbookmark);
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
            String query = "update bookmarks set username=?,productid=?,dateofbookmark=? where bookmarkid=?";
            statement = con.prepareStatement(query);
            statement.setString(1, username);
            statement.setString(2, productid);
            statement.setString(3, dateofbookmark);
            statement.setString(4, bookmarkid);
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
            String query = "delete from bookmarks where productid=? and username=?";
            statement = con.prepareStatement(query);
            statement.setString(1, productid);
              statement.setString(2, username);
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
        ArrayList bookmarkdata = new ArrayList();
        PreparedStatement statement = null;
        Connection con = null;
        ResultSet resultset = null;

        try {
            con = DataConnection.getConnection();
            String query = "select * from bookmarks";
            statement = con.prepareStatement(query);

            resultset = statement.executeQuery();
            while (resultset.next()) {
                bookmarksbean bookmark = new bookmarksbean();
                bookmark.bookmarkid = resultset.getString("bookmarkid");
                bookmark.username = resultset.getString("username");
                bookmark.productid = resultset.getString("productid");
                bookmark.dateofbookmark = resultset.getString("dateofbookmark");
                bookmarkdata.add(bookmark);
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
        return bookmarkdata;
    }
 public ArrayList showBookmark() {
        boolean flag = false;
        PreparedStatement statement = null;
        Connection con = null;
        ResultSet resultset = null;
ArrayList data=new ArrayList();
        try {
            con = DataConnection.getConnection();
            String query = "select * from bookmarks where username=?" ;
            statement = con.prepareStatement(query);
            statement.setString(1,username);
         
            resultset = statement.executeQuery();
           while (resultset.next()) {
             bookmarksbean bookmark=new bookmarksbean();
             bookmark.setDateofbookmark(resultset.getString("dateofbookmark"));
             bookmark.setProductid(resultset.getString("productid"));
               bookmark.setBookmarkid(resultset.getString("bookmarkid"));
             data.add(bookmark);
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
        return data;
    }
    //function to get category
    public boolean checkBookMark() {
        boolean flag = false;
        PreparedStatement statement = null;
        Connection con = null;
        ResultSet resultset = null;

        try {
            con = DataConnection.getConnection();
            String query = "select * from bookmarks where username=? and productid=?";
            statement = con.prepareStatement(query);
            statement.setString(1,username);
            statement.setString(2,productid);
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
