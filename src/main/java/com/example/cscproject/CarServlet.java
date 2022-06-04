package com.example.cscproject;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "CarServlet", value = "/CarServlet")
public class CarServlet extends HttpServlet {
    private carDao cd;
    public void init() {
        cd = new carDao();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");

        String action = request.getParameter("action");
        try {
            switch (action) {
                case "addCar":
                    addCar(request, response);
                    break;
                case "delete":
                    removeCar(request, response);
                    break;

            }

        } catch (SQLException e) {
            throw new ServletException(e);
        }
    }
    private void addCar(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {

        String plate = request.getParameter("carPlate");
        String brand = request.getParameter("carBrand");
        String model = request.getParameter("carModel");
        double price = Double.parseDouble(request.getParameter("carPrice"));
        int years = Integer.parseInt(request.getParameter("carYears"));
        String pic = request.getParameter("carImage");
        String status = request.getParameter("carStatus");


        car c = new car();


        c.setCarPlate(plate);
        c.setCarBrand(brand);
        c.setCarModel(model);
        c.setCarPrice(price);
        c.setCarYears(years);
        c.setCarPic(pic);
        c.setCarStatus(status);

        cd.addCar(c);
        response.sendRedirect("dashboard.jsp");
    }
    private void removeCar(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        String plate = request.getParameter("carPlate");

        car c = new car();
        c.setCarPlate(plate);
        cd.removeCar(c);
        response.sendRedirect("carlist.jsp");

    }
}
