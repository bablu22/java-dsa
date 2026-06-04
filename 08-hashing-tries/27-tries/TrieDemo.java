
import java.util.*;

public class TrieDemo {

    static class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean isEnd;
        int count;   // number of words passing through this node
    }

    static class Trie {
        TrieNode root = new TrieNode();

        // insert word into the trie — O(m)
        void insert(String word) {

        }

        // return true if exact word exists — O(m)
        boolean search(String word) {
            return false;
        }

        // return true if any inserted word starts with prefix — O(m)
        boolean startsWith(String prefix) {
            return false;
        }

        // return how many inserted words share this prefix
        int countWithPrefix(String prefix) {
            return 0;
        }

        // remove word from trie — O(m)
        void delete(String word) {

        }

        boolean deleteHelper(TrieNode node, String word, int depth) {
            return false;
        }

        boolean isLeaf(TrieNode n) {
            return false;
        }

        // return all words in the trie that start with prefix
        List<String> autoComplete(String prefix) {
            return new ArrayList<>();
        }

        // DFS to collect all words from node, appending to result
        void dfsCollect(TrieNode node, StringBuilder sb, List<String> result) {

        }
    }

    public static void main(String[] args) {
        // insert words, test search, startsWith, countWithPrefix, autoComplete, delete
    }

    // return longest string that is a prefix of every word in the array
    static String longestCommonPrefix(String[] words) {
        return "";
    }
}
