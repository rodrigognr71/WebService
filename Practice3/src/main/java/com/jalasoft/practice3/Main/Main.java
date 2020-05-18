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

package com.jalasoft.practice3.Main;

import com.jalasoft.practice3.Bicycle;
import com.jalasoft.practice3.Car;
import com.jalasoft.practice3.ListLandTransport;

public class Main {

    public static void main(String [] args){
        ListLandTransport listLandTransport = new ListLandTransport();
        listLandTransport.addLand(new Bicycle("Cross", 500, false, false ));
        listLandTransport.addLand(new Car("Toyota", 10000, true, true));
        listLandTransport.display();
    }
}
