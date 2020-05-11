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
import com.jalasoft.practice.Practice;

public class Main {
    public static void main(String[] args){

        Practice practice = new Practice();
        System.out.println("This is the filters using foreach");
        practice.practiceWithForeach();
        System.out.println("------------------------------------");
        System.out.println("Countries that Begins with A:");
        practice.printCountriesThatBeginsWithA();
        System.out.println("Countries that have more than five characters:");
        practice.printCountriesMoreThanFiveCharacters();
        System.out.println("Countries that the sum of characters is pair:");
        practice.printCountriesThatSumOfCharactersIsPair();

    }
}
