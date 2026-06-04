
public class ConditionalStatements {

    public static void main(String[] args) {
        int age = 26;
        int marks = 75;
        char grade = 'B';

        // Simple if
        System.out.println("\n=== if Statement ===");

        if (age >= 18) {
            System.out.println("You are an adult");
        }

        // if-else
        System.out.println("\n=== if-else Statement ===");

        if (marks >= 50) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }

        // if-else-if Ladder
        System.out.println("\n=== if-else-if Statement ===");

        if (marks >= 90) {
            System.out.println("Grade A+");
        } else if (marks >= 80) {
            System.out.println("Grade A");
        } else if (marks >= 70) {
            System.out.println("Grade B");
        } else if (marks >= 60) {
            System.out.println("Grade C");
        } else {
            System.out.println("Grade F");
        }

        // Nested if
        System.out.println("\n=== Nested if Statement ===");
        boolean hasIdCard = true;

        if (age >= 18) {
            if (hasIdCard) {
                System.out.println("Entry Allowed");
            } else {
                System.out.println("ID Card Required");
            }
        } else {
            System.out.println("Under Age");
        }

        // Switch Statement
        System.out.println("\n=== Switch Statement ===");

        switch (grade) {
            case 'A':
                System.out.println("Excellent");
                break;

            case 'B':
                System.out.println("Good");
                break;

            case 'C':
                System.out.println("Average");
                break;

            case 'D':
                System.out.println("Poor");
                break;

            default:
                System.out.println("Invalid Grade");
        }

        // Ternary Operator
        System.out.println("\n=== Ternary Operator ===");

        String status = age >= 18 ? "Adult" : "Minor";
        System.out.println(status);
    }

}
