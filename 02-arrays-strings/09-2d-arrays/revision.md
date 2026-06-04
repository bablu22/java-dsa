# 2D Arrays — Revision Notes

## Quick Revision Points

- `matrix.length` = rows; `matrix[0].length` = cols
- Row-major storage: each row is a contiguous array
- Transpose (square): swap `[i][j]` with `[j][i]` for `j > i`
- Rotate 90° clockwise: transpose → reverse each row
- Rotate 90° counter-clockwise: transpose → reverse each column
- Spiral traversal: 4 boundaries (top, bottom, left, right), shrink inward
- Search in sorted matrix: start top-right, eliminate row or column each step → O(n+m)

## Common Mistakes

1. Using `matrix.length` for columns (it's rows) — always use `matrix[0].length` for cols
2. In-place transpose: looping `j` from `0` to `n` (not `i+1`) swaps elements twice — back to original
3. Spiral: forgetting the inner boundary checks (`if (top <= bottom)`) for non-square matrices
4. ArrayIndexOutOfBoundsException when matrix is empty — check `matrix.length > 0`

## Interview Notes

| Problem | Key Technique |
|---------|--------------|
| Rotate Matrix 90° | Transpose + Reverse rows |
| Spiral Order | 4-boundary shrink |
| Search in sorted matrix | Top-right elimination |
| Set Matrix Zeroes | Mark rows/cols first, then zero |
| Word Search | DFS + backtracking on grid |
| Number of Islands | BFS/DFS flood fill |
| Unique Paths | DP table |
