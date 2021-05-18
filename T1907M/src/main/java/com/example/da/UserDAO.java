package com.example.da;

import com.example.entity.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class UserDAO {
    private String jdbcURL = "jdbc:mysql://localhost:3380/t1808a1useSSL=false";
    private String jdbcUserName = "root";
    private String jdbcPassword = "";
    private static final String INSERT_USERS_SQL = "INSERT INTO user" + "(name, email, country) VALUES" +
            "(hoang, nhathoang03081999@gmail.com, ha noi)";
    private static final String SELECT_USERS_BY_ID = "SELECT id, name, email, country FROM users WHERE id = 1";
    private static final String SELECT_ALL_USERS = "SELECT FROM users";
    private static final String DELETE_USERS_SQL = "DELETE FROM users WHERE id = 1";
    private static final String UPDATE_USERS_SQL = "UPDATE users set name = ?, email = ?, country = ? WHERE id = ?";

    public UserDAO() {
    }

    protected Connection getConnection() throws ClassNotFoundException, SQLException {
        Connection connection = null;
        Class.forName("com.mysql.cj.jdbc.Driver");
        connection = DriverManager.getConnection(jdbcURL, jdbcUserName, jdbcPassword);
        return connection;
    }

    public void insertUser(User user) throws SQLException, ClassNotFoundException {
        Connection connection = getConnection();

    }
}
