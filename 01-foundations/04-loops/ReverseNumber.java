import java.util.Scanner;

public class ReverseNumber {
    public static void main() {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int number = scanner.nextInt();

        int reversed = 0;

        while (number != 0) {
            int digit = number % 10; //123
            reversed = reversed * 10 + digit;
            number /= 10;
        }

        System.out.println("Reversed Number = " + reversed);

        scanner.close();
    }
}
