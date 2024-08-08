package com.qacart.todo.utils;

import java.util.Properties;                       ///FOR RUN /mvn clean test -Denv=PRODUCTION (orlocal)



public class ConfigUtils { // role t9ra men Properties w trj3li eli 7jti bih
    private  Properties properties; // Properties trj3 Properties
    private static ConfigUtils configUtils;

    private ConfigUtils() {
        String env = System.getProperty("env", "PRODUCTION");
        switch (env) {
            case "PRODUCTION":
                properties = PropertiesUtils.loadProperties("src/test/java/com/qacart/todo/config/production.properties");
                break;
            case "LOCAL":
                properties = PropertiesUtils.loadProperties("src/test/java/com/qacart/todo/config/local.properties0++");
                break;
            default:
                throw new RuntimeException("Environment is not supported");
        }

    }

    public static ConfigUtils getInstance() {   // pour verifer es ce que ConfigUtils 3rfnga 9bel ou nn
        if(configUtils == null) {//mech m3rfinha
            configUtils = new ConfigUtils();// 3rfha sion
        }
        return configUtils;// sion rj3 configUtils
    }

    public String getBaseUrl() {
        String prop =  properties.getProperty("baseUrl");
        if(prop != null) return prop;// kna prop m wjouda donc rj3 prop
        throw new RuntimeException("Could not fine the base url in the property file");// lna mech mwjouda(sion rj3 could
 // mb3ed nmchi login pAGE NBDE get http en   driver.get(ConfigUtils.getInstance().getBaseUrl());
    }

    public String getEmail() {
        String prop =  properties.getProperty("email");
        if(prop != null) return prop;
        throw new RuntimeException("Could not fine the email in the property file");
    }

    public String getPassword() {
        String prop =  properties.getProperty("password");
        if(prop != null) return prop;
        throw new RuntimeException("Could not fine the password in the property file");
        // fel casde tes twli      .login(ConfigUtils.getInstance().getEmail(), ConfigUtils.getInstance().getPassword())
    }
}
