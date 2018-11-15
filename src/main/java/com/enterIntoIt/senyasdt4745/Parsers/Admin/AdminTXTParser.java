package com.enterIntoIt.senyasdt4745.Parsers.Admin;

import java.io.*;

public class AdminTXTParser {

    BufferedReader in;

    {
        try {
            in = new BufferedReader(new InputStreamReader(new FileInputStream(
                        new File("AdminID.txt"))));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    static  String  admIdAsString;

    {
        try {
            admIdAsString = in.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static String [] admId;

    public static String [] parsAdmTxt () {
        return admId = admIdAsString.split(" ");
    }

}
