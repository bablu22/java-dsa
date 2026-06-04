
public class Patterns {

    public static void main(String[] args) {
        int n = 5;

        System.out.println("\n=== Right Triangle ===");
        rightTriangle(n);

        System.out.println("\n=== Inverted Triangle ===");
        invertedTriangle(n);

        System.out.println("\n=== Pyramid Triangle ===");
        pyramid(n);

    }

    // print right-angled triangle of stars (n rows)
    static void rightTriangle(int n) {

        for (int row = 1; row <= n; row++) {
            for (int col = 1; col <= row; col++) {
                System.out.print("*");
            }
            System.out.println();
        }

    }

    // print inverted right triangle (n rows)
    static void invertedTriangle(int n) {

        for (int row = n; row >= 1; row--) {
            for (int col = 1; col <= row; col++) {
                System.out.print("*");
            }
            System.out.println();
        }

    }

    // print centred pyramid (n rows)
    static void pyramid(int n) {

        for (int row = 1; row <= n; row++) {
            // space
            for (int space = 1; space <= n - row; space++) {
                System.out.print(" ");
            }

            // stars
            for (int star = 1; star <= (2 * row - 1); star++) {
                System.out.print("*");
            }

            System.out.println();
        }

    }

}
