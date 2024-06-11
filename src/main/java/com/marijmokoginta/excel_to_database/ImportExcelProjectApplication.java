package com.marijmokoginta.excel_to_database;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.marijmokoginta.excel_to_database.database.DatabaseConnection;
import com.marijmokoginta.excel_to_database.database.DatabaseSaver;
import com.marijmokoginta.excel_to_database.reader.CSVReader;
import com.marijmokoginta.excel_to_database.utils.ColorText;
import com.marijmokoginta.excel_to_database.utils.UserInput;

public class ImportExcelProjectApplication {

	private static List<String> data;

	public static void main(String[] args) {
		UserInput input = new UserInput();

		String dbName;
		while (true) {
			dbName = input.getString("Enter DB Name: ");
			System.out.println("Membuat koneksi ke database...");
			Connection conn = null;
			try {
				conn = DatabaseConnection.getConnection(dbName);
				if (conn == null)
					System.err.println("Koneksi ke database gagal!");
				else {
					System.out.println(ColorText.ANSI_GREEN + "Koneksi ke database berhasil!" + ColorText.ANSI_RESET);
					break;
				}
			} catch (SQLException exception) {
				System.err.println("Terjadi sql exception");
				System.err.println(exception.getMessage());
			} finally {
				if (conn != null) {
					try {
						conn.close();
					} catch (SQLException exception2) {
						System.err.println(exception2.getMessage());
					}
				}
				
			}
		}

		String tableName = input.getString("Enter database table name: ");
		String columnName = input.getString("Enter database column name: ");

		String filePath;
		while (true) {
			filePath = input.getString("Enter file location: ");
			File file = new File(filePath);
			if (file.exists() && file.isFile())
				System.out.println(ColorText.ANSI_GREEN + "File ditemukan!" + ColorText.ANSI_RESET);
			else
				System.err.println("File not found!");

			try {
				data = CSVReader.readFileCSV(filePath, true, ";");
				if (data.size() > 0) {
					System.out.println(ColorText.ANSI_GREEN + data.size() + " data berhasil dibaca!" + ColorText.ANSI_RESET);
					break;
				} else
					System.out.println(data.size() + "data!");
			} catch (IOException exception) {
				System.err.println(exception.getMessage());
			}
		}

		System.out.println("Mencoba untuk menyimpan data ke database...");
		try {
			DatabaseSaver.saveToDatabase(data, dbName, tableName, columnName);
			System.out.println(ColorText.ANSI_GREEN + "Berhasil menyimpan data ke database!" + ColorText.ANSI_RESET);
		} catch (SQLException exception) {
			System.err.println(exception.getMessage());
		}
	}

}
