package com.fcastro.codility;

public class FindMinimumInRotatedSortedArray {

    public static void main(String[] args){
        var o = new FindMinimumInRotatedSortedArray();

        //Find minimum element

        System.out.println("{4,5,1,2,3} => " + o.findMinimumElement(new int[]{4,5,1,2,3}));
        System.out.println("{4,5,6,7,0,1,2} => " + o.findMinimumElement(new int[]{4,5,6,7,0,1,2}));
        System.out.println("{11,13,15,17} => " + o.findMinimumElement(new int[]{11,13,15,17}));
        System.out.println("{3,1,2} => " + o.findMinimumElement(new int[]{3,1,2}));
        System.out.println("{3,4,5,1,2} => " + o.findMinimumElement(new int[]{3,4,5,1,2}));
        System.out.println("{3,4,5,6,7,1,2} => " + o.findMinimumElement(new int[]{3,4,5,6,7,1,2}));
        System.out.println("{2,3,4,5,1} => " + o.findMinimumElement(new int[]{2,3,4,5,1}));
        System.out.println("{5,6,7,8,9,1,2,3,4} => " + o.findMinimumElement(new int[]{5,6,7,8,9,1,2,3,4}));
        System.out.println("{2} => " + o.findMinimumElement(new int[]{2}));
        System.out.println("{} => " + o.findMinimumElement(new int[]{}));
        System.out.println("{2,3} => " + o.findMinimumElement(new int[]{2,3}));
        System.out.println("null => " + o.findMinimumElement(null));


    }

    //Time Complexity: O(n)
    private int findMinimumElement(int[] array){
        if (array == null || array.length == 0) return -5001;
        if (array.length == 1) return array[0];
        if (array.length == 2) return array[0] < array[1] ? array[0] : array[1];

        int min = 5001;
        for (int i = 0; i < array.length; i++) {

            if (array[i]<min)
                min = array[i];
        }

        return min;
    }
}
