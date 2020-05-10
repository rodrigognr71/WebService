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

import java.util.ArrayList;
import java.util.List;

public class Practice {

    private List<String> countryList = new ArrayList();

    private void addCountries(){
        countryList.add("Bolivia");
        countryList.add("Argentina");
        countryList.add("Argelia");
        countryList.add("Portugal");
        countryList.add("Italia");
        countryList.add("Australia");
    }

    public void practiceWithForeach(){
        addCountries();
        System.out.println();
        System.out.println("Filer by Countries that Begins with A:");

        for (String list: countryList) {
            if(list.charAt(0)=='A'){
                System.out.println(list);
            }
        }

        System.out.println();
        System.out.println("Filer by Countries that have more than five characters:");
        for (String list: countryList) {
            if(list.length() > 5){
                System.out.println(list);
            }
        }

        System.out.println();
        System.out.println("Filer by Countries that the sum of characters is pair:");
        for (String list: countryList) {
            if(list.length() % 2 == 0){
                System.out.println(list);
            }
        }

    }

    public void printCountriesThatBeginsWithA(){

        countryList.stream().filter(country -> country.charAt(0)=='A')
                .forEach(country ->System.out.println(country));
        System.out.println("-----------------------------");
    }

    public void printCountriesMoreThanFiveCharacters(){
        countryList.stream().filter(country -> country.length() > 5)
                .forEach(country ->System.out.println(country));
        System.out.println("-----------------------------");
    }

    public void printCountriesThatSumOfCharactersIsPair(){
        countryList.stream().filter(country -> country.length() % 2 == 0)
                .forEach(country ->System.out.println(country));
        System.out.println("-----------------------------");
    }
}
