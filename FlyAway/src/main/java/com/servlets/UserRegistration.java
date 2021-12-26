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

public class UserRegistration extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String name = req.getParameter("name");
        String phone = req.getParameter("phone");
        String adress = req.getParameter("adress");

        HashMap<String,String> user = new HashMap<>();
        user.put("email",email);
        user.put("password",password);
        user.put("name",name);
        user.put("phone",phone);
        user.put("adress",adress);

        try {
            Dao dao = new Dao();
            boolean result = dao.insertUser(user);
            HttpSession session = req.getSession();
            if (result)
            {
                session.setAttribute("message","user added successful");
            }
            else {
                session.setAttribute("message","Invalid message");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        resp.sendRedirect("UserPage.jsp");
    }
}
