# Graphs — Theory

## Concepts

A **graph** is a non-linear data structure consisting of **vertices** (nodes) and **edges** (connections). Unlike trees, graphs can have cycles and are not necessarily connected.

- **Directed (Digraph):** edges have direction (A → B)
- **Undirected:** edges go both ways (A ↔ B)
- **Weighted:** edges have costs/weights
- **Unweighted:** all edges are equal

---

## Graph Representations

### 1. Adjacency List (Most Common — Sparse Graphs)
```java
List<List<Integer>> graph = new ArrayList<>();
for (int i = 0; i < n; i++) graph.add(new ArrayList<>());
graph.get(u).add(v);  // directed edge u → v
graph.get(v).add(u);  // undirected: add both
```

### 2. Adjacency Matrix (Dense Graphs)
```java
int[][] matrix = new int[n][n];
matrix[u][v] = 1;  // edge exists
matrix[u][v] = w;  // weighted edge
// Space: O(V²) — good only when E ≈ V²
```

### 3. Edge List
```java
int[][] edges = {{0,1,5}, {1,2,3}, ...};  // [from, to, weight]
```

---

## Graph Traversals

### BFS — Breadth First Search — O(V + E)
```java
void bfs(int start, List<List<Integer>> graph) {
    boolean[] visited = new boolean[graph.size()];
    Queue<Integer> queue = new LinkedList<>();
    visited[start] = true;
    queue.offer(start);
    while (!queue.isEmpty()) {
        int node = queue.poll();
        for (int neighbor : graph.get(node)) {
            if (!visited[neighbor]) {
                visited[neighbor] = true;
                queue.offer(neighbor);
            }
        }
    }
}
```

### DFS — Depth First Search — O(V + E)
```java
void dfs(int node, boolean[] visited, List<List<Integer>> graph) {
    visited[node] = true;
    for (int neighbor : graph.get(node)) {
        if (!visited[neighbor]) dfs(neighbor, visited, graph);
    }
}
```

---

## Cycle Detection

### Undirected Graph (DFS with parent tracking)
```java
boolean hasCycle(int node, int parent, boolean[] visited, List<List<Integer>> graph) {
    visited[node] = true;
    for (int neighbor : graph.get(node)) {
        if (!visited[neighbor]) {
            if (hasCycle(neighbor, node, visited, graph)) return true;
        } else if (neighbor != parent) return true;  // back edge = cycle
    }
    return false;
}
```

### Directed Graph (DFS with recursion stack)
```java
boolean hasCycleDirected(int node, boolean[] visited, boolean[] recStack, ...) {
    visited[node] = true; recStack[node] = true;
    for (int neighbor : graph.get(node)) {
        if (!visited[neighbor] && hasCycleDirected(neighbor, visited, recStack, graph)) return true;
        else if (recStack[neighbor]) return true;
    }
    recStack[node] = false;
    return false;
}
```

---

## Topological Sort

Only for **Directed Acyclic Graphs (DAGs)**. Ordering of vertices such that for every directed edge (u → v), u comes before v.

### DFS-based
```java
void topoSort(int node, boolean[] visited, Deque<Integer> stack, List<List<Integer>> graph) {
    visited[node] = true;
    for (int neighbor : graph.get(node)) {
        if (!visited[neighbor]) topoSort(neighbor, visited, stack, graph);
    }
    stack.push(node);  // add AFTER visiting all descendants
}
```

### Kahn's Algorithm (BFS-based)
```java
int[] inDegree = new int[n];
for (List<Integer> neighbors : graph) for (int v : neighbors) inDegree[v]++;
Queue<Integer> queue = new LinkedList<>();
for (int i = 0; i < n; i++) if (inDegree[i] == 0) queue.offer(i);
List<Integer> order = new ArrayList<>();
while (!queue.isEmpty()) {
    int node = queue.poll();
    order.add(node);
    for (int neighbor : graph.get(node)) {
        if (--inDegree[neighbor] == 0) queue.offer(neighbor);
    }
}
// If order.size() < n → cycle exists (not a DAG)
```

---

## Shortest Path

### BFS — Unweighted graph — O(V + E)
BFS naturally gives shortest path in unweighted graphs.

### Dijkstra — Weighted, no negative edges — O((V+E) log V)
Use priority queue (min-heap on distance).

### Bellman-Ford — Weighted, negative edges allowed — O(VE)
Relax all edges V-1 times.

---

## Union-Find (Disjoint Set)

Used for connected components, cycle detection in undirected graphs.

```java
int[] parent, rank;
int find(int x) {
    if (parent[x] != x) parent[x] = find(parent[x]);  // path compression
    return parent[x];
}
void union(int x, int y) {
    int px = find(x), py = find(y);
    if (px == py) return;
    if (rank[px] < rank[py]) { int t = px; px = py; py = t; }
    parent[py] = px;
    if (rank[px] == rank[py]) rank[px]++;
}
```

---

## Complexity Analysis

| Algorithm | Time | Space |
|-----------|------|-------|
| BFS | O(V + E) | O(V) |
| DFS | O(V + E) | O(V) |
| Topological Sort | O(V + E) | O(V) |
| Dijkstra | O((V+E) log V) | O(V) |
| Bellman-Ford | O(VE) | O(V) |
| Union-Find (path compression) | O(α(n)) ≈ O(1) | O(V) |

---

## Key Takeaways

1. Use BFS for shortest path in **unweighted** graphs; Dijkstra for **weighted positive** edges; Bellman-Ford for **negative edges**.
2. Topological sort = valid course schedule — only works on DAGs; if a cycle exists, no valid order exists.
3. Union-Find with path compression is nearly O(1) per operation — use it for connected component problems.
4. DFS on directed graphs: visiting a node in the recursion stack = cycle.
5. Graph problems often reduce to BFS/DFS — recognize the pattern (flood fill = BFS/DFS on grid).
