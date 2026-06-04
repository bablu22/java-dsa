# Divide & Conquer — Theory

## Concepts

**Divide and Conquer** is a recursive problem-solving paradigm:

1. **Divide** — split the problem into smaller subproblems
2. **Conquer** — recursively solve each subproblem
3. **Combine** — merge the subproblem solutions into the final answer

This approach achieves O(n log n) for sorting and O(log n) for search — both better than naive O(n²) or O(n).

---

## Classic Divide & Conquer Algorithms

### 1. Binary Search — O(log n)
```java
int binarySearch(int[] arr, int lo, int hi, int target) {
    if (lo > hi) return -1;
    int mid = lo + (hi - lo) / 2;
    if (arr[mid] == target) return mid;
    if (arr[mid] < target) return binarySearch(arr, mid + 1, hi, target);
    return binarySearch(arr, lo, mid - 1, target);
}
```
- Divide: pick mid
- Conquer: recurse on one half
- Combine: no combining needed

---

### 2. Merge Sort — O(n log n)
```java
void mergeSort(int[] arr, int l, int r) {
    if (l >= r) return;
    int mid = l + (r - l) / 2;
    mergeSort(arr, l, mid);           // conquer left
    mergeSort(arr, mid + 1, r);       // conquer right
    merge(arr, l, mid, r);            // combine
}
```
- Divide: split at midpoint
- Conquer: sort both halves
- Combine: merge two sorted halves

---

### 3. Quick Sort — O(n log n) average
```java
void quickSort(int[] arr, int lo, int hi) {
    if (lo < hi) {
        int p = partition(arr, lo, hi);
        quickSort(arr, lo, p - 1);
        quickSort(arr, p + 1, hi);
    }
}
```
- Divide: partition around pivot
- Conquer: sort each partition
- Combine: no combining (partition is in-place)

---

### 4. Maximum Subarray — O(n log n)
```java
int maxCrossing(int[] arr, int l, int mid, int r) {
    int leftSum = Integer.MIN_VALUE, sum = 0;
    for (int i = mid; i >= l; i--) { sum += arr[i]; leftSum = Math.max(leftSum, sum); }
    int rightSum = Integer.MIN_VALUE; sum = 0;
    for (int i = mid + 1; i <= r; i++) { sum += arr[i]; rightSum = Math.max(rightSum, sum); }
    return leftSum + rightSum;
}

int maxSubarray(int[] arr, int l, int r) {
    if (l == r) return arr[l];
    int mid = l + (r - l) / 2;
    return Math.max(Math.max(maxSubarray(arr, l, mid), maxSubarray(arr, mid + 1, r)),
                    maxCrossing(arr, l, mid, r));
}
```
Note: Kadane's algorithm solves this in O(n) — D&C is educational here.

---

### 5. Count Inversions (Merge Sort based) — O(n log n)
An inversion is a pair `(i,j)` where `i < j` but `arr[i] > arr[j]`.

During merge: if left element > right element, all remaining left elements form inversions with this right element.

---

### 6. Closest Pair of Points — O(n log n)
1. Sort points by x
2. Find closest pair in left and right halves
3. Find closest pair across the dividing strip
4. Return the minimum

---

## Master Theorem (for Divide and Conquer)

`T(n) = a * T(n/b) + f(n)`

where:
- `a` = number of subproblems
- `n/b` = size of each subproblem
- `f(n)` = cost of divide + combine

| Example | a | b | f(n) | Result |
|---------|---|---|------|--------|
| Merge Sort | 2 | 2 | O(n) | O(n log n) |
| Binary Search | 1 | 2 | O(1) | O(log n) |
| Naive Matrix Multiply | 8 | 2 | O(n²) | O(n³) |
| Strassen Matrix Multiply | 7 | 2 | O(n²) | O(n^2.81) |

---

## Complexity Analysis

| Algorithm | Time | Space |
|-----------|------|-------|
| Binary Search | O(log n) | O(log n) |
| Merge Sort | O(n log n) | O(n) |
| Quick Sort | O(n log n) avg | O(log n) |
| Max Subarray (D&C) | O(n log n) | O(log n) |

---

## Key Takeaways

1. Divide and Conquer beats brute force when combining is cheap and the halving reduces work logarithmically.
2. The "log n" factor comes from the number of levels of recursion — O(log n) levels, each doing O(n) work = O(n log n).
3. Merge Sort is the canonical D&C algorithm — understand the merge step deeply.
4. Binary Search is D&C with only one recursive branch — hence O(log n) not O(n log n).
5. Use Master Theorem to quickly compute recurrence complexities.
