# Heaps — Theory

## Concepts

A **heap** is a complete binary tree satisfying the **heap property**:
- **Min-Heap:** parent ≤ children (root = minimum)
- **Max-Heap:** parent ≥ children (root = maximum)

Heaps are typically stored as **arrays** — no pointers needed.

For a node at index `i`:
- Left child: `2*i + 1`
- Right child: `2*i + 2`
- Parent: `(i - 1) / 2`

---

## Heap as Array

```
Min-heap:       1
               / \
              3   6
             / \ / \
            5  9 8  7

Array: [1, 3, 6, 5, 9, 8, 7]
Index:  0  1  2  3  4  5  6
```

---

## Core Operations

### Insert (Bubble Up) — O(log n)
```java
void insert(int[] heap, int n, int val) {
    heap[n] = val;
    int i = n;
    while (i > 0 && heap[(i-1)/2] > heap[i]) {
        swap(heap, i, (i-1)/2);
        i = (i-1)/2;
    }
}
```

### Extract Min (Bubble Down / Heapify Down) — O(log n)
```java
int extractMin(int[] heap, int n) {
    int min = heap[0];
    heap[0] = heap[n-1];  // move last to root
    heapifyDown(heap, 0, n-1);
    return min;
}

void heapifyDown(int[] heap, int i, int n) {
    int smallest = i;
    int left = 2*i+1, right = 2*i+2;
    if (left < n && heap[left] < heap[smallest]) smallest = left;
    if (right < n && heap[right] < heap[smallest]) smallest = right;
    if (smallest != i) {
        swap(heap, i, smallest);
        heapifyDown(heap, smallest, n);
    }
}
```

### Build Heap (from array) — O(n)
```java
void buildHeap(int[] arr) {
    int n = arr.length;
    // start from last non-leaf node
    for (int i = n/2 - 1; i >= 0; i--) {
        heapifyDown(arr, i, n);
    }
}
// Surprising: O(n) not O(n log n) — the math works out
```

---

## Priority Queue in Java

```java
// Min-Heap (default)
PriorityQueue<Integer> minHeap = new PriorityQueue<>();
minHeap.offer(5); minHeap.offer(1); minHeap.offer(3);
minHeap.poll();  // 1 (minimum)
minHeap.peek();  // 3

// Max-Heap
PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

// Custom comparator (sort by second element)
PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);

// Min-Heap for strings by length
PriorityQueue<String> pq = new PriorityQueue<>(Comparator.comparingInt(String::length));
```

---

## Heap Sort — O(n log n), O(1) space

```java
void heapSort(int[] arr) {
    int n = arr.length;
    // Build max-heap
    for (int i = n/2 - 1; i >= 0; i--) maxHeapify(arr, n, i);
    // Extract elements one by one
    for (int i = n - 1; i > 0; i--) {
        swap(arr, 0, i);          // move current max to end
        maxHeapify(arr, i, 0);   // heapify reduced heap
    }
}
```

---

## Key Patterns

### Kth Largest Element — O(n log k)
```java
int findKthLargest(int[] nums, int k) {
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    for (int num : nums) {
        minHeap.offer(num);
        if (minHeap.size() > k) minHeap.poll();  // remove smallest
    }
    return minHeap.peek();  // kth largest
}
```

### Top K Frequent Elements
```java
Map<Integer, Integer> freq = new HashMap<>();
for (int x : nums) freq.merge(x, 1, Integer::sum);
PriorityQueue<Integer> minHeap = new PriorityQueue<>(Comparator.comparingInt(freq::get));
for (int key : freq.keySet()) {
    minHeap.offer(key);
    if (minHeap.size() > k) minHeap.poll();
}
```

---

## Complexity Analysis

| Operation | Time |
|-----------|------|
| Insert | O(log n) |
| Extract Min/Max | O(log n) |
| Peek | O(1) |
| Build Heap | O(n) |
| Heap Sort | O(n log n) |
| Kth Largest (min-heap of size k) | O(n log k) |

---

## Key Takeaways

1. Min-Heap = root is always minimum; Max-Heap = root is always maximum.
2. Java's `PriorityQueue` is a min-heap — use `Collections.reverseOrder()` for max-heap.
3. **Kth largest** → min-heap of size k (counterintuitive: smallest of the top-k is maintained at root).
4. Build heap is O(n), not O(n log n) — crucial for heap sort efficiency analysis.
5. Heap sort is O(n log n) time and O(1) space — but not stable and not cache-friendly.
6. Whenever you see "top K", "median", or "most frequent K" — think heap.
