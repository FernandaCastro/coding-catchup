package com.fcastro.algorithm;

import java.util.ArrayList;
import java.util.List;

//Given a number N return the index value of the Fibonacci sequence,
//where the sequence is: 0, 1, 1, 2, 3, 5, 8, 13, 21, 24, 55, 89, 144...
//                       0  1  2  3  4  5  6   7   8   9  10  11   12
public class RecursionFibonacci {

    public static int recursiveFibonacci(int index){
        return recursiveFibonacci(index, new ArrayList(List.of(0,1)));
    }

    public static int recursiveFibonacci(int index, List<Integer> memo){
        if (index < 2)
            return index;

        if (memo.size() > index){
            return memo.get(index);
        }

        memo.add(recursiveFibonacci(index-2, memo) + recursiveFibonacci(index-1, memo));
        return memo.get(index);
    }

    public static int iterativeFibonacci(int index){
        List<Integer> fibonacci = new ArrayList(List.of(0,1));

        for(int i = 2; i<=index; i++){
            fibonacci.add( fibonacci.get(i-1) + fibonacci.get(i-2));
        }
        return fibonacci.get(index);
    }

    public static void main(String[] args) {

        System.out.println("Recursive Index 12(144): " + recursiveFibonacci(120));
        System.out.println("-------");
        System.out.println("Iterative Index 12(144): " + iterativeFibonacci(120));
    }
}
