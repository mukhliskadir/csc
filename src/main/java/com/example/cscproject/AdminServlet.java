package com.example.cscproject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet(name = "AdminServlet", value = "/AdminServlet")
public class AdminServlet extends HttpServlet {

    private AdminDao ad;
    public void init() {
        ad = new AdminDao();
    }



    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String action = request.getParameter("action");

        try {
            switch (action) {
                case "login":
                    login(request, response);
                    break;

            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }


    }



    /*######################################################( LOGIN )#############################################################*/


    private void login(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();

        String password = request.getParameter("adminpassword");
        String username = request.getParameter("adminusername");

        try {

            Class.forName("org.postgresql.Driver"); // ni stay
            String dbURL = "jdbc:postgresql://ec2-34-194-171-47.compute-1.amazonaws.com/dcb70s908sasfa"; //ni url dri heroku database
            String user = "gpdkvocjaztxrw"; //ni user dri heroku database
            String pass = "dceb52b9fa471dce9048a701a0f88b7d4dee9e9ca420a48101baa31d0e68def5"; //ni password dri heroku database
            Connection conn = DriverManager.getConnection(dbURL, user, pass);

            String sql  ="SELECT * from admin";

            if (conn != null){
                DatabaseMetaData dm = conn.getMetaData();
                System.out.println("Driver name: " + dm.getDriverName());
                System.out.println("Driver version: " + dm.getDriverVersion());
                System.out.println("Product Name: " + dm.getDatabaseProductName());
                System.out.println("Product version: " + dm.getDatabaseProductVersion());


                Statement statement = conn.createStatement();
                ResultSet res = statement.executeQuery(sql);

                while (res.next()){
                    if(username.equals(res.getString("adminusername")) && password.equals(res.getString("adminpassword")))
                    {
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