package com.cybertek.tests.day09_properties_browser_utils;

import com.cybertek.utilities.ConfigurationReader;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadingProperties {

    @Test
    public void reading_from_properties_file() throws IOException {
        //#1- Create object of Properties class (coming from Java lib)
        Properties properties = new Properties();//creating object of Properties
        //#2- Open the file using FileInputStream
        //We are trying to open a file, so we need to pass the path.
        FileInputStream file = new FileInputStream("configuration.properties");//copy path from config.properties file

        //#3- load the properties object with our file
        properties.load(file);//loading

        //reading from configuration.properties
        System.out.println("properties.getProperty(\"browser\") = " + properties.getProperty("browser"));
        System.out.println("properties.getProperty(\"env\") = " + properties.getProperty("env"));
        System.out.println("properties.getProperty(\"env\") = " + properties.getProperty("username"));

    }

@Test
    public void using_properties_method(){
    ConfigurationReader.getProperty("browser");
    ConfigurationReader.getProperty("env");
}
}