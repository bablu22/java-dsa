# Arrays — Theory

## Concepts

An **array** is a contiguous block of memory that stores elements of the same data type. Each element is accessed via a zero-based index in O(1) time.

In Java, arrays are objects stored on the heap. The variable holds a reference to the array.

```java
int[] arr = new int[5];           // declaration + allocation
int[] arr = {1, 2, 3, 4, 5};     // declaration + initialization
int[] arr = new int[]{1, 2, 3};  // explicit form
```

---

## Types of Arrays in Java

### 1D Array
```java
int[] arr = new int[n];
```

### 2D Array (Matrix)
```java
int[][] matrix = new int[rows][cols];
```

### Dynamic Array (ArrayList)
```java
List<Integer> list = new ArrayList<>();
```

---

## Core Operations

### Traversal
```java
for (int i = 0; i < arr.length; i++) { ... }  // index-based
for (int x : arr) { ... }                      // enhanced for-each
```

### Linear Search — O(n)
```java
for (int i = 0; i < arr.length; i++) {
    if (arr[i] == target) return i;
}
return -1;
```

### Binary Search — O(log n) — requires sorted array
```java
int lo = 0, hi = arr.length - 1;
while (lo <= hi) {
    int mid = lo + (hi - lo) / 2;   // avoids integer overflow
    if (arr[mid] == target) return mid;
    else if (arr[mid] < target) lo = mid + 1;
    else hi = mid - 1;
}
return -1;
```

---

## Important Algorithms on Arrays

### Prefix Sum
Enables O(1) range sum queries after O(n) preprocessing.
```java
int[] prefix = new int[n + 1];
for (int i = 0; i < n; i++) prefix[i + 1] = prefix[i] + arr[i];
// Sum from l to r (inclusive) = prefix[r + 1] - prefix[l]
```

### Two Pointer Technique
Used when the array is sorted or when you need to find pairs.
```java
int left = 0, right = arr.length - 1;
while (left < right) {
    int sum = arr[left] + arr[right];
    if (sum == target) return new int[]{left, right};
    else if (sum < target) left++;
    else right--;
}
```

### Sliding Window — Fixed Size
```java
int windowSum = 0;
for (int i = 0; i < k; i++) windowSum += arr[i];
int maxSum = windowSum;
for (int i = k; i < arr.length; i++) {
    windowSum += arr[i] - arr[i - k];
    maxSum = Math.max(maxSum, windowSum);
}
```

### Kadane's Algorithm — Maximum Subarray Sum — O(n)
```java
int maxSum = arr[0], currentSum = arr[0];
for (int i = 1; i < arr.length; i++) {
    currentSum = Math.max(arr[i], currentSum + arr[i]);
    maxSum = Math.max(maxSum, currentSum);
}
```

### Dutch National Flag — 3-way partition — O(n)
```java
int lo = 0, mid = 0, hi = arr.length - 1;
while (mid <= hi) {
    if (arr[mid] == 0)      swap(arr, lo++, mid++);
    else if (arr[mid] == 1) mid++;
    else                    swap(arr, mid, hi--);
}
```

---

## Complexity Analysis

| Operation | Time | Space |
|-----------|------|-------|
| Access by index | O(1) | O(1) |
| Linear search | O(n) | O(1) |
| Binary search | O(log n) | O(1) |
| Insert at end | O(1) | O(1) |
| Insert at middle | O(n) | O(1) |
| Delete | O(n) | O(1) |
| Traverse | O(n) | O(1) |
| Prefix Sum (build) | O(n) | O(n) |
| Prefix Sum (query) | O(1) | O(1) |
| Sliding Window | O(n) | O(1) |
| Sorting | O(n log n) | O(log n) |

---

## Java Utility Methods

```java
Arrays.sort(arr);                  // O(n log n) — dual-pivot quicksort for primitives
Arrays.fill(arr, 0);               // fill with value
Arrays.copyOf(arr, newLength);     // copy array
Arrays.copyOfRange(arr, from, to); // partial copy [from, to)
Arrays.toString(arr);              // print array as string
Arrays.equals(arr1, arr2);        // compare arrays element-by-element
```

---

## Key Takeaways

1. Arrays give O(1) random access — the biggest advantage over linked lists.
2. Arrays are fixed-size in Java; use `ArrayList` when dynamic sizing is needed.
3. Always consider the **two-pointer** approach for sorted array problems.
4. **Sliding window** is the go-to technique for subarray problems with a constraint.
5. **Prefix sums** convert repeated range-sum queries from O(n) to O(1).
6. Use `lo + (hi - lo) / 2` instead of `(lo + hi) / 2` to avoid integer overflow in binary search.
7. When sorting is allowed and doesn't affect the answer, sort first — it often unlocks simpler solutions.
8. `Arrays.sort()` uses dual-pivot quicksort for primitives (not stable) and Timsort for objects (stable).
