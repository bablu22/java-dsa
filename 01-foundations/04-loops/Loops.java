
public class Loops {

    public static void main(String[] args) {
        System.out.println("\n=== FOR LOOP ===");

        for (int i = 1; i <= 5; i++) {
            System.out.println(i);
        }

        System.out.println("\n=== WHILE LOOP ===");

        int j = 1;
        while (j <= 5) {
            System.out.println(j);
            j++;
        }

        System.out.println("\n=== DO WHILE LOOP ===");

        int k = 1;

        do {
            System.out.println(k);
            k++;
        } while (k <= 5);

        System.out.println("\n=== BREAK ===");

        for (int i = 1; i <= 10; i++) {
            if (i == 5) {
                break;
            }

            System.out.println(i);
        }

        System.out.println("\n=== CONTINUE ===");
        for (int i = 1; i <= 10; i++) {
            if (i == 3) {
                continue;
            }

            System.out.println(i);
        }

        System.out.println("\n=== NESTED LOOP ===");
        for (int row = 1; row <= 3; row++) {

            for (int col = 1; col <= 3; col++) {
                System.out.print("* ");
            }

            System.out.println();
        }
    }

}
