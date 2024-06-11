package com.marijmokoginta.excel_to_database.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/";
    private static final String DB_USERNAME = "root";
    private static final String DB_PASSWORD = "";

    public static Connection getConnection(String dbName) throws SQLException {
        String final_url = DB_URL + dbName;
        return DriverManager.getConnection(final_url, DB_USERNAME, DB_PASSWORD);
    }
    
}