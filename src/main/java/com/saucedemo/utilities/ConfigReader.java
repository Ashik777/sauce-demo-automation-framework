package com.saucedemo.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    private static Properties prop;
    static{
        try
        {
            FileInputStream input= new FileInputStream("src/test/resources/config.properties");
            prop=new Properties();
            prop.load(input);

        } catch (IOException e) {
            e.printStackTrace();

        }
    }
    public static String getProperty(String key)
    {
        return prop.getProperty(key);
    }
}
