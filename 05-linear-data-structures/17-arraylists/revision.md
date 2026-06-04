# ArrayLists — Revision Notes

## Quick Revision Points

- Dynamic array backed by a fixed array; resizes by 1.5× when full
- `add()` to end: O(1) amortized; `add(index)`: O(n) — elements shift
- `get(i)`, `set(i)`: O(1) — random access same as array
- `remove(index)`: O(n) — elements shift left
- Stores objects only — primitives autoboxed (int → Integer)
- `ConcurrentModificationException` if you modify while iterating with for-each — use Iterator

## Common Mistakes

1. Removing elements with for-each → `ConcurrentModificationException`
2. `remove(0)` vs `remove(Integer.valueOf(0))` — first removes by index, second by value
3. Comparing with `==` instead of `.equals()` — objects, not primitives
4. Forgetting `.size()` changes during iteration when removing elements

## Interview Notes

- ArrayList vs LinkedList: ArrayList faster for random access (O(1)); LinkedList faster for front/middle insert (O(1) with iterator)
- When to use ArrayList: most cases — random access needed, size unknown
- When to use LinkedList: frequent insertions/deletions at front or middle
- Implement LRU Cache using `LinkedHashMap` (maintains insertion order) not plain ArrayList
- `Collections.frequency(list, val)` — count occurrences
- `Collections.max(list)`, `Collections.min(list)` — useful shortcuts
