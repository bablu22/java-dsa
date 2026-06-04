
import java.util.*;

public class GraphDemo {

    public static void main(String[] args) {
        // build a sample adjacency list graph and call each method below
    }

    // add undirected edge between u and v
    static void addEdge(List<List<Integer>> g, int u, int v) {

    }

    // BFS from src; print visited nodes in order
    static void bfs(List<List<Integer>> g, int src) {

    }

    // DFS from u; print visited nodes in order
    static void dfs(List<List<Integer>> g, int u, boolean[] vis) {

    }

    // return true if undirected graph has a cycle (BFS parent-tracking)
    static boolean hasCycleBFS(List<List<Integer>> g, int n) {
        return false;
    }

    // Kahn's algorithm: return topological order of a DAG (BFS / in-degree)
    static List<Integer> topoSortKahn(List<List<Integer>> g, int n) {
        return new ArrayList<>();
    }

    // Dijkstra: return shortest distances from src to all nodes
    static int[] dijkstra(List<List<int[]>> g, int n, int src) {
        return new int[0];
    }

    // Union-Find helpers for Kruskal
    static int[] parent, rank;

    // return root of x with path compression
    static int find(int x) {
        return 0;
    }

    // union by rank; return false if already in the same set
    static boolean union(int x, int y) {
        return false;
    }

    // Kruskal's MST: sort edges by weight, union if no cycle; return total weight
    static int kruskalMST(int[][] edges, int n) {
        return 0;
    }
}
