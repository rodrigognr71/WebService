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

package com.jalasoft.practice.Controller.Request;

import org.springframework.web.multipart.MultipartFile;

/**
 * @author Rodrigo
 * @version 1.1
 */
public class RequestExtractParameter {
    private String format;
    private MultipartFile file;

    public RequestExtractParameter(String format, MultipartFile file) {
        this.format = format;
        this.file = file;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }
}
