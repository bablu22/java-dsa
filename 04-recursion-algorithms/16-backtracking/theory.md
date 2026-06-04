# Backtracking — Theory

## Concepts

**Backtracking** is a refined brute-force technique that builds solutions incrementally and **abandons (backtracks)** a partial solution as soon as it determines it cannot lead to a valid complete solution.

It explores a **state space tree** — a tree of all possible partial solutions — and prunes branches that cannot yield valid answers.

---

## Template

```java
void backtrack(result, current, params) {
    if (base case / solution found) {
        result.add(new copy of current);
        return;
    }

    for (each choice available) {
        if (choice is valid) {
            make the choice;        // add to current
            backtrack(...);         // explore
            undo the choice;        // remove from current (backtrack)
        }
    }
}
```

---

## Classic Problems

### 1. All Subsets (Power Set) — O(2ⁿ)
```java
void subsets(int[] nums, int start, List<Integer> current, List<List<Integer>> result) {
    result.add(new ArrayList<>(current));  // every state is a valid subset
    for (int i = start; i < nums.length; i++) {
        current.add(nums[i]);
        subsets(nums, i + 1, current, result);
        current.remove(current.size() - 1);  // backtrack
    }
}
```

### 2. All Permutations — O(n! × n)
```java
void permutations(int[] nums, boolean[] used, List<Integer> current, List<List<Integer>> result) {
    if (current.size() == nums.length) { result.add(new ArrayList<>(current)); return; }
    for (int i = 0; i < nums.length; i++) {
        if (used[i]) continue;
        used[i] = true;
        current.add(nums[i]);
        permutations(nums, used, current, result);
        current.remove(current.size() - 1);
        used[i] = false;
    }
}
```

### 3. Combination Sum — O(2ⁿ)
```java
void combinationSum(int[] candidates, int target, int start,
                    List<Integer> current, List<List<Integer>> result) {
    if (target == 0) { result.add(new ArrayList<>(current)); return; }
    for (int i = start; i < candidates.length; i++) {
        if (candidates[i] > target) break;  // pruning (sort first)
        current.add(candidates[i]);
        combinationSum(candidates, target - candidates[i], i, current, result);
        current.remove(current.size() - 1);
    }
}
```

### 4. N-Queens — O(n!)
```java
void solveNQueens(int n, int row, int[] cols, List<String[]> result) {
    if (row == n) { result.add(buildBoard(cols, n)); return; }
    for (int col = 0; col < n; col++) {
        if (isValid(cols, row, col)) {
            cols[row] = col;
            solveNQueens(n, row + 1, cols, result);
            cols[row] = -1;  // backtrack
        }
    }
}
```

### 5. Word Search on Grid — O(m × n × 4^L)
```java
boolean dfs(char[][] board, String word, int i, int j, int idx) {
    if (idx == word.length()) return true;
    if (i < 0 || i >= board.length || j < 0 || j >= board[0].length) return false;
    if (board[i][j] != word.charAt(idx)) return false;

    char temp = board[i][j];
    board[i][j] = '#';  // mark visited
    boolean found = dfs(board, word, i+1, j, idx+1) || dfs(board, word, i-1, j, idx+1)
                 || dfs(board, word, i, j+1, idx+1) || dfs(board, word, i, j-1, idx+1);
    board[i][j] = temp;  // restore (backtrack)
    return found;
}
```

---

## Pruning (Optimization)

Pruning cuts branches early when we know they cannot produce valid solutions:
- **Sorted array + target exceeded** → break (don't continue)
- **Constraint violated** → skip this choice
- **Duplicate elements** → skip when `i > start && nums[i] == nums[i-1]`

---

## Complexity Analysis

| Problem | Time | Space |
|---------|------|-------|
| All Subsets | O(2ⁿ) | O(n) |
| All Permutations | O(n! × n) | O(n) |
| N-Queens | O(n!) | O(n) |
| Combination Sum | O(2ⁿ) | O(target) |
| Word Search | O(m × n × 4^L) | O(L) |

---

## Key Takeaways

1. Always make a copy of `current` when adding to results (`new ArrayList<>(current)`).
2. The **undo** step must perfectly mirror the **make** step — if you `add`, you `remove`.
3. Pruning dramatically reduces the actual search space — always look for early termination.
4. Backtracking is exhaustive by nature; worst case is always exponential. The goal is to prune as much as possible.
5. Word Search and Sudoku Solver use in-place marking (modify the board, restore on backtrack) to avoid an extra `visited` array.
