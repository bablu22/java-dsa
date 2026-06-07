import java.util.Arrays;

public class LinearSearch {
    public static void main() {

        int[] numbers = { 10, 50, 30, 70, 80, 20, 90, 40 };
        int target = 30;

        // Sort the arr
        Arrays.sort(numbers);

        int result = searchOPtimized(numbers, target);

        if (result != -1) {
            System.out.println("Element found at index: " + result);
        } else {
            System.out.println("Element not found in the array.");
        }
    }

    // Time Complexity: O(n)
    public static int search(int[] arr, int target) {

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;
            }
        }

        return -1;
    }

    // Time Complexity: O(log n)
    public static int searchOPtimized(int[] arr, int target) {

        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] == target) {
                return mid;
            }

            if (arr[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return -1;
    }

}
