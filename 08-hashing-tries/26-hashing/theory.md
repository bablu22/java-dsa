# Hashing — Theory

## Concepts

**Hashing** maps keys to indices in a fixed-size array (hash table) using a **hash function**. It provides average O(1) get/put/delete operations — the most powerful data structure for lookup.

```
key → hash function → index in table → value
```

---

## Hash Function

A good hash function:
1. Is deterministic — same key always gives same hash
2. Distributes keys uniformly to minimize collisions
3. Is fast to compute

```java
// Java's built-in: Object.hashCode()
"hello".hashCode()    // consistent hash for strings
(42).hashCode()       // Integer wraps to its own value
```

---

## Collision Resolution

Two keys mapping to the same index is a **collision**.

### 1. Chaining (Java's HashMap uses this)
Each bucket holds a linked list of entries that hash to the same index.

```
index 3: [("cat", 1)] → [("bat", 2)] → null
```

### 2. Open Addressing (Linear Probing)
On collision, find the next empty slot by probing.

---

## Java HashMap

```java
Map<String, Integer> map = new HashMap<>();
map.put("apple", 3);
map.get("apple");            // 3
map.getOrDefault("mango", 0); // 0 (key absent)
map.containsKey("apple");    // true
map.containsValue(3);        // true
map.remove("apple");
map.size();
map.isEmpty();

// Iterate
for (Map.Entry<String, Integer> entry : map.entrySet()) {
    System.out.println(entry.getKey() + ": " + entry.getValue());
}
for (String key : map.keySet()) { ... }
for (int val : map.values()) { ... }

// Merge (count frequency)
map.merge(key, 1, Integer::sum);   // put 1, or add 1 to existing

// Compute if absent
map.computeIfAbsent(key, k -> new ArrayList<>()).add(val);
```

---

## Java HashSet

```java
Set<Integer> set = new HashSet<>();
set.add(5);
set.contains(5);  // true — O(1)
set.remove(5);
set.size();

// Set operations
set1.retainAll(set2);  // intersection
set1.addAll(set2);     // union
set1.removeAll(set2);  // difference
```

---

## Common HashMap Patterns

### Frequency Count
```java
Map<Character, Integer> freq = new HashMap<>();
for (char c : s.toCharArray()) freq.merge(c, 1, Integer::sum);
// or: freq.put(c, freq.getOrDefault(c, 0) + 1);
```

### Two Sum (Complement Lookup)
```java
Map<Integer, Integer> seen = new HashMap<>();
for (int i = 0; i < nums.length; i++) {
    if (seen.containsKey(target - nums[i])) return new int[]{seen.get(target-nums[i]), i};
    seen.put(nums[i], i);
}
```

### Group Anagrams
```java
Map<String, List<String>> groups = new HashMap<>();
for (String s : strs) {
    char[] ca = s.toCharArray(); Arrays.sort(ca);
    String key = new String(ca);
    groups.computeIfAbsent(key, k -> new ArrayList<>()).add(s);
}
```

### Subarray Sum Equals K (Prefix Sum + HashMap)
```java
int count = 0, sum = 0;
Map<Integer, Integer> prefixCount = new HashMap<>();
prefixCount.put(0, 1);
for (int x : nums) {
    sum += x;
    count += prefixCount.getOrDefault(sum - k, 0);
    prefixCount.merge(sum, 1, Integer::sum);
}
```

---

## Linked HashMap and Tree Map

```java
// LinkedHashMap — maintains insertion order
Map<String, Integer> linked = new LinkedHashMap<>();

// TreeMap — sorted by key (Red-Black BST)
Map<String, Integer> sorted = new TreeMap<>();
sorted.firstKey(); sorted.lastKey(); sorted.floorKey(k); sorted.ceilingKey(k);
```

---

## Complexity Analysis

| Operation | HashMap (average) | HashMap (worst) | TreeMap |
|-----------|------------------|-----------------|---------|
| put | O(1) | O(n) — all keys collide | O(log n) |
| get | O(1) | O(n) | O(log n) |
| remove | O(1) | O(n) | O(log n) |
| containsKey | O(1) | O(n) | O(log n) |
| Space | O(n) | O(n) | O(n) |

Java 8+: HashMap uses a balanced BST (Red-Black) for buckets with 8+ entries → worst case O(log n).

---

## Key Takeaways

1. HashMap lookup is O(1) average — the go-to structure for any "check if seen before" problem.
2. `getOrDefault(key, 0)` and `merge(key, 1, Integer::sum)` are cleaner than null-checking manually.
3. Use `HashSet` when you only care about membership, not values.
4. Prefix sum + HashMap solves "subarray sum = k" in O(n) — a critical pattern.
5. Use `LinkedHashMap` to maintain insertion order (LRU Cache pattern).
6. Use `TreeMap` when you need sorted keys or range queries.
