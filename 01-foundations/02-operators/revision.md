# Operators — Revision Notes

## Quick Revision Points

- `7 / 2 = 3` (integer division truncates) — cast to `double` for `3.5`
- `7 % 2 = 1` — modulus gives remainder; sign follows the dividend in Java
- `&&` and `||` short-circuit: right side not evaluated if result is already known
- `==` on objects compares references, not values — use `.equals()` instead
- `a++` returns old value; `++a` returns new value
- `<<1` multiplies by 2; `>>1` divides by 2

## Common Mistakes

1. Using `==` to compare `String` or `Integer` objects — always use `.equals()`
2. Forgetting integer division: `1 / 2 = 0`, not `0.5`
3. `%` with negatives: `-7 % 2 = -1` — add `n` when you need a positive result: `((n % m) + m) % m`
4. Operator precedence surprise: `2 + 3 * 4 = 14`, not `20` — multiplication before addition
5. Confusing `&` (bitwise AND, no short-circuit) with `&&` (logical AND, short-circuits)

## Interview Notes

- Check if a number is even: `n % 2 == 0`
- Check if a number is odd: `(n & 1) == 1` — faster bitwise check
- Check if a number is a power of 2: `n > 0 && (n & (n - 1)) == 0`
- Swap two variables without temp: `a ^= b; b ^= a; a ^= b;`
- Ternary is useful for compact min/max: `int min = (a < b) ? a : b;`
- Modular arithmetic pattern in circular problems: `(index + 1) % n`
