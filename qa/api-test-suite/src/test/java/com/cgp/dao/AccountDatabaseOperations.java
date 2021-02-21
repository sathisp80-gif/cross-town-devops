package com.cgp.dao;

import java.sql.*;
import java.util.Calendar;

public class AccountDatabaseOperations {

    public boolean shiftOperationDate(Integer operationId, Integer shiftDays) throws SQLException, ClassNotFoundException {
        Statement statement = null;
        Connection connection = getLoginDbConnection();
        statement = connection.createStatement();
        String sqlQuery = "SELECT operation_add_dtg from operation where operation_id="+operationId+";";
        ResultSet rs =statement.executeQuery(sqlQuery);
        rs.next();
        Timestamp currentTime = rs.getTimestamp("operation_add_dtg");
        Calendar cal = Calendar.getInstance();
        cal.setTime(currentTime);
        cal.add(Calendar.DATE,shiftDays);
        Timestamp updateTime = new Timestamp(cal.getTime().getTime());
        statement.close();
        connection.close();
        return updateOperationDate(updateTime, operationId);
    }

    public boolean updateOperationDate(Timestamp timestamp, Integer operationId) throws SQLException, ClassNotFoundException {
        Statement statement = null;
        Connection connection = getLoginDbConnection();
        statement = connection.createStatement();
        String sqlQuery = "update operation set operation_add_dtg ='"+timestamp+"' where operation_id ="+operationId+";";
        statement.execute(sqlQuery);
        statement.close();
        connection.close();
        return true;
    }

    public boolean deleteSubEntityByCode(String subEntityCode ) throws SQLException, ClassNotFoundException {
        Statement statement = null;
        Connection connection = getLoginDbConnection();
        statement = connection.createStatement();
        statement.execute("DELETE FROM sub_entity WHERE sub_entity_code='" + subEntityCode + "';");
        statement.close();
        connection.close();
        return true;
    }

    public boolean deleteEntityByCode(String entityCode ) throws SQLException, ClassNotFoundException {
        Statement statement = null;
        Connection connection = getLoginDbConnection();
        statement = connection.createStatement();
        statement.execute("DELETE FROM entity WHERE entity_code='" + entityCode + "';");
        statement.close();
        connection.close();
        return true;
    }

    public boolean deleteProgramByCode(String programCode) throws SQLException, ClassNotFoundException{
        Statement statement = null;
        Connection connection = getLoginDbConnection();
        statement = connection.createStatement();
        statement.execute("DELETE FROM program WHERE program_code='" + programCode + "';");
        statement.close();
        connection.close();
        return true;
    }

    public boolean deleteaccountHolderByCode(String accountHolderCode) throws SQLException, ClassNotFoundException{
        Statement statement = null;
        Connection connection = getLoginDbConnection();
        statement = connection.createStatement();
        statement.execute("DELETE FROM account_holder WHERE account_holder_code='" + accountHolderCode + "';");
        statement.close();
        connection.close();
        return true;
    }

    public boolean deleteaccountByCode(String accountCode) throws SQLException, ClassNotFoundException{
        Statement statement = null;
        Connection connection = getLoginDbConnection();
        statement = connection.createStatement();
        statement.execute("DELETE FROM account WHERE account_code='" + accountCode + "';");
        statement.close();
        connection.close();
        return true;
    }

    public void deleteOperationnById(Long operationId) throws SQLException, ClassNotFoundException{
        Statement statement = null;
        Connection connection = getLoginDbConnection();
        statement = connection.createStatement();
        statement.execute("DELETE FROM operation WHERE operation_id=" + operationId + ";");
        statement.execute("DELETE FROM movement WHERE operation_id=" + operationId + ";");
        statement.close();
        connection.close();
    }

    public Connection getLoginDbConnection() throws ClassNotFoundException, SQLException {
        Connection connection = null;
        String URL = "jdbc:postgresql://" + System.getProperty("accountDBHost") + ":" + System.getProperty("accountDBPort") + "/" + System.getProperty("accountDBName");
        connection = DriverManager.getConnection(URL, System.getProperty("accountDBUser") , System.getProperty("accountDBPass"));
        return connection;
    }


}
