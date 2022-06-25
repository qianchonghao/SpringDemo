package com.example.springdemo.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesUtils {
    public static Properties getSpringFactories(){
        InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream("META-INF/spring.factories");
        Properties props = new Properties();
        try {
            props.load(is);
        } catch (IOException e) {
            System.out.println("props load failed");
        }
        System.out.println("PropsUtils: "+ props.getProperty("org.springframework.boot.SpringApplicationRunListener"));
        return props;
    }
}
