package com.JDBC.DB;

import com.JDBC.Api.ConnectionInstaller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class DefaultLoader {
    private List<Integer> list = load();

    ConnectionInstaller connectionInstaller;

    public DefaultLoader(ConnectionInstaller connectionInstaller) {
        this.connectionInstaller = connectionInstaller;
    }

    public List<Integer> load()  {

        Statement statement;
        String query = "select * from Fibonacci";
        try {
            statement = connectionInstaller.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                list.add(resultSet.getInt("Result"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
