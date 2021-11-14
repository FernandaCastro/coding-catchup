package com.fcastro.algorithm;

import java.util.HashSet;
import java.util.Set;

//Given an array [2,5,1,2,3,5,1,2,4] returns 2
//Given an array [2,1,1,2,3,4,1,2,4] returns 1
//Given an array [2,3,4,5] returns -1
public class FirstRecurringCharacter {

    public static void main(String[] args) {
        FirstRecurringCharacter o = new FirstRecurringCharacter();
        System.out.println("Best - Expected 2: " + o.FirstRecurringCharacter(new int[]{2,5,1,2,3,5,1,2,4}));
        System.out.println("Best - Expected 1: " + o.FirstRecurringCharacter(new int[]{2,1,1,2,3,4,1,2,4}));
        System.out.println("Best - Expected -1: " + o.FirstRecurringCharacter(new int[]{2,3,4,5}));

        //In this scenario  {2,5,5,2,3,5,1,2,4} it should return 5 instead of 2
        System.out.println("Best - Expected 5: " + o.FirstRecurringCharacter(new int[]{2,5,5,2,3,5,1,2,4}));
        System.out.println("Naive - Expected 2: " + o.FirstRecurringCharacterNaiveScenario1(new int[]{2,5,5,2,3,5,1,2,4}));
        System.out.println("Naive - Expected 5: " + o.FirstRecurringCharacterNaiveScenario2(new int[]{2,5,5,2,3,5,1,2,4}));
    }

    //Best solution
    //Iterate the array
    //try to get the array item from the HashMap, otherwise add it to the HashMap
    //return the first array item found in the HashMap
    //Time and Memory complexity: O(n)
    int FirstRecurringCharacter(int[] array){
        Set<Integer> set = new HashSet<>();
        for(int i=0; i<array.length; i++){
            if (set.contains(array[i]))
                return array[i];

            set.add(array[i]);
        }
        return -1;
    }

    //Naive solution - Scenario 1
    //Loop through nested loops, comparing idx with idx+1
    //Time complexity: O(nˆ2)  Memory complexity: O(1)
    //Scenario1: It should return 2 when given {2,5,5,2,3,5,1,2,4}
    int FirstRecurringCharacterNaiveScenario1(int[] array){
        for(int i=0; i<array.length; i++){
            for(int j=i+1; j< array.length; j++){
                if(array[i] == array[j])
                    return array[i];
            }
        }
        return -1;
    }

    //Naive solution - Scenario 2
    //Loop through nested loops, comparing idx with idx+1
    //Time complexity: O(nˆ2)  Memory complexity: O(1)
    //Scenario2: It should return 5 when given {2,5,5,2,3,5,1,2,4}
    int FirstRecurringCharacterNaiveScenario2(int[] array){
        for(int i = 0; i < array.length; i++){
            for(int j = i + 1; j < array.length; j++){
                if(array[i] == array[j])
                    return array[i];
                if (array[j] == array[(j+1)])
                    return array[j];
            }
        }
        return -1;
    }

}
