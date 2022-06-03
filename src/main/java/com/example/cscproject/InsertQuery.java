package com.example.cscproject;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.*;



public class InsertQuery {
    public static void main(String[] args) {
        try{

            Class.forName("org.postgresql.Driver"); // ni stay
            String dbURL = "jdbc:postgresql://ec2-54-227-248-71.compute-1.amazonaws.com/dbg69f8o5aj3pj";
            String user = "ruosfovocnllbi";
            String pass = "4c5eb370559357ded07f3ea6e699d8d7a41249752c9011caf5ac8c6d215bd790";
            Connection con = DriverManager.getConnection(dbURL, user, pass);
            Statement stmt=con.createStatement();
            String sql="INSERT INTO STAFF(staffid,staffame,staffphone, staffusername,staffpassword)VALUES(2,'ADSli','sda','zara', '123')";


            stmt.executeUpdate(sql);

            con.close();
        }catch(Exception e){
            System.out.println(e);
        }
    }
}