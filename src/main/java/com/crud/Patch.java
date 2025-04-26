package com.crud;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/patch")
public class Patch extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        PrintWriter out = res.getWriter();

        String userId = req.getParameter("id");
        int id = Integer.parseInt(userId);
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        out.println("Password: " + password);

        User user = new User();
        user.setId(id);
        user.setUsername(username);
        user.setPassword(password);

        try {
            int result = UserDao.update(user);
            if (result > 0) {
                res.sendRedirect("users");
            } else {
                out.println("Unable to update record");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        out.close();

    }
}
