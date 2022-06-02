package com.fcastro.algorithm.sorting;

import java.util.Arrays;

/*
    1) Choose a pivot.
    Consider the type of the list to choose it intelligently and avoid worst time complexity scenario.
    Worst scenario happens when the pivot is the smallest or the largest item of a list,
    which prevent the list to be split in half.

    2) Compare the pivot to the list, when pivot is:
        2.1) greater than index item: let it as it is and move to the next item
        2.2) smaller than index item:
                      a) move the pivot one position to the left
                      b) move the left item to the position of the index item
                      c) move the index item to the old pivot position

                      3 7 8 5 2 1 9 5  4 <-- pivot(4) compared to 3(index item), let it as it is
                      3 7 8 5 2 1 9 5  4 <-- pivot(4) compared to 7(index item), then:
                        |           |<-|     a)move the pivot one position to the left
                        |<----------|        b)move the left item to the position of the index
                        |------------->|     c)move the index item to the old pivot position
                      3 5 8 5 2 1 9 4  7

    3) When pivot finds its right position, split the list in half and restart the pivot technique.

    Time complexity(AVG): O(n log n)
    Time complexity(Worst): O(nˆ2)
    Space complexity: O(log(n))
 */
public class QuickSort {

    int[] quickSort(int[] array, int left, int right){

        int length = array.length; //11
        int pivotIdx;
        int partitionIndex;

        if(left < right) {
            pivotIdx = right; //10
            partitionIndex = partition(array, pivotIdx, left, right);

            //sort left and right
            quickSort(array, left, partitionIndex - 1);
            quickSort(array, partitionIndex + 1, right);

        }
        return array;
    }

    int partition(int[] array, int pivotIdx, int left, int right){
        int pivotValue = array[pivotIdx];
        int partitionIndex = left;

        for(int i = left; i < right; i++) {
            if(array[i] < pivotValue){
                swap(array, i, partitionIndex);
                partitionIndex++;
            }
        }

        swap(array, right, partitionIndex);
        return partitionIndex;
    }

    void swap(int[] array, int i, int partitionIndex){
        var temp = array[i];
        array[i] = array[partitionIndex];
        array[partitionIndex] = temp;
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
        int[] numbers = {99, 44, 6, 2, 1, 5, 63, 87, 283, 4, 0};

        QuickSort o = new QuickSort();
        o.print("Input: ", numbers);
        numbers = o.quickSort(numbers, 0, numbers.length - 1);
        o.print("Output: ", numbers);
    }

}
