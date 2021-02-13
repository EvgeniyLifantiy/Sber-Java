package com.Refactor.Salary;

import com.Refactor.Salary.Interfaces.ConnectionInstaller;

import java.sql.*;
import java.time.LocalDate;

public class MySqlConnectionInstaller implements ConnectionInstaller {

    Connection connection;
    String departmentId;
    LocalDate dateFrom;
    LocalDate dateTo;

    public MySqlConnectionInstaller(Connection connection, String departmentId, LocalDate dateFrom, LocalDate dateTo) {
        this.connection = connection;
        this.departmentId = departmentId;
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
    }

    @Override
    public ResultSet establishConnection() throws SQLException
    {
        // prepare statement with sql
        PreparedStatement ps = connection.prepareStatement("select emp.id as emp_id, emp.name as amp_name, sum(salary) as salary from employee emp left join" +
                "salary_payments sp on emp.id = sp.employee_id where emp.department_id = ? and" +
                " sp.date >= ? and sp.date <= ? group by emp.id, emp.name");
        // inject parameters to sql
        ps.setString(0, departmentId);
        ps.setDate(1, new Date(dateFrom.toEpochDay()));
        ps.setDate(2, new Date(dateTo.toEpochDay()));
        // execute query and get the results
        return ps.executeQuery();

    }

}
