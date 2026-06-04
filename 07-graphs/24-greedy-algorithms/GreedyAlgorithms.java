
import java.util.*;

public class GreedyAlgorithms {

    public static void main(String[] args) {
        // call and print results of each method below
    }

    // return max number of non-overlapping activities (sort by end time)
    static int activitySelection(int[] start, int[] end) {
        return 0;
    }

    // return maximum value achievable with given capacity (fractions allowed)
    static double fractionalKnapsack(int[] weights, int[] values, int capacity) {
        return 0;
    }

    // return list of coins used to make amount (greedy, standard denominations)
    static List<Integer> coinChange(int[] coins, int amount) {
        return new ArrayList<>();
    }

    // return maximum profit from scheduling one job per deadline slot
    static int jobScheduling(int[] deadlines, int[] profits) {
        return 0;
    }

    // Huffman node
    static class HNode implements Comparable<HNode> {
        char ch;
        int freq;
        HNode left, right;
        HNode(char ch, int freq) { this.ch = ch; this.freq = freq; }

        @Override
        public int compareTo(HNode o) { return 0; }  // compare by freq
    }

    // build Huffman tree using a min-heap; print each character's binary code
    static void buildHuffman(char[] chars, int[] freq) {

    }

    // recursively print codes: left edge = '0', right edge = '1'
    static void printCodes(HNode n, String code) {

    }

    // return minimum number of platforms needed so no train waits
    static int minPlatforms(int[] arrival, int[] departure) {
        return 0;
    }
}
