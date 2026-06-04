
public class Operators {
    public static void main(String[] args) {

        int a = 10;
        int b = 3;

        // Arithmetic Operators
        System.out.println("\n=== Arithmetic Operators ====");
        System.out.println("a + b = " + (a + b));
        System.out.println("a - b = " + (a - b));
        System.out.println("a * b = " + (a * b));
        System.out.println("a / b = " + (a / b));
        System.out.println("a % b = " + (a % b));

        // Assignment Operators
        int c = 5;
        c += 2; // c = c + 2
        System.out.println("\n=== Assignment Operators ===");
        System.out.println("c += 2 : " + c);

        // Relational Operators
        System.out.println("\n=== Relational Operators ===");
        System.out.println("a == b : " + (a == b));
        System.out.println("a != b : " + (a != b));
        System.out.println("a > b : " + (a > b));
        System.out.println("a < b : " + (a < b));
        System.out.println("a >= b : " + (a >= b));
        System.out.println("a <= b : " + (a <= b));

        // Logical Operators
        boolean x = true;
        boolean y = false;

        System.out.println("\n=== Logical Operators ===");
        System.out.println("x && y : " + (x && y));
        System.out.println("x || y : " + (x || y));
        System.out.println("!x : " + (!x));

        // Bitwise Operators
        int p = 5;
        int q = 3;

        System.out.println("\n=== Bitwise Operators ===");
        System.out.println("p & q = " + (p & q)); // AND
        System.out.println("p | q = " + (p | q)); // OR
        System.out.println("p ^ q = " + (p ^ q)); // XOR
        System.out.println("~p = " + (~p)); // NOT
        System.out.println("a >= b : " + (a >= b)); // Left Shift
        System.out.println("a <= b : " + (a <= b)); // Left Shift

        // Ternary Operator
        int age = 20;

        String status = age >= 18 ? "Adult" : "Minor";

        System.out.println("\n=== Ternary Operator ===");
        System.out.println(status);

        // Compound Assignment Operators
        int score = 10;

        score += 5;
        System.out.println("\nscore += 5 : " + score);

    }
}
