# Graphs — Revision Notes

## Quick Revision Points

- Adjacency list: O(V + E) space — preferred for sparse graphs
- Adjacency matrix: O(V²) space — preferred for dense graphs or edge lookup
- BFS: uses queue; finds shortest path in unweighted graphs
- DFS: uses recursion/stack; finds connected components, cycles, topological order
- Topological sort: only DAGs; Kahn's = BFS on in-degrees; DFS = push after all neighbors done
- Union-Find: tracks connected components; O(α(n)) with path compression + union by rank

## Algorithm Selection Guide

| Need | Algorithm |
|------|----------|
| Shortest path (unweighted) | BFS |
| Shortest path (weighted, no negatives) | Dijkstra |
| Shortest path (negative edges) | Bellman-Ford |
| All-pairs shortest path | Floyd-Warshall |
| Minimum Spanning Tree | Kruskal or Prim |
| Connected components | Union-Find or BFS/DFS |
| Cycle detection (undirected) | DFS with parent |
| Cycle detection (directed) | DFS with recursion stack |
| Ordering with dependencies | Topological Sort |

## Common Mistakes

1. BFS visited array: mark visited when **offered to queue** (not when polled) — avoids duplicate enqueue
2. Topological sort on cyclic graph → output will have fewer than V nodes
3. Dijkstra: skip stale entries — `if (d > dist[u]) continue;`
4. Union-Find: always use path compression AND union by rank for near-O(1) performance

## Interview Notes

| Problem | Graph Pattern |
|---------|--------------|
| Number of Islands | BFS/DFS flood fill |
| Course Schedule | Topological sort + cycle check |
| Clone Graph | BFS with HashMap (old→new) |
| Word Ladder | BFS on word transformations |
| Accounts Merge | Union-Find |
| Pacific Atlantic Water Flow | Multi-source BFS from both shores |
| Cheapest Flights within K Stops | Modified Dijkstra / Bellman-Ford |
