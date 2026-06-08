public class LargestElementInMatrix {

    public static void main() {
        int[][] matrix = {
                { 1, 2, 3 },
                { 4, 5, 6 },
                { 7, 8, 9 }
        };

        int largest = findLargestElement(matrix);
        System.out.println("The largest element in the matrix is: " + largest);
    }

    static int findLargestElement(int[][] matrix) {
        int largest = Integer.MIN_VALUE;

        for (int row = 0; row < matrix.length; row++) {

            for (int col = 0; col < matrix[row].length; col++) {
                largest = Math.max(largest, matrix[row][col]);
            }

        }

        return largest;
    }
}
