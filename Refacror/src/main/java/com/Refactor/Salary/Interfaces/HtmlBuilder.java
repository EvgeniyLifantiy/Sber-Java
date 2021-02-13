package com.Refactor.Salary.Interfaces;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface HtmlBuilder {
      StringBuilder buildReport(ResultSet results) throws SQLException;
}
