package com.marijmokoginta.excel_to_database;

import java.io.File;
import java.io.IOException;
import java.util.List;

import com.marijmokoginta.excel_to_database.reader.CSVReader;
import com.marijmokoginta.excel_to_database.utils.UserInput;

public class ImportExcelProjectApplication {

	private static List<String> data;
	private static String filePath;

	public static void main(String[] args) {
		UserInput input = new UserInput();

		while (true) {
			// String dbName = input.getString("Enter DB Name: ");
			filePath = input.getString("Enter file location: ");
			File file = new File(filePath);
			if (file.exists() && file.isFile())
				break;
			else
				System.out.println("File not found!");
		}

		
		try {
			data = CSVReader.readFileCSV(filePath);
			for (String dataString : data) {
				System.out.println(dataString);
			}
		} catch (IOException exception) {
			System.out.println(exception.getMessage());
		}
	}

}
