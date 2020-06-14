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
import com.jalasoft.practice.Model.result.Result;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 * @author Rodrigo
 * @version 1.1
 */
public class ExtractorText implements IExtractor<ExtractTextParam>{
    XWPFDocument document = new XWPFDocument();

    @Override
    public Result extract(ExtractTextParam param) throws ParameterInvalidException, ExtractException {

        XWPFParagraph paragraph = document.createParagraph(); //create paragraph in the document
        XWPFRun run = paragraph.createRun(); //create run object in the paragraph

        param.validate();

        try {
            FileReader fileReader = new FileReader(param.getInputFile());
            BufferedReader bufferedReader = new BufferedReader(fileReader);

           String text;
            while ((text = bufferedReader.readLine()) != null){
                document.createParagraph();
                run.setText(text);//add text to paragraph
                run.addBreak();
            }
            Result result = new Result(run.toString());
            return result;
        } catch (Exception e) {
            throw new ExtractException(e);
        }
    }
}
