# Patterns — Theory

## Concepts

Pattern problems train you to think in terms of **nested loops**, **row-column relationships**, and **incremental logic**. They are common in early interviews and entrance exams.

The key skill is: for each cell `(row, col)`, determine **what to print** based on its position.

---

## Pattern 1 — Right Triangle (Stars)

```
*
* *
* * *
* * * *
* * * * *
```

```java
for (int i = 1; i <= n; i++) {
    for (int j = 1; j <= i; j++) {
        System.out.print("* ");
    }
    System.out.println();
}
```

---

## Pattern 2 — Inverted Right Triangle

```
* * * * *
* * * *
* * *
* *
*
```

```java
for (int i = n; i >= 1; i--) {
    for (int j = 1; j <= i; j++) {
        System.out.print("* ");
    }
    System.out.println();
}
```

---

## Pattern 3 — Number Triangle

```
1
1 2
1 2 3
1 2 3 4
```

```java
for (int i = 1; i <= n; i++) {
    for (int j = 1; j <= i; j++) {
        System.out.print(j + " ");
    }
    System.out.println();
}
```

---

## Pattern 4 — Repeated Row Number

```
1
2 2
3 3 3
4 4 4 4
```

```java
for (int i = 1; i <= n; i++) {
    for (int j = 1; j <= i; j++) {
        System.out.print(i + " ");
    }
    System.out.println();
}
```

---

## Pattern 5 — Pyramid (Centered)

```
    *
   * *
  * * *
 * * * *
* * * * *
```

```java
for (int i = 1; i <= n; i++) {
    // spaces
    for (int j = 1; j <= n - i; j++) System.out.print(" ");
    // stars
    for (int j = 1; j <= i; j++) System.out.print("* ");
    System.out.println();
}
```

---

## Pattern 6 — Diamond

```
    *
   * *
  * * *
   * *
    *
```

```java
// Upper half
for (int i = 1; i <= n; i++) {
    for (int j = 1; j <= n - i; j++) System.out.print(" ");
    for (int j = 1; j <= i; j++) System.out.print("* ");
    System.out.println();
}
// Lower half
for (int i = n - 1; i >= 1; i--) {
    for (int j = 1; j <= n - i; j++) System.out.print(" ");
    for (int j = 1; j <= i; j++) System.out.print("* ");
    System.out.println();
}
```

---

## Pattern 7 — Floyd's Triangle (Consecutive Numbers)

```
1
2 3
4 5 6
7 8 9 10
```

```java
int num = 1;
for (int i = 1; i <= n; i++) {
    for (int j = 1; j <= i; j++) {
        System.out.print(num++ + " ");
    }
    System.out.println();
}
```

---

## Pattern 8 — Pascal's Triangle

```
    1
   1 1
  1 2 1
 1 3 3 1
1 4 6 4 1
```

```java
for (int i = 0; i < n; i++) {
    int val = 1;
    for (int j = 0; j <= i; j++) {
        System.out.print(val + " ");
        val = val * (i - j) / (j + 1);
    }
    System.out.println();
}
```

---

## Pattern 9 — Hollow Rectangle

```
* * * * *
*       *
*       *
* * * * *
```

```java
for (int i = 1; i <= rows; i++) {
    for (int j = 1; j <= cols; j++) {
        if (i == 1 || i == rows || j == 1 || j == cols)
            System.out.print("* ");
        else
            System.out.print("  ");
    }
    System.out.println();
}
```

---

## The Thinking Framework

For any pattern problem:
1. Count the rows → outer loop
2. For each row, count what's printed → inner loop
3. Express the inner loop bound/value as a function of the row number `i`
4. Separate spaces, symbols, and newlines

---

## Complexity Analysis

| Pattern | Time | Space |
|---------|------|-------|
| All patterns above | O(n²) | O(1) |

---

## Key Takeaways

1. Every pattern is controlled by the relationship between `i` (row) and `j` (column).
2. Printing spaces before stars creates alignment — count spaces as `n - i`.
3. Track a separate counter variable (like `num` in Floyd's Triangle) when the value is independent of position.
4. Pascal's Triangle uses the formula: `C(i, j) = C(i, j-1) * (i - j + 1) / j`.
5. Hollow patterns: print edge cells differently using `if` conditions.
