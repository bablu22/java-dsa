# Basic Sorting Algorithms — Theory

## Concepts

A **sorting algorithm** rearranges elements of a collection in a defined order (ascending or descending). Understanding sorting algorithms teaches algorithmic thinking, loop logic, and complexity analysis.

---

## 1. Bubble Sort

**Idea:** Repeatedly compare adjacent elements and swap if out of order. Largest element "bubbles" to the end each pass.

```java
void bubbleSort(int[] arr) {
    int n = arr.length;
    for (int i = 0; i < n - 1; i++) {
        boolean swapped = false;
        for (int j = 0; j < n - i - 1; j++) {
            if (arr[j] > arr[j + 1]) {
                int temp = arr[j]; arr[j] = arr[j+1]; arr[j+1] = temp;
                swapped = true;
            }
        }
        if (!swapped) break;  // already sorted — early exit
    }
}
```

| Case | Time |
|------|------|
| Best (sorted) | O(n) |
| Average | O(n²) |
| Worst | O(n²) |

Space: O(1) — Stable: Yes

---

## 2. Selection Sort

**Idea:** Find the minimum element in the unsorted portion, place it at the beginning.

```java
void selectionSort(int[] arr) {
    int n = arr.length;
    for (int i = 0; i < n - 1; i++) {
        int minIdx = i;
        for (int j = i + 1; j < n; j++) {
            if (arr[j] < arr[minIdx]) minIdx = j;
        }
        int temp = arr[minIdx]; arr[minIdx] = arr[i]; arr[i] = temp;
    }
}
```

| Case | Time |
|------|------|
| All cases | O(n²) |

Space: O(1) — Stable: No (swapping can move equal elements)

---

## 3. Insertion Sort

**Idea:** Build a sorted array one element at a time by inserting each element into its correct position.

```java
void insertionSort(int[] arr) {
    int n = arr.length;
    for (int i = 1; i < n; i++) {
        int key = arr[i];
        int j = i - 1;
        while (j >= 0 && arr[j] > key) {
            arr[j + 1] = arr[j];
            j--;
        }
        arr[j + 1] = key;
    }
}
```

| Case | Time |
|------|------|
| Best (sorted) | O(n) |
| Average | O(n²) |
| Worst | O(n²) |

Space: O(1) — Stable: Yes — Excellent for nearly-sorted arrays.

---

## 4. Merge Sort

**Idea:** Divide array in half recursively, sort each half, merge sorted halves.

```java
void mergeSort(int[] arr, int l, int r) {
    if (l >= r) return;
    int mid = l + (r - l) / 2;
    mergeSort(arr, l, mid);
    mergeSort(arr, mid + 1, r);
    merge(arr, l, mid, r);
}

void merge(int[] arr, int l, int mid, int r) {
    int[] temp = new int[r - l + 1];
    int i = l, j = mid + 1, k = 0;
    while (i <= mid && j <= r)
        temp[k++] = (arr[i] <= arr[j]) ? arr[i++] : arr[j++];
    while (i <= mid) temp[k++] = arr[i++];
    while (j <= r)   temp[k++] = arr[j++];
    for (int x = 0; x < temp.length; x++) arr[l + x] = temp[x];
}
```

| Case | Time |
|------|------|
| All cases | O(n log n) |

Space: O(n) — Stable: Yes

---

## 5. Quick Sort

**Idea:** Choose a pivot, partition the array around it, recursively sort both halves.

```java
void quickSort(int[] arr, int lo, int hi) {
    if (lo < hi) {
        int p = partition(arr, lo, hi);
        quickSort(arr, lo, p - 1);
        quickSort(arr, p + 1, hi);
    }
}

int partition(int[] arr, int lo, int hi) {
    int pivot = arr[hi], i = lo - 1;
    for (int j = lo; j < hi; j++) {
        if (arr[j] <= pivot) {
            i++;
            int temp = arr[i]; arr[i] = arr[j]; arr[j] = temp;
        }
    }
    int temp = arr[i+1]; arr[i+1] = arr[hi]; arr[hi] = temp;
    return i + 1;
}
```

| Case | Time |
|------|------|
| Best/Average | O(n log n) |
| Worst (sorted/reverse) | O(n²) |

Space: O(log n) call stack — Stable: No — In practice, fastest due to cache performance.

---

## Comparison Summary

| Algorithm | Best | Average | Worst | Space | Stable |
|-----------|------|---------|-------|-------|--------|
| Bubble Sort | O(n) | O(n²) | O(n²) | O(1) | Yes |
| Selection Sort | O(n²) | O(n²) | O(n²) | O(1) | No |
| Insertion Sort | O(n) | O(n²) | O(n²) | O(1) | Yes |
| Merge Sort | O(n log n) | O(n log n) | O(n log n) | O(n) | Yes |
| Quick Sort | O(n log n) | O(n log n) | O(n²) | O(log n) | No |

---

## Java's Built-in Sort

```java
Arrays.sort(arr);                    // dual-pivot quicksort for primitives
Arrays.sort(arr, (a, b) -> a - b);  // custom comparator for objects
Collections.sort(list);             // Timsort (merge+insertion) for objects
```

---

## Key Takeaways

1. For large datasets: use Merge Sort (guaranteed O(n log n)) or Quick Sort (fastest average).
2. For small or nearly-sorted arrays: Insertion Sort outperforms Merge/Quick Sort.
3. Stable sort preserves the relative order of equal elements — important when sorting objects by multiple keys.
4. Java's `Arrays.sort()` for primitives uses dual-pivot Quick Sort (not stable); for objects it uses Timsort (stable).
5. Quick Sort worst case (O(n²)) is avoided by random pivot selection or median-of-three strategy.
