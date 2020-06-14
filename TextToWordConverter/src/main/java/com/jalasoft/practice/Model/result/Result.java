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

package com.jalasoft.practice.Model.result;

import org.apache.poi.xwpf.usermodel.XWPFDocument;

/**
 * @author Rodrigo
 * @version 1.1
 */
public class Result extends XWPFDocument {
    private String text;

    public Result(String text) {
        this.text = text.trim();
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
