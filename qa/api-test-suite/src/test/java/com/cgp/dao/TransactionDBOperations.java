package com.cgp.dao;

import com.cgp.containers.responses.TransactionDao;

import java.math.BigDecimal;
import java.sql.*;

public class TransactionDBOperations {

    public TransactionDao getTransactionDetails(String payee) throws SQLException, ClassNotFoundException{
        Statement statement = null;
        Connection connection = getLoginDbConnection();
        statement = connection.createStatement();
        TransactionDao transactionDao = new TransactionDao();
        String sql = "select transaction_code, transaction_status , " +
                "transaction_from_account , transaction_to_account ," +
                " (transaction_amount/100000)::varchar as amount, transaction_desc, \n" +
                "(transaction_add_dtg)::varchar as dateval from transaction where transaction_to_account='"+payee + "';";

        ResultSet rs = statement.executeQuery(sql);
        while(rs.next()){
            transactionDao.setTransactionAddDtg(rs.getString("dateval"));
            transactionDao.setTransactionAmount(new BigDecimal(rs.getString("amount")));
            transactionDao.setTransactionCode(rs.getString("transaction_code"));
            transactionDao.setTransactionDesc(rs.getString("transaction_desc"));
            transactionDao.setTransactionFromAccount(rs.getString("transaction_from_account"));
            transactionDao.setTransactionToAccount(rs.getString("transaction_to_account"));
            transactionDao.setTransactionStatus(rs.getString("transaction_status"));
        }
        rs.close();
        statement.close();
        connection.close();
        return transactionDao;
    }

    public boolean deleteAllData() throws SQLException, ClassNotFoundException{
        Statement statement = null;
        Connection connection = getLoginDbConnection();
        statement = connection.createStatement();
        statement.execute("DELETE FROM transaction;");
        statement.close();
        connection.close();
        return true;
    }

    public Connection getLoginDbConnection() throws ClassNotFoundException, SQLException {
        Connection connection = null;
        String URL = "jdbc:postgresql://" + System.getProperty("transactionDBHost") + ":" + System.getProperty("transactionDBPort") + "/" + System.getProperty("transactionDBName");
        connection = DriverManager.getConnection(URL, System.getProperty("transactionDBUser") , System.getProperty("transactionDBPass"));
        return connection;
    }

}
