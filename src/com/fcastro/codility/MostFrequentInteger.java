package com.fcastro.codility;

import java.util.Arrays;
import java.util.Map;

public class MostFrequentInteger {

    public static void main(String[] args) {
        System.out.println(mostFrequentIntegerSorted(new int[]{2, 4, 5, 1, 9, 4}));
        System.out.println(mostFrequentIntegerSorted(new int[]{76, 32, 9, 24, 5, 24, 89}));
        System.out.println(mostFrequentIntegerSorted(new int[]{1,5,3}));
        System.out.println(mostFrequentIntegerSorted(new int[]{}));
    }

    /*
    Given an unsorted list of integer, find the most repeated one and return it.
    [2, 4, 5, 1, 9, 4] -> 4
    [76, 32, 9, 24, 5, 24, 89] -> 24

    What to return when none is more frequent?
    what to return when input is empty?

    Solution based on Arrays.sort()
    Time complexity: O(n)
     */
    private static Integer mostFrequentIntegerSorted(int[] input){
        if (input==null || input.length==0){
            return null;
        }

        Arrays.sort(input);

        int countTempNum = 0, countMostFrequent = 0;
        int tempNum = input[0];
        Integer mostFrequentNum = null;

        for (int i = 0; i < input.length; i++) {

            if ( tempNum == input[i]){
                countTempNum++;

            }else {
                if (countMostFrequent < countTempNum){
                    countMostFrequent = countTempNum;
                    mostFrequentNum = tempNum;
                }

                tempNum = input[i];
                countTempNum = 1;
            }
        }
        return mostFrequentNum;
    }

    private static Integer mostFrequentIntegerUnsorted(int[] input){
        if (input == null || input.length == 0)
            return null;

        //Map<Integer, Integer>

        Integer mostFrequentNum = null;



        return mostFrequentNum;
    }


}
