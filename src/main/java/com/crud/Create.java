package com.crud;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/create")
public class Create extends HttpServlet {
    protected void processRequest(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        res.setContentType("text/html;charset=UTF-8");
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        PrintWriter out = res.getWriter();

        String username = req.getParameter("username");
        String password = req.getParameter("password");

        User user = new User();
        user.setUsername(username);
        user.setPassword(password);

        int status = 0;

        try {
            status = UserDao.create(user);
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (status > 0) {
            res.sendRedirect("users");
        } else {
            out.println("<p>Unable to save record!</p>");
        }
        out.close();

    }
}
