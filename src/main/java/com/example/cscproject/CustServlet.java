package com.example.cscproject;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet(name = "CustServlet", value = "/CustServlet")
public class CustServlet extends HttpServlet {

    private custDao cd;
    public void init() {
        cd = new custDao();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        session.removeAttribute("custid");
        session.invalidate();
        response.sendRedirect("login.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        String action = request.getParameter("action");

        try {
            switch (action) {
                case "login":
                    login(request, response);
                    break;
                case "signup":
                    signup(request, response);
                    break;
            }

        } catch (SQLException e) {
            throw new ServletException(e);
        }

    }
    private void login(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        try {

            Class.forName("org.postgresql.Driver"); // ni stay
            String dbURL = "jdbc:postgresql://ec2-54-227-248-71.compute-1.amazonaws.com/dbg69f8o5aj3pj";
            String user = "ruosfovocnllbi";
            String pass = "4c5eb370559357ded07f3ea6e699d8d7a41249752c9011caf5ac8c6d215bd790";
            Connection con = DriverManager.getConnection(dbURL, user, pass);

            String sql  = "SELECT * from customer";

            if (con != null){
                DatabaseMetaData dm = con.getMetaData();
                System.out.println("Driver name: " + dm.getDriverName());
                System.out.println("Driver version: " + dm.getDriverVersion());
                System.out.println("Product Name: " + dm.getDatabaseProductName());
                System.out.println("Product version: " + dm.getDatabaseProductVersion());


                Statement statement = con.createStatement();
                ResultSet res = statement.executeQuery(sql);

                while (res.next()){
                    if(username.equals(res.getString("custusername")) && password.equals(res.getString("custpassword")))
                    {

                        customer cst = new customer();

                        cst.setCustID(res.getInt(1));
                        cst.setCustName(res.getString(2));
                        cst.setCustNRIC(res.getString(3));
                        cst.setCustPhone(res.getString(4));
                        cst.setCustAddress(res.getString(5));
                        cst.setCustUsername(res.getString(6));
                        cst.setCustPassword(res.getString(7));
                        cst.setCustLicenseNo(res.getString(8));

                        session.setAttribute("custid", cst.getCustID());
                        session.setAttribute("customer", cst);
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
    private void signup(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {

        String name = request.getParameter("custName");
        String phone = request.getParameter("custPhone");
        String nric = request.getParameter("custNric");
        String address = request.getParameter("custAddress");
        String username = request.getParameter("custUsername");
        String password = request.getParameter("custPassword");
        String license = request.getParameter("custLicenseNo");


        customer cst = new customer();


        cst.setCustName(name);
        cst.setCustPhone(phone);
        cst.setCustNRIC(nric);
        cst.setCustAddress(address);
        cst.setCustUsername(username);
        cst.setCustPassword(password);
        cst.setCustLicenseNo(license);

        cd.signup(cst);
        response.sendRedirect("dashboard.jsp");
    }
}
