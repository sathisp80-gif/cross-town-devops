package com.cgp.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TransactionDatabaseOperations {

    public void deleteTransactionById(Long transactionId) throws SQLException, ClassNotFoundException{
        Statement statement = null;
        Connection connection = getTransactionDbConnection();
        statement = connection.createStatement();
        statement.execute("DELETE FROM transaction WHERE transaction_id=" + transactionId + ";");
        statement.close();
        connection.close();
    }

    public Connection getTransactionDbConnection() throws ClassNotFoundException, SQLException {
        Connection connection = null;
        String URL = "jdbc:postgresql://" + System.getProperty("transactionDBHost") + ":" + System.getProperty("transactionDBPort") + "/transaction";
        connection = DriverManager.getConnection(URL, System.getProperty("transactionDBUser") , System.getProperty("transactionDBPass"));
        return connection;
    }
}
