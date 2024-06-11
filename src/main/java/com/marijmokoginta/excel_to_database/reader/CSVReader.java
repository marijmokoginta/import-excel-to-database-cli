package com.marijmokoginta.excel_to_database.reader;

import java.util.List;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class CSVReader {

    private static List<String> data;

    public static List<String> readFileCSV(String filePath) throws IOException {
        // BufferedReader in = new BufferedReader(new FileReader(filePath))

        data = new ArrayList<>();
        // String line;
        // while ((line = in.readLine()) !== null) {
        //     data.add(line);
        // }
        return data;
    }
    
}