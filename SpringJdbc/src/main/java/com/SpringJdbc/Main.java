package com.SpringJdbc;

import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.sql.*;

class Main {
    public static void main(String args[]){
        try{
            Driver driver = new FabricMySQLDriver();
            DriverManager.registerDriver(driver);
            Connection con=DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/recipesdb?autoReconnect=true&useSSL=false","root","123456789");
//here sonoo is database name, root is username and password  
            Statement stmt=con.createStatement();
            ResultSet rs=stmt.executeQuery("select * from recipes");
            while(rs.next())
                System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));
            con.close();
        }catch(SQLException  e){ System.out.println(e);}
    }
}  