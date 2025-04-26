package com.crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConn {
    protected static Connection initDB() throws SQLException, ClassNotFoundException {
        String url = "jdbc:mysql://localhost:3306/";
        String db = "auth";
        String username = "admin";
        String password = "admin123";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(url + db, username, password);
            return conn;
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
