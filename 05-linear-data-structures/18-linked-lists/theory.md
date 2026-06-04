# Linked Lists — Theory

## Concepts

A **linked list** is a linear data structure where each element (node) contains a value and a pointer (reference) to the next node. Unlike arrays, nodes are NOT stored in contiguous memory — they are scattered on the heap and connected via pointers.

---

## Types of Linked Lists

### 1. Singly Linked List
```
[data|next] → [data|next] → [data|next] → null
```

```java
class ListNode {
    int val;
    ListNode next;
    ListNode(int val) { this.val = val; }
}
```

### 2. Doubly Linked List
```
null ← [prev|data|next] ↔ [prev|data|next] ↔ [prev|data|next] → null
```

### 3. Circular Linked List
Last node points back to the head.

---

## Core Operations

### Insert at Head — O(1)
```java
ListNode newNode = new ListNode(val);
newNode.next = head;
head = newNode;
```

### Insert at Tail — O(n)
```java
ListNode curr = head;
while (curr.next != null) curr = curr.next;
curr.next = new ListNode(val);
```

### Delete a Node — O(n) to find, O(1) to delete
```java
// Delete node with value val
ListNode dummy = new ListNode(0);
dummy.next = head;
ListNode prev = dummy;
while (prev.next != null) {
    if (prev.next.val == val) { prev.next = prev.next.next; break; }
    prev = prev.next;
}
return dummy.next;
```

### Reverse a Linked List — O(n)
```java
ListNode prev = null, curr = head;
while (curr != null) {
    ListNode next = curr.next;
    curr.next = prev;
    prev = curr;
    curr = next;
}
return prev;  // new head
```

### Find Middle (Fast/Slow Pointer) — O(n)
```java
ListNode slow = head, fast = head;
while (fast != null && fast.next != null) {
    slow = slow.next;
    fast = fast.next.next;
}
return slow;  // slow is at middle
```

### Detect Cycle (Floyd's Algorithm) — O(n)
```java
ListNode slow = head, fast = head;
while (fast != null && fast.next != null) {
    slow = slow.next;
    fast = fast.next.next;
    if (slow == fast) return true;  // cycle detected
}
return false;
```

### Merge Two Sorted Lists — O(m + n)
```java
ListNode mergeSorted(ListNode l1, ListNode l2) {
    ListNode dummy = new ListNode(0), curr = dummy;
    while (l1 != null && l2 != null) {
        if (l1.val <= l2.val) { curr.next = l1; l1 = l1.next; }
        else                  { curr.next = l2; l2 = l2.next; }
        curr = curr.next;
    }
    curr.next = (l1 != null) ? l1 : l2;
    return dummy.next;
}
```

---

## Dummy Node Trick

Use a dummy node as the head's predecessor to simplify edge cases (deleting head, inserting before head):

```java
ListNode dummy = new ListNode(0);
dummy.next = head;
// ... operations using dummy.next ...
return dummy.next;  // new head
```

---

## Complexity Analysis

| Operation | Singly LL | Doubly LL |
|-----------|-----------|-----------|
| Access by index | O(n) | O(n) |
| Insert at head | O(1) | O(1) |
| Insert at tail | O(n) | O(1) with tail ptr |
| Insert at middle | O(n) find + O(1) insert | O(n) find + O(1) insert |
| Delete at head | O(1) | O(1) |
| Search | O(n) | O(n) |

---

## Key Takeaways

1. Always use a **dummy node** to simplify edge cases (empty list, deleting head).
2. The **fast/slow pointer** technique solves: find middle, detect cycle, find cycle start, detect palindrome.
3. To delete a node you only have reference to (not its predecessor): copy next node's value into current, then delete next node.
4. Reversing a linked list is an in-place O(n) operation using three pointers: `prev`, `curr`, `next`.
5. Linked lists have O(n) search — use when insertions/deletions at head are frequent and random access is not needed.
6. Java's `LinkedList` class implements both `List` and `Deque` interfaces.
