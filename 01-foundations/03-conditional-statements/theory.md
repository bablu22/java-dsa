# Conditional Statements — Theory

## Concepts

Conditional statements control the flow of execution based on boolean conditions. Java provides `if-else`, `switch`, and the ternary operator.

---

## 1. if Statement

```java
if (condition) {
    // executes if condition is true
}
```

## 2. if-else Statement

```java
if (condition) {
    // true branch
} else {
    // false branch
}
```

## 3. if-else-if Ladder

```java
if (score >= 90) {
    grade = 'A';
} else if (score >= 80) {
    grade = 'B';
} else if (score >= 70) {
    grade = 'C';
} else {
    grade = 'F';
}
```

Only the first matching condition executes. All others are skipped.

## 4. Nested if

```java
if (a > 0) {
    if (b > 0) {
        System.out.println("Both positive");
    }
}
```

---

## 5. switch Statement

```java
switch (day) {
    case 1:
        System.out.println("Monday");
        break;          // without break, falls through to next case
    case 2:
        System.out.println("Tuesday");
        break;
    default:
        System.out.println("Other");
}
```

- Works with: `int`, `char`, `String`, `enum` (not `long`, `float`, `double`)
- `default` runs when no case matches — always include it
- Without `break`, execution **falls through** to the next case

## 6. switch Expression (Java 14+)

```java
String result = switch (day) {
    case 1 -> "Monday";
    case 2 -> "Tuesday";
    default -> "Other";
};
```

Arrow syntax prevents fall-through automatically.

---

## 7. Ternary Operator (Compact Conditional)

```java
int max = (a > b) ? a : b;
String label = (n % 2 == 0) ? "even" : "odd";
```

Use for simple assignments — avoid nesting ternaries (it hurts readability).

---

## Short-Circuit Evaluation in Conditions

```java
// if arr is null, arr.length is never evaluated — no NullPointerException
if (arr != null && arr.length > 0) { ... }

// if x != 0 is false, 10/x is never evaluated — no division by zero
if (x != 0 && 10 / x > 1) { ... }
```

---

## Complexity Analysis

All conditional checks are O(1). A sequence of `n` independent conditions is still O(n) in code length but O(1) per check.

---

## Key Takeaways

1. Always include `break` in `switch` cases unless fall-through is intentional.
2. Use `switch` over long `if-else-if` chains when comparing a single variable to constants — it's cleaner and may be faster.
3. `switch` does not work with `long`, `float`, or `double`.
4. Short-circuit `&&` and `||` prevent null-pointer and division-by-zero errors — use them as guards.
5. Prefer ternary for simple two-branch assignments; use `if-else` for multi-line logic.
6. Java 14+ arrow `switch` expressions are cleaner and don't fall through.
