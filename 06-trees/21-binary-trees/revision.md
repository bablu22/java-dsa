# Binary Trees — Revision Notes

## Quick Revision Points

- TreeNode: `val`, `left`, `right`
- Height = longest root-to-leaf path; Depth = distance from root
- Inorder: Left→Root→Right (BST gives sorted order)
- Preorder: Root→Left→Right (serialization, copy)
- Postorder: Left→Right→Root (deletion, expression eval)
- Level Order: BFS with queue, process level by level
- DFS uses call stack O(h); BFS uses queue O(w)

## Must-Know Traversal Patterns

| Pattern | When |
|---------|------|
| Return value from left + right + root | Height, diameter, sum |
| Compare left and right subtrees | Symmetric, same tree |
| Carry info downward (param) | Path sum, max depth |
| BFS level tracking | Level order, zigzag, right view |

## Common Mistakes

1. Not checking `if (node == null) return ...` at start — NullPointerException
2. Using `==` to compare node values instead of `.val ==`
3. Diameter: updating global variable in recursive helper vs returning it
4. Level order: forgetting to snapshot `queue.size()` before inner loop

## Interview Notes

| Problem | Technique |
|---------|----------|
| Max depth | DFS: 1 + max(left, right) |
| Balanced tree | DFS returning -1 for unbalanced |
| Symmetric tree | Compare mirrored nodes |
| Same tree | Check val, left, right recursively |
| Path sum | Carry remaining target downward |
| LCA | Return node if found; root if both found on different sides |
| Diameter | Track max(left + right) as global; return max(left, right) + 1 |
| Serialize/Deserialize | Preorder with null markers |
| Right side view | BFS, take last element of each level |
