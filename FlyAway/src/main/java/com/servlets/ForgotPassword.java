package com.servlets;

import com.database.Dao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

public class ForgotPassword extends HttpServlet {
    protected static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");

        try {
            Dao dao = new Dao();
            HttpSession session = req.getSession();
            if (dao.changeAdminPassword(email,password)){
                session.setAttribute("message","password changed successful");
            }
            else{
                session.setAttribute("message","Invalid details");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        resp.sendRedirect("AdminPage.jsp");
    }
}
