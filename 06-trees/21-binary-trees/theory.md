# Binary Trees — Theory

## Concepts

A **tree** is a hierarchical, non-linear data structure consisting of nodes connected by edges. A **binary tree** is a tree where each node has at most two children: left and right.

```java
class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int val) { this.val = val; }
}
```

---

## Tree Terminology

| Term | Definition |
|------|-----------|
| Root | Top node with no parent |
| Leaf | Node with no children |
| Height | Longest path from root to a leaf |
| Depth | Distance from root to a node |
| Level | All nodes at the same depth |
| Subtree | A node and all its descendants |
| Parent / Child / Sibling | Relative node positions |

---

## Types of Binary Trees

| Type | Property |
|------|---------|
| Full | Every node has 0 or 2 children |
| Complete | All levels filled except last; last filled left to right |
| Perfect | All internal nodes have 2 children, all leaves at same level |
| Balanced | Height is O(log n) — AVL, Red-Black trees |
| Skewed | All nodes lean to one side — degenerates to a linked list |

---

## Tree Traversals

### 1. Inorder — Left, Root, Right
```java
void inorder(TreeNode node) {
    if (node == null) return;
    inorder(node.left);
    System.out.print(node.val + " ");
    inorder(node.right);
}
// BST inorder gives sorted sequence
```

### 2. Preorder — Root, Left, Right
```java
void preorder(TreeNode node) {
    if (node == null) return;
    System.out.print(node.val + " ");
    preorder(node.left);
    preorder(node.right);
}
// Used for: copy tree, serialize tree
```

### 3. Postorder — Left, Right, Root
```java
void postorder(TreeNode node) {
    if (node == null) return;
    postorder(node.left);
    postorder(node.right);
    System.out.print(node.val + " ");
}
// Used for: delete tree, evaluate expression tree
```

### 4. Level Order (BFS) — Level by Level
```java
List<List<Integer>> levelOrder(TreeNode root) {
    List<List<Integer>> result = new ArrayList<>();
    if (root == null) return result;
    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);
    while (!queue.isEmpty()) {
        int size = queue.size();
        List<Integer> level = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            TreeNode node = queue.poll();
            level.add(node.val);
            if (node.left != null) queue.offer(node.left);
            if (node.right != null) queue.offer(node.right);
        }
        result.add(level);
    }
    return result;
}
```

### 5. Iterative Inorder (using Stack)
```java
List<Integer> inorderIterative(TreeNode root) {
    List<Integer> result = new ArrayList<>();
    Deque<TreeNode> stack = new ArrayDeque<>();
    TreeNode curr = root;
    while (curr != null || !stack.isEmpty()) {
        while (curr != null) { stack.push(curr); curr = curr.left; }
        curr = stack.pop();
        result.add(curr.val);
        curr = curr.right;
    }
    return result;
}
```

---

## Common Tree Problems

### Height of Tree — O(n)
```java
int height(TreeNode root) {
    if (root == null) return 0;
    return 1 + Math.max(height(root.left), height(root.right));
}
```

### Diameter (Longest path between any two nodes) — O(n)
```java
int diameter = 0;
int dfs(TreeNode node) {
    if (node == null) return 0;
    int left = dfs(node.left), right = dfs(node.right);
    diameter = Math.max(diameter, left + right);
    return 1 + Math.max(left, right);
}
```

### Check Balanced — O(n)
```java
int checkHeight(TreeNode node) {
    if (node == null) return 0;
    int left = checkHeight(node.left);
    int right = checkHeight(node.right);
    if (left == -1 || right == -1 || Math.abs(left - right) > 1) return -1;
    return 1 + Math.max(left, right);
}
boolean isBalanced(TreeNode root) { return checkHeight(root) != -1; }
```

### Lowest Common Ancestor — O(n)
```java
TreeNode lca(TreeNode root, TreeNode p, TreeNode q) {
    if (root == null || root == p || root == q) return root;
    TreeNode left = lca(root.left, p, q);
    TreeNode right = lca(root.right, p, q);
    if (left != null && right != null) return root;
    return (left != null) ? left : right;
}
```

---

## Complexity Analysis

| Operation | Time | Space |
|-----------|------|-------|
| Traversal (any) | O(n) | O(h) — h = height |
| Height | O(n) | O(h) |
| Search | O(n) | O(h) |
| Level Order | O(n) | O(w) — w = max width |

For balanced tree: h = O(log n). For skewed: h = O(n).

---

## Key Takeaways

1. Almost all tree problems use recursion — trust the recursive leap of faith.
2. **Inorder** of BST = sorted sequence. **Preorder** = used for cloning/serialization.
3. DFS uses O(h) stack space; BFS uses O(w) queue space (w = max width).
4. The "return up" pattern: compute something at each node and propagate it up to the parent.
5. For problems involving two nodes (LCA, path between nodes), handle three cases: both in left subtree, both in right, or one on each side.
