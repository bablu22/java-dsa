import java.util.Scanner;

public class ArraysDemo {

    public static void main(String[] args) {
        int[] numbers = { 10, 20, 30, 40, 50 };

        for (int i = 0; i < numbers.length; i++) {
            System.out.println(numbers[i]);
        }

        userInput();
    }

    public static void userInput() {
        Scanner scanner = new Scanner(System.in);

        int[] arr = new int[5];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = scanner.nextInt();
        }

        System.out.println("Array: ");

        for (int num : arr) {
            System.out.print(num + " ");
        }

        scanner.close();
    }

}
