package com.fcastro.algorithm;

public class RecursionFactorial {

    int recursiveFactorial(int number){
        if (number == 1){
            return number;
        }
        return number * recursiveFactorial(--number);
    }

    int iterativeFactorial(int number){
        int factorial=1;
        while (number > 0){
            factorial = factorial * number;
            number--;
        }
        return factorial;
    }

    public static void main(String[] args) {
        RecursionFactorial o = new RecursionFactorial();
        int expected = 5 * 4 * 3 * 2;
        System.out.println("Expected "+ expected);
        System.out.println("Recursion: " + o.recursiveFactorial(5));
        System.out.println("Non-recursion: " + o.iterativeFactorial(5));
    }
}
