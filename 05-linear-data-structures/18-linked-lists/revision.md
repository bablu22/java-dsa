# Linked Lists — Revision Notes

## Quick Revision Points

- Nodes connected via pointers — NOT contiguous memory
- Insert at head: O(1); insert at tail (no tail pointer): O(n)
- Search: always O(n) — no random access
- Dummy head node simplifies edge cases — use it always
- Fast/slow pointers: find middle, detect cycle, find cycle start
- Reverse in-place: `prev = null`, iterate with `curr.next = prev` pattern

## Pointer Tricks

| Technique | Use Case |
|-----------|---------|
| Fast/slow pointer | Middle, cycle detection |
| Dummy head | Avoid null checks on head deletion |
| Two-pass | Nth from end (count total, then walk n steps) |
| Reverse sections | k-group reverse, palindrome check |

## Common Mistakes

1. Losing reference: always save `next` before changing `curr.next`
2. Not handling empty list (`head == null`) as first check
3. Off-by-one in "nth from end": careful with the `n` offset
4. Cycle detection: if fast reaches null, there is no cycle — not a bug

## Interview Notes

| Problem | Key Technique |
|---------|--------------|
| Reverse LL | 3-pointer: prev, curr, next |
| Find middle | Fast/slow pointer |
| Detect cycle | Floyd's algorithm |
| Find cycle start | Move one pointer to head after meeting |
| Merge two sorted lists | Dummy head + compare |
| Remove nth from end | Two-pointer with n gap |
| Palindrome check | Find middle, reverse second half, compare |
| LRU Cache | HashMap + Doubly linked list |
| Intersection point | Advance the longer list by difference |
