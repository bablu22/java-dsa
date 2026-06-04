# Time & Space Complexity — Revision Notes

## Quick Revision Points

- Big O = upper bound (worst case); ignore constants and lower-order terms
- O(1) < O(log n) < O(n) < O(n log n) < O(n²) < O(2ⁿ) < O(n!)
- Single loop → O(n); nested loops → O(n²); halving loop → O(log n)
- Recursion depth = O(depth) stack space
- Amortized O(1): ArrayList add — rare O(n) resize averages out

## Pattern → Complexity Map

| Code Pattern | Time |
|-------------|------|
| `for i in 0..n` | O(n) |
| `for i; for j in 0..n` | O(n²) |
| `while n > 0: n /= 2` | O(log n) |
| `for i; n /= 2 each outer` | O(n log n) |
| Recursion: f(n) = 2f(n/2) + O(n) | O(n log n) |
| Recursion: f(n) = f(n/2) + O(1) | O(log n) |
| All subsets | O(2ⁿ) |
| All permutations | O(n!) |

## Common Mistakes

1. Forgetting to count the recursion stack space (it's O(depth))
2. Assuming nested loops are always O(n²) — check if inner loop runs less than n times
3. Confusing O(n log n) with O(n²) — they are significantly different for large n
4. Counting input space as "extra" space — space complexity counts only auxiliary space

## Interview Notes

- Always state "Time: O(...), Space: O(...)" before and after coding
- Interviewers expect you to know: array ops, hashmap ops, sort complexity by heart
- "Can we do better?" usually means: can we go from O(n²) to O(n log n), or O(n log n) to O(n)?
- Common trade-off: use extra O(n) space to improve time from O(n²) to O(n) (hash map trick)
