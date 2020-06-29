package com.stefan.main;

import java.util.HashMap;

public class Configuration {

    private Configuration() {
        kv = new HashMap<>();
    }

    private HashMap<String, Object> kv; 

    private static Configuration instance = null;

    public static Configuration getInstance() {
        if (instance == null) {
            instance = new Configuration();
        }
        return instance;
    }

    public void setProperty(String name, Object value) {
        kv.put(name, value);
    }

    public Object getProperty(String name, Object defaultValue) {
        return kv.getOrDefault(name, defaultValue);
    }
}