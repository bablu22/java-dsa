
public class BasicSorting {

    public static void main(String[] args) {
        // create test array, clone it for each sort, print result after each
    }

    static void swap(int[] a, int i, int j) {

    }

    // O(n²) — swap adjacent elements until sorted; stop early if no swap in a pass
    static void bubbleSort(int[] a) {

    }

    // O(n²) — find minimum of unsorted part, swap to front
    static void selectionSort(int[] a) {

    }

    // O(n²) best O(n) — shift elements right to insert current key in correct position
    static void insertionSort(int[] a) {

    }

    // O(n log n) — divide in half, sort each half, merge back
    static void mergeSort(int[] a, int l, int r) {

    }

    // merge two sorted halves a[l..mid] and a[mid+1..r]
    static void merge(int[] a, int l, int mid, int r) {

    }

    // O(n log n) avg — partition around pivot, recurse on both sides
    static void quickSort(int[] a, int l, int r) {

    }

    // place pivot in correct position; return its index
    static int partition(int[] a, int l, int r) {
        return 0;
    }

    // O(n + k) — count occurrences then rebuild (non-negative integers only)
    static int[] countingSort(int[] a) {
        return new int[0];
    }
}
