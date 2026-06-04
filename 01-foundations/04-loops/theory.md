# Loops — Theory

## Concepts

Loops repeatedly execute a block of code while a condition is true. Java provides four loop constructs: `for`, `while`, `do-while`, and enhanced `for-each`.

---

## 1. for Loop

Best when the number of iterations is known.

```java
for (initialization; condition; update) {
    // body
}

for (int i = 0; i < n; i++) {
    System.out.println(i);
}
```

- Initialization runs once
- Condition checked before each iteration
- Update runs after each iteration

---

## 2. while Loop

Best when iterations depend on a condition that may change inside the loop.

```java
while (condition) {
    // body
}

int i = 0;
while (i < n) {
    System.out.println(i);
    i++;
}
```

---

## 3. do-while Loop

Executes the body **at least once**, then checks the condition.

```java
do {
    // body
} while (condition);

int i = 0;
do {
    System.out.println(i);
    i++;
} while (i < n);
```

---

## 4. Enhanced for-each Loop

Best for iterating over arrays and collections without needing an index.

```java
int[] arr = {1, 2, 3, 4, 5};
for (int x : arr) {
    System.out.println(x);
}

List<String> list = List.of("a", "b", "c");
for (String s : list) {
    System.out.println(s);
}
```

---

## 5. break and continue

```java
// break: exits the loop immediately
for (int i = 0; i < 10; i++) {
    if (i == 5) break;   // stops at 5
}

// continue: skips the current iteration, goes to next
for (int i = 0; i < 10; i++) {
    if (i % 2 == 0) continue;  // skips even numbers
    System.out.println(i);     // prints 1 3 5 7 9
}
```

---

## 6. Labeled break/continue (for nested loops)

```java
outer:
for (int i = 0; i < 3; i++) {
    for (int j = 0; j < 3; j++) {
        if (j == 1) break outer;  // exits both loops
    }
}
```

---

## 7. Nested Loops

```java
for (int i = 1; i <= n; i++) {
    for (int j = 1; j <= i; j++) {
        System.out.print("* ");
    }
    System.out.println();
}
```

Nested loops form the basis of pattern problems and matrix traversal.

---

## Common Loop Patterns

### Sum of array
```java
int sum = 0;
for (int x : arr) sum += x;
```

### Count occurrences
```java
int count = 0;
for (int x : arr) if (x == target) count++;
```

### Find index of element
```java
int idx = -1;
for (int i = 0; i < arr.length; i++) {
    if (arr[i] == target) { idx = i; break; }
}
```

### Loop from right to left
```java
for (int i = arr.length - 1; i >= 0; i--) { ... }
```

---

## Complexity Analysis

| Loop Type | Time Complexity |
|-----------|----------------|
| Single loop of n | O(n) |
| Nested loop n × n | O(n²) |
| Loop halving each time | O(log n) |
| Loop inside loop, inner varies | Depends — analyze carefully |

---

## Key Takeaways

1. Prefer `for-each` when you don't need the index — it's cleaner and less error-prone.
2. Use `for` when the iteration count is known; `while` when it depends on runtime state.
3. `do-while` guarantees at least one execution — useful for menus, input validation.
4. Nested loops of depth k over n elements → O(nᵏ). Two nested loops = O(n²).
5. `break` with a label is the cleanest way to exit nested loops in Java (no `goto`).
6. Always ensure the loop will eventually terminate — check that the update progresses toward the exit condition.
