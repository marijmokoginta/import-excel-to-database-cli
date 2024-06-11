package com.marijmokoginta.excel_to_database.reader;

import java.util.List;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class CSVReader {

    private static List<String> data;

    public static List<String> readFileCSV(String filePath, boolean clearEntry, String separate) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader(filePath));

        data = new ArrayList<>();
        String line;
        while ((line = in.readLine()) != null) {
            String clearData = line;
            if (clearEntry) {
                String[] lineData = line.split(separate);
                if (lineData[1].charAt(0) == ' ')
                    clearData = lineData[1].substring(1);
                else
                    clearData = lineData[1];
            }
            data.add(clearData);
        }
        in.close();
        return data;
    }
    
}