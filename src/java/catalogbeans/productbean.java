/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package catalogbeans;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class productbean {

    private String productid, categoryid, productname, price, image, description, status;

    public String getProductid() {
        return productid;
    }

    public void setProductid(String productid) {
        this.productid = productid;
    }

    public String getCategoryid() {
        return categoryid;
    }

    public void setCategoryid(String categoryid) {
        this.categoryid = categoryid;
    }

    public String getProductname() {
        return productname;
    }

    public void setProductname(String productname) {
        this.productname = productname;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    //function to save category    

    public int save() {
        PreparedStatement statement = null;
        Connection con = null;
        int chk = 0;
        try {
            con = DataConnection.getConnection();
            String query = "insert into product values(?,?,?,?,?,?,?)";
            statement = con.prepareStatement(query);
            statement.setString(1, "0");
            statement.setString(2, categoryid);
            statement.setString(3, productname);
            statement.setString(4, price);
            statement.setString(5, image);
            statement.setString(6, description);
            statement.setString(7, "Available");
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
    public int modify(int k) {
        PreparedStatement statement = null;
        Connection con = null;
        String query="";
        int chk = 0;
        try {
     
            con = DataConnection.getConnection();
            if(k==1)
            {
           query = "update product set categoryid=?,productname=?,price=?,description=?,status=? where productid=?";
           statement = con.prepareStatement(query);
            statement.setString(1, categoryid);
            statement.setString(2, productname);
            statement.setString(3, price);
           // statement.setString(4, image);
            statement.setString(4, description);
            statement.setString(5, status);
            statement.setString(6, productid);
            }
        else
           {
            query = "update product set categoryid=?,productname=?,price=?,image=? ,description=?,status=? where productid=?";
           statement = con.prepareStatement(query);
            statement.setString(1, categoryid);
            statement.setString(2, productname);
            statement.setString(3, price);
            statement.setString(4, image);
            statement.setString(5, description);
            statement.setString(6, status);
            statement.setString(7, productid);
       }
            
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

    //function to delete product
    public int delete() {
        PreparedStatement statement = null;
        Connection con = null;
        int chk = 0;
        try {
            con = DataConnection.getConnection();
            String query = "delete from product where productid=?";
            statement = con.prepareStatement(query);
            statement.setString(1, productid);
            chk = statement.executeUpdate();
            System.out.println("fff " + chk);
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
        ArrayList productdata = new ArrayList();
        PreparedStatement statement = null;
        Connection con = null;
        ResultSet resultset = null;

        try {

            con = DataConnection.getConnection();
            String query = "select * from product";
            statement = con.prepareStatement(query);

            resultset = statement.executeQuery();
            while (resultset.next()) {
                System.out.println("hello");
                productbean product = new productbean();
                product.productid = resultset.getString("productid");
                product.categoryid = resultset.getString("categoryid");

                product.productname = resultset.getString("productname");
                product.price = resultset.getString("price");
                product.image = resultset.getString("image");
                product.description = resultset.getString("description");
                product.status = resultset.getString("status");
                productdata.add(product);
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
        return productdata;
    }

    //function to get all category
    public ArrayList productsByCategory() {
        ArrayList productdata = new ArrayList();
        PreparedStatement statement = null;
        Connection con = null;
        ResultSet resultset = null;

        try {

            con = DataConnection.getConnection();
            String query = "select * from product where categoryid=?";
            statement = con.prepareStatement(query);
            System.out.println("categotyid " + categoryid);
            statement.setString(1, categoryid);
            resultset = statement.executeQuery();
            while (resultset.next()) {

                productbean product = new productbean();
                product.productid = resultset.getString("productid");

                product.productname = resultset.getString("productname");
                product.description = resultset.getString("description");
                product.image = resultset.getString("image");
                product.price = resultset.getString("price");

                product.status = resultset.getString("status");
                productdata.add(product);
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
        return productdata;
    }

    //function to get category
    public boolean search(String code) {
        boolean flag = false;
        PreparedStatement statement = null;
        Connection con = null;
        ResultSet resultset = null;

        try {
            con = DataConnection.getConnection();
            String query = "select * from product where productid=?";
            statement = con.prepareStatement(query);
            statement.setString(1, code);
            resultset = statement.executeQuery();
            if (resultset.next()) {
                productname = resultset.getString("productname");
                categoryid = resultset.getString("categoryid");
                price = resultset.getString("price");
                image = resultset.getString("image");
                description = resultset.getString("description");
                status = resultset.getString("status");
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

    public ArrayList productsByName(String name) {
        ArrayList productdata = new ArrayList();
        PreparedStatement statement = null;
        Connection con = null;
        ResultSet resultset = null;

        try {

            con = DataConnection.getConnection();
            String query = "select * from product where productname like '%" + name + "%'";
            statement = con.prepareStatement(query);
            resultset = statement.executeQuery();
            while (resultset.next()) {

                productbean product = new productbean();
                product.productid = resultset.getString("productid");

                product.productname = resultset.getString("productname");
                product.price = resultset.getString("price");
                product.image = resultset.getString("image");

                product.status = resultset.getString("status");
                productdata.add(product);
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
        return productdata;
    }
}
