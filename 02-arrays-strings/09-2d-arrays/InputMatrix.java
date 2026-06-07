import java.util.Scanner;

public class InputMatrix {

    public static void main() {

        Scanner scanner = new Scanner(System.in);

        int rows = 3;
        int cols = 3;

        int[][] matrix = new int[rows][cols];

        for (int row = 0; row < rows; row++) {

            for (int col = 0; col < cols; col++) {
                matrix[row][col] = scanner.nextInt();
            }
        }

        System.out.println("-----------------------------");

        for (int row = 0; row < rows; row++) {

            for (int col = 0; col < cols; col++) {

                System.out.print(matrix[row][col] + " ");
            }

            System.out.println();

        }

        scanner.close();

    }
}
