package com.cgp.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CardDatabaseOperations {



    public boolean deleteProfileByCode(String profileCode) throws SQLException, ClassNotFoundException{
        Statement statement = null;
        Connection connection = getLoginDbConnection();
        statement = connection.createStatement();
        statement.execute("DELETE FROM profile WHERE profile_code='" + profileCode + "';");
        statement.close();
        connection.close();
        return true;
    }

    public boolean deleteCardByCode(String cardCode) throws SQLException, ClassNotFoundException{
        Statement statement = null;
        Connection connection = getLoginDbConnection();
        statement = connection.createStatement();
        statement.execute("DELETE FROM card WHERE card_client_code='" + cardCode + "';");
        statement.close();
        connection.close();
        return true;
    }



    public Connection getLoginDbConnection() throws ClassNotFoundException, SQLException {
        Connection connection = null;
        String URL = "jdbc:postgresql://" + System.getProperty("cardDBHost") + ":" + System.getProperty("cardDBPort") + "/cards";
        connection = DriverManager.getConnection(URL, System.getProperty("cardDBUser") , System.getProperty("cardDBPass"));
        return connection;
    }
}
