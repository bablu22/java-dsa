# Segment Trees — Revision Notes

## Quick Revision Points

- Segment tree: range queries + point/range updates in O(log n)
- Build: O(n); Query: O(log n); Update: O(log n)
- Tree array size = 4n
- Node `i`: left child = `2i`, right child = `2i+1`
- Three query cases: out-of-range (return 0), fully-in-range (return node), partial (recurse both)
- Lazy propagation: defers range updates — O(log n) range update (without it: O(n))

## Core Template

```java
// Build
build(1, 0, n-1)

// Point Update
update(1, 0, n-1, idx, newVal)

// Range Query [l, r]
query(1, 0, n-1, l, r)
```

## Query Case Logic

```java
if (r < start || end < l) return identity;     // fully outside
if (l <= start && end <= r) return tree[node]; // fully inside
// else: partial overlap — recurse both halves
```

## Common Mistakes

1. Allocating tree of size `2n` instead of `4n` — causes index out of bounds
2. Wrong identity value for min (use `Integer.MAX_VALUE`) or max (use `Integer.MIN_VALUE`)
3. Forgetting to push down lazy values before recursing in lazy propagation
4. Using 0-indexed node vs 1-indexed — be consistent (1-indexed is standard)

## When to Use What

| Scenario | Best Tool |
|----------|----------|
| No updates, only range queries | Prefix Sum — O(1) query |
| Point update + range query | Segment Tree — O(log n) |
| Range update + range query | Segment Tree + Lazy Propagation |
| Range update, no query | Difference Array — O(1) update, O(n) rebuild |

## Interview Notes

- Segment trees are asked in competitive programming and hard interviews
- Common problems: Range Sum Query (Mutable), Count of Smaller Numbers After Self
- BIT (Binary Indexed Tree / Fenwick Tree) is simpler to implement but less flexible — O(log n) point update + prefix sum only
- Prefer Fenwick Tree for simple prefix sum with updates; Segment Tree for range query of any aggregate
