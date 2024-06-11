package com.marijmokoginta.excel_to_database.database;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DatabaseConnection {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/";
    private static final String DB_USERNAME = "root";
    private static final String DB_PASSWORD = "";

    public static Connection getConnection(String dbName) throws SQLException {
        String final_url = DB_URL + dbName;
        return DriverManager.getConnection(final_url, DB_USERNAME, DB_PASSWORD);
    }

    public static boolean isTableExist(String dbName, String tableName) throws SQLException {
        Connection conn = getConnection(dbName);
        DatabaseMetaData metaData = conn.getMetaData();
        ResultSet set = metaData.getTables(null, null, tableName, null);
        return set.next();
    }
    
}