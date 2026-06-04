# Heaps — Revision Notes

## Quick Revision Points

- Min-Heap: parent ≤ children, root = minimum
- Max-Heap: parent ≥ children, root = maximum
- Java `PriorityQueue` = min-heap by default
- Insert (bubble up): O(log n); Extract (bubble down): O(log n); Peek: O(1)
- Build heap from array: O(n) — not O(n log n)
- Kth largest: use min-heap of size k (not max-heap!)

## Index Formula (Array-based heap)

```
Parent of i:      (i - 1) / 2
Left child of i:  2 * i + 1
Right child of i: 2 * i + 2
Last non-leaf:    n/2 - 1
```

## Common Mistakes

1. Using max-heap for "Kth largest" — you want a min-heap of size k (the kth largest is the minimum of the top-k)
2. Forgetting `peek()` doesn't remove — use `poll()` to extract
3. Custom comparator order: `(a, b) -> a - b` = min-heap (ascending); `(a, b) -> b - a` = max-heap
4. Build heap: start from `n/2 - 1` downward — missing this gives O(n log n) instead of O(n)

## Interview Notes

| Problem | Heap Pattern |
|---------|-------------|
| Kth largest element | Min-heap of size k |
| Top K frequent | Min-heap keyed by frequency |
| Merge K sorted lists | Min-heap of (value, list-index) |
| Find median from stream | Max-heap (left) + Min-heap (right) |
| Task Scheduler | Max-heap of frequencies |
| K Closest Points | Max-heap of size k (or min-heap + extract k) |
| Reorganize String | Max-heap of char frequencies |

## Median from Stream Pattern

```java
// left = max-heap (lower half), right = min-heap (upper half)
// Invariant: left.size() == right.size() or left.size() == right.size() + 1
double findMedian() {
    if (left.size() > right.size()) return left.peek();
    return (left.peek() + right.peek()) / 2.0;
}
```
