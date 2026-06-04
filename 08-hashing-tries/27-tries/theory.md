# Tries — Theory

## Concepts

A **Trie** (pronounced "try", from re**trie**val) is a tree-like data structure used to store strings where each node represents a character. Tries excel at prefix-based operations.

Key properties:
- Root is empty
- Each path from root to a leaf represents a stored string
- Nodes share common prefixes — efficient for autocomplete, spell check, IP routing

---

## Trie Node Structure

```java
class TrieNode {
    TrieNode[] children = new TrieNode[26];  // for lowercase a-z
    boolean isEnd = false;                   // marks end of a word
}
```

---

## Trie Operations

### Insert — O(L) where L = word length
```java
void insert(String word) {
    TrieNode node = root;
    for (char c : word.toCharArray()) {
        int idx = c - 'a';
        if (node.children[idx] == null) node.children[idx] = new TrieNode();
        node = node.children[idx];
    }
    node.isEnd = true;
}
```

### Search — O(L)
```java
boolean search(String word) {
    TrieNode node = root;
    for (char c : word.toCharArray()) {
        int idx = c - 'a';
        if (node.children[idx] == null) return false;
        node = node.children[idx];
    }
    return node.isEnd;  // must be a complete word
}
```

### StartsWith (Prefix Search) — O(L)
```java
boolean startsWith(String prefix) {
    TrieNode node = root;
    for (char c : prefix.toCharArray()) {
        int idx = c - 'a';
        if (node.children[idx] == null) return false;
        node = node.children[idx];
    }
    return true;  // prefix exists — don't check isEnd
}
```

### Complete Trie Class
```java
class Trie {
    private TrieNode root = new TrieNode();

    public void insert(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            int i = c - 'a';
            if (node.children[i] == null) node.children[i] = new TrieNode();
            node = node.children[i];
        }
        node.isEnd = true;
    }

    public boolean search(String word) {
        TrieNode node = traverse(word);
        return node != null && node.isEnd;
    }

    public boolean startsWith(String prefix) {
        return traverse(prefix) != null;
    }

    private TrieNode traverse(String s) {
        TrieNode node = root;
        for (char c : s.toCharArray()) {
            int i = c - 'a';
            if (node.children[i] == null) return null;
            node = node.children[i];
        }
        return node;
    }
}
```

---

## Advanced Trie Applications

### Word Search with Wildcard ('.' matches any character)
```java
boolean searchWithWildcard(String word, int idx, TrieNode node) {
    if (idx == word.length()) return node.isEnd;
    char c = word.charAt(idx);
    if (c == '.') {
        for (TrieNode child : node.children) {
            if (child != null && searchWithWildcard(word, idx + 1, child)) return true;
        }
        return false;
    }
    int i = c - 'a';
    return node.children[i] != null && searchWithWildcard(word, idx + 1, node.children[i]);
}
```

### Count Words with Prefix
Add a `count` field to TrieNode:
```java
class TrieNode {
    TrieNode[] children = new TrieNode[26];
    boolean isEnd = false;
    int prefixCount = 0;  // how many words pass through this node
}
// Increment on insert; decrement on delete
```

---

## Trie vs HashMap for String Storage

| Feature | Trie | HashMap |
|---------|------|---------|
| Space | O(n × L) | O(n × L) |
| Insert | O(L) | O(L) |
| Search | O(L) | O(L) avg |
| Prefix search | O(L) | O(n × L) — scan all keys |
| Sorted iteration | Yes (DFS) | No |
| Autocomplete | Natural | Inefficient |

**Use Trie when:** prefix queries, autocomplete, dictionary lookups, counting words with a given prefix.

---

## Complexity Analysis

| Operation | Time | Space |
|-----------|------|-------|
| Insert | O(L) | O(L) per word |
| Search | O(L) | O(1) |
| Prefix Search | O(L) | O(1) |
| Delete | O(L) | O(1) |
| Space (n words, avg length L) | — | O(n × L × 26) |

---

## Key Takeaways

1. Tries are the most efficient structure for **prefix operations** — O(L) regardless of dictionary size.
2. The classic TrieNode has `children[26]` for lowercase letters + an `isEnd` flag.
3. `search()` checks `isEnd`; `startsWith()` does NOT — the key difference.
4. Adding `count` fields enables counting words with a given prefix in O(L).
5. Trie uses more memory than HashMap (26 pointers per node) but enables operations HashMap can't do efficiently.
