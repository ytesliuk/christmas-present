package com.present.model.jdbc;

import java.sql.*;

/**
 * Created by Yuliia Tesliuk on 11/05/2018
 */
public class DBConnection {
    private static String URL = "jdbc:mysql://localhost:3306/christmas_presents?useSSL=false&characterEncoding=UTF-8";
    private static String USER = "root";
    private static String PASSWORD = "3363611444";
    private Connection connection;


    public DBConnection(){
        try {
            connection = DriverManager.getConnection(URL,USER,PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection(){
        return connection;
    }

    public boolean isConnected(){
        return connection != null;
    }

}
