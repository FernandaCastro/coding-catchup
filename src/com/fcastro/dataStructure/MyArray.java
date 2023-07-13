package com.fcastro.dataStructure;

import java.util.Arrays;

public class MyArray {

    public static void main(String[] args) {
        int[] single = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[][] multi1 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] multi2 = new int[3][3];
        multi2[0][0] = 1;
        multi2[0][1] = 2;
        multi2[0][2] = 3;
        multi2[1][0] = 4;
        multi2[1][1] = 5;
        multi2[1][2] = 6;
        multi2[2][0] = 7;
        multi2[2][1] = 8;
        multi2[2][2] = 9;

        Arrays.stream(single).forEach(e -> System.out.print(e + " "));

        System.out.println();
        Arrays.stream(multi1).forEach(a -> {
            System.out.print("{");
            Arrays.stream(a).forEach(b -> System.out.print(b + " ") );
            System.out.print("}");
        });

        System.out.println();
        Arrays.stream(multi2).forEach(a -> {
            System.out.print("{");
            Arrays.stream(a).forEach(b -> System.out.print(b + " ") );
            System.out.print("}");
        });
    }
}
