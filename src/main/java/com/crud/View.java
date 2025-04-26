package com.crud;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/users")
public class View extends HttpServlet {
    protected void processRequest(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        res.setContentType("text/html;charset=UTF-8");
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        processRequest(req, res);
        PrintWriter out = res.getWriter();

        List<User> list = null;

        out.print("<h1> Users Table </h1>");
        out.print(
                "<table border='1' cellpadding='4' width='80%'>");
        out.print("<tr><th>Id</th><th>username</th></tr>");

        try {
            list = UserDao.fetchAll();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        if (list != null) {
            for (User user : list) {
                out.print("<tr><td>" + user.getId() + "</td><td>" + user.getUsername() + "</td></tr>");
            }
            out.print("</table>");
        }
        out.close();
    }
}
