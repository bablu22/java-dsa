# Time & Space Complexity — Theory

## Concepts

**Complexity analysis** measures how an algorithm's resource usage (time or memory) grows relative to input size `n`. It lets us compare algorithms without running them.

---

## Big O Notation

Big O describes the **upper bound** (worst-case) growth rate, ignoring constants and lower-order terms.

```
O(2n + 5)  →  O(n)     (drop constants)
O(n² + n)  →  O(n²)    (drop lower-order terms)
O(n log n + n) → O(n log n)
```

---

## Common Complexity Classes

| Complexity | Name | Example |
|------------|------|---------|
| O(1) | Constant | Array access, HashMap get |
| O(log n) | Logarithmic | Binary search, BST lookup |
| O(n) | Linear | Linear search, single loop |
| O(n log n) | Log-linear | Merge sort, heap sort |
| O(n²) | Quadratic | Bubble/selection sort, nested loops |
| O(n³) | Cubic | Matrix multiplication (naive) |
| O(2ⁿ) | Exponential | Generating all subsets |
| O(n!) | Factorial | Generating all permutations |

Growth order: O(1) < O(log n) < O(n) < O(n log n) < O(n²) < O(2ⁿ) < O(n!)

---

## Best, Average, and Worst Case

- **Best case (Ω):** Minimum operations for any input of size n
- **Average case (Θ):** Expected operations across all inputs
- **Worst case (O):** Maximum operations for any input of size n

We almost always care about **worst case** in interviews.

---

## How to Calculate Time Complexity

### Single Loop → O(n)
```java
for (int i = 0; i < n; i++) { }  // n iterations
```

### Nested Loop → O(n²)
```java
for (int i = 0; i < n; i++)
    for (int j = 0; j < n; j++) { }  // n * n = n²
```

### Halving Loop → O(log n)
```java
while (n > 0) n /= 2;  // n, n/2, n/4, ..., 1 → log₂(n) iterations
```

### Loop inside halving → O(n log n)
```java
while (n > 0) {
    for (int i = 0; i < n; i++) { }  // each level: n work, log n levels
    n /= 2;
}
```

### Recursive Calls
Use the **Master Theorem**: T(n) = aT(n/b) + f(n)

| Condition | Result |
|-----------|--------|
| f(n) = O(n^c) where c < log_b(a) | O(n^log_b(a)) |
| f(n) = O(n^c) where c = log_b(a) | O(n^c · log n) |
| f(n) = O(n^c) where c > log_b(a) | O(f(n)) |

Examples:
- Merge Sort: `T(n) = 2T(n/2) + O(n)` → O(n log n)
- Binary Search: `T(n) = T(n/2) + O(1)` → O(log n)

---

## Space Complexity

Measures extra memory used (not counting input).

| Situation | Space |
|-----------|-------|
| Fixed variables | O(1) |
| Array of size n | O(n) |
| 2D array n×n | O(n²) |
| Recursion depth d | O(d) call stack |
| Merge sort auxiliary | O(n) |

---

## Amortized Complexity

Average cost per operation over a sequence of operations.

Example: `ArrayList.add()` is O(n) when it resizes, but O(1) amortized because resizing is rare.

---

## Key Takeaways

1. Drop constants and lower-order terms — O(3n + 100) = O(n).
2. Nested loops multiply: two nested loops over n = O(n²); three = O(n³).
3. Each halving of the problem = one log factor: binary search, BST, divide-and-conquer.
4. Recursion space = O(call depth). Factorial recursion = O(n) stack space.
5. An O(n log n) algorithm is far better than O(n²) for large n.
6. Always state your time AND space complexity when explaining a solution in interviews.
