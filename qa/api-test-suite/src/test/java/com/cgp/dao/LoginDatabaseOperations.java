package com.cgp.dao;

import com.cgp.containers.memory.LoginContainer;

import java.sql.Connection;


import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class LoginDatabaseOperations {

    public boolean deleteUser(Long loginId ) throws SQLException, ClassNotFoundException {
        Statement statement = null;
        Connection connection = getLoginDbConnection();
        statement = connection.createStatement();
        statement.execute("DELETE FROM login WHERE login_id=" + loginId + ";");
        statement.close();
        connection.close();
        return true;
    }

    public Connection getLoginDbConnection() throws ClassNotFoundException, SQLException {
        Connection connection = null;
//        Class.forName("com.postgres.jdbc.Driver");
        String URL = "jdbc:postgresql://" + System.getProperty("loginDBHost") + ":" + System.getProperty("loginDBPort") + "/login";
        connection = DriverManager.getConnection(URL, System.getProperty("loginDBUser") , System.getProperty("loginDBPass"));

        return connection;
    }
}
