package com.fcastro.algorithm;

import java.util.ArrayList;
import java.util.List;

//Given a number N return the index value of the Fibonacci sequence,
//where the sequence is: 0, 1, 1, 2, 3, 5, 8, 13, 21, 24, 55, 89, 144...
//                       0  1  2  3  4  5  6   7   8   9  10  11   12
public class RecursionFibonacci {

    int recursiveFibonacci(int index){
        if (index < 2)
            return index;

        return recursiveFibonacci(index-2) + recursiveFibonacci(index-1);
    }

    int iterativeFibonacci(int index){
        if (index < 2)
            return index;

        int previous1 = 0;
        int previous2 = 1;
        int current = 0;
        for(int i = 2; i<=index; i++){
            current = previous1 + previous2;
            previous1 = previous2;
            previous2 = current;
        }
        return current;
    }

    int iterativeFibonacci2(int index){
        List<Integer> fibonacci = new ArrayList(List.of(0,1));

        for(int i = 2; i<=index; i++){
            fibonacci.add( fibonacci.get(i-1) + fibonacci.get(i-2));
        }
        return fibonacci.get(index);
    }

    public static void main(String[] args) {
        RecursionFibonacci o = new RecursionFibonacci();
        System.out.println("Recursive Index 02(01): " + o.recursiveFibonacci(2));
        System.out.println("Recursive Index 03(02): " + o.recursiveFibonacci(3));
        System.out.println("Recursive Index 04(03): " + o.recursiveFibonacci(4));
        System.out.println("Recursive Index 07(13): " + o.recursiveFibonacci(7));
        System.out.println("Recursive Index 10(55): " + o.recursiveFibonacci(10));
        System.out.println("Recursive Index 12(144): " + o.recursiveFibonacci(12));

        System.out.println("-------");

        System.out.println("Iterative Index 02(01): " + o.iterativeFibonacci2(2));
        System.out.println("Iterative Index 03(02): " + o.iterativeFibonacci2(3));
        System.out.println("Iterative Index 04(03): " + o.iterativeFibonacci2(4));
        System.out.println("Iterative Index 07(13): " + o.iterativeFibonacci2(7));
        System.out.println("Iterative Index 10(55): " + o.iterativeFibonacci2(10));
        System.out.println("Iterative Index 12(144): " + o.iterativeFibonacci2(12));
    }
}
