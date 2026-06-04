# Patterns — Revision Notes

## Quick Revision Points

- Outer loop = rows, inner loop = columns
- Inner loop bound expressed as function of outer loop variable `i`
- Spaces before stars: `n - i` spaces for right-aligned / centered patterns
- Separate counter for consecutive numbers: `int num = 1; num++`
- Hollow patterns: print symbol only on edges `(i==1 || i==n || j==1 || j==n)`
- All 2D patterns are O(n²) time, O(1) space

## Pattern Decision Table

| What you see | Inner loop condition |
|-------------|---------------------|
| Increasing stars per row | `j <= i` |
| Decreasing stars per row | `j <= n - i + 1` |
| Row number printed | print `i` |
| Column number printed | print `j` |
| Consecutive numbers | separate `num++` counter |
| Spaces then stars | two inner loops |

## Common Mistakes

1. Missing `System.out.println()` at end of outer loop — all output on one line
2. Off-by-one in loop bounds — draw the pattern on paper first
3. Forgetting to reset counter variable for problems where pattern repeats
4. Confusing row index `i` with column index `j` when computing values

## Interview Notes

- Pattern problems test loop control and index logic — not algorithms
- Draw the matrix on paper, label rows (i) and columns (j), identify the rule
- Pascal's Triangle is an important DP concept — each cell = sum of two above it
- Floyd's Triangle tests "running counter" logic used in problem numbering
