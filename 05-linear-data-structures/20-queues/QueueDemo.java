
import java.util.*;

public class QueueDemo {

    public static void main(String[] args) {
        // demonstrate Queue<Integer> with offer/poll/peek
        // demonstrate Deque with offerFirst/offerLast
        // demonstrate PriorityQueue (min-heap and max-heap)
        // call bfs and slidingMax below
    }

    // BFS traversal from node 0 over an implicit binary tree of n nodes
    static void bfs(int n) {

    }

    // return array of max values in each sliding window of size k
    static int[] slidingMax(int[] a, int k) {
        return new int[0];
    }

    // array-based circular queue
    static class CircularQueue {
        int[] data;
        int head, tail, size, capacity;

        CircularQueue(int capacity) {

        }

        // add val to the rear; return false if full
        boolean enqueue(int val) {
            return false;
        }

        // remove from the front; return false if empty
        boolean dequeue() {
            return false;
        }

        int peek() {
            return -1;
        }

        int size() {
            return 0;
        }

        boolean isEmpty() {
            return false;
        }
    }
}
