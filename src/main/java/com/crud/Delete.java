package com.crud;

import java.io.IOException;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/delete")
public class Delete extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        String userId = req.getParameter("id");
        int id = Integer.parseInt(userId);

        try {
            UserDao.delete(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        res.sendRedirect("users");

    }
}
