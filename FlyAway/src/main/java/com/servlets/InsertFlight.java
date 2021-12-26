package com.servlets;

import com.database.Dao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;

public class InsertFlight extends HttpServlet {
    protected static final long serialVersionUID = 1L;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("Name");
        String from = req.getParameter("From");
        String to = req.getParameter("To");
        String departure = req.getParameter("Departure");
        String time = req.getParameter("Time");
        String price = req.getParameter("Price");


        HashMap<String,String> flight = new HashMap<>();
        flight.put("Name",name);
        flight.put("From",from);
        flight.put("To",to);
        flight.put("Departure",departure);
        flight.put("Time",time);
        flight.put("Price",price);

        try {
            Dao dao = new Dao();
            HttpSession session = req.getSession();

            if (dao.insertFlight(flight))
            {

                session.setAttribute("message","Flight added successful");
            }
            else {

                session.setAttribute("message","Invalid message");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        resp.sendRedirect("AdminHome.jsp");
    }
}
