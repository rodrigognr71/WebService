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

package com.jalasoft.practice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Rodrigo
 * @version 1.1
 */
@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello!!!");
        SpringApplication.run(Main.class, args);
    }
}
