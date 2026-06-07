public class KadanesAlgorithm {

    public static void main() {
        int[] arr = { 1, -2, 6, -1, 3 };

        int currentSum = 0;

        int maxSum = Integer.MAX_VALUE;

        for (int num : arr) {

            currentSum += num;

            maxSum = Math.max(maxSum, currentSum);

            if (currentSum < 0) {
                currentSum = 0;
            }

        }

        System.out.println("Maximum Sum = " + maxSum);
    }
}
