package com.example.cscproject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
/**
 * Servlet implementation class AdminServlet
 */
@WebServlet("/AdminServlet")
public class AdminServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminServlet() {
        super();

        // TODO Auto-generated constructor stub
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        PrintWriter out = response.getWriter();


        String password = request.getParameter("adminpassword");
        String username = request.getParameter("adminusername");

        try {
            Class.forName("org.postgresql.Driver"); // ni stay
            String dbURL = "jdbc:postgresql://ec2-54-227-248-71.compute-1.amazonaws.com/dbg69f8o5aj3pj";
            String user = "ruosfovocnllbi";
            String pass = "4c5eb370559357ded07f3ea6e699d8d7a41249752c9011caf5ac8c6d215bd790";
            Connection con = DriverManager.getConnection(dbURL, user, pass);

            String sql  ="SELECT * from admin";

            if (con != null){
                Statement statement = con.createStatement();
                ResultSet res = statement.executeQuery(sql);

                while (res.next()){
                    if(username.equals(res.getString("adminusername")) && password.equals(res.getString("adminpassword")))
                    {


                        response.sendRedirect("dashboard.jsp");


                    }else{
                        out.println("User not exist");
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}


