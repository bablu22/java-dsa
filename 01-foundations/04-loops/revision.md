# Loops — Revision Notes

## Quick Revision Points

- `for`: use when number of iterations is known
- `while`: use when condition may change unpredictably
- `do-while`: always runs at least once
- `for-each`: cleanest for arrays/collections when index isn't needed
- `break` exits the loop; `continue` skips to next iteration
- Labeled `break outer` exits nested loops cleanly

## Common Mistakes

1. Off-by-one: `i < n` vs `i <= n` — draws a common source of bugs
2. Infinite loop: forgetting to update loop variable (`i++`)
3. Modifying collection while iterating with for-each → `ConcurrentModificationException`
4. Using `for-each` when you need the index — switch to index-based `for`
5. Nested `break` only exits the innermost loop — use labeled break for outer loops

## Interview Notes

- Single loop patterns: sum, max/min, frequency count, two-pointer
- Double loop patterns: all pairs, bubble sort, matrix traversal
- Pattern for "while condition, keep looping": `while (lo < hi)` in binary search style
- Reverse a string/array: loop from both ends `(left, right)` moving inward
- "Loop until convergence" appears in Floyd's cycle detection, binary search variants
