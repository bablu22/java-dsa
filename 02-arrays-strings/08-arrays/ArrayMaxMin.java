public class ArrayMaxMin {

    public static void main() {
        int[] numbers = { 5, 3, 9, 1, 7 };

        System.out.print("Array elements: ");
        for (int num : numbers) {
            System.out.print(num + " ");
        }
        System.out.println();

        max(numbers);
        min(numbers);
    }

    public static void max(int arr[]) {

        int max = arr[0];

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }

        System.out.println("Maximum Value: " + max);
    }

    public static void min(int arr[]) {

        int min = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
        }

        System.out.println("Minimum Value: " + min);
    }

}
