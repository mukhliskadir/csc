package com.example.cscproject;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static java.lang.System.out;

public class staffDAO {


    String dbURL = "jdbc:postgresql://ec2-54-227-248-71.compute-1.amazonaws.com/dbg69f8o5aj3pj"; //ni url dri heroku database
    String user = "ruosfovocnllbi"; //ni user dri heroku database
    String pass = "4c5eb370559357ded07f3ea6e699d8d7a41249752c9011caf5ac8c6d215bd790"; //ni password dri heroku database




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



    public void signup (staff adm) throws SQLException {

        // try-with-resource statement will auto close the connection.
        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement("insert into staff(staffname,staffphone,staffusername,staffpassword) values(?,?,?,?)");)
        {
            ps.setString(1, adm.getStaffName());
            ps.setString(2, adm.getStaffPhone());
            ps.setString(3, adm.getStaffUsername());
            ps.setString(4, adm.getStaffPassword());

            out.println(ps);
            ps.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }



    public boolean updateUser(staff adm) throws SQLException {
        boolean UpdateRow;
        try (Connection con = getConnection();
             PreparedStatement stmt = con.prepareStatement("UPDATE admin set staffusername=?,staffpassword=?,staffname=?,staffphone=? where staffid=?");)
        {
            stmt.setString(1, adm.getStaffName());
            stmt.setString(2, adm.getStaffPhone());
            stmt.setString(3,adm.getStaffUsername());
            stmt.setString(4, adm.getStaffPassword());
            stmt.setInt(5, adm.getStaffID());

            UpdateRow = stmt.executeUpdate() > 0;
        }
        return UpdateRow;
    }



    public boolean deleteUser(int staffID) throws SQLException {
        boolean DeleteRow;
        try (Connection con = getConnection();
             PreparedStatement stmt = con.prepareStatement("delete from staff where staffid=?");) {
            stmt.setInt(1, staffID);
            DeleteRow = stmt.executeUpdate() > 0;
        }
        return DeleteRow;
    }


    public boolean deleteCust(int custID) throws SQLException {
        boolean DeleteRow;
        try (Connection con = getConnection();
             PreparedStatement stmt = con.prepareStatement("delete from customer where custid=?");) {
            stmt.setInt(1, custID);
            DeleteRow = stmt.executeUpdate() > 0;
        }
        return DeleteRow;
    }

    private void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }






}
