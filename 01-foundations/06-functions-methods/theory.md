# Functions & Methods — Theory

## Concepts

A **method** in Java is a named block of code that performs a specific task. It promotes code reuse, modularity, and readability.

```java
returnType methodName(parameter1, parameter2, ...) {
    // body
    return value; // if returnType is not void
}
```

---

## Method Components

| Component | Description |
|-----------|-------------|
| Return type | Type of value returned (`void` if nothing) |
| Method name | Identifier following camelCase |
| Parameters | Input values (optional) |
| Method body | Code that runs when called |
| Return statement | Sends a value back to the caller |

```java
// Example: returns the larger of two ints
static int max(int a, int b) {
    return (a > b) ? a : b;
}
```

---

## Types of Methods

### 1. Static Methods
Belong to the class, not an instance. Called with the class name.
```java
static int add(int a, int b) { return a + b; }
// Call: add(3, 5)  or  ClassName.add(3, 5)
```

### 2. Instance Methods
Belong to an object. Require an object to be called on.
```java
class Circle {
    double radius;
    double area() { return Math.PI * radius * radius; }
}
// Call: circle.area()
```

---

## Parameters vs Arguments

- **Parameters** — variables in the method declaration: `(int a, int b)`
- **Arguments** — actual values passed when calling: `add(3, 5)`

---

## Pass by Value

Java is **strictly pass-by-value**.

```java
void change(int x) { x = 100; }  // x is a copy
int n = 5;
change(n);
System.out.println(n);  // still 5 — original not changed
```

For objects, the **reference** is passed by value — so you can mutate the object's fields, but you cannot make the caller's variable point to a new object.

```java
void modifyArray(int[] arr) { arr[0] = 99; }  // modifies original array
void replaceArray(int[] arr) { arr = new int[5]; }  // caller's arr unchanged
```

---

## Method Overloading

Same method name, different parameter lists. Resolved at **compile time**.

```java
int add(int a, int b) { return a + b; }
double add(double a, double b) { return a + b; }
int add(int a, int b, int c) { return a + b + c; }
```

Overloading is NOT about return type — you cannot overload by return type alone.

---

## Variable Scope

```java
int x = 10;  // instance or class scope

static void method() {
    int y = 20;  // local scope — only visible inside this method
    // x is accessible if method is in same class
}
// y is not accessible here
```

---

## Varargs (Variable Arguments)

```java
int sum(int... nums) {
    int total = 0;
    for (int n : nums) total += n;
    return total;
}
// Call: sum(1, 2, 3, 4, 5)
```

---

## Recursion Basics

A method that calls itself. Must have a **base case** to stop.

```java
int factorial(int n) {
    if (n == 0) return 1;          // base case
    return n * factorial(n - 1);  // recursive case
}
```

---

## Math Utility Methods (java.lang.Math)

```java
Math.abs(-5)        // 5
Math.max(3, 7)      // 7
Math.min(3, 7)      // 3
Math.pow(2, 10)     // 1024.0
Math.sqrt(16)       // 4.0
Math.floor(3.7)     // 3.0
Math.ceil(3.2)      // 4.0
Math.log(Math.E)    // 1.0
Math.log10(1000)    // 3.0
```

---

## Complexity Analysis

Method calls themselves are O(1). The complexity of a method depends on its body.

---

## Key Takeaways

1. Break large problems into small methods — each method should do one thing.
2. Java is **pass-by-value** — primitives are copied; object references are copied (but the object itself is shared).
3. Method overloading is resolved at compile time (static polymorphism).
4. Recursion always needs a base case — missing it causes `StackOverflowError`.
5. Prefer `static` methods for utility functions that don't depend on object state.
6. `void` methods can have `return;` (no value) to exit early.
