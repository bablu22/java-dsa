# Greedy Algorithms — Revision Notes

## Quick Revision Points

- Make locally optimal choice at each step; never backtrack
- Works when: greedy-choice property + optimal substructure are provable
- Most greedy problems: sort first, then scan with a condition
- Fractional Knapsack = greedy (OK to take fractions); 0/1 Knapsack = DP
- Dijkstra = greedy shortest path; fails on negative edges
- Interval problems: sort by END time for selection; by START time for merging

## Greedy Patterns

| Problem Type | Greedy Strategy |
|-------------|----------------|
| Interval Scheduling | Sort by finish time, pick earliest non-overlapping |
| Merge Intervals | Sort by start, merge if overlapping |
| Fractional Knapsack | Sort by value/weight ratio descending |
| Huffman Encoding | Build from least frequent nodes first (min-heap) |
| Task Scheduler | Schedule most frequent task first |
| Jump Game | Track max reachable index |

## Common Mistakes

1. Assuming greedy works without proving it — 0/1 Knapsack is the classic trap
2. Sorting by wrong key — activity selection needs sort by END, not START
3. Dijkstra on negative weights → incorrect result (use Bellman-Ford)
4. Gas Station: resetting `tank` when negative but forgetting to reset `start`

## Interview Notes

- Greedy vs DP: "Can we always make a safe local choice?" → greedy. "Do we need to try all options?" → DP
- Common greedy trigger words: "minimum number of", "maximum non-overlapping", "earliest/latest"
- Platform problem: max overlapping intervals at any point = number of platforms needed
