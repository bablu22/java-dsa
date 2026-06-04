# Operators — Theory

## Concepts

An **operator** is a symbol that tells the compiler to perform a specific operation on operands. Java has a rich set of operators grouped by function.

---

## 1. Arithmetic Operators

| Operator | Operation | Example | Result |
|----------|-----------|---------|--------|
| `+` | Addition | `5 + 3` | `8` |
| `-` | Subtraction | `5 - 3` | `2` |
| `*` | Multiplication | `5 * 3` | `15` |
| `/` | Division | `7 / 2` | `3` (integer division) |
| `%` | Modulus (remainder) | `7 % 2` | `1` |

```java
int a = 7, b = 2;
System.out.println(a / b);   // 3  — truncates decimal for int
System.out.println(a % b);   // 1
System.out.println((double) a / b);  // 3.5 — cast to get decimal
```

---

## 2. Relational (Comparison) Operators

| Operator | Meaning | Example |
|----------|---------|---------|
| `==` | Equal to | `5 == 5` → `true` |
| `!=` | Not equal | `5 != 3` → `true` |
| `<` | Less than | `3 < 5` → `true` |
| `>` | Greater than | `5 > 3` → `true` |
| `<=` | Less than or equal | `5 <= 5` → `true` |
| `>=` | Greater than or equal | `5 >= 6` → `false` |

---

## 3. Logical Operators

| Operator | Name | Behaviour |
|----------|------|-----------|
| `&&` | AND | `true` only if both sides are `true` |
| `\|\|` | OR | `true` if at least one side is `true` |
| `!` | NOT | Inverts the boolean value |

**Short-circuit evaluation:**
- `&&` — if left side is `false`, right side is NOT evaluated
- `||` — if left side is `true`, right side is NOT evaluated

```java
int x = 5;
if (x != 0 && 10 / x > 1) { ... }  // safe — division skipped if x == 0
```

---

## 4. Bitwise Operators

Operate on individual bits of integer types.

| Operator | Name | Example (a=5=0101, b=3=0011) | Result |
|----------|------|-------------------------------|--------|
| `&` | AND | `5 & 3` | `1` (0001) |
| `\|` | OR | `5 \| 3` | `7` (0111) |
| `^` | XOR | `5 ^ 3` | `6` (0110) |
| `~` | NOT | `~5` | `-6` |
| `<<` | Left shift | `5 << 1` | `10` (multiply by 2) |
| `>>` | Right shift | `5 >> 1` | `2` (divide by 2) |
| `>>>` | Unsigned right shift | `5 >>> 1` | `2` |

---

## 5. Assignment Operators

| Operator | Equivalent |
|----------|------------|
| `a += b` | `a = a + b` |
| `a -= b` | `a = a - b` |
| `a *= b` | `a = a * b` |
| `a /= b` | `a = a / b` |
| `a %= b` | `a = a % b` |
| `a &= b` | `a = a & b` |
| `a \|= b` | `a = a \| b` |
| `a ^= b` | `a = a ^ b` |
| `a <<= b` | `a = a << b` |
| `a >>= b` | `a = a >> b` |

---

## 6. Unary Operators

```java
int a = 5;
a++;   // post-increment: use then increment → 5, a becomes 6
++a;   // pre-increment:  increment then use → 7
a--;   // post-decrement
--a;   // pre-decrement
-a;    // negation
!true; // logical NOT → false
```

---

## 7. Ternary Operator

```java
int max = (a > b) ? a : b;
// equivalent to:
// if (a > b) max = a; else max = b;
```

---

## 8. instanceof Operator

```java
Object obj = "Hello";
if (obj instanceof String) {
    System.out.println("It is a String");
}
```

---

## Operator Precedence (High → Low)

| Level | Operators |
|-------|-----------|
| 1 (highest) | `++` `--` (postfix) |
| 2 | `++` `--` `+` `-` `!` `~` (prefix/unary) |
| 3 | `*` `/` `%` |
| 4 | `+` `-` |
| 5 | `<<` `>>` `>>>` |
| 6 | `<` `>` `<=` `>=` `instanceof` |
| 7 | `==` `!=` |
| 8 | `&` |
| 9 | `^` |
| 10 | `\|` |
| 11 | `&&` |
| 12 | `\|\|` |
| 13 | `?:` (ternary) |
| 14 (lowest) | `=` `+=` `-=` etc. |

---

## Complexity Analysis

All operator expressions evaluate in O(1).

---

## Key Takeaways

1. Integer division truncates: `7 / 2 = 3`. Cast one operand to `double` for decimal result.
2. `%` on negative numbers: `-7 % 2 = -1` in Java (sign follows dividend).
3. `&&` and `||` short-circuit — use this to guard against null/division errors.
4. `==` compares references for objects; use `.equals()` for value comparison.
5. `<<1` = multiply by 2, `>>1` = divide by 2 — useful in bit manipulation problems.
6. Pre-increment (`++a`) vs post-increment (`a++`) matters in expressions, not in standalone statements.
