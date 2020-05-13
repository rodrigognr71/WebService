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

package com.jalasoft.practice3;

import java.util.ArrayList;
import java.util.List;

public class ListLandTransport {
    private List<Land> landList = new ArrayList<>();

    public void addLand(Land land){
        landList.add(land);
    }
    public void display(){
        //String[] strings = landList.stream().toArra(size -> new String[size]);
        //String[] strings = landList.toArray(new String[landList.size()]);
        //Land strings = landList.get(0);
        landList.stream().forEach(data ->System.out.println(data));
    }
}
