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

package com.jalasoft.practice.Controller.service;

import com.jalasoft.practice.Controller.components.Properties;
import com.jalasoft.practice.Controller.exception.FileException;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

/**
 * @author Rodrigo
 * @version 1.1
 */
@Service
public class FileService {
    @Autowired
    private Properties properties;

    public File store(MultipartFile file, String format) throws FileException {
        String fileInput;
        String folderPath = properties.getInputFolder();
        fileInput = folderPath + file.getOriginalFilename();
        if (format.trim().isEmpty()) {
            throw new FileException("Format error");
        }

        if(!"txt".equals(FilenameUtils.getExtension(fileInput))){
            throw new FileException("Invalid file extension");
        }

        try {
        Files.createDirectories(Paths.get(folderPath));
        Path path = Paths.get(fileInput);
        Files.copy(file.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
        return new File(fileInput);
        } catch (IOException e) {
            throw new FileException("File error", e);
        }
    }

    public String getDownloadLink(File file){
        return ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/api/v1/download/")
                .path(file.getName())
                .toUriString();
    }
}
