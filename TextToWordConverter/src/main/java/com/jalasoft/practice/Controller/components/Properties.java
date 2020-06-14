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

package com.jalasoft.practice.Controller.components;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author Rodrigo
 * @version 1.1
 */
@Component
@ConfigurationProperties(prefix = "extractor")
public class Properties {
    String inputFolder;
    String publicFolder;

    public String getInputFolder() {
        return inputFolder;
    }

    public void setInputFolder(String inputFolder) {
        this.inputFolder = inputFolder;
    }

    public String getPublicFolder() {
        return publicFolder;
    }

    public void setPublicFolder(String publicFolder) {
        this.publicFolder = publicFolder;
    }
}
