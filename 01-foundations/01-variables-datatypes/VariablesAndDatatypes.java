
public class VariablesAndDatatypes {
    public static void main(String[] args) {

        // primitives Data types
        byte age = 25;
        short year = 2024;
        int population = 780000000;
        long distanceToSun = 149600000000L;

        float pi = 3.14f;
        double gravity = 9.81;

        char grade = 'A';
        boolean isJavaFun = true;

        // Output the variables
        System.out.println("Age: " + age);
        System.out.println("Year: " + year);
        System.out.println("Population: " + population);
        System.out.println("Distance to Sun: " + distanceToSun + " km");
        System.out.println("Pi: " + pi);
        System.out.println("Gravity: " + gravity + " m/s²");
        System.out.println("Grade: " + grade);
        System.out.println("Is Java Fun? " + isJavaFun);

        // Widening Casting
        int number = 100;
        double widenedNumber = number;

        System.out.println("\n=== Widening Casting ==");
        System.out.println("Original int: " + number);
        System.out.println("Converted double: " + widenedNumber);

        // Narrowing Casting
        double price = 99.99;
        int narrowedPrice = (int) price;

        System.out.println("\n=== Narrowing Casting ===");
        System.out.println("Original double: " + price);
        System.out.println("Converted int: " + narrowedPrice);

    }
}
