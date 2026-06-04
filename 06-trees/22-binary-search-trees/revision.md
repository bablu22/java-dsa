# Binary Search Trees — Revision Notes

## Quick Revision Points

- BST property: left < root < right (holds for every node)
- Inorder traversal always gives sorted sequence
- Search/Insert/Delete: O(log n) balanced, O(n) skewed
- Delete (2 children): replace with inorder successor (min of right subtree)
- Validate BST: pass `(min, max)` range down — simple parent-child check is WRONG
- `TreeMap`/`TreeSet` in Java = Red-Black tree = always balanced O(log n)

## Common Mistakes

1. BST validation: checking only parent vs child misses this invalid case:
   ```
       5
      / \
     1   4
        / \
       3   6
   ```
   4 is right child of 5 but 3 < 5 — invalid BST
2. Delete: forgetting the two-children case (replace with successor, don't just remove)
3. Assuming BST is always balanced — worst case is O(n) for sorted insertions

## Interview Notes

| Problem | Key Insight |
|---------|------------|
| Validate BST | Pass (min, max) range downward |
| Kth Smallest | Inorder traversal — count nodes |
| BST from Sorted Array | Pick mid as root recursively |
| BST Iterator | Inorder traversal with explicit stack |
| Floor/Ceiling in BST | Navigate left/right and track candidates |
| LCA in BST | Both p,q < root → go left; both > root → go right; else root is LCA |
| Convert BST to sorted DLL | Inorder with prev pointer |

## When to Use TreeMap/TreeSet

- Need sorted iteration over a map/set
- Need floor/ceiling queries: `floorKey()`, `ceilingKey()`
- Need first/last element efficiently
