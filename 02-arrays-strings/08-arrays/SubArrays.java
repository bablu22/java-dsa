public class SubArrays {
    public static void main() {
        int[] arr = { 1, 2, 3 };
        printAllSubArrays(arr);

        System.out.println("-----------------------------");
        countSubArrays(arr);

        System.out.println("-----------------------------");
        printSubArraySums(arr);
    }

    static void printAllSubArrays(int[] arr) {

        int n = arr.length;

        for (int start = 0; start < n; start++) {

            for (int end = start; end < n; end++) {

                for (int k = start; k <= end; k++) {
                    System.out.print(arr[k] + " ");
                }
                System.out.println();

            }
        }
    }

    static void countSubArrays(int[] arr) {

        int n = arr.length;
        int count = 0;

        for (int start = 0; start < n; start++) {
            for (int end = start; end < n; end++) {
                count++;
            }
        }

        System.out.println("Total SubArrays = " + count);

    }

    static void printSubArraySums(int[] arr) {

        int n = arr.length;

        for (int start = 0; start < n; start++) {

            for (int end = start; end < n; end++) {

                int sum = 0;

                for (int k = start; k <= end; k++) {
                    sum += arr[k];
                }

                System.out.println("Sum of SubArray from index " + start + " to " + end + " is: " + sum);
            }
        }

    }

}
