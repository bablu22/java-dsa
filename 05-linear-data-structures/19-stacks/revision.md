# Stacks — Revision Notes

## Quick Revision Points

- LIFO: Last In, First Out
- Use `ArrayDeque` not `Stack` (Stack is synchronized and slow)
- `push()` adds to top, `pop()` removes from top, `peek()` reads top — all O(1)
- Parentheses matching: push open brackets, pop and match on close brackets
- Monotonic stack: keep stack in sorted order by popping when invariant breaks
- Min Stack: parallel stack tracking minimums in sync with main stack

## Deque as Stack Quick Reference

```java
Deque<Integer> stack = new ArrayDeque<>();
stack.push(x);   // addFirst
stack.pop();     // removeFirst
stack.peek();    // peekFirst
```

## Common Mistakes

1. Using `Stack` class instead of `ArrayDeque` — legacy, synchronized, slower
2. Popping from empty stack → `NoSuchElementException` — check `isEmpty()` first
3. Monotonic stack: forgetting to process remaining elements in stack after the loop
4. Forgetting `.isEmpty()` check before `.peek()` → exception

## Interview Notes

| Problem | Pattern |
|---------|---------|
| Valid Parentheses | Push open, match on close |
| Min Stack | Two stacks in parallel |
| Daily Temperatures | Monotonic decreasing stack |
| Next Greater Element | Monotonic stack with indices |
| Largest Rectangle | Monotonic increasing stack |
| Trapping Rain Water | Stack or two-pointer |
| Evaluate RPN | Operand stack |
| Decode String | Stack for counts and strings |
