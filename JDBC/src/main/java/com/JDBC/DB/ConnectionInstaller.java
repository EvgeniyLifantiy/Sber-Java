package com.JDBC.DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionInstaller {

    void Connect(String link, String login, String password)  {
        try {
            Connection connection=DriverManager.getConnection(link,login,password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
