package com.fcastro.algorithm;

import java.time.Duration;
import java.time.Instant;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MergeSortedArrays {

    public static void main(String[] args) {
        MergeSortedArrays o = new MergeSortedArrays();
        //int[] array1 = {0, 3, 4, 31};
        //int[] array2 = {4, 6, 30};
        //System.out.println("MergeTwoSortedArrays - using Arrays only: " + Arrays.toString(o.mergeTwoSortedArrays(array1, array2)));

        // generate 100 random number between 0 to 100
        int[] array1 = IntStream.generate(() -> new Random().nextInt(100000)).limit(100000).sorted().toArray();
        int[] array2 = IntStream.generate(() -> new Random().nextInt(100000)).limit(100000).sorted().toArray();

        Instant start = Instant.now();
        o.mergeTwoSortedArrays(array1, array2);
        Instant end = Instant.now();
        System.out.println("Duration: " + Duration.between(start, end).toMillis() + "ms");


        //System.out.println("  MergeTwoSortedArrays - using ArrayList: " + Arrays.toString(o.mergeTwoSortedArrays2(array1, array2)));
    }

    //Merge 2 sorted arrays
    //array1 [0, 3, 4, 31]  array2[4, 6, 30]
    //merged array[0, 3, 4, 4, 6, 30, 31]
    //What is the type of the arrays? int?
    //What's the size of the arrays? 100.000?
    //Memory is a restriction?
    //Should use only array in the solution?

    //Brute Force
    //Iterate both arrays at the same time saving the smaller element.
    int[] mergeTwoSortedArrays(int[] array1, int[] array2) {
        if (array1 == null && array2 == null) return null;
        if ((array1 == null || array1.length == 0)) return array2;
        if ((array2 == null || array2.length == 0)) return array1;

        int[] merge = new int[(array1.length + array2.length)];

        int i = 1;
        int j = 1;
        int k = 0;
        int item1 = array1[0];
        int item2 = array2[0];

        while ((i<=array1.length) || (j<=array2.length)){

            boolean addArrayItem1 = shouldAddFromArray1(item1, item2, i, j, array1.length, array2.length);

            if (addArrayItem1){
                merge[k] = item1;
                if (i< array1.length)
                    item1 = array1[i];
                i++;
            }else{
                merge[k] = item2;
                if (j<array2.length)
                    item2 = array2[j];
                j++;
            }

            k++;
        }

        return merge;
    }

    boolean shouldAddFromArray1(int item1, int item2, int indexArray1, int indexArray2, int lengthArray1, int lengthArray2){
        return (((item1 < item2) && (indexArray1<lengthArray1)) || (indexArray2>lengthArray2));
    }

    //create a dynamic array sized to the sum of array1 and 2
    //containing the longest array
    //Iterate the smaller array, lookup item or neighbours, the insert
    int[] mergeTwoSortedArrays2(int[] array1, int[] array2) {
        List<Integer> merge = Arrays.stream(array1).boxed().collect(Collectors.toList());
        merge.addAll(Arrays.stream(array2).boxed().collect(Collectors.toList()));
        merge.sort(Comparator.naturalOrder());
        return merge.stream().mapToInt(Integer::intValue).toArray();
    }

}
