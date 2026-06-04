# Recursion — Theory

## Concepts

**Recursion** is a technique where a method calls itself to solve a smaller version of the same problem. Every recursive solution has:

1. **Base case** — the condition that stops recursion
2. **Recursive case** — the call that reduces the problem toward the base case

```java
returnType solve(params) {
    if (base condition) return base value;  // base case
    return solve(smaller params);           // recursive case
}
```

---

## How Recursion Works — The Call Stack

Each recursive call creates a **stack frame** on the call stack containing local variables and the return address. Frames are popped as calls return.

```
factorial(4)
  → factorial(3)
      → factorial(2)
          → factorial(1)
              → factorial(0) returns 1
          ← returns 1 * 1 = 1
      ← returns 2 * 1 = 2
  ← returns 3 * 2 = 6
← returns 4 * 6 = 24
```

---

## Classic Recursive Problems

### 1. Factorial
```java
int factorial(int n) {
    if (n == 0) return 1;           // base case
    return n * factorial(n - 1);    // recursive case
}
// T(n) = O(n), Space = O(n) stack
```

### 2. Fibonacci
```java
int fib(int n) {
    if (n <= 1) return n;
    return fib(n - 1) + fib(n - 2);
}
// T(n) = O(2ⁿ) — exponential, very slow without memoization
```

### 3. Power (a^b)
```java
double power(double base, int exp) {
    if (exp == 0) return 1;
    if (exp % 2 == 0) {
        double half = power(base, exp / 2);
        return half * half;          // fast power: O(log n)
    }
    return base * power(base, exp - 1);
}
```

### 4. Sum of digits
```java
int sumDigits(int n) {
    if (n < 10) return n;
    return n % 10 + sumDigits(n / 10);
}
```

### 5. Tower of Hanoi
```java
void hanoi(int n, char from, char to, char aux) {
    if (n == 1) { System.out.println("Move disk 1: " + from + " → " + to); return; }
    hanoi(n - 1, from, aux, to);
    System.out.println("Move disk " + n + ": " + from + " → " + to);
    hanoi(n - 1, aux, to, from);
}
// T(n) = O(2ⁿ) — minimum 2ⁿ - 1 moves required
```

### 6. Binary Search (Recursive)
```java
int binarySearch(int[] arr, int lo, int hi, int target) {
    if (lo > hi) return -1;
    int mid = lo + (hi - lo) / 2;
    if (arr[mid] == target) return mid;
    if (arr[mid] < target) return binarySearch(arr, mid + 1, hi, target);
    return binarySearch(arr, lo, mid - 1, target);
}
// T(n) = O(log n), Space = O(log n) stack
```

---

## Recursion Types

### 1. Direct Recursion — method calls itself
```java
void f() { f(); }
```

### 2. Indirect Recursion — A calls B, B calls A
```java
void f() { g(); }
void g() { f(); }
```

### 3. Tail Recursion — recursive call is the last operation
```java
void count(int n) {
    if (n == 0) return;
    System.out.println(n);
    count(n - 1);  // last action — compiler can optimize to iteration
}
```

---

## Recursion vs Iteration

| Aspect | Recursion | Iteration |
|--------|-----------|-----------|
| Readability | Often cleaner for tree/graph problems | Cleaner for simple loops |
| Space | O(depth) call stack | O(1) usually |
| Speed | Function call overhead | Faster in practice |
| Risk | Stack overflow for deep recursion | No stack risk |

---

## Complexity Analysis

| Problem | Time | Space |
|---------|------|-------|
| Factorial | O(n) | O(n) |
| Fibonacci (naive) | O(2ⁿ) | O(n) |
| Binary Search | O(log n) | O(log n) |
| Fast Power | O(log n) | O(log n) |
| Tower of Hanoi | O(2ⁿ) | O(n) |

---

## Key Takeaways

1. Always define the base case first — it's the most important part.
2. Ensure every recursive call makes progress toward the base case.
3. Recursion uses O(depth) stack space — can cause `StackOverflowError` for very deep calls.
4. Naive Fibonacci is O(2ⁿ) — always use memoization or DP for it.
5. Fast power (exponentiation by squaring) reduces O(n) to O(log n).
6. Tree and graph traversals are naturally recursive — master this pattern.
