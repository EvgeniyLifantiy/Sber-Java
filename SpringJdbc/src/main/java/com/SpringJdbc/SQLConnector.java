package com.SpringJdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Component;
import javax.sql.DataSource;

@Component
public class SQLConnector {

    /*
    Connect class
     */
    private static final String URL="jdbc:mysql://localhost:3306/recipes_db";
    private static final String USERNAME="root";
    private static final String PASSWORD="123456789";

    @Bean
    public DataSource dataSource(){
        return new DriverManagerDataSource(URL,USERNAME,PASSWORD);
    }

    @Autowired
    @Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource){
        return new JdbcTemplate(dataSource);
    }
}
