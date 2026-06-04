# Backtracking — Revision Notes

## Quick Revision Points

- Pattern: choose → explore → unchoose (undo)
- ALWAYS copy current state when adding to results: `new ArrayList<>(current)`
- Undo must perfectly mirror the make step — symmetry is critical
- Pruning = cutting branches early when a constraint is violated
- Sort the input when you want to prune duplicate solutions or target-exceeded cases
- Backtracking = DFS on state space tree

## Backtracking vs. Plain Recursion

| | Recursion | Backtracking |
|--|-----------|-------------|
| Goal | Compute a value | Explore/collect solutions |
| Undo step | Not needed | Required |
| State management | Usually stateless | Explicit state tracking |

## Common Mistakes

1. Forgetting to **undo** the choice → state is polluted for sibling branches
2. Adding `current` to results directly (not copying) → all results point to same list
3. Missing pruning → TLE on large inputs
4. Forgetting `i > start` condition when skipping duplicates in sorted input

## When to Use Backtracking

| Problem type | Example |
|-------------|---------|
| Generate all combinations | Combination Sum |
| Generate all permutations | Permutations I/II |
| Generate all subsets | Subsets I/II |
| Constraint satisfaction | N-Queens, Sudoku |
| Grid exploration | Word Search |

## Interview Notes

- Subsets = include/exclude each element → 2ⁿ solutions
- Permutations = arrange n elements → n! solutions
- Duplicates handling: sort + skip `if (i > start && nums[i] == nums[i-1]) continue`
- N-Queens validity check: same column, same diagonal (`|row - r| == |col - c|`)
- Sudoku Solver: try 1-9, check row/col/box validity, backtrack if stuck
