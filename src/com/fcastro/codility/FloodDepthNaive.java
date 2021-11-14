package com.fcastro.codility;

import java.util.*;

public class FloodDepthNaive {
    Integer[] floodDepth;

    public static void main(String[] args) {
        //int[] a = {1, 3, 2, 1, 2, 1, 5, 3, 3, 4, 2};
        //int[] a = {5, 8};
        //int[] a = {8, 5, 3, 1, 9, 1, 5, 3, 3, 4, 2};
        int[] a = {1, 0, 3, 1, 2, 0, 3, 1, 2, 0, 4, 2, 1, 2, 0, 1};
        FloodDepthNaive solution = new FloodDepthNaive();
        System.out.println(solution.solution(a));
    }

    //O(N) or O(N**2)
    public int solution(int[] A) {
        floodDepth = new Integer[A.length];
        int nextPeekIndex;

        int i = 0;
        while(i < A.length){
            nextPeekIndex = findHigherPeek(i, A);

            if (nextPeekIndex > -1) {
                if ((nextPeekIndex - i) > 1) {
                    calculateDepth(i, nextPeekIndex, A);
                    i = nextPeekIndex;
                    continue;
                }

                floodDepth[i] = 0;
                i++;
                continue;
            }

            nextPeekIndex = findAnyPeek(i, A);
            if (nextPeekIndex > -1) {
                if ((nextPeekIndex - i) > 1) {
                    calculateDepth(i, nextPeekIndex, A);
                    i = nextPeekIndex;
                    continue;
                }
                floodDepth[i] = 0;
                i++;
                continue;

            }

            setRemainingToZero(i, A);
            break;
        }

        Optional<Integer> maxDepth = Arrays.stream(floodDepth).max(Integer::compareTo);
        if (maxDepth.isPresent())
            return maxDepth.get();
        return 0;
    }

    private void setRemainingToZero(int beginIndex, int[] a){
        int i = beginIndex;
        while(i < a.length){
            floodDepth[i] = 0;
            i++;
        }
    }

    private void calculateDepth(int beginIndex, int endIndex, int[] a){
        floodDepth[beginIndex]=0;
        floodDepth[endIndex]=0;

        int lowerPeek = Math.min(a[beginIndex], a[endIndex]);

        int i = beginIndex + 1;
        while (i < endIndex){
            floodDepth[i] = lowerPeek - a[i];
            i++;
        }
    }

    private int findHigherPeek(int idxPeek, int[] a){
        int altitude = a[idxPeek];
        int i = idxPeek+1;

        while(i<a.length){
            if (a[i]>=altitude) {
                return i;
            }
            i++;
        }
        return -1;
    }

    private int findAnyPeek(int beginIndex, int[] a){
        int altitude = 0;
        int peekIndex = -1;

        int i = beginIndex+1;
        while(i<a.length){
            if (a[i]>altitude) {
                altitude = a[i];
                peekIndex = i;
            }
            i++;
        }
        return peekIndex ;
    }
}
