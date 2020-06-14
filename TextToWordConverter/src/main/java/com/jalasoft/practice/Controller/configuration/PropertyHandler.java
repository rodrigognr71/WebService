/*
 * Copyright (c) 2020 Jalasoft.
 *
 *  This software is the confidential and proprietary information of Jalasoft.
 *  ("Confidential Information"). You shall not disclose such Confidential
 *  Information and shall use it only in accordance with the terms of the
 *  license agreement you entered into with Jalasoft.
 *
 *
 */

package com.jalasoft.practice.Controller.configuration;

import com.sun.media.sound.InvalidDataException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

/**
 * @author Rodrigo
 * @version 1.1
 */
public class PropertyHandler {
    private static PropertyHandler propertyHandler;
    private static Properties properties;
    private final static String CONFIG_FILE = "configuration.properties";
    private final static String SEPARATOR = ",";
    private  PropertyHandler() throws InvalidDataException{

        try {
            properties = new Properties();
            properties.load(getClass().getClassLoader().getResourceAsStream(CONFIG_FILE));
        } catch (IOException e) {
            throw new InvalidDataException(e.getMessage());
        }
    }

    public static PropertyHandler getInstance() throws InvalidDataException {
        if (propertyHandler == null){
            propertyHandler = new PropertyHandler();
        }
        return propertyHandler;
    }
    public String getValueAsString (String key){
        return properties.getProperty(key);
    }

    public List<String> getValueAsList(String key){
        String value = this.getValueAsString(key);
        return new ArrayList<>(Arrays.asList(value.split(SEPARATOR)));
    }
}
