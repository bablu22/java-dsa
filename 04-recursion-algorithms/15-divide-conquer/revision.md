# Divide & Conquer — Revision Notes

## Quick Revision Points

- 3 steps: Divide → Conquer (recurse) → Combine
- Binary Search: 1 recursive call → O(log n)
- Merge Sort: 2 recursive calls + O(n) merge → O(n log n)
- Quick Sort: 2 recursive calls + O(n) partition → O(n log n) average
- D&C gets O(log n) levels because we halve the problem each time
- Master Theorem: `T(n) = aT(n/b) + f(n)`

## Master Theorem Quick Reference

| Recurrence | Result |
|-----------|--------|
| `T(n) = T(n/2) + O(1)` | O(log n) — Binary Search |
| `T(n) = 2T(n/2) + O(n)` | O(n log n) — Merge Sort |
| `T(n) = T(n-1) + O(1)` | O(n) — linear recursion |
| `T(n) = 2T(n-1) + O(1)` | O(2ⁿ) — Tower of Hanoi |

## Common Mistakes

1. Forgetting the `combine` step — D&C is useless if you don't merge results
2. Off-by-one in `mid`: always use `mid = lo + (hi - lo) / 2`
3. Right half in merge sort starts at `mid + 1`, not `mid`
4. Not accounting for stack space in space complexity

## Interview Notes

- "Explain how merge sort works" is a classic — walk through divide + merge steps
- Count inversions in an array → modified merge sort
- Closest pair of points → D&C with strip optimization → O(n log n)
- "Median of two sorted arrays" (LC #4) → binary search D&C → O(log(m+n))
