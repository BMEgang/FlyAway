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

public class UserLogin extends HttpServlet {
    private static final long serialVersionUID = 1L;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");

        try {
            Dao dao = new Dao();
            HashMap<String,String> user = dao.checkUser(email,password);
            HttpSession session = req.getSession();
            if (user != null)
            {
                session.setAttribute("user",user);
                resp.sendRedirect("HomePage.jsp");
            }
            else {
                session.setAttribute("message","Invalid details");
                resp.sendRedirect("UserPage.jsp");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
