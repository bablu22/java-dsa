import java.util.Arrays;

public class SearchInMatrix {

    public static void main() {

        int[][] matrix = {
                { 1, 2, 3 },
                { 4, 5, 6 },
                { 7, 8, 9 }
        };

        int target = 8;

        int[] position = findPosition(matrix, target);
        if (position[0] != -1) {
            System.out.println("Found at row: " + position[0] + ", column: " + position[1]);
            System.out.println("Coordinates: " + Arrays.toString(position));
        } else {
            System.out.println("Target not found in the matrix.");
        }

    }

    static int[] findPosition(int[][] matrix, int target) {

        if (matrix == null || matrix.length == 0) {
            return new int[] { -1, -1 };
        }

        for (int row = 0; row < matrix.length; row++) {

            for (int col = 0; col < matrix[row].length; col++) {

                if (matrix[row][col] == target) {
                    return new int[] { row, col };
                }

            }

        }

        return new int[] { -1, -1 };

    }
}
