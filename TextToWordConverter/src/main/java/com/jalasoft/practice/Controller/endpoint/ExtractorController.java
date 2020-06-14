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

package com.jalasoft.practice.Controller.endpoint;

import com.jalasoft.practice.Controller.Request.RequestExtractParameter;
import com.jalasoft.practice.Controller.Response.ErrorResponse;
import com.jalasoft.practice.Controller.Response.OKResponse;
import com.jalasoft.practice.Controller.components.Properties;
import com.jalasoft.practice.Controller.exception.FileException;
import com.jalasoft.practice.Controller.service.FileService;
import com.jalasoft.practice.Model.GeneratePathFromFile;
import com.jalasoft.practice.Model.Parameter.OutputDirParam;
import com.jalasoft.practice.Model.exception.ExtractException;
import com.jalasoft.practice.Model.exception.ParameterInvalidException;
import com.jalasoft.practice.Model.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.File;

@RestController
@RequestMapping("/api/v1")
public class ExtractorController {

    @Autowired
    private Properties properties;

    @Autowired
    private FileService fileService;

    @PostMapping("/extractor")
    public ResponseEntity extract(RequestExtractParameter parameter) {

        try {
            File text = fileService.store(parameter.getFile(), parameter.getFormat());
            GeneratePathFromFile extractMetadataFromFile = new GeneratePathFromFile();
            Result result = extractMetadataFromFile.extract(new OutputDirParam(
                    text, parameter.getFormat(), properties.getPublicFolder()));
            String fileDownloadUri = fileService.getDownloadLink(new File(result.getText()));
            return ResponseEntity.ok().body(
                    new OKResponse(fileDownloadUri, Integer.toString(HttpServletResponse.SC_OK)));
        } catch (FileException e) {
            return ResponseEntity.badRequest().body(
                    new ErrorResponse(e.getMessage(), Integer.toString(HttpServletResponse.SC_BAD_REQUEST)));
        } catch (ExtractException e) {
            return ResponseEntity.badRequest().body(
                    new ErrorResponse(e.getMessage(), Integer.toString(HttpServletResponse.SC_BAD_REQUEST)));
        } catch (ParameterInvalidException e) {
            return ResponseEntity.badRequest().body(
                    new ErrorResponse(e.getMessage(), Integer.toString(HttpServletResponse.SC_BAD_REQUEST)));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(
                    new ErrorResponse(e.getMessage(), Integer.toString(HttpServletResponse.SC_BAD_REQUEST)));
        }
    }
}
