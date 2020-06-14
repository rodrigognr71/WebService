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
import com.jalasoft.practice.Model.Parameter.OutputDirParam;
import com.jalasoft.practice.Model.exception.ExtractException;
import com.jalasoft.practice.Model.exception.ParameterInvalidException;
import com.jalasoft.practice.Model.result.Result;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author Rodrigo
 * @version 1.1
 */
public class GeneratePathFromFile implements IExtractor<OutputDirParam> {

    @Override
    public Result extract(OutputDirParam outputDirParam) throws ParameterInvalidException, ExtractException {
        outputDirParam.validate();

        try {
            ExtractTextParam extractTextParam = new ExtractTextParam(outputDirParam.getInputFile(),
                    outputDirParam.getType());
            extractTextParam.validate();
            ExtractorText extractorText = new ExtractorText();
            String outputFile = outputDirParam.getOutputDir() + outputDirParam.getInputFile()
                    .getName() + "." + outputDirParam.getType();
            FileOutputStream out = new FileOutputStream(outputFile);
            extractorText.extract(extractTextParam);
            extractorText.document.write(out);
            return new Result(outputFile);
        } catch (IOException e) {
            throw new ExtractException(e);
        }
    }
}
