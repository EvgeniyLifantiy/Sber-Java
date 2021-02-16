package com.JDBC.DB;

import com.JDBC.Api.ConnectionInstaller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DefaultSaver {


    ConnectionInstaller connectionInstaller;

    public DefaultSaver(ConnectionInstaller connectionInstaller) {
        this.connectionInstaller = connectionInstaller;
    }

    public boolean save(List<Integer> list) {

        try(Statement statement = connectionInstaller.getConnection().createStatement()) {



            int getInt = 0;
            try {
                ResultSet resultSet = statement.executeQuery("SELECT * FROM Fibonacci");
                while (resultSet.next())
                {
                    getInt = resultSet.getInt("int");
                }}
            catch (SQLException e){
                e.printStackTrace();
            }



            for (int i = ++getInt; i <list.size() ; i++) {

                // add all values
                PreparedStatement preparedStatement = connectionInstaller.getConnection().prepareStatement("INSERT INTO Fibonacci values (?,?)");
                preparedStatement.setInt(1,i);
                preparedStatement.setInt(2, list.get(i));
                preparedStatement.execute();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
