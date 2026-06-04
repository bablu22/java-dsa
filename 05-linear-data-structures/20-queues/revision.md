# Queues — Revision Notes

## Quick Revision Points

- FIFO: First In, First Out — insert at rear, remove from front
- Use `ArrayDeque` for queue (faster than `LinkedList`)
- `PriorityQueue` = min-heap by default; use `Collections.reverseOrder()` for max-heap
- `Deque` = double-ended queue — can act as both stack and queue
- BFS always uses a queue — it's the fundamental queue application
- Monotonic Deque: sliding window maximum in O(n)

## Queue API Quick Reference

```java
Queue<Integer> q = new ArrayDeque<>();
q.offer(x);   // enqueue (returns false if fails)
q.poll();     // dequeue (returns null if empty)
q.peek();     // front element (null if empty)
```

## Common Mistakes

1. Using `add()`/`remove()` instead of `offer()`/`poll()` — former throws exceptions on failure
2. Forgetting `levelSize = queue.size()` snapshot before level-order loop — queue grows during the loop
3. PriorityQueue: `peek()` returns min (not max) by default
4. Modifying deque while iterating

## Interview Notes

| Problem | Pattern |
|---------|---------|
| BFS on graph/tree | Queue + visited set |
| Level-order traversal | Queue with level-size snapshot |
| Sliding window maximum | Monotonic deque |
| Rotten Oranges | Multi-source BFS |
| Queue using two stacks | Lazy transfer: move in→out only when out is empty |
| Task Scheduler | Priority Queue + greedy |
| K closest points | Max-heap of size K |
