# Queues — Theory

## Concepts

A **queue** is a FIFO (First In, First Out) linear data structure. Think of a real-world queue — first person in line is first to be served.

Core operations:
- `offer(x)` / `enqueue` — add to rear
- `poll()` / `dequeue` — remove from front
- `peek()` — view front without removing
- `isEmpty()` — check if empty

---

## Queue Variants

| Type | Description |
|------|-------------|
| Simple Queue | Standard FIFO |
| Circular Queue | Rear wraps around to front |
| Double-Ended Queue (Deque) | Insert/delete from both ends |
| Priority Queue | Dequeue in order of priority |

---

## Implementation in Java

### Using `Queue` (LinkedList-backed) — Standard
```java
Queue<Integer> queue = new LinkedList<>();
queue.offer(1);   // add to rear — O(1)
queue.offer(2);
queue.poll();     // remove from front — O(1), returns 1
queue.peek();     // view front — O(1), returns 2
queue.isEmpty();
queue.size();
```

### Using `ArrayDeque` — Faster, Preferred
```java
Deque<Integer> queue = new ArrayDeque<>();
queue.offer(1);   // addLast
queue.poll();     // removeFirst
queue.peek();     // peekFirst
```

### Priority Queue (Min-Heap by default)
```java
PriorityQueue<Integer> minHeap = new PriorityQueue<>();
PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

minHeap.offer(5); minHeap.offer(1); minHeap.offer(3);
minHeap.poll();   // returns 1 (minimum)
minHeap.peek();   // returns 3 (next minimum)
```

### Deque (Double-Ended Queue)
```java
Deque<Integer> deque = new ArrayDeque<>();
deque.offerFirst(1);  // add to front
deque.offerLast(2);   // add to rear
deque.pollFirst();    // remove from front
deque.pollLast();     // remove from rear
deque.peekFirst();
deque.peekLast();
```

---

## Classic Queue Problems

### 1. BFS (Breadth-First Search) — Core use of Queue
```java
void bfs(int start, List<List<Integer>> graph) {
    Queue<Integer> queue = new LinkedList<>();
    boolean[] visited = new boolean[graph.size()];
    queue.offer(start);
    visited[start] = true;

    while (!queue.isEmpty()) {
        int node = queue.poll();
        System.out.println(node);
        for (int neighbor : graph.get(node)) {
            if (!visited[neighbor]) {
                visited[neighbor] = true;
                queue.offer(neighbor);
            }
        }
    }
}
```

### 2. Level Order Traversal of Binary Tree
```java
List<List<Integer>> levelOrder(TreeNode root) {
    List<List<Integer>> result = new ArrayList<>();
    if (root == null) return result;
    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);

    while (!queue.isEmpty()) {
        int levelSize = queue.size();
        List<Integer> level = new ArrayList<>();
        for (int i = 0; i < levelSize; i++) {
            TreeNode node = queue.poll();
            level.add(node.val);
            if (node.left != null)  queue.offer(node.left);
            if (node.right != null) queue.offer(node.right);
        }
        result.add(level);
    }
    return result;
}
```

### 3. Sliding Window Maximum (Monotonic Deque) — O(n)
```java
int[] maxSlidingWindow(int[] nums, int k) {
    Deque<Integer> deque = new ArrayDeque<>();  // stores indices
    int[] result = new int[nums.length - k + 1];
    for (int i = 0; i < nums.length; i++) {
        // remove indices out of window
        while (!deque.isEmpty() && deque.peekFirst() < i - k + 1) deque.pollFirst();
        // remove smaller elements from rear
        while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) deque.pollLast();
        deque.offerLast(i);
        if (i >= k - 1) result[i - k + 1] = nums[deque.peekFirst()];
    }
    return result;
}
```

### 4. Implement Queue Using Two Stacks
```java
Deque<Integer> in = new ArrayDeque<>(), out = new ArrayDeque<>();
void enqueue(int x) { in.push(x); }
int dequeue() {
    if (out.isEmpty()) while (!in.isEmpty()) out.push(in.pop());
    return out.pop();
}
```

---

## Complexity Analysis

| Operation | LinkedList | ArrayDeque | PriorityQueue |
|-----------|-----------|------------|---------------|
| Enqueue (offer) | O(1) | O(1) amortized | O(log n) |
| Dequeue (poll) | O(1) | O(1) | O(log n) |
| Peek | O(1) | O(1) | O(1) |
| Contains | O(n) | O(n) | O(n) |

---

## Key Takeaways

1. Queue = FIFO. BFS and level-order traversal always use a queue.
2. Prefer `ArrayDeque` over `LinkedList` as a queue — lower memory overhead.
3. `PriorityQueue` in Java is a **min-heap** by default — for max-heap use `Collections.reverseOrder()`.
4. **Monotonic Deque** solves Sliding Window Maximum in O(n) — a critical optimization.
5. "Implement Queue using Stacks" is a common interview question — transfer between stacks on demand.
