package com.fcastro.codility;

public class FloodDepthBest {
    Integer[] floodDepth;

    public static void main(String[] args) {
        //int[] a = {1, 3, 2, 1, 2, 1, 5, 3, 3, 4, 2}; //2
        //int[] a = {5, 8}; //0
        //int[] a = {8, 5, 3, 1, 9, 1, 5, 3, 3, 4, 2};  //7
        int[] a = {1, 0, 3, 1, 2, 0, 3, 1, 2, 0, 4, 2, 1, 2, 0, 1}; //3
        FloodDepthBest solution = new FloodDepthBest();
        System.out.println(solution.solution(a));
    }

    /*
    O(N)
    traversal from left to right, with left highest wall as the reference, remember the depths of all possible lakes.
    traversal from right to left, with right highest wall as the reference, update the depths of all possible lakes.

    worst-case time complexity: O(n), where n is the length of the A.
    worst-case space complexity: O(n), where n is the length of the A.
    */
    public int solution(int[] A) {
        int n = A.length;
        int res = 0;

        int[] depths = new int[n];
        int wall = A[0];
        for(int i=1; i<n-1; ++i)
        {
            if(A[i] > wall) wall = A[i];
            else depths[i] = wall - A[i];
        }

        wall = A[n-1];
        for(int i= n-2; i>0; --i)
        {
            if(A[i] > wall)
            {
                wall = A[i];
                depths[i] = 0;
            }
            else depths[i] = Math.min(wall-A[i], depths[i]);

            res = Math.max(res, depths[i]);
        }
        return res;
    }
}
