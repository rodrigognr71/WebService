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

import com.jalasoft.practice.Controller.configuration.PropertyHandler;
import com.jalasoft.practice.Model.exception.ParameterInvalidException;
import com.sun.media.sound.InvalidDataException;

import java.io.File;
import java.util.List;

/**
 * @author Rodrigo
 * @version 1.1
 */
public class ExtractTextParam extends Parameter{
    private String format;
    private List<String> FORMATS;

    public ExtractTextParam(File inputFile, String format) throws InvalidDataException {
        super(inputFile);
        this.format = format;
        this.FORMATS = PropertyHandler.getInstance().getValueAsList("server.extractor-text-extensions");
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }


    @Override
    public void validate() throws ParameterInvalidException {
        super.validate();
        if(this.format.trim().isEmpty()){
            throw new ParameterInvalidException();
        }

        if(!FORMATS.contains(format)){
            throw new ParameterInvalidException("format", format);
        }
    }
}
