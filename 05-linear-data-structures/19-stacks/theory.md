# Stacks — Theory

## Concepts

A **stack** is a LIFO (Last In, First Out) linear data structure. Think of a stack of plates — you add and remove from the top only.

Core operations:
- `push(x)` — add to top
- `pop()` — remove from top
- `peek()` — view top without removing
- `isEmpty()` — check if empty

---

## Implementation in Java

### Using Java's `Deque` (Recommended)
```java
Deque<Integer> stack = new ArrayDeque<>();
stack.push(1);         // addFirst — O(1)
stack.push(2);
stack.pop();           // removeFirst — O(1), returns 2
stack.peek();          // peekFirst — O(1), returns 1
stack.isEmpty();
```

> Prefer `ArrayDeque` over `Stack` class — `Stack` extends `Vector` (synchronized, slow).

### Custom Array-Based Stack
```java
class Stack {
    int[] arr;
    int top = -1;

    Stack(int capacity) { arr = new int[capacity]; }

    void push(int x) {
        if (top == arr.length - 1) throw new RuntimeException("Overflow");
        arr[++top] = x;
    }

    int pop() {
        if (top == -1) throw new RuntimeException("Underflow");
        return arr[top--];
    }

    int peek() { return arr[top]; }
    boolean isEmpty() { return top == -1; }
}
```

---

## Classic Stack Problems

### 1. Valid Parentheses
```java
boolean isValid(String s) {
    Deque<Character> stack = new ArrayDeque<>();
    for (char c : s.toCharArray()) {
        if (c == '(' || c == '{' || c == '[') stack.push(c);
        else {
            if (stack.isEmpty()) return false;
            char top = stack.pop();
            if (c == ')' && top != '(') return false;
            if (c == '}' && top != '{') return false;
            if (c == ']' && top != '[') return false;
        }
    }
    return stack.isEmpty();
}
```

### 2. Min Stack — O(1) minimum retrieval
```java
Deque<Integer> stack = new ArrayDeque<>();
Deque<Integer> minStack = new ArrayDeque<>();

void push(int x) {
    stack.push(x);
    minStack.push(minStack.isEmpty() ? x : Math.min(x, minStack.peek()));
}

void pop() { stack.pop(); minStack.pop(); }
int getMin() { return minStack.peek(); }
```

### 3. Next Greater Element
```java
int[] nextGreater(int[] arr) {
    int n = arr.length;
    int[] result = new int[n];
    Arrays.fill(result, -1);
    Deque<Integer> stack = new ArrayDeque<>();  // stores indices

    for (int i = 0; i < n; i++) {
        while (!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
            result[stack.pop()] = arr[i];
        }
        stack.push(i);
    }
    return result;
}
```

### 4. Evaluate Reverse Polish Notation
```java
int evalRPN(String[] tokens) {
    Deque<Integer> stack = new ArrayDeque<>();
    for (String t : tokens) {
        if ("+-*/".contains(t)) {
            int b = stack.pop(), a = stack.pop();
            switch (t) {
                case "+" -> stack.push(a + b);
                case "-" -> stack.push(a - b);
                case "*" -> stack.push(a * b);
                case "/" -> stack.push(a / b);
            }
        } else {
            stack.push(Integer.parseInt(t));
        }
    }
    return stack.pop();
}
```

### 5. Largest Rectangle in Histogram — O(n)
Use a monotonic stack to track bars in increasing height order.

---

## Monotonic Stack Pattern

A stack that is always maintained in increasing or decreasing order. Used for:
- Next Greater Element
- Previous Smaller Element
- Largest Rectangle in Histogram
- Daily Temperatures
- Trapping Rain Water

```java
// Monotonic increasing stack (bottom = smallest, top = largest)
for (int i = 0; i < n; i++) {
    while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
        stack.pop();
    }
    stack.push(i);
}
```

---

## Complexity Analysis

| Operation | Time | Space |
|-----------|------|-------|
| push | O(1) | — |
| pop | O(1) | — |
| peek | O(1) | — |
| isEmpty | O(1) | — |
| Stack of n elements | — | O(n) |

---

## Key Takeaways

1. Use `ArrayDeque` as a stack in Java — not the `Stack` class (it's outdated and synchronized).
2. Stack = LIFO. Any problem involving "most recent" or "undo" usually uses a stack.
3. Parentheses matching, expression evaluation, and browser history all use stacks.
4. **Monotonic stack** solves "next/previous greater/smaller" problems in O(n).
5. Min Stack trick: maintain a parallel min-stack that stores the minimum at each level.
