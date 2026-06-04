# Hashing — Revision Notes

## Quick Revision Points

- HashMap: O(1) average for put/get/remove; O(n) worst case (all collisions)
- HashSet: O(1) membership check — use when you only need presence, not key-value
- `getOrDefault(key, default)` — avoids null-check for counting
- `merge(key, 1, Integer::sum)` — cleaner frequency counting
- `computeIfAbsent(key, k -> new ArrayList<>())` — lazy-init for grouped values
- Prefix sum + HashMap: subarray sum = k in O(n)
- LinkedHashMap: insertion order preserved; TreeMap: sorted by key

## HashMap vs HashSet vs TreeMap vs LinkedHashMap

| Class | Ordered? | Sorted? | Use Case |
|-------|---------|---------|---------|
| HashMap | No | No | General key-value lookup |
| HashSet | No | No | Membership testing |
| LinkedHashMap | Insertion order | No | LRU Cache |
| TreeMap | Sorted | Yes | Range queries, floor/ceiling |
| TreeSet | Sorted | Yes | Sorted unique elements |

## Common Mistakes

1. Using `map.get(key)` without null check when key might be absent — use `getOrDefault`
2. `HashMap` is not thread-safe — use `ConcurrentHashMap` for multi-threading
3. Mutable objects as HashMap keys — hashCode/equals must be consistent
4. Iterating over a HashMap and modifying it → `ConcurrentModificationException`

## Interview Notes

| Problem | HashMap Pattern |
|---------|----------------|
| Two Sum | Complement lookup: `target - nums[i]` |
| Group Anagrams | Sort string as key |
| Subarray Sum = K | Prefix sum + frequency map |
| Longest Consecutive Sequence | Set membership check |
| Top K Frequent Elements | Frequency map + heap |
| Contains Duplicate | HashSet membership |
| First Non-Repeating Char | LinkedHashMap to maintain order |
| LRU Cache | LinkedHashMap with access order |
