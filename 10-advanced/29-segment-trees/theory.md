# Segment Trees — Theory

## Concepts

A **Segment Tree** is a tree data structure used for storing information about intervals (segments) of an array, enabling efficient **range queries** and **point/range updates**.

Built on the idea: each node stores the answer for a contiguous segment of the array.

Common use cases:
- Range sum query: sum of `arr[l..r]`
- Range minimum/maximum query
- Range updates (with lazy propagation)

---

## Structure

For an array of size `n`:
- Tree has at most `4n` nodes
- Stored in an array of size `4n`
- Node at index `i`: left child at `2i`, right child at `2i+1`
- Leaf nodes represent single elements

```
Array: [1, 3, 5, 7, 9, 11]

Segment Tree (Sum):
              36 [0..5]
           /          \
        9 [0..2]    27 [3..5]
        /   \        /    \
     4[0..1] 5    16[3..4] 11
     / \          /   \
    1   3        7     9
```

---

## Build — O(n)

```java
int[] tree;
int[] arr;

void build(int node, int start, int end) {
    if (start == end) {
        tree[node] = arr[start];  // leaf
    } else {
        int mid = (start + end) / 2;
        build(2 * node, start, mid);
        build(2 * node + 1, mid + 1, end);
        tree[node] = tree[2 * node] + tree[2 * node + 1];  // merge
    }
}
// Call: build(1, 0, n-1);
```

---

## Point Update — O(log n)

```java
void update(int node, int start, int end, int idx, int val) {
    if (start == end) {
        arr[idx] = val;
        tree[node] = val;
    } else {
        int mid = (start + end) / 2;
        if (idx <= mid) update(2 * node, start, mid, idx, val);
        else            update(2 * node + 1, mid + 1, end, idx, val);
        tree[node] = tree[2 * node] + tree[2 * node + 1];
    }
}
// Call: update(1, 0, n-1, idx, newVal);
```

---

## Range Query — O(log n)

```java
int query(int node, int start, int end, int l, int r) {
    if (r < start || end < l) return 0;        // out of range
    if (l <= start && end <= r) return tree[node]; // fully inside
    int mid = (start + end) / 2;
    int left = query(2 * node, start, mid, l, r);
    int right = query(2 * node + 1, mid + 1, end, l, r);
    return left + right;
}
// Call: query(1, 0, n-1, l, r);
```

---

## Lazy Propagation — Range Update in O(log n)

Lazy propagation defers updates — instead of propagating a range update all the way down immediately, we mark nodes as "lazy" and apply the update only when needed.

```java
int[] lazy;

void updateRange(int node, int start, int end, int l, int r, int val) {
    if (lazy[node] != 0) {               // apply pending lazy update
        tree[node] += (end - start + 1) * lazy[node];
        if (start != end) { lazy[2*node] += lazy[node]; lazy[2*node+1] += lazy[node]; }
        lazy[node] = 0;
    }
    if (r < start || end < l) return;    // out of range
    if (l <= start && end <= r) {        // fully in range
        tree[node] += (end - start + 1) * val;
        if (start != end) { lazy[2*node] += val; lazy[2*node+1] += val; }
        return;
    }
    int mid = (start + end) / 2;
    updateRange(2*node, start, mid, l, r, val);
    updateRange(2*node+1, mid+1, end, l, r, val);
    tree[node] = tree[2*node] + tree[2*node+1];
}
```

---

## Segment Tree for Different Queries

Change the **merge operation** to support different query types:

| Query Type | Merge Operation | Identity Value |
|-----------|----------------|----------------|
| Sum | `left + right` | `0` |
| Min | `Math.min(left, right)` | `Integer.MAX_VALUE` |
| Max | `Math.max(left, right)` | `Integer.MIN_VALUE` |
| GCD | `gcd(left, right)` | `0` |
| AND | `left & right` | `~0` |
| OR | `left \| right` | `0` |

---

## Complexity Analysis

| Operation | Time | Space |
|-----------|------|-------|
| Build | O(n) | O(4n) |
| Point Update | O(log n) | O(1) |
| Range Query | O(log n) | O(1) |
| Range Update (lazy) | O(log n) | O(4n) |

---

## When to Use Segment Trees

| Use Segment Tree when | Use Prefix Sum when |
|----------------------|---------------------|
| Array is frequently updated | Array is static (no updates) |
| Range queries + updates both needed | Only range queries needed |
| Range update + range query | Point update + range query |

---

## Key Takeaways

1. Segment tree = divide array into halves recursively; each node stores aggregate for its range.
2. Tree size = 4n — always allocate `new int[4 * n]`.
3. Base case: `start == end` → leaf node, store single element.
4. Three cases in query: fully outside (return identity), fully inside (return node), partial (recurse both).
5. Lazy propagation enables **range updates in O(log n)** — without it, range update is O(n).
6. Prefix sum is sufficient for static arrays — use segment tree only when updates are needed.
