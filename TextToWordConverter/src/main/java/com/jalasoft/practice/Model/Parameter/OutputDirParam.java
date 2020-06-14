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

package com.jalasoft.practice.Model.Parameter;

import java.io.File;

/**
 * @author Rodrigo
 * @version 1.1
 */
public class OutputDirParam extends Parameter {
    String outputDir;
    String type;

    public OutputDirParam(File inputFile, String type, String outputDir) {
        super(inputFile);
        this.type = type;
        this.outputDir = outputDir;
    }

    public String getOutputDir() {
        return outputDir;
    }

    public void setOutputDir(String outputDir) {
        this.outputDir = outputDir;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
