# Recursion — Revision Notes

## Quick Revision Points

- Every recursive function needs: (1) base case, (2) progress toward base case
- Missing base case → infinite recursion → `StackOverflowError`
- Call stack depth = O(recursion depth) extra space
- Tail recursion: recursive call is last — some languages optimize this; Java does NOT
- Naive Fibonacci is O(2ⁿ) — use memoization to reduce to O(n)
- Fast power (exponentiation by squaring): O(log n)

## Recursion Mental Model

```
solve(n):
  if n is base case → return answer
  solve(smaller n) → use result to build answer for n
```

## Common Mistakes

1. No base case → infinite recursion
2. Base case wrong or too late → incorrect answers or stack overflow
3. Forgetting to `return` the recursive call result
4. Fibonacci: `fib(n) = fib(n-1) + fib(n-2)` without memoization is exponential
5. Modifying shared state inside recursion without backtracking — causes incorrect results

## Interview Notes

- "Print all subsets / permutations" → recursion + backtracking
- "Tree traversal" → recursion is natural (preorder, inorder, postorder)
- Time complexity from recurrence: `T(n) = T(n-1) + O(1)` → O(n); `T(n) = 2T(n/2) + O(n)` → O(n log n)
- Know how to convert simple recursion to iteration using an explicit stack
- Tower of Hanoi is a classic — explain in 3 steps: move n-1 disks to aux, move nth to target, move n-1 from aux to target
