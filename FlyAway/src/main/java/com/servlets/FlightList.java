package com.servlets;

import com.database.Dao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class FlightList extends HttpServlet {
    protected static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String from = req.getParameter("From");
        String to = req.getParameter("To");
        String departure = req.getParameter("Departure");

        try {
            Dao dao = new Dao();
            List<String[]> flights = dao.getAvailableFlights(from,to,departure);
            HttpSession session = req.getSession();
            session.setAttribute("flights",flights);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        resp.sendRedirect("FlightList.jsp");

    }
}
