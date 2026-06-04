# Dynamic Programming — Theory

## Concepts

**Dynamic Programming (DP)** solves complex problems by breaking them into simpler overlapping subproblems, solving each subproblem once, and storing the results (memoization/tabulation) to avoid redundant computation.

Two key properties required for DP:
1. **Optimal Substructure:** optimal solution built from optimal solutions of subproblems
2. **Overlapping Subproblems:** same subproblems recur multiple times

---

## Top-Down vs Bottom-Up

### Memoization (Top-Down) — Recursion + Cache
```java
Map<Integer, Long> memo = new HashMap<>();
long fib(int n) {
    if (n <= 1) return n;
    if (memo.containsKey(n)) return memo.get(n);
    long result = fib(n-1) + fib(n-2);
    memo.put(n, result);
    return result;
}
```

### Tabulation (Bottom-Up) — Iterative
```java
long fib(int n) {
    long[] dp = new long[n + 1];
    dp[0] = 0; dp[1] = 1;
    for (int i = 2; i <= n; i++) dp[i] = dp[i-1] + dp[i-2];
    return dp[n];
}
// Space optimized: only keep last two values → O(1) space
```

---

## DP Patterns

### Pattern 1: 1D DP (Linear)

**Climbing Stairs** — ways to reach step n using 1 or 2 steps:
```java
int climbStairs(int n) {
    if (n <= 2) return n;
    int a = 1, b = 2;
    for (int i = 3; i <= n; i++) { int c = a + b; a = b; b = c; }
    return b;
}
// T: O(n), S: O(1)
```

**Coin Change** — min coins to make amount:
```java
int coinChange(int[] coins, int amount) {
    int[] dp = new int[amount + 1];
    Arrays.fill(dp, amount + 1);
    dp[0] = 0;
    for (int i = 1; i <= amount; i++) {
        for (int coin : coins) {
            if (coin <= i) dp[i] = Math.min(dp[i], dp[i - coin] + 1);
        }
    }
    return dp[amount] > amount ? -1 : dp[amount];
}
// T: O(amount × coins), S: O(amount)
```

---

### Pattern 2: 0/1 Knapsack

Each item either taken (1) or not (0). Cannot reuse.

```java
int knapsack(int[] weights, int[] values, int W) {
    int n = weights.length;
    int[][] dp = new int[n + 1][W + 1];
    for (int i = 1; i <= n; i++) {
        for (int w = 0; w <= W; w++) {
            dp[i][w] = dp[i-1][w];  // don't take item i
            if (weights[i-1] <= w)
                dp[i][w] = Math.max(dp[i][w], dp[i-1][w - weights[i-1]] + values[i-1]);
        }
    }
    return dp[n][W];
}
// T: O(n × W), S: O(n × W) → optimizable to O(W)
```

---

### Pattern 3: Longest Common Subsequence (LCS)

```java
int lcs(String s, String t) {
    int m = s.length(), n = t.length();
    int[][] dp = new int[m + 1][n + 1];
    for (int i = 1; i <= m; i++) {
        for (int j = 1; j <= n; j++) {
            if (s.charAt(i-1) == t.charAt(j-1)) dp[i][j] = dp[i-1][j-1] + 1;
            else dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
        }
    }
    return dp[m][n];
}
// T: O(m × n), S: O(m × n)
```

---

### Pattern 4: Longest Increasing Subsequence (LIS)

```java
int lis(int[] nums) {
    int n = nums.length;
    int[] dp = new int[n];
    Arrays.fill(dp, 1);
    int maxLen = 1;
    for (int i = 1; i < n; i++) {
        for (int j = 0; j < i; j++) {
            if (nums[j] < nums[i]) dp[i] = Math.max(dp[i], dp[j] + 1);
        }
        maxLen = Math.max(maxLen, dp[i]);
    }
    return maxLen;
}
// T: O(n²), S: O(n) — Binary search version: O(n log n)
```

---

### Pattern 5: Matrix/Grid DP

**Unique Paths:**
```java
int uniquePaths(int m, int n) {
    int[][] dp = new int[m][n];
    for (int i = 0; i < m; i++) dp[i][0] = 1;
    for (int j = 0; j < n; j++) dp[0][j] = 1;
    for (int i = 1; i < m; i++)
        for (int j = 1; j < n; j++)
            dp[i][j] = dp[i-1][j] + dp[i][j-1];
    return dp[m-1][n-1];
}
```

---

### Pattern 6: String DP

**Edit Distance (Levenshtein):**
```java
int editDistance(String s, String t) {
    int m = s.length(), n = t.length();
    int[][] dp = new int[m + 1][n + 1];
    for (int i = 0; i <= m; i++) dp[i][0] = i;
    for (int j = 0; j <= n; j++) dp[0][j] = j;
    for (int i = 1; i <= m; i++) {
        for (int j = 1; j <= n; j++) {
            if (s.charAt(i-1) == t.charAt(j-1)) dp[i][j] = dp[i-1][j-1];
            else dp[i][j] = 1 + Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1]));
        }
    }
    return dp[m][n];
}
```

---

## Complexity Analysis

| Problem | Time | Space | Space Optimized |
|---------|------|-------|-----------------|
| Fibonacci | O(n) | O(n) | O(1) |
| Coin Change | O(n × amount) | O(amount) | — |
| 0/1 Knapsack | O(n × W) | O(n × W) | O(W) |
| LCS | O(m × n) | O(m × n) | O(min(m,n)) |
| LIS | O(n²) | O(n) | O(n log n) with binary search |
| Edit Distance | O(m × n) | O(m × n) | O(min(m,n)) |

---

## Key Takeaways

1. DP = recursion + memoization. If you can write a recursive solution, converting to DP is mechanical.
2. Identify the **state** — what variables uniquely describe a subproblem.
3. Identify the **transition** — how state(i) relates to state(i-1) or smaller states.
4. Base cases must be set before the transition loop.
5. Space optimization: when only the previous row/value is needed, use O(1) or O(n) space instead of O(n²).
6. The hardest part is identifying which DP pattern applies — practice the 10 canonical patterns.
