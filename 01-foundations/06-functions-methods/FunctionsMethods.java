import java.util.Arrays;

public class FunctionsMethods {

    public static void main(String[] args) {

        System.out.println("Add: " + add(10, 20));

        System.out.println("Factorial(5): " + factorial(5));

        System.out.println("Is 17 Prime? " + isPrime(17));

        System.out.println("Max of 10 and 20: " + max(10, 20));

        System.out.println("Max of 10, 20 and 30: " + max(10, 20, 30));

        System.out.println("Sum: " + sum(1, 2, 3, 4, 5));

        // Pass-by-reference
        int[] numbers = { 1, 2, 3, 4, 5 };

        System.out.println("Before doubling: " + Arrays.toString(numbers));

        doubleArray(numbers);

        System.out.println("After doubling: " + Arrays.toString(numbers));
    }

    static int add(int a, int b) {
        return a + b;
    }

    static long factorial(int n) {

        long result = 1;

        for (int i = 1; i <= n; i++) {
            result *= i;

        }
        return result;

    }

    static boolean isPrime(int n) {

        if (n <= 1) {
            return false;
        }

        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }

        return true;
    }

    // overloaded: max of two ints
    static int max(int a, int b) {
        return Math.max(a, b);
    }

    // overloaded: max of three ints
    static int max(int a, int b, int c) {
        return Math.max(a, Math.max(b, c));
    }

    // varargs: sum of any number of ints
    static int sum(int... nums) {

        int total = 0;

        for (int num : nums) {
            total += num;
        }

        return total;
    }

    // double every element in the array (modifies original)
    static void doubleArray(int[] arr) {

        for (int i = 0; i < arr.length; i++) {
            arr[i] *= 2;
        }
    }
}
