package com.marijmokoginta.excel_to_database.utils;

import java.util.Scanner;

public class UserInput {
 
    private Scanner scanner;

    public UserInput() {
        scanner = new Scanner(System.in);
    }

    public String getString(String promt) {
        System.out.print(promt);
        return scanner.nextLine();
    }

    public int getInt(int promt) {
        System.out.print(promt);
        return scanner.nextInt();
    }
    
}