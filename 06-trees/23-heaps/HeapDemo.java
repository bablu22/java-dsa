
import java.util.*;

public class HeapDemo {

    public static void main(String[] args) {
        // demonstrate PriorityQueue as min-heap and max-heap
        // call heapSort, kthLargest, kthSmallest, mergeKSorted, topKFrequent
    }

    // sort array in-place using heap sort — O(n log n)
    static void heapSort(int[] a) {

    }

    // build max-heap at subtree rooted at index i (heap size = n)
    static void heapify(int[] a, int n, int i) {

    }

    // return kth largest element using a min-heap of size k
    static int kthLargest(int[] a, int k) {
        return 0;
    }

    // return kth smallest element using a max-heap of size k
    static int kthSmallest(int[] a, int k) {
        return 0;
    }

    // merge k sorted arrays into one sorted list using a min-heap
    static List<Integer> mergeKSorted(int[][] arrays) {
        return new ArrayList<>();
    }

    // return list of k most frequent elements
    static List<Integer> topKFrequent(int[] nums, int k) {
        return new ArrayList<>();
    }

    // array-based min-heap implementation
    static class MinHeap {
        int[] heap;
        int size;

        MinHeap(int capacity) {

        }

        // insert val and bubble up to restore heap property
        void insert(int val) {

        }

        // remove and return the minimum element; bubble down to restore heap property
        int extractMin() {
            return 0;
        }

        int peek() {
            return 0;
        }

        void bubbleUp(int i) {

        }

        void bubbleDown(int i) {

        }
    }
}
