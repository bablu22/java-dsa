# Arrays — Revision Notes

## Quick Revision Points

- Array = contiguous memory, fixed size, O(1) index access
- Java arrays are 0-indexed; last element at `arr.length - 1`
- `int[] arr` holds a reference; the actual data lives on the heap
- Default values: `int[]` → 0, `boolean[]` → false, `Object[]` → null
- `arr.length` is a field, not a method (unlike String's `s.length()`)

---

## Interview Notes

### Choose Array When:
- You need constant-time random access
- Size is known in advance
- Cache performance matters (contiguous memory = cache friendly)

### Don't Use Array When:
- Frequent insertions/deletions in the middle (use LinkedList)
- Unknown or frequently changing size (use ArrayList)

### Patterns That Appear in 80% of Array Interview Questions:

| Pattern | When to Use | Complexity |
|---------|-------------|------------|
| Two Pointers | Sorted array, find pair, reverse | O(n) |
| Sliding Window | Subarray with constraint | O(n) |
| Prefix Sum | Range sum queries | O(n) build, O(1) query |
| Binary Search | Sorted array, find target | O(log n) |
| Kadane's | Maximum subarray sum | O(n) |
| Hash Map | Frequency, complement lookup | O(n) |
| Sort First | Simplify problem | O(n log n) |

---

## Common Mistakes

1. **Off-by-one in binary search**
   - Use `lo <= hi` (not `lo < hi`) when searching for exact target
   - Use `lo < hi` when finding boundary (left-most or right-most)
   - Mid = `lo + (hi - lo) / 2` — always this form

2. **Integer overflow in mid calculation**
   - Bad: `(lo + hi) / 2` — can overflow for large arrays
   - Good: `lo + (hi - lo) / 2`

3. **Modifying array while iterating**
   - Use a separate result array or two-pass approach

4. **Forgetting to handle empty array**
   - Always check `if (arr == null || arr.length == 0)` at the start

5. **Not copying when returning subarray**
   - `Arrays.copyOfRange(arr, l, r)` returns a NEW array

6. **Sliding window: forgetting to shrink the window**
   - Always shrink from the left when the window condition is violated

7. **Kadane's: initializing to 0 instead of arr[0]**
   - If all elements are negative, the answer is the max negative — not 0

---

## Tricky Interview Edge Cases

- All elements are the same
- All elements are negative
- Array has only one element
- Array is already sorted (ascending or descending)
- Duplicate elements in a problem that assumes uniqueness
- Target doesn't exist in the array
- Overflow when summing large values — consider `long`

---

## Key Formulas to Remember

```
Prefix sum range query: prefix[r + 1] - prefix[l]   (0-indexed)
Binary search mid:      lo + (hi - lo) / 2
Sliding window size:    right - left + 1
Rotate array by k:      effectively split at (n - k) and swap halves
```

---

## Must-Know Array Problems (with approach hints)

| Problem | Key Insight |
|---------|------------|
| Two Sum | HashMap: store complement |
| Best Time to Buy Sell Stock | Track running min price |
| Maximum Subarray | Kadane's algorithm |
| Product of Array Except Self | Left and right pass, no division |
| Find Duplicate Number | Floyd's cycle detection OR XOR |
| Merge Intervals | Sort by start, then greedy merge |
| 3Sum | Sort + two pointers, skip duplicates |
| Rotate Array | Reverse 3 times |
| Trap Rain Water | Two pointers or prefix max arrays |
| Search in Rotated Array | Modified binary search |
