# Greedy Algorithms — Theory

## Concepts

A **greedy algorithm** makes the locally optimal choice at each step, hoping it leads to a globally optimal solution. It never backtracks or reconsiders past decisions.

**When greedy works:** when a **greedy-choice property** and **optimal substructure** can be proven — the locally optimal choice is always part of the globally optimal solution.

---

## Greedy vs Dynamic Programming

| | Greedy | Dynamic Programming |
|-|--------|---------------------|
| Approach | Pick best now, no backtrack | Consider all options |
| When to use | Provably optimal local choice | Overlapping subproblems |
| Efficiency | Usually faster | Usually slower |
| Example | Activity Selection | 0/1 Knapsack |

---

## Classic Greedy Problems

### 1. Activity Selection (Interval Scheduling) — O(n log n)
Select the maximum number of non-overlapping activities.

**Strategy:** Always pick the activity with the earliest finishing time.

```java
// Sort by finish time
Arrays.sort(activities, (a, b) -> a[1] - b[1]);
int count = 1, lastEnd = activities[0][1];
for (int i = 1; i < activities.length; i++) {
    if (activities[i][0] >= lastEnd) {  // start >= last end
        count++;
        lastEnd = activities[i][1];
    }
}
```

### 2. Merge Intervals — O(n log n)
```java
Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
List<int[]> result = new ArrayList<>();
result.add(intervals[0]);
for (int i = 1; i < intervals.length; i++) {
    int[] last = result.get(result.size() - 1);
    if (intervals[i][0] <= last[1]) last[1] = Math.max(last[1], intervals[i][1]);
    else result.add(intervals[i]);
}
```

### 3. Fractional Knapsack — O(n log n)
(Unlike 0/1 Knapsack which requires DP)
```java
// Sort by value/weight ratio descending
Arrays.sort(items, (a, b) -> Double.compare((double)b[1]/b[0], (double)a[1]/a[0]));
double totalValue = 0;
for (int[] item : items) {
    if (capacity >= item[0]) { totalValue += item[1]; capacity -= item[0]; }
    else { totalValue += (double) item[1] / item[0] * capacity; break; }
}
```

### 4. Jump Game — O(n)
Can you reach the last index?
```java
int maxReach = 0;
for (int i = 0; i < nums.length; i++) {
    if (i > maxReach) return false;
    maxReach = Math.max(maxReach, i + nums[i]);
}
return true;
```

### 5. Gas Station — O(n)
```java
int total = 0, tank = 0, start = 0;
for (int i = 0; i < gas.length; i++) {
    tank += gas[i] - cost[i];
    total += gas[i] - cost[i];
    if (tank < 0) { start = i + 1; tank = 0; }
}
return total >= 0 ? start : -1;
```

### 6. Minimum Platforms (Train Schedule) — O(n log n)
Sort arrivals and departures separately, use two pointers.

---

## Graph-Based Greedy Algorithms

### Dijkstra's Shortest Path — O((V + E) log V)
Greedy: always process the unvisited vertex with the smallest known distance.

```java
int[] dist = new int[n]; Arrays.fill(dist, Integer.MAX_VALUE);
dist[src] = 0;
PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
pq.offer(new int[]{src, 0});
while (!pq.isEmpty()) {
    int[] curr = pq.poll();
    int u = curr[0], d = curr[1];
    if (d > dist[u]) continue;  // stale entry
    for (int[] edge : graph.get(u)) {
        int v = edge[0], w = edge[1];
        if (dist[u] + w < dist[v]) {
            dist[v] = dist[u] + w;
            pq.offer(new int[]{v, dist[v]});
        }
    }
}
```

### Kruskal's MST — O(E log E)
Sort edges by weight, add edge if it doesn't form a cycle (using Union-Find).

### Prim's MST — O(E log V)
Start from any vertex, always add the minimum weight edge that connects a new vertex.

---

## Complexity Analysis

| Algorithm | Time | Space |
|-----------|------|-------|
| Activity Selection | O(n log n) | O(1) |
| Fractional Knapsack | O(n log n) | O(1) |
| Dijkstra | O((V+E) log V) | O(V) |
| Kruskal's MST | O(E log E) | O(V) |

---

## Key Takeaways

1. Greedy works when **locally optimal choices lead to a globally optimal solution** — not always true.
2. **Sort first** — most greedy problems start by sorting by some key (finish time, value/weight ratio, weight).
3. Dijkstra is a greedy BFS with a priority queue — it fails on negative edges (use Bellman-Ford instead).
4. 0/1 Knapsack is NOT greedy (fractional Knapsack is) — a key distinction.
5. When in doubt between greedy and DP: try a greedy proof; if you can't prove it, use DP.
