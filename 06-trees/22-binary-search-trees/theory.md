# Binary Search Trees — Theory

## Concepts

A **Binary Search Tree (BST)** is a binary tree with a special ordering property:
- All values in the **left subtree** are **less than** the root
- All values in the **right subtree** are **greater than** the root
- This property holds for **every node** in the tree

This ordering makes search, insert, and delete O(log n) for balanced trees.

---

## BST Property

```
        8
       / \
      3   10
     / \    \
    1   6    14
       / \   /
      4   7 13
```

- Inorder traversal of BST gives a **sorted sequence**: 1, 3, 4, 6, 7, 8, 10, 13, 14

---

## Core Operations

### Search — O(log n) average, O(n) worst
```java
TreeNode search(TreeNode root, int target) {
    if (root == null || root.val == target) return root;
    if (target < root.val) return search(root.left, target);
    return search(root.right, target);
}
```

### Insert — O(log n) average
```java
TreeNode insert(TreeNode root, int val) {
    if (root == null) return new TreeNode(val);
    if (val < root.val) root.left = insert(root.left, val);
    else if (val > root.val) root.right = insert(root.right, val);
    return root;
}
```

### Delete — O(log n) average
```java
TreeNode delete(TreeNode root, int key) {
    if (root == null) return null;
    if (key < root.val) { root.left = delete(root.left, key); }
    else if (key > root.val) { root.right = delete(root.right, key); }
    else {
        // Node found — 3 cases:
        if (root.left == null) return root.right;   // no left child
        if (root.right == null) return root.left;   // no right child
        // Two children: replace with inorder successor (smallest in right subtree)
        TreeNode successor = findMin(root.right);
        root.val = successor.val;
        root.right = delete(root.right, successor.val);
    }
    return root;
}

TreeNode findMin(TreeNode node) {
    while (node.left != null) node = node.left;
    return node;
}
```

---

## BST Validation

```java
boolean isValidBST(TreeNode root) {
    return validate(root, Long.MIN_VALUE, Long.MAX_VALUE);
}

boolean validate(TreeNode node, long min, long max) {
    if (node == null) return true;
    if (node.val <= min || node.val >= max) return false;
    return validate(node.left, min, node.val)
        && validate(node.right, node.val, max);
}
```

---

## Kth Smallest Element in BST

```java
int count = 0, result = 0;
void kthSmallest(TreeNode root, int k) {
    if (root == null) return;
    kthSmallest(root.left, k);
    if (++count == k) { result = root.val; return; }
    kthSmallest(root.right, k);
}
// Inorder traversal counts nodes; kth node is the answer
```

---

## BST from Sorted Array

```java
TreeNode sortedArrayToBST(int[] nums, int l, int r) {
    if (l > r) return null;
    int mid = l + (r - l) / 2;
    TreeNode node = new TreeNode(nums[mid]);
    node.left = sortedArrayToBST(nums, l, mid - 1);
    node.right = sortedArrayToBST(nums, mid + 1, r);
    return node;
}
```

---

## BST vs Balanced BST

| Tree Type | Search | Insert | Delete |
|-----------|--------|--------|--------|
| Balanced BST (AVL, Red-Black) | O(log n) | O(log n) | O(log n) |
| Skewed BST (worst case) | O(n) | O(n) | O(n) |

Java's `TreeMap` and `TreeSet` use a Red-Black Tree internally — guaranteed O(log n).

---

## Java TreeMap / TreeSet

```java
TreeMap<Integer, String> map = new TreeMap<>();
map.put(5, "five"); map.put(3, "three"); map.put(7, "seven");
map.firstKey();    // 3 (smallest)
map.lastKey();     // 7 (largest)
map.floorKey(4);   // 3 (largest key ≤ 4)
map.ceilingKey(4); // 5 (smallest key ≥ 4)

TreeSet<Integer> set = new TreeSet<>();
set.floor(4);    // greatest element ≤ 4
set.ceiling(4);  // smallest element ≥ 4
```

---

## Complexity Analysis

| Operation | Average | Worst (skewed) |
|-----------|---------|----------------|
| Search | O(log n) | O(n) |
| Insert | O(log n) | O(n) |
| Delete | O(log n) | O(n) |
| Inorder traversal | O(n) | O(n) |

---

## Key Takeaways

1. BST inorder = sorted order — this is the foundation of many BST problems.
2. Delete is the trickiest operation — handle 3 cases: no child, one child, two children.
3. Two-children deletion: replace with **inorder successor** (min of right subtree) or inorder predecessor (max of left subtree).
4. Validate BST: pass valid range `(min, max)` down — don't just compare parent-child, check the full range.
5. Java's `TreeMap`/`TreeSet` are self-balancing BSTs (Red-Black) — use them when you need sorted order with O(log n) operations.
