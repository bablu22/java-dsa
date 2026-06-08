import java.util.Scanner;

public class PalindromeString {

    public static void main() {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a word: ");
        String str = scanner.next();

        String reversed = "";

        for (int i = str.length() - 1; i >= 0; i--) {
            reversed += str.charAt(i);
        }

        if (str.equals(reversed)) {
            System.out.println("Palindrome");
        } else {
            System.out.println("Not Palindrome");
        }

        scanner.close();
    }
}
