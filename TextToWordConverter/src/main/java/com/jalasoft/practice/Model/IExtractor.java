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

import com.jalasoft.practice.Model.Parameter.Parameter;
import com.jalasoft.practice.Model.exception.ExtractException;
import com.jalasoft.practice.Model.exception.ParameterInvalidException;
import com.jalasoft.practice.Model.result.Result;

/**
 * @author Rodrigo
 * @version 1.1
 */
public interface IExtractor<T extends Parameter> {
    Result extract(T param) throws ParameterInvalidException, ExtractException;

}
