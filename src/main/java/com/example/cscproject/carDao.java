package com.example.cscproject;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static java.lang.System.out;
public class carDao {

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
    public void addCar (car c) throws SQLException {

        // try-with-resource statement will auto close the connection.
        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement
                     ("insert into cars(carplate,carbrand,carmodel,carprice,caryears,carpic,carstatus) values(?,?,?,?,?,?,?)"))
        {

            ps.setString(1, c.getCarPlate());
            ps.setString(2, c.getCarBrand());
            ps.setString(3, c.getCarModel());
            ps.setDouble(4, c.getCarPrice());
            ps.setInt(5, c.getCarYears());
            ps.setString(6, c.getCarPic());
            ps.setString(7, c.getCarStatus());
            out.println(ps);
            ps.executeUpdate();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
