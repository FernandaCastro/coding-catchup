package com.fcastro.algorithm.sorting;

import java.util.Arrays;
import java.util.List;

/*
    Divide the list and sublist into half until having one item
    Compare and sort 2 items at a time (left/right) rebuilding a sublist as a reverse tree
    Continue comparing and sorting 2 sublist at a time (left/right),
    move the index of each side independently as it's get sorted.
    
    Time complexity: O(n log n)
    Space complexity: O(n)
 */
public class MergeSort {
    int[] mergeSort (int[] array) {
        if (array.length <= 1) {
            return array;
        }

        // Split Array in into right and left
        int middle = (array.length/2);
        var left = Arrays.copyOfRange(array, 0, middle);
        var right = Arrays.copyOfRange(array, middle, array.length);

        print("Left: ", left);
        print("Right: ", right);

        return merge(
                mergeSort(left),
                mergeSort(right)
        );
    }

    int[] merge(int[] left, int[] right){
        int[] result = new int[(left.length + right.length)];

        int leftIndex = 0;
        int rightIndex = 0;
        int resultIndex = 0;

        while(leftIndex < left.length && rightIndex < right.length){

            if(left[leftIndex] < right[rightIndex]){
                result[resultIndex] = left[leftIndex];
                leftIndex++;
            } else{
                result[resultIndex] = right[rightIndex];
                rightIndex++;
            }
            resultIndex++;
        }

        while (leftIndex < left.length){
            result[resultIndex] = left[leftIndex];
            leftIndex++;
            resultIndex++;
        }

        while (rightIndex < right.length){
            result[resultIndex] = right[rightIndex];
            rightIndex++;
            resultIndex++;
        }

        print("Merge: ", result);
        return result;
    }

    String print(String note, int[] array){
        String sorted = "";
        for(int i=0; i<array.length; i++){
            sorted += array[i] + " ";
        }

        System.out.println(note + sorted);
        return sorted;
    }

    public static void main(String[] args) {
        int[] array = {99, 44, 6, 2, 1, 5, 63, 87, 283, 4, 0};

        MergeSort mergeSort = new MergeSort();

        mergeSort.print("Input: ", array);
        array = mergeSort.mergeSort(array);
        mergeSort.print("Output: ", array);
    }

}
