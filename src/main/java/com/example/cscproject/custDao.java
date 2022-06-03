package com.example.cscproject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static java.lang.System.out;

public class custDao {

    String dbURL = "jdbc:postgresql://ec2-54-227-248-71.compute-1.amazonaws.com/dbg69f8o5aj3pj";
    String user = "ruosfovocnllbi";
    String pass = "4c5eb370559357ded07f3ea6e699d8d7a41249752c9011caf5ac8c6d215bd790";



    protected Connection getConnection() {
        Connection con = null;
        try {
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection(dbURL, user, pass);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return con;

    }
    public void signup (customer cst) throws SQLException {

        // try-with-resource statement will auto close the connection.
        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement
                     ("insert into customer(custname,custphone,custnric,custaddress,custusername,custpassword,custlicenseno) values(?,?,?,?,?,?,?)"))
        {

            ps.setString(2, cst.getCustName());
            ps.setString(3, cst.getCustPhone());
            ps.setString(4, cst.getCustNRIC());
            ps.setString(5, cst.getCustAddress());
            ps.setString(6, cst.getCustUsername());
            ps.setString(7, cst.getCustPassword());
            ps.setString(8, cst.getCustLicenseNo());
            out.println(ps);
            ps.executeUpdate();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

}
