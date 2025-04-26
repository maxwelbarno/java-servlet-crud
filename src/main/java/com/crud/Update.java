package com.crud;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/update")
public class Update extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        res.setContentType("text/html;charset=UTF-8");

        PrintWriter out = res.getWriter();
        String userId = req.getParameter("id");
        int id = Integer.parseInt(userId);

        try {
            User user = UserDao.fetchById(id);

            out.println("<h2>Update User Details</h2>");
            out.print("<form action='patch' method='post'>");
            out.print("<table>");
            out.print("<tr><td></td><td><input type='hidden' name='id' value='" + user.getId() + "'/></td></tr>");
            out.print("<tr><td></td><td><input type='text' name='username' value='" + user.getUsername()
                    + "'/></td></tr>");
            out.print("<tr><td></td><td><input type='text' name='password' value='" + user.getPassword()
                    + "'/></td></tr>");
            out.print("<tr><td colspan='2'><input type='submit' value='Update'/></td></tr>");
            out.print("</table>");
            out.print("</form>");
            out.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
