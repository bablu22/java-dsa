# Tries — Revision Notes

## Quick Revision Points

- Trie = prefix tree; each node = one character; path = prefix or full word
- `isEnd = true` marks a complete word
- Insert, Search, Prefix Search: all O(L) where L = word length
- `search()` checks `isEnd`; `startsWith()` doesn't — KEY DIFFERENCE
- TrieNode children: `TrieNode[26]` for a-z; index = `c - 'a'`
- Tries are memory-heavy (26 pointers per node) but prefix ops are O(L) regardless of dict size

## Trie Operations Summary

```java
// Navigate to a node for string s
TrieNode traverse(String s) {
    TrieNode node = root;
    for (char c : s.toCharArray()) {
        int i = c - 'a';
        if (node.children[i] == null) return null;
        node = node.children[i];
    }
    return node;
}

search(word)    → traverse(word) != null && node.isEnd
startsWith(p)  → traverse(p) != null
```

## Common Mistakes

1. `search()` returning `true` just because the path exists — must also check `isEnd`
2. Forgetting to create a new TrieNode when inserting and the child is null
3. Using `children[26]` when words can contain uppercase or other characters — adjust size

## Interview Notes

| Problem | Trie Application |
|---------|----------------|
| Implement Trie | Build insert/search/startsWith |
| Word Search II | Trie of dictionary + DFS on board |
| Design Search Autocomplete | Trie with DFS to collect all completions |
| Replace Words | Trie + replace each word with its shortest root |
| Concatenated Words | Trie + DP |
| Longest Word in Dictionary | Trie + BFS/DFS |
| Max XOR of Two Numbers | Binary Trie on bit representation |
