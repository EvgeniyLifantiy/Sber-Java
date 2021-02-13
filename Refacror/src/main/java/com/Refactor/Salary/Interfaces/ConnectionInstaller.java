package com.Refactor.Salary.Interfaces;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface ConnectionInstaller {
     ResultSet establishConnection() throws SQLException;
}
