package com.fcastro.algorithm.sorting;

public class ElementarySortingAlgorithms {

    /*
      Nested loops comparing 2 elements and swapping them when needed
      Repeat it until all numbers are sorted.
      Basic Sorting Algorithm - One of the least efficient sorting algorithms
      Time complexity O(nˆ2)
     */
    int[] bubbleSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length-1; j++) {
                //swap numbers
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
        return array;
    }

    /*
        Scan the list starting by the position, iterate to find the smallest element.
        Then swap the smallest with the start position.
        Move the start point to the next position and repeat the scan process.
        Do it again until all positions are set.
        Time complexity O(nˆ2)
     */
    int[] selectionSort(int[] array){

        for (int i = 0; i < array.length; i++) {
            int idxSmallest = i;
            int temp = array[i];

            //Select the smallest
            for (int j = i+1; j < array.length; j++) {
                if (array[j] < array[idxSmallest])
                    idxSmallest = j;
            }

            //Swap the smallest with the initial position values
            array[i] = array[idxSmallest];
            array[idxSmallest] = temp;
        }
        return array;
    }

    /*
        Still not the efficient sort algorithm but good for partially sorted or even already sorted lists.
        Keep the starting point value (Key)
        Iterate backwards from the (start point - 1) comparing the value to the key until finding a smaller value.
        Once found, insert the start point value (Key) to the position found + 1
        Time complexity O(nˆ2)
     */
    int[] insertionSort(int[] array){
        if (array.length <= 1)
            return array;

        for (int i=0; i < array.length; i++){
            int key = array[i];
            int j = i-1;

            //Move greater value one position ahead until find item < key
            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j--;
            }

            array[j+1] = key;
        }

        return array;
    }

    public static void main(String[] args) {
        int[] array = {99, 44, 6, 2, 1, 5, 63, 87, 283, 4, 0};

        ElementarySortingAlgorithms sortingAlgorithms = new ElementarySortingAlgorithms();

        //sortingAlgorithms.bubbleSort(array);
        //sortingAlgorithms.selectionSort(array);
        sortingAlgorithms.insertionSort(array);


        StringBuilder sorted = new StringBuilder();
        for(int i=0; i<array.length; i++){
            sorted.append(array[i]).append(" ");
        }
        System.out.println(sorted);
    }
}
