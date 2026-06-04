
public class SegmentTree {

    // ── Range Sum Segment Tree ────────────────────────────────────────────
    static class SegTree {
        int[] tree;
        int n;

        SegTree(int[] arr) {

        }

        // build tree from arr in O(n)
        void build(int[] arr, int node, int start, int end) {

        }

        // update single element at index idx to val — O(log n)
        void update(int idx, int val) {

        }

        void updateHelper(int node, int start, int end, int idx, int val) {

        }

        // return sum of elements in range [l..r] — O(log n)
        int query(int l, int r) {
            return 0;
        }

        int queryHelper(int node, int start, int end, int l, int r) {
            return 0;
        }
    }

    // ── Range Min Segment Tree ────────────────────────────────────────────
    static class MinSegTree {
        int[] tree;
        int n;

        MinSegTree(int[] arr) {

        }

        void build(int[] arr, int node, int start, int end) {

        }

        // return minimum value in range [l..r]
        int query(int l, int r) {
            return 0;
        }

        int queryHelper(int node, int start, int end, int l, int r) {
            return 0;
        }
    }

    // ── Lazy Propagation (range add update + range sum query) ─────────────
    static class LazySegTree {
        long[] tree, lazy;
        int n;

        LazySegTree(int[] arr) {

        }

        void build(int[] arr, int node, int start, int end) {

        }

        // push pending lazy update down to children
        void propagate(int node, int start, int end) {

        }

        // add val to every element in [l..r] — O(log n)
        void rangeUpdate(int l, int r, long val) {

        }

        void updateHelper(int node, int start, int end, int l, int r, long val) {

        }

        // return sum of [l..r] — O(log n)
        long query(int l, int r) {
            return 0;
        }

        long queryHelper(int node, int start, int end, int l, int r) {
            return 0;
        }
    }

    // ── Fenwick Tree / BIT (prefix sums, O(log n) update & query) ─────────
    static class BIT {
        int[] bit;
        int n;

        BIT(int n) {

        }

        // add delta to index i (0-indexed)
        void update(int i, int delta) {

        }

        // return prefix sum [0..i]
        int prefixSum(int i) {
            return 0;
        }

        // return sum of [l..r]
        int rangeSum(int l, int r) {
            return 0;
        }
    }

    public static void main(String[] args) {
        // build each tree on a sample array
        // test point update, range query, lazy range update
    }
}
