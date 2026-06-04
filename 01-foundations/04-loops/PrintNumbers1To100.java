public class PrintNumbers1To100 {
    public static void main() {

        for (int i = 1; i <= 100; i++) {
            System.out.println(i);
        }
    }

    public static void printEvenNumbers() {

        for (int i = 2; i <= 100; i += 2) {
            System.out.println(i);
        }
    }
}
