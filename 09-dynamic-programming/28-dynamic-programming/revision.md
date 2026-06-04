# Dynamic Programming — Revision Notes

## Quick Revision Points

- DP = optimal substructure + overlapping subproblems
- Top-down (memoization): recursion + cache; Bottom-up (tabulation): iterative fill
- Define state → write transition → set base cases → fill table
- 1D DP: `dp[i]` depends on `dp[i-1]` (or a range)
- 2D DP: `dp[i][j]` depends on `dp[i-1][j]`, `dp[i][j-1]`, or `dp[i-1][j-1]`
- Space optimization: when only previous row needed → use 1D rolling array

## DP Pattern → Problem Mapping

| Pattern | Problems |
|---------|---------|
| 1D Linear | Fibonacci, Climbing Stairs, House Robber |
| Coin Change | Coin Change, Unbounded Knapsack |
| 0/1 Knapsack | 0/1 Knapsack, Partition Equal Subset |
| LCS | LCS, Edit Distance, Shortest Common Supersequence |
| LIS | LIS, Russian Doll Envelopes |
| Grid DP | Unique Paths, Min Path Sum, Dungeon Game |
| String DP | Edit Distance, Word Break, Palindrome Partition |
| Interval DP | Burst Balloons, Matrix Chain Multiplication |
| Tree DP | House Robber III, Max Path Sum |

## Common Mistakes

1. Not identifying overlapping subproblems → writing pure recursion that is O(2ⁿ)
2. Wrong state definition — make sure state captures all info needed for the transition
3. Wrong base case → wrong answers for small inputs
4. Off-by-one: `dp[i]` for prefix of length i means `dp[0]` = empty string/0 items
5. Forgetting to initialize with correct sentinel (e.g., `Integer.MAX_VALUE` for min)

## Interview Notes

- **Greedy vs DP:** can you prove the greedy choice is always safe? If not, use DP
- DP decision tree: linear/2D/interval/tree DP based on problem structure
- Most DP problems on LeetCode: 70 (Climbing Stairs), 198 (House Robber), 322 (Coin Change), 300 (LIS), 1143 (LCS), 72 (Edit Distance), 416 (Subset Sum)
- For space optimization: iterate right-to-left in 1D knapsack to avoid using same item twice in 0/1 knapsack
