# Object-Oriented Programming — Theory

## Concepts

OOP organizes code around **objects** — instances of **classes** that bundle data (fields) and behaviour (methods) together.

The four pillars of OOP: **Encapsulation, Inheritance, Polymorphism, Abstraction**.

---

## Class and Object

```java
// Class — blueprint
class Dog {
    String name;   // field
    int age;

    // Constructor
    Dog(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Method
    void bark() {
        System.out.println(name + " says: Woof!");
    }
}

// Object — instance of the class
Dog d = new Dog("Rex", 3);
d.bark();
```

---

## 1. Encapsulation

Hiding internal data using `private` fields and providing controlled access via `public` getters and setters.

```java
class BankAccount {
    private double balance;   // hidden

    public double getBalance() { return balance; }
    public void deposit(double amount) {
        if (amount > 0) balance += amount;
    }
}
```

---

## 2. Inheritance

A subclass **inherits** fields and methods from a superclass. Use `extends`.

```java
class Animal {
    String name;
    void eat() { System.out.println(name + " eats."); }
}

class Dog extends Animal {
    void bark() { System.out.println(name + " barks."); }
}

Dog d = new Dog();
d.eat();   // inherited
d.bark();  // own method
```

Java supports **single inheritance** (one parent class). Use interfaces for multiple inheritance of type.

---

## 3. Polymorphism

**Compile-time (Overloading):** Same method name, different parameters.

**Runtime (Overriding):** Subclass provides its own implementation of a parent's method.

```java
class Animal { void sound() { System.out.println("..."); } }
class Dog extends Animal {
    @Override
    void sound() { System.out.println("Woof"); }
}

Animal a = new Dog();  // upcasting
a.sound();             // prints "Woof" — runtime polymorphism
```

---

## 4. Abstraction

Hiding implementation details. Achieved via **abstract classes** and **interfaces**.

### Abstract Class
```java
abstract class Shape {
    abstract double area();  // no body
    void display() { System.out.println("Area: " + area()); }
}

class Circle extends Shape {
    double r;
    Circle(double r) { this.r = r; }
    double area() { return Math.PI * r * r; }
}
```

### Interface
```java
interface Drawable {
    void draw();  // implicitly public abstract
}

interface Resizable {
    void resize(double factor);
}

class Square implements Drawable, Resizable {
    public void draw() { ... }
    public void resize(double factor) { ... }
}
```

Key differences:
| | Abstract Class | Interface |
|--|----------------|-----------|
| Fields | Can have state | Only constants (`static final`) |
| Methods | Abstract + concrete | Abstract (+ `default` in Java 8+) |
| Inheritance | `extends` (single) | `implements` (multiple) |
| Constructor | Yes | No |

---

## Constructors

```java
class Point {
    int x, y;

    Point() { this(0, 0); }              // default — calls other constructor
    Point(int x, int y) { this.x = x; this.y = y; }
}
```

- Same name as the class, no return type
- Called automatically when `new` is used
- If you don't define one, Java provides a no-arg constructor
- `this(...)` calls another constructor in the same class (constructor chaining)
- `super(...)` calls the parent class constructor

---

## Access Modifiers

| Modifier | Class | Package | Subclass | World |
|----------|-------|---------|---------|-------|
| `public` | ✅ | ✅ | ✅ | ✅ |
| `protected` | ✅ | ✅ | ✅ | ❌ |
| (default) | ✅ | ✅ | ❌ | ❌ |
| `private` | ✅ | ❌ | ❌ | ❌ |

---

## this and super Keywords

```java
class Animal {
    String name;
    Animal(String name) { this.name = name; }
    void sound() { System.out.println("generic"); }
}

class Dog extends Animal {
    Dog(String name) {
        super(name);        // calls Animal constructor
    }

    @Override
    void sound() {
        super.sound();      // calls Animal's sound()
        System.out.println("Woof");
    }
}
```

---

## static Keyword

```java
class Counter {
    static int count = 0;  // shared across all instances
    int id;

    Counter() {
        count++;
        this.id = count;
    }

    static int getCount() { return count; }
}
```

---

## Complexity Analysis

OOP constructs have no inherent time complexity — they're design patterns. Object creation is O(1).

---

## Key Takeaways

1. **Encapsulate** data with `private` — expose only what's needed.
2. **Inherit** to reuse code; **override** to customize behaviour.
3. Program to **interfaces** (or abstract classes), not concrete implementations — enables flexible design.
4. `@Override` annotation is not required but always use it — the compiler will catch errors if the method signature doesn't match.
5. Java does not support multiple class inheritance — use interfaces for that.
6. `static` belongs to the class, not instances — use for utility methods and shared counters.
