# 2D Arrays — Theory

## Concepts

A **2D array** is an array of arrays — a matrix with rows and columns. In Java, a 2D array is stored as an array of references to 1D arrays (row-major order).

```java
int[][] matrix = new int[rows][cols];
int[][] grid = {{1,2,3},{4,5,6},{7,8,9}};

// Access element at row i, col j
int val = matrix[i][j];

// Dimensions
int rows = matrix.length;
int cols = matrix[0].length;
```

---

## Traversal Patterns

### Row-wise (standard)
```java
for (int i = 0; i < rows; i++) {
    for (int j = 0; j < cols; j++) {
        System.out.print(matrix[i][j] + " ");
    }
    System.out.println();
}
```

### Column-wise
```java
for (int j = 0; j < cols; j++) {
    for (int i = 0; i < rows; i++) {
        System.out.print(matrix[i][j] + " ");
    }
}
```

### Diagonal
```java
// Main diagonal (top-left to bottom-right): i == j
// Anti diagonal: i + j == n - 1
for (int i = 0; i < n; i++) System.out.print(matrix[i][i]);
```

---

## Key Operations

### Transpose (swap rows and columns)
```java
// In-place transpose for square matrix
for (int i = 0; i < n; i++) {
    for (int j = i + 1; j < n; j++) {
        int temp = matrix[i][j];
        matrix[i][j] = matrix[j][i];
        matrix[j][i] = temp;
    }
}
```

### Rotate 90° clockwise
```java
// Step 1: Transpose
// Step 2: Reverse each row
for (int[] row : matrix) {
    int l = 0, r = row.length - 1;
    while (l < r) { int t = row[l]; row[l++] = row[r]; row[r--] = t; }
}
```

### Spiral Order Traversal
```java
int top = 0, bottom = rows-1, left = 0, right = cols-1;
while (top <= bottom && left <= right) {
    for (int i = left; i <= right; i++)   result.add(matrix[top][i]);   top++;
    for (int i = top; i <= bottom; i++)   result.add(matrix[i][right]); right--;
    if (top <= bottom)
        for (int i = right; i >= left; i--) result.add(matrix[bottom][i]); bottom--;
    if (left <= right)
        for (int i = bottom; i >= top; i--) result.add(matrix[i][left]);  left++;
}
```

### Search in Row-Wise and Column-Wise Sorted Matrix
```java
// Start from top-right corner
int i = 0, j = cols - 1;
while (i < rows && j >= 0) {
    if (matrix[i][j] == target) return true;
    else if (matrix[i][j] > target) j--;
    else i++;
}
return false;
```

---

## Jagged Arrays

Java 2D arrays can have rows of different lengths:
```java
int[][] jagged = new int[3][];
jagged[0] = new int[1];
jagged[1] = new int[2];
jagged[2] = new int[3];
```

---

## Complexity Analysis

| Operation | Time | Space |
|-----------|------|-------|
| Access element | O(1) | O(1) |
| Traverse | O(n × m) | O(1) |
| Transpose (in-place) | O(n²) | O(1) |
| Spiral traversal | O(n × m) | O(n × m) result |
| Search in sorted matrix | O(n + m) | O(1) |

---

## Key Takeaways

1. `matrix.length` = number of rows; `matrix[0].length` = number of columns.
2. Transpose = swap `matrix[i][j]` with `matrix[j][i]` for `j > i` (upper triangle only — avoids double swap).
3. Rotate 90° clockwise = Transpose + Reverse each row.
4. Rotate 90° counter-clockwise = Transpose + Reverse each column.
5. Spiral traversal: maintain four boundaries (`top`, `bottom`, `left`, `right`) and shrink inward.
6. For sorted matrices (each row/column sorted), search from top-right corner in O(n + m).
