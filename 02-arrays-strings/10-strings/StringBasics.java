import java.util.Scanner;

public class StringBasics {

    public static void main(String[] args) {
        String name = "John Doe";
        System.out.println("Name: " + name);

        // String concatenation
        String greeting = "Hello, " + name + "!";
        System.out.println(greeting);

        // String length
        int length = name.length();
        System.out.println("Length of name: " + length);

        // Accessing characters
        char firstChar = name.charAt(0);
        System.out.println("First character: " + firstChar);

        // Substring
        String lastName = name.substring(5);
        System.out.println("Last name: " + lastName);

        // String comparison
        String anotherName = "John Doe";
        boolean isEqual = name.equals(anotherName);
        System.out.println("Is the same name: " + isEqual);

        // String immutability
        String modifiedName = name.replace("John", "Jane");
        System.out.println("Modified name: " + modifiedName);
        System.out.println("Original name: " + name);

        // Input and output
        System.out.println("\n--- User Input ---");
        inputOutput();
    }

    static void inputOutput() {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your name: ");
        String userName = scanner.nextLine();
        System.out.println("Hello, " + userName + "!");
        scanner.close();
    }
}
