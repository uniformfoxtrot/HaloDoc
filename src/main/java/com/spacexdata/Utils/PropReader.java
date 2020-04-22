package com.spacexdata.Utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropReader {
    static String basePath = System.getProperty("user.dir");
    static String inputFileName = "//Users//lee//Documents//HaloDocInterview//src//main//resources//Static//testInput.properties";
    static FileInputStream fis;
    static Properties prop = new Properties();

    public static String getValue(String key) {
        try {
            fis= new FileInputStream(inputFileName);
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        try {
            prop.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String value = prop.getProperty("key");
        return value;
    }
}
