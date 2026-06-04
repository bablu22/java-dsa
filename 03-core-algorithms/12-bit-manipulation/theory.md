# Bit Manipulation — Theory

## Concepts

Bit manipulation operates directly on the binary representation of integers. It provides extremely fast, O(1) operations that replace arithmetic or loop-based solutions.

In Java, integers are 32-bit (int) or 64-bit (long) signed two's complement numbers.

---

## Binary Representation

```
Decimal  Binary
0        0000
1        0001
2        0010
3        0011
4        0100
5        0101
6        0110
7        0111
8        1000
-1       11111111 11111111 11111111 11111111  (two's complement)
```

---

## Bitwise Operators

| Operator | Name | Operation |
|----------|------|-----------|
| `&` | AND | 1 only if both bits are 1 |
| `\|` | OR | 1 if at least one bit is 1 |
| `^` | XOR | 1 if bits differ |
| `~` | NOT | flips all bits |
| `<<` | Left shift | multiply by 2^n |
| `>>` | Right shift (signed) | divide by 2^n (preserves sign) |
| `>>>` | Unsigned right shift | fills with 0s |

---

## Essential Bit Tricks

### Check if a number is even or odd
```java
if ((n & 1) == 0)  // even
if ((n & 1) == 1)  // odd
```

### Check if bit k is set
```java
boolean isSet = (n & (1 << k)) != 0;
```

### Set bit k (turn it ON)
```java
n = n | (1 << k);
```

### Clear bit k (turn it OFF)
```java
n = n & ~(1 << k);
```

### Toggle bit k
```java
n = n ^ (1 << k);
```

### Remove lowest set bit
```java
n = n & (n - 1);
// Use: count set bits, check power of 2
```

### Get lowest set bit
```java
int lsb = n & (-n);   // isolates rightmost 1-bit
```

### Check if n is a power of 2
```java
boolean isPow2 = (n > 0) && (n & (n - 1)) == 0;
```

### Count set bits (Brian Kernighan's Algorithm)
```java
int count = 0;
while (n != 0) {
    n &= (n - 1);  // removes one set bit per iteration
    count++;
}
// Or use: Integer.bitCount(n)
```

### XOR Properties
```java
a ^ 0 = a       // XOR with 0 gives same number
a ^ a = 0       // XOR with itself gives 0
a ^ b ^ a = b   // XOR is associative and commutative
```

### Find the single non-duplicate in an array (all others appear twice)
```java
int result = 0;
for (int x : arr) result ^= x;
// result holds the unique element
```

### Swap two numbers without temp variable
```java
a ^= b;
b ^= a;
a ^= b;
```

---

## Left and Right Shift

```java
n << k   equals   n * 2^k
n >> k   equals   n / 2^k   (for positive n)

5 << 1  = 10    (5 * 2)
5 << 2  = 20    (5 * 4)
20 >> 2 = 5     (20 / 4)
-4 >> 1 = -2    (arithmetic shift — sign preserved)
-4 >>> 1        (logical shift — fills with 0)
```

---

## Complexity Analysis

All bit operations are O(1). Counting set bits with Kernighan's = O(number of set bits).

---

## Key Takeaways

1. `n & 1` is faster than `n % 2` for even/odd check.
2. `n & (n-1)` removes the lowest set bit — core of set-bit counting and power-of-2 check.
3. XOR is the go-to for "find the odd one out" / "find the unique element" problems.
4. `1 << k` creates a mask with only bit k set — use to check, set, clear, toggle individual bits.
5. Prefer `Integer.bitCount(n)` in production; implement manually in interviews to show understanding.
6. Bit tricks are O(1) and often turn O(n) solutions into constant time.
