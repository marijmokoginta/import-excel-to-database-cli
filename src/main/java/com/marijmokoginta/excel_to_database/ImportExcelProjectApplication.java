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
					System.err.println(ColorText.ANSI_RED + "Koneksi ke database gagal!" + ColorText.ANSI_RESET);
				else {
					System.out.println(ColorText.ANSI_GREEN + "Koneksi ke database berhasil!" + ColorText.ANSI_RESET);
					break;
				}
			} catch (SQLException exception) {
				System.err.println(ColorText.ANSI_RED + "Terjadi sql exception" + ColorText.ANSI_RESET);
				System.err.println(ColorText.ANSI_RED + exception.getMessage() + ColorText.ANSI_RESET);
			} finally {
				if (conn != null) {
					try {
						conn.close();
					} catch (SQLException exception2) {
						System.err.println(ColorText.ANSI_RED + exception2.getMessage() + ColorText.ANSI_RESET);
					}
				}
				
			}
		}

		String tableName;
		while (true) {
			tableName = input.getString("Enter database table name: ");
			try {
				if (DatabaseConnection.isTableExist(dbName, tableName)) {
					System.out.println(ColorText.ANSI_GREEN + "Tabel ditemukan!" + ColorText.ANSI_RESET);
					break;
				} else {
					System.err.println(ColorText.ANSI_RED + "Tabel " + tableName + " tidak ditemukan!" + ColorText.ANSI_RESET);
				}
			} catch (SQLException exception) {
				System.err.println(ColorText.ANSI_RED + exception.getMessage() + ColorText.ANSI_RESET);
			}
		}
		String columnName = input.getString("Enter database column name: ");

		String filePath;
		while (true) {
			filePath = input.getString("Enter file location: ");
			File file = new File(filePath);
			if (file.exists() && file.isFile())
				System.out.println(ColorText.ANSI_GREEN + "File ditemukan!" + ColorText.ANSI_RESET);
			else
				System.err.println(ColorText.ANSI_RED + "File not found!" + ColorText.ANSI_RESET);

			try {
				data = CSVReader.readFileCSV(filePath, true, ";");
				if (data.size() > 0) {
					System.out.println(ColorText.ANSI_GREEN + data.size() + " data berhasil dibaca!" + ColorText.ANSI_RESET);
					break;
				} else
					System.out.println(data.size() + "data!");
			} catch (IOException exception) {
				System.err.println(ColorText.ANSI_RED + exception.getMessage() + ColorText.ANSI_RESET);
			}
		}

		System.out.println("Mencoba untuk menyimpan data ke database...");
		try {
			DatabaseSaver.saveToDatabase(data, dbName, tableName, columnName);
			System.out.println(ColorText.ANSI_GREEN + "Berhasil menyimpan data ke database!" + ColorText.ANSI_RESET);
		} catch (SQLException exception) {
			System.err.println(ColorText.ANSI_RED + exception.getMessage() + ColorText.ANSI_RESET);
		}
		System.exit(0);
	}

}
