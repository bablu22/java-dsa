# Basic Sorting — Revision Notes

## Quick Revision Points

- Bubble Sort: swap adjacent pairs; each pass moves max to end — O(n²), stable
- Selection Sort: find min, place at front — O(n²), NOT stable
- Insertion Sort: insert into correct position; best for nearly-sorted — O(n²) avg, O(n) best, stable
- Merge Sort: divide-sort-merge; guaranteed O(n log n), stable, needs O(n) extra space
- Quick Sort: pivot partition; O(n log n) average, O(n²) worst, not stable, O(log n) space

## Stability Matters When

- Sorting objects by multiple fields (e.g., sort by name, then by age)
- Preserving original order of equal elements
- Use Merge Sort or Java's `Collections.sort()` when stability is needed

## Common Mistakes

1. Quick Sort worst case on already-sorted input — fix with random pivot
2. Forgetting the early-exit optimization in Bubble Sort (`if (!swapped) break`)
3. Off-by-one in Merge Sort: `mid = l + (r - l) / 2`, right half starts at `mid + 1`
4. Selection Sort is never better than O(n²) — don't use it for large arrays

## Interview Notes

- Know complexities cold — interviewers ask these frequently
- Merge Sort is preferred over Quick Sort when: stability required, worst-case O(n log n) required
- Quick Sort is preferred in practice: cache-friendly, in-place, low constant factor
- "Sort an almost-sorted array" → Insertion Sort
- Counting Sort / Radix Sort exist for special cases (integers in small range) → O(n+k)
- `Arrays.sort()` for primitives = dual-pivot QuickSort; for objects = Timsort
