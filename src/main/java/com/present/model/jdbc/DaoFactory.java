package com.present.model.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by Yuliia Tesliuk on 11/14/2018
 */
public class DaoFactory {

    private static DaoFactory daoFactory;

    public static DaoFactory getInstance() {
        if (daoFactory == null) {
            synchronized (DaoFactory.class) {
                if (daoFactory == null) {
                    DaoFactory temp = new DaoFactory();
                    daoFactory = temp;
                }
            }
        }
        return daoFactory;
    }

    public SweetyDAO createSweetyDAO() {
        return new SweetyDAO(getConnection());
    }

    private Connection getConnection() {
        try {
            return DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/christmas_presents?useSSL=false&characterEncoding=UTF-8",
                    "root",
                    "3363611444");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
