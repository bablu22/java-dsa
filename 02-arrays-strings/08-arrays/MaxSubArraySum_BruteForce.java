public class MaxSubArraySum_BruteForce {
    public static void main() {

        int[] arr = { 1, -2, 6, -1, 3 };

        int n = arr.length;
        int maxSum = Integer.MAX_VALUE;

        for (int start = 0; start < n; start++) {

            for (int end = start; end < n; end++) {

                int currentSum = 0;

                for (int k = start; k <= end; k++) {
                    currentSum += arr[k];
                }

                maxSum = Math.max(maxSum, currentSum);
            }
        }

        System.out.println("Maximum Sum = " + maxSum);
    }

}
