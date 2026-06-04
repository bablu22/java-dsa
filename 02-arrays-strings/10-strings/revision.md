# Strings — Revision Notes

## Quick Revision Points

- String is immutable — every "change" creates a new String object
- `==` compares references; `.equals()` compares content — always use `.equals()`
- `StringBuilder` for mutable string building — `append()` is O(1) amortized
- `charAt(i)` is O(1); `substring(l,r)` is O(r-l) — creates new string
- `c - 'a'` maps lowercase letters to 0-25 index for frequency arrays
- `toCharArray()` converts String to `char[]` for manipulation

## Common Mistakes

1. String concatenation in a loop with `+` → O(n²) — use `StringBuilder`
2. `s.split(".")` splits on every character (`.` is regex "any char") — use `s.split("\\.")`
3. `s.substring(l, r)` is exclusive of `r` — common off-by-one
4. Comparing `String` with `==` after operations — always `.equals()`
5. Forgetting that `String.charAt()` returns a `char`, which promotes to `int` in arithmetic

## Interview Notes

| Problem | Key Technique |
|---------|--------------|
| Palindrome | Two pointers from both ends |
| Anagram | Frequency array `int[26]` or sort both strings |
| Longest Substring No Repeat | Sliding window + HashSet |
| Longest Common Prefix | Vertical scan or binary search |
| String to Integer (atoi) | Manual parse with edge cases |
| Count vowels/consonants | `"aeiou".indexOf(c)` check |
| Check if all unique chars | `HashSet` or `int[128]` |
| Reverse words | Split + join reversed |

- XOR trick for char frequency: `freq ^= (1 << (c - 'a'))` — used in palindrome permutation problems
- `String.format("%05d", n)` for padded number strings
