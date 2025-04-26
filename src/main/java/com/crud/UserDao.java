package com.crud;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDao {
    public static List<User> fetchAll() throws SQLException, ClassNotFoundException {
        List<User> list = new ArrayList<User>();
        Connection conn = DB.initConnection();
        PreparedStatement statement = conn.prepareStatement("SELECT * FROM users");
        ResultSet result = statement.executeQuery();
        while (result.next()) {
            User user = new User();
            user.setId(result.getInt(1));
            user.setUsername(result.getString(2));
            user.setPassword(result.getString(3));
            list.add(user);
        }
        conn.close();
        return list;
    }

    public static int create(User user) throws SQLException, ClassNotFoundException {
        int result = 0;
        Connection conn = DB.initConnection();
        PreparedStatement statement = conn.prepareStatement("INSERT INTO users(username, password) values(?,?)");

        statement.setString(1, user.getUsername());
        statement.setString(2, user.getPassword());
        result = statement.executeUpdate();
        conn.close();
        return result;
    }
}
