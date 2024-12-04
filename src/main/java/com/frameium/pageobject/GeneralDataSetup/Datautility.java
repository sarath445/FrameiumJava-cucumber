package com.frameium.pageobject.GeneralDataSetup;

import com.frameium.genericfunctions.GenericFunctions;
import org.openqa.selenium.WebDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.security.Key;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class Datautility extends GenericFunctions {
    private GenericFunctions genericFunctions;
    private WebDriver driver;
    private static Properties properties;

    public static Properties loadproperties(String filepath)throws  IOException{
        properties = new Properties();
        FileInputStream fis = new FileInputStream(filepath);
        properties.load(fis);
        return properties;
    }

    public static String getPropertyvalue(String key){
        return properties.getProperty(key, "properties not found");
    }





    public static Map<String, String> loadTestData(String filepath)throws IOException{
        Properties testdataproperties = new Properties();
        //opens the file specified by filepath to read its content.
        //Loads the key-value pairs from the file into the Properties object.
        FileInputStream fis = new FileInputStream(filepath);
        testdataproperties.load(fis);
        Map<String,String> dataMap = new HashMap<>();
        //Returns all keys in the properties object as a set of strings.
        //Retrieves the value corresponding to the key.
        for(String Key : testdataproperties.stringPropertyNames()){
            dataMap.put(Key, testdataproperties.getProperty(Key));
        }
        return dataMap;
    }

    public static String getTestData(String key, Map<String,String> testdata){
        return testdata.getOrDefault(key, "Data not found");
    }
}
