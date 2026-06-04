
public class BinarySearchTree {

    static class Node {
        int val;
        Node left, right;
        Node(int val) { this.val = val; }
    }

    static class BST {
        Node root;

        // insert val maintaining BST property
        void insert(int val) {

        }

        Node insertRec(Node n, int val) {
            return null;
        }

        // return true if val exists in the tree
        boolean search(int val) {
            return false;
        }

        boolean searchRec(Node n, int val) {
            return false;
        }

        // remove node with val; replace with in-order successor if two children
        void delete(int val) {

        }

        Node deleteRec(Node n, int val) {
            return null;
        }

        // return node with smallest value
        Node minNode(Node n) {
            return null;
        }

        // return node with largest value
        Node maxNode(Node n) {
            return null;
        }

        // return largest value ≤ val
        int floor(int val) {
            return 0;
        }

        // return smallest value ≥ val
        int ceiling(int val) {
            return 0;
        }

        // return the kth smallest value (1-indexed) using in-order traversal
        int kthSmallest(int k) {
            return 0;
        }

        // return lowest common ancestor of values a and b
        Node lca(int a, int b) {
            return null;
        }

        // return true if tree satisfies BST property for all nodes
        boolean isValid() {
            return false;
        }

        // print values in sorted order
        void inorder() {

        }
    }

    public static void main(String[] args) {
        // insert [5,3,7,1,4,6,8], test search, delete, floor, ceiling, kthSmallest, lca
    }
}
