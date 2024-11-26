package com.frameium.pageobject.GeneralDataSetup;

import org.openqa.selenium.WebDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.security.Key;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class Datautility {
    private WebDriver driver;

    public static Map<String, String> loadTestData(String filepath)throws IOException{
        Properties properties = new Properties();
        //opens the file specified by filepath ro read its content.
        //Loads the key-value pairs from the file into the Properties object.
        FileInputStream fis = new FileInputStream(filepath);
        properties.load(fis);
        Map<String,String> dataMap = new HashMap<>();
        //Returns all keys in the properties object as a set of strings.
        //Retrieves the value corresponding to the key.
        for(String Key : properties.stringPropertyNames()){
            dataMap.put(Key, properties.getProperty(Key));
        }
        return dataMap;
    }

    public static String getTestData(String key, Map<String,String> testdata){
        return testdata.getOrDefault(key, "Data not found");
    }
}
