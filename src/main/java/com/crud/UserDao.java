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
        Connection conn = DBConn.initDB();
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
}
