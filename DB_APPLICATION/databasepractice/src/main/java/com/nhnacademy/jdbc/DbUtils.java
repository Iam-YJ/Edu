package com.nhnacademy.jdbc;

import org.apache.commons.dbcp2.BasicDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbUtils {
    private static final BasicDataSource DATASOURCE;

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection("jdbc:mysql://133.186.211.156:3306/nhn_academy_12",
                    "nhn_academy_12",
                    "jcR59.XEQFn[ES6o");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static DataSource getDataSource() {
        return DATASOURCE;
    }

    static {
        BasicDataSource basicDataSource = new BasicDataSource();
        basicDataSource.setUrl("jdbc:mysql://133.186.211.156:3306/nhn_academy_12");
        basicDataSource.setUsername("nhn_academy_12");
        basicDataSource.setPassword("jcR59.XEQFn[ES6o");
        basicDataSource.setInitialSize(10);
        basicDataSource.setMaxTotal(10);

        DATASOURCE = basicDataSource;
    }
}
