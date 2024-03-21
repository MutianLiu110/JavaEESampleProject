package com.example.javaeesampleproject.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestConnection {
    private String jdbcURL = "jdbc:mysql://localhost:3306/coursework?useSSL=false";
    private String jdbcUsername = "root";
    private String jdbcPassword = "601456";

    public Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (SQLException | ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return connection;
    }

    public static void main (String[] args){
        TestConnection connection = new TestConnection();
        if (connection.getConnection() != null) {
            System.out.println("Okay");
        } else {
            System.out.println("Fail");
        }
    }
}
