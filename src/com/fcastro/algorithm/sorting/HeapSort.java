package com.fcastro.algorithm.sorting;

/*
    The heapsort algorithm has two main parts (that will be broken down further below): building a max-heap and then sorting it.

    The max-heap (larger elements at the top) is a vital part of the heapsort algorithm and is built method called max_heapify(A,i)
    which takes an array and an index as input.
    Essentially, if an element arr[i] violates the max-heap property, max_heapify will correct it by trickling the element down the tree,
    until the subtree rooted at index i is a max-heap (and therefore the violation is corrected).

    Then, heapsort produces a sorted array by repeatedly removing the
    largest element from the heap (which is the root of the heap), and then inserting it into the array.
    The heap is updated after each removal. Once all elements have been removed from the heap, the result is a sorted array.

    1) Build a max-heap from an unordered array.
    2) Find the maximum element, which is located at arr[0] because the heap is a max-heap.
    3) Swap elements arr[n] and arr[0] so that the maximum element is at the end of the array where it belongs.
    4) Decrement the heap size by one (this discards the node we just moved to the bottom of the heap, which was the largest element).
       In a manner of speaking, the sorted part of the list has grown and the heap (which holds the unsorted elements) has shrunk.
    5) Now run max_heapify on the heap in case the new root causes a violation of the max-heap property. (Its children will still be max-heaps.)
    6) Return to step 2.

    Pros
    Time-complexity: O(n log n)
    Less memory usage
    Consistent performance: it performs equally well in best-, average-, and worst-case scenarios

    Cons
    Unstable sort
    External sorting not possible with heapsort


 */
public class HeapSort {

    public void heapSort(int arr[]) {
        int heapSize = arr.length;

        // 1) Build heap (rearrange array)
        for (int i = (heapSize / 2 - 1); i >= 0; i--)
            maxHeapify(arr, heapSize, i);

        // 2) One by one extract an element from heap
        for (int i = heapSize - 1; i > 0; i--) {
            // 3) Move current root to end
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // 4) and 5) call max heapify on the reduced heap
            maxHeapify(arr, i, 0);
        }
    }

    // To heapify a subtree rooted with node i which is
    // an index in arr[]. n is size of heap
    //Time complexity: O(log n)
    void maxHeapify(int arr[], int heapSize, int i) {
        int largest = i; // Initialize largest as root
        int left = 2 * i + 1; // left = 2*i + 1
        int right = 2 * i + 2; // right = 2*i + 2

        // If left child is larger than root
        if (left < heapSize && arr[left] > arr[largest])
            largest = left;

        // If right child is larger than largest so far
        if (right < heapSize && arr[right] > arr[largest])
            largest = right;

        // If largest is not root
        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            // Recursively heapify the affected sub-tree
            maxHeapify(arr, heapSize, largest);
        }
    }

    String print(String note, int[] array) {
        StringBuilder sorted = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            sorted.append(array[i]).append(" ");
        }

        System.out.println(note + sorted);
        return sorted.toString();
    }

    // Driver code
    public static void main(String args[]) {
        int arr[] = {99, 44, 6, 2, 1, 5, 63, 87, 283, 4, 0};
        int n = arr.length;

        HeapSort ob = new HeapSort();
        ob.heapSort(arr);

        System.out.println("Input: " + "{99, 44, 6, 2, 1, 5, 63, 87, 283, 4, 0}");
        ob.print("Output: ", arr);
    }
}
