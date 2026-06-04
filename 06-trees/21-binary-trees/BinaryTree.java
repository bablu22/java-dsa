
import java.util.*;

public class BinaryTree {

    static class Node {
        int val;
        Node left, right;
        Node(int val) { this.val = val; }
    }

    public static void main(String[] args) {
        // build a sample tree and call each method below
    }

    // left → root → right
    static void inorder(Node n) {

    }

    // root → left → right
    static void preorder(Node n) {

    }

    // left → right → root
    static void postorder(Node n) {

    }

    // return list of levels, each level is a list of node values
    static List<List<Integer>> levelOrder(Node root) {
        return new ArrayList<>();
    }

    // return height (number of edges on longest root-to-leaf path)
    static int height(Node n) {
        return 0;
    }

    // return diameter (longest path between any two nodes, counted in edges)
    static int diameter(Node n) {
        return 0;
    }

    // return maximum path sum (path can start and end at any node)
    static int maxPathSum(Node root) {
        return 0;
    }

    // return total number of nodes
    static int countNodes(Node n) {
        return 0;
    }

    // return number of leaf nodes
    static int countLeaves(Node n) {
        return 0;
    }

    // return true if no subtree differs in height by more than 1
    static boolean isBalanced(Node n) {
        return false;
    }

    // mirror (invert) the tree in-place
    static void mirrorTree(Node n) {

    }

    // return first visible node at each level from the left
    static List<Integer> leftView(Node root) {
        return new ArrayList<>();
    }

    // return first visible node at each level from the right
    static List<Integer> rightView(Node root) {
        return new ArrayList<>();
    }

    // return sum of node values at each level
    static List<Long> levelSums(Node root) {
        return new ArrayList<>();
    }
}
