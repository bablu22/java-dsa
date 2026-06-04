# DSA Cheatsheet

Quick-reference for complexity, patterns, and Java built-ins.

---

## Time Complexity Reference

| Complexity | Name         | Example                             |
| ---------- | ------------ | ----------------------------------- |
| O(1)       | Constant     | Array index access, HashMap get/put |
| O(log n)   | Logarithmic  | Binary Search, BST operations       |
| O(n)       | Linear       | Linear search, single loop          |
| O(n log n) | Linearithmic | Merge Sort, Heap Sort               |
| O(n²)      | Quadratic    | Bubble Sort, nested loops           |
| O(n³)      | Cubic        | Triple nested loops                 |
| O(2ⁿ)      | Exponential  | Recursive fibonacci, subsets        |
| O(n!)      | Factorial    | Permutations                        |

---

## Data Structure Complexity

### Arrays

| Operation       | Time           |
| --------------- | -------------- |
| Access          | O(1)           |
| Search          | O(n)           |
| Insert (end)    | O(1) amortized |
| Insert (middle) | O(n)           |
| Delete          | O(n)           |

### Linked List

| Operation     | Singly | Doubly |
| ------------- | ------ | ------ |
| Access        | O(n)   | O(n)   |
| Search        | O(n)   | O(n)   |
| Insert (head) | O(1)   | O(1)   |
| Insert (tail) | O(n)   | O(1)   |
| Delete (head) | O(1)   | O(1)   |

### Stack / Queue

| Operation      | Time |
| -------------- | ---- |
| Push / Enqueue | O(1) |
| Pop / Dequeue  | O(1) |
| Peek           | O(1) |
| Search         | O(n) |

### HashMap

| Operation | Average | Worst |
| --------- | ------- | ----- |
| Get       | O(1)    | O(n)  |
| Put       | O(1)    | O(n)  |
| Delete    | O(1)    | O(n)  |

### Binary Search Tree

| Operation | Average  | Worst |
| --------- | -------- | ----- |
| Search    | O(log n) | O(n)  |
| Insert    | O(log n) | O(n)  |
| Delete    | O(log n) | O(n)  |

### Heap (Priority Queue)

| Operation       | Time     |
| --------------- | -------- |
| Insert          | O(log n) |
| Extract Min/Max | O(log n) |
| Peek            | O(1)     |
| Build Heap      | O(n)     |

### Graph (V = vertices, E = edges)

| Algorithm        | Time           | Space |
| ---------------- | -------------- | ----- |
| BFS              | O(V + E)       | O(V)  |
| DFS              | O(V + E)       | O(V)  |
| Dijkstra         | O((V+E) log V) | O(V)  |
| Bellman-Ford     | O(VE)          | O(V)  |
| Floyd-Warshall   | O(V³)          | O(V²) |
| Topological Sort | O(V + E)       | O(V)  |

---

## Sorting Algorithms

| Algorithm      | Best       | Average    | Worst      | Space    | Stable |
| -------------- | ---------- | ---------- | ---------- | -------- | ------ |
| Bubble Sort    | O(n)       | O(n²)      | O(n²)      | O(1)     | Yes    |
| Selection Sort | O(n²)      | O(n²)      | O(n²)      | O(1)     | No     |
| Insertion Sort | O(n)       | O(n²)      | O(n²)      | O(1)     | Yes    |
| Merge Sort     | O(n log n) | O(n log n) | O(n log n) | O(n)     | Yes    |
| Quick Sort     | O(n log n) | O(n log n) | O(n²)      | O(log n) | No     |
| Heap Sort      | O(n log n) | O(n log n) | O(n log n) | O(1)     | No     |
| Counting Sort  | O(n+k)     | O(n+k)     | O(n+k)     | O(k)     | Yes    |

---

## Common Patterns

### Two Pointers

```java
int left = 0, right = arr.length - 1;
while (left < right) {
    // process arr[left] and arr[right]
    left++;
    right--;
}
```

### Sliding Window (Fixed Size)

```java
int windowSum = 0;
for (int i = 0; i < k; i++) windowSum += arr[i];
int maxSum = windowSum;
for (int i = k; i < arr.length; i++) {
    windowSum += arr[i] - arr[i - k];
    maxSum = Math.max(maxSum, windowSum);
}
```

### Sliding Window (Variable Size)

```java
int left = 0, result = 0;
for (int right = 0; right < arr.length; right++) {
    // expand window: add arr[right]
    while (/* window invalid */) {
        // shrink window: remove arr[left]
        left++;
    }
    result = Math.max(result, right - left + 1);
}
```

### Binary Search

