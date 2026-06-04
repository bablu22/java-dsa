# Strings — Theory

## Concepts

A **String** in Java is an immutable sequence of characters. Strings are objects of the `java.lang.String` class and are stored in the **String Pool** (a special area of the heap).

**Immutability** means: every operation that appears to modify a String actually creates a new one.

```java
String s = "hello";
s = s + " world";  // "hello" is unchanged; a new String is created
```

---

## String Creation

```java
String s1 = "hello";          // from String pool
String s2 = new String("hello"); // forces a new heap object (not from pool)

s1 == s2       // false (different references)
s1.equals(s2)  // true  (same content)
```

Always use `.equals()` or `.equalsIgnoreCase()` to compare Strings.

---

## Key String Methods

```java
String s = "Hello, World!";

s.length()              // 13
s.charAt(0)             // 'H'
s.indexOf('o')          // 4
s.lastIndexOf('o')      // 8
s.substring(7)          // "World!"
s.substring(7, 12)      // "World"     [inclusive, exclusive)
s.toLowerCase()         // "hello, world!"
s.toUpperCase()         // "HELLO, WORLD!"
s.trim()                // removes leading/trailing whitespace
s.strip()               // like trim(), but handles Unicode spaces (Java 11+)
s.replace('l', 'r')     // "Herro, Worrd!"
s.replace("Hello", "Hi")// "Hi, World!"
s.contains("World")     // true
s.startsWith("Hello")   // true
s.endsWith("!")         // true
s.isEmpty()             // false (length == 0)
s.isBlank()             // false (length == 0 or all whitespace, Java 11+)
s.split(", ")           // ["Hello", "World!"]
s.toCharArray()         // char[] {'H','e','l','l','o',',','  ','W',...}
String.valueOf(42)       // "42"
Integer.parseInt("42")  // 42
```

---

## StringBuilder (Mutable String)

Use `StringBuilder` when building strings in a loop — concatenating with `+` in a loop is O(n²).

```java
StringBuilder sb = new StringBuilder();
sb.append("Hello");
sb.append(", ");
sb.append("World");
sb.insert(5, "!");      // insert at index
sb.delete(5, 6);        // delete range [5, 6)
sb.reverse();           // reverse in-place
sb.toString();          // convert back to String
sb.length();
sb.charAt(i);
sb.setCharAt(i, 'x');
```

---

## Character Operations

```java
char c = 'A';
Character.isLetter(c)    // true
Character.isDigit(c)     // false
Character.isUpperCase(c) // true
Character.toLowerCase(c) // 'a'
(int) 'A'                // 65 — ASCII value
'A' + 1                  // 66 (promotes to int)
(char)('A' + 1)          // 'B'

// Frequency array for lowercase letters
int[] freq = new int[26];
for (char ch : s.toCharArray()) freq[ch - 'a']++;
```

---

## String Comparison

```java
s1.equals(s2)            // case-sensitive equality
s1.equalsIgnoreCase(s2)  // case-insensitive equality
s1.compareTo(s2)         // lexicographic: 0 if equal, <0 if s1 < s2, >0 if s1 > s2
```

---

## Common Patterns

### Palindrome check
```java
boolean isPalindrome(String s) {
    int l = 0, r = s.length() - 1;
    while (l < r) {
        if (s.charAt(l++) != s.charAt(r--)) return false;
    }
    return true;
}
```

### Anagram check
```java
boolean isAnagram(String s, String t) {
    if (s.length() != t.length()) return false;
    int[] count = new int[26];
    for (char c : s.toCharArray()) count[c - 'a']++;
    for (char c : t.toCharArray()) count[c - 'a']--;
    for (int x : count) if (x != 0) return false;
    return true;
}
```

### Reverse a String
```java
new StringBuilder(s).reverse().toString();
```

---

## Complexity Analysis

| Operation | String | StringBuilder |
|-----------|--------|---------------|
| `length()` | O(1) | O(1) |
| `charAt(i)` | O(1) | O(1) |
| `+` concatenation | O(n) per operation | — |
| `append()` | — | O(1) amortized |
| `substring(l, r)` | O(r-l) | — |
| `indexOf()` | O(n) | — |
| `split()` | O(n) | — |
| Build string with n appends | O(n²) with `+`, O(n) with StringBuilder |

---

## Key Takeaways

1. Strings are immutable — every modification creates a new object.
2. Always compare strings with `.equals()`, never with `==`.
3. Use `StringBuilder` for string building inside loops — it's O(n) vs O(n²).
4. `charAt(i)` is O(1); use it instead of converting to char array when only accessing a few positions.
5. Character math: `c - 'a'` gives 0-based index for lowercase letters (0–25).
6. `String.split()` accepts regex — `split("\\.")` to split on dots.
