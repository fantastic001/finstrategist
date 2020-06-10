package com.stefan.main;

public class Configuration {

    private Configuration() {

    }

    private static Configuration instance = null;

    public static Configuration getInstance() {
        if (instance == null) {
            instance = new Configuration();
        }
        return instance;
    }

    public void setProperty(String name, Object value) {

    }

    public Object getProperty(String name, Object defaultValue) {
        return null;
    }
}