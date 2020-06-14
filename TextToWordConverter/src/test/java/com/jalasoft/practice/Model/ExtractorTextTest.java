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

package com.jalasoft.practice.Model;

import com.jalasoft.practice.Model.Parameter.ExtractTextParam;
import com.jalasoft.practice.Model.exception.ExtractException;
import com.jalasoft.practice.Model.exception.ParameterInvalidException;
import com.sun.media.sound.InvalidDataException;
import org.junit.Test;

import java.io.File;

import static org.junit.Assert.assertEquals;

public class ExtractorTextTest {


    private final static String PATH = "src/test/resources/extractText/";

    @Test
    public void extractTextFromTxtFile() throws ParameterInvalidException, ExtractException, InvalidDataException {
        ExtractTextParam extractTextParam = new ExtractTextParam(new File(PATH + "Hello.txt"),
                "docx");
        ExtractorText extractorText = new ExtractorText();
        assertEquals("Hello World", extractorText.extract(extractTextParam).getText());
    }
}