package com.JDBC.Api;

import java.sql.Connection;

public interface ConnectionInstaller {
    void Connect(String link, String login, String password);
     Connection getConnection();
}
