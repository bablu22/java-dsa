public class SumOfMatrix {

    public static void main() {
        int[][] matrix = {
                { 1, 2, 3 },
                { 4, 5, 6 },
                { 7, 8, 9 }
        };

        int sum = calculateSum(matrix);
        System.out.println("The largest element in the matrix is: " + sum);

        System.out.println();
        rowSum(matrix);
    }

    static int calculateSum(int[][] matrix) {
        int sum = 0;

        for (int row = 0; row < matrix.length; row++) {

            for (int col = 0; col < matrix[row].length; col++) {
                sum += matrix[row][col];
            }
        }

        return sum;
    }

    static void rowSum(int[][] matrix) {

        for (int row = 0; row < matrix.length; row++) {
            int sum = 0;

            for (int col = 0; col < matrix[row].length; col++) {
                sum += matrix[row][col];
            }

            System.out.println("The sum of row " + row + " is: " + sum);
        }

    }
}
