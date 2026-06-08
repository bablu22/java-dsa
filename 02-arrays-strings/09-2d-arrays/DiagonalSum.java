public class DiagonalSum {
    public static void main(String[] args) {
        int[][] matrix = {
                { 1, 2, 3 },
                { 4, 5, 6 },
                { 7, 8, 9 }
        };

        int sum = diagonalSum(matrix);
        System.out.println("Diagonal Sum: " + sum);
    }

    static int diagonalSum(int[][] matrix) {

        int sum = 0;
        int n = matrix.length;

        for (int i = 0; i < n; i++) {
            sum += matrix[i][i];
            sum += matrix[i][n - 1 - i];
        }

        return sum;

    }

}
