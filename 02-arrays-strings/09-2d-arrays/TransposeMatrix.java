public class TransposeMatrix {
    public static void main(String[] args) {
        int[][] matrix = {
                { 1, 2, 3 },
                { 4, 5, 6 },
                { 7, 8, 9 }
        };

        int rows = matrix.length;
        int cols = matrix[0].length;

        int[][] transpose = new int[rows][cols];

        for (int row = 0; row < rows; row++) {

            for (int col = 0; col < cols; col++) {
                transpose[col][row] = matrix[row][col];
            }

        }

        for (int row = 0; row < transpose.length; row++) {

            for (int col = 0; col < transpose[row].length; col++) {
                System.out.print(transpose[row][col] + " ");
            }

            System.out.println();
        }

    }
}
