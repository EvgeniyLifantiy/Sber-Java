package com.JDBC.DB;

import com.JDBC.Api.ConnectionInstaller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DefaultConnectionInstaller implements ConnectionInstaller {

    Connection connection;

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public void Connect(String link, String login, String password)  {
        try {
            connection=DriverManager.getConnection(link,login,password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
