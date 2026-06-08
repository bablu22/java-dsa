
public class OOPConcepts {

    public static void main(String[] args) {

        Student s = new Student("Bablu", 25);

        // s.name = "Bablu";
        // s.age = 25;

        s.introduce();
        BankAccount account = new BankAccount();
        account.deposit(1000);
        System.out.println("Balance: " + account.getBalance());

        Dog dog = new Dog();
        dog.eat();
        dog.sound();

        Circle circle = new Circle(5);
        circle.draw();

        PaypalPayment payment = new PaypalPayment();
        payment.pay(250);

        System.out.println("Area of Circle: " + MathUtils.calculateAreaOfCircle(5));

        Child child = new Child();
        child.display();

    }

}

// Class & Object

class Student {
    String name;
    int age;

    Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    void introduce() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }
}

// Encapsulation
class BankAccount {
    private double balance;

    public void deposit(double amount) {
        balance += amount;
    }

    public double getBalance() {
        return balance;
    }
}

// Inheritance
class Animal {

    void eat() {
        System.out.println("Eating...");
    }

    void sound() {
        System.out.println("Animal Sound");
    }

}

class Dog extends Animal {

    void bark() {
        System.out.println("Barking...");
    }

    // Method Overriding
    // Polymorphism -> One interface many forms
    @Override
    void sound() {
        System.out.println("Bark");
    }

}

// Abstraction
abstract class Shape {
    abstract void draw();
}

class Circle extends Shape {

    double radius;

    Circle(double radius) {
        this.radius = radius;
    }

    @Override
    void draw() {
        System.out.println("Drawing Circle with radius: " + radius);
    }
}

// Interface
interface Payment {
    void pay(double amount);
}

class PaypalPayment implements Payment {

    @Override
    public void pay(double amount) {
        System.out.println("Paying " + amount + " using Paypal");
    }
}

// Static
class MathUtils {
    static double PI = 3.14159;

    static double calculateAreaOfCircle(double radius) {
        return PI * radius * radius;
    }
}

// super
class Parent {
    void display() {
        System.out.println("Parent Class");
    }
}

class Child extends Parent {
    @Override
    void display() {
        super.display(); // Call parent method
        System.out.println("Child Class");
    }
}
