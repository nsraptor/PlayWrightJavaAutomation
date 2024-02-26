package com.test.roku.utils;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

public class ConfigUtils {
    static Properties prop = new Properties();

    /**************************************************************************************************
     Function to load properties files based on machine OS
     **************************************************************************************************/
    public static void loadProperties() {
        try {
            String os = System.getProperty("os.name").toLowerCase();
            String confPath, contactUsPath, urlPath;

            if (os.startsWith("win")) {
                confPath = "\\src\\test\\resources\\config.properties";
                contactUsPath = "\\src\\test\\resources\\contactus.properties";
                urlPath = "\\src\\test\\resources\\url.properties";
            } else {
                confPath = "/src/test/resources/config.properties";
                contactUsPath = "/src/test/resources/contactus.properties";
                urlPath = "/src/test/resources/url.properties";
            }
            prop.load(Files.newInputStream(Paths.get(System.getProperty("user.dir") + File.separator + confPath)));
            prop.load(Files.newInputStream(Paths.get(System.getProperty("user.dir") + File.separator + contactUsPath)));
            prop.load(Files.newInputStream(Paths.get(System.getProperty("user.dir") + File.separator + urlPath)));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static String getPropertyByKey(String key) {
        return prop.getProperty(key);
    }
}
