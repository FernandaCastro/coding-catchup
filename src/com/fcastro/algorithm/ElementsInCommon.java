package com.fcastro.algorithm;

import java.util.Arrays;
import java.util.HashSet;

public class ElementsInCommon {
    public static void main(String[] args) {
        String[] array1 = new String[]{"a", "b", "c", "x"};
        String[] array2 = new String[]{"i", "y", "x"};

        ElementsInCommon obj = new ElementsInCommon();
        System.out.println(obj.findElementInCommon2(array1, array2));
    }

    //Thinking out loud
    //array1[a, b, c, d] array2[i, y, e, o] returns false
    //array1[a, b, c, x] array2[i, y, e, x] returns true
    //input type? Same size? ordered?
    //Can we assume we will always receive 2 inputs?
    //How big are the inputs?
    //What's the goal here? Time efficiency or Space efficiency?

    //Brutal force/Naive solution: It would be ok if inputs are small or fixed
    //O(nˆ2) (N square)  when 2 arrays are the same size
    //o(a*b) (a times b) when 2 arrays are different size

    //inputs - arrays - no size limit
    //O(a + b) (a plus b) It is better for Time complexity

    //Brutal Force - Naive solution
    boolean findElementInCommon1(String[] array1, String[] array2){
        for(int i=0; i<array1.length; i++){
            for(int j=0; j<array2.length; j++){
                if(array1[i].equals(array2[j]))
                    return true;
            }
        }
        return false;
    }

    //Better solution
    boolean findElementInCommon2(String[] array1, String[] array2){
        //Insert all elements from array1 to a set
        HashSet<String> map = new HashSet<>();
        map.addAll(Arrays.asList(array1));

        //Iterate through array2 and check if it exists in the set
        for(int i=0; i<array2.length; i++){
            if(map.contains(array2[i]))
                return true;
        }
        return false;
    }

}