```java
int lo = 0, hi = arr.length - 1;
while (lo <= hi) {
    int mid = lo + (hi - lo) / 2;  // avoids overflow
    if (arr[mid] == target) return mid;
    else if (arr[mid] < target) lo = mid + 1;
    else hi = mid - 1;
}
return -1;
```

### BFS (Graph)

```java
Queue<Integer> queue = new LinkedList<>();
Set<Integer> visited = new HashSet<>();
queue.offer(start);
visited.add(start);
while (!queue.isEmpty()) {
    int node = queue.poll();
    for (int neighbor : graph.get(node)) {
        if (!visited.contains(neighbor)) {
            visited.add(neighbor);
            queue.offer(neighbor);
        }
    }
}
```

### DFS (Graph)

```java
void dfs(int node, Set<Integer> visited, Map<Integer, List<Integer>> graph) {
    visited.add(node);
    for (int neighbor : graph.get(node)) {
        if (!visited.contains(neighbor)) {
            dfs(neighbor, visited, graph);
        }
    }
}
```

### Prefix Sum

```java
int[] prefix = new int[arr.length + 1];
for (int i = 0; i < arr.length; i++) {
    prefix[i + 1] = prefix[i] + arr[i];
}
// sum from index l to r (inclusive) = prefix[r+1] - prefix[l]
```

### Backtracking Template

```java
void backtrack(List<List<Integer>> result, List<Integer> current, ...) {
    if (/* base case */) {
        result.add(new ArrayList<>(current));
        return;
    }
    for (int choice : choices) {
        current.add(choice);         // choose
        backtrack(result, current, ...);  // explore
        current.remove(current.size() - 1); // unchoose
    }
}
```

### Dynamic Programming (Bottom-Up)

```java
int[] dp = new int[n + 1];
dp[0] = baseCase;
for (int i = 1; i <= n; i++) {
    dp[i] = /* transition from dp[i-1], dp[i-2], etc. */;
}
return dp[n];
```

---

## Java Useful Built-ins

### Collections

```java
// Sorting
Arrays.sort(arr);                        // primitives: O(n log n)
Collections.sort(list);                  // objects: O(n log n)
Arrays.sort(arr, (a, b) -> a - b);      // custom comparator

// Searching
Arrays.binarySearch(arr, target);        // O(log n), arr must be sorted

// Frequency map
Map<Character, Integer> freq = new HashMap<>();
for (char c : s.toCharArray())
    freq.merge(c, 1, Integer::sum);

// Priority Queue (Min-Heap)
PriorityQueue<Integer> minHeap = new PriorityQueue<>();

// Priority Queue (Max-Heap)
PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

// Deque as Stack
Deque<Integer> stack = new ArrayDeque<>();
stack.push(x); stack.pop(); stack.peek();

// Deque as Queue
Deque<Integer> queue = new ArrayDeque<>();
queue.offer(x); queue.poll(); queue.peek();
```

### String

```java
s.length()
s.charAt(i)
s.substring(l, r)        // [l, r)
s.toCharArray()
s.split(" ")
s.trim()
s.toLowerCase() / toUpperCase()
String.valueOf(num)      // int to String
Integer.parseInt(s)      // String to int
new StringBuilder()      // mutable string
sb.append(), sb.reverse(), sb.toString()
```

### Bit Manipulation

```java
n & 1           // check if odd
n >> 1          // divide by 2
n << 1          // multiply by 2
n & (n - 1)     // remove lowest set bit
n & (-n)        // isolate lowest set bit
n ^ n           // 0 (XOR with itself)
~n              // bitwise NOT
Integer.bitCount(n)  // count set bits
```

---

## Recursion Complexity Formula

For recurrence `T(n) = a * T(n/b) + f(n)`:

Use **Master Theorem**:

- If `f(n) = O(n^c)` where `c < log_b(a)` → `T(n) = O(n^log_b(a))`
- If `f(n) = O(n^c)` where `c = log_b(a)` → `T(n) = O(n^c * log n)`
- If `f(n) = O(n^c)` where `c > log_b(a)` → `T(n) = O(f(n))`

Common examples:

- Merge Sort: `T(n) = 2T(n/2) + O(n)` → `O(n log n)`
- Binary Search: `T(n) = T(n/2) + O(1)` → `O(log n)`

---

## When to Use Which Data Structure

| Situation                         | Use                       |
| --------------------------------- | ------------------------- |
| Fast lookup by key                | HashMap                   |
| Ordered key-value pairs           | TreeMap                   |
| Fast min/max retrieval            | PriorityQueue (Heap)      |
| LIFO operations                   | Stack / Deque             |
| FIFO operations                   | Queue / LinkedList        |
| Unique elements                   | HashSet / TreeSet         |
| Prefix matching / autocomplete    | Trie                      |
| Range queries on array            | Segment Tree              |
| Union-Find / connected components | Disjoint Set (Union-Find) |
