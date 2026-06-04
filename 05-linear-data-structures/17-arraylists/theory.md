# ArrayLists — Theory

## Concepts

`ArrayList` is Java's **dynamic array** — it grows automatically when full. It is backed by a fixed-size array that resizes by 1.5× when capacity is exceeded.

```java
import java.util.ArrayList;
import java.util.List;

List<Integer> list = new ArrayList<>();
List<String> names = new ArrayList<>(Arrays.asList("Alice", "Bob"));
```

---

## Key Operations

```java
list.add(10);                // add to end — O(1) amortized
list.add(1, 99);             // insert at index — O(n)
list.get(0);                 // access by index — O(1)
list.set(0, 42);             // update by index — O(1)
list.remove(Integer.valueOf(10)); // remove by value — O(n)
list.remove(0);              // remove by index — O(n)
list.size();                 // number of elements — O(1)
list.isEmpty();              // O(1)
list.contains(42);           // O(n) linear scan
list.indexOf(42);            // O(n)
list.clear();                // O(n)
Collections.sort(list);      // O(n log n)
Collections.reverse(list);   // O(n)
```

---

## Iteration

```java
// Index-based
for (int i = 0; i < list.size(); i++) { ... }

// Enhanced for-each
for (int x : list) { ... }

// Iterator (safe for removal during iteration)
Iterator<Integer> it = list.iterator();
while (it.hasNext()) {
    int x = it.next();
    if (x < 0) it.remove();  // safe removal
}

// Java 8+ Stream
list.stream().filter(x -> x > 0).forEach(System.out::println);
```

---

## Array vs ArrayList

| Feature | Array | ArrayList |
|---------|-------|-----------|
| Size | Fixed | Dynamic |
| Type | Primitives + Objects | Objects only (use wrappers) |
| Access | O(1) | O(1) |
| Insert/Delete | O(n) | O(n) |
| Memory | Less overhead | More overhead |
| Syntax | `arr[i]` | `list.get(i)` |

---

## Useful Conversions

```java
// Array to ArrayList
Integer[] arr = {1, 2, 3};
List<Integer> list = new ArrayList<>(Arrays.asList(arr));

// ArrayList to Array
Integer[] arr2 = list.toArray(new Integer[0]);

// Primitive array to List (via streaming)
int[] prim = {1, 2, 3};
List<Integer> l = Arrays.stream(prim).boxed().collect(Collectors.toList());
```

---

## 2D ArrayList

```java
List<List<Integer>> grid = new ArrayList<>();
for (int i = 0; i < n; i++) grid.add(new ArrayList<>());
grid.get(0).add(1);
```

---

## Complexity Analysis

| Operation | Time |
|-----------|------|
| `add(e)` — end | O(1) amortized |
| `add(i, e)` — middle | O(n) |
| `get(i)` | O(1) |
| `set(i, e)` | O(1) |
| `remove(i)` | O(n) |
| `contains(e)` | O(n) |
| `size()` | O(1) |
| Resize (internal) | O(n) amortized |

---

## Key Takeaways

1. Use `ArrayList` when size is unknown or frequently changes.
2. `get()` and `set()` are O(1) — same as arrays for random access.
3. Insert/delete in the middle is O(n) — all elements must shift.
4. ArrayList stores objects, not primitives — `int` becomes `Integer` (autoboxing).
5. Never modify an ArrayList inside a for-each loop — use `Iterator.remove()` or iterate backwards.
6. Initial capacity hint: `new ArrayList<>(n)` avoids repeated resizing if you know the approximate size.
