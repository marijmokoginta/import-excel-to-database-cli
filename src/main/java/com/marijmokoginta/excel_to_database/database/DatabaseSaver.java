package com.marijmokoginta.excel_to_database.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class DatabaseSaver {
 
    public static void saveToDatabase(List<List<String>> data, String dbName, String tableName, String columnName) throws SQLException {
        Connection connection = DatabaseConnection.getConnection(dbName);
        String query = "INSERT INTO " + tableName + "(" + columnName + ")" + "VALUES (?)";
        PreparedStatement statement = connection.prepareStatement(query); 
    }
    
}