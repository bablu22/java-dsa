# Bit Manipulation — Revision Notes

## Quick Revision Points

- `n & 1` → check odd/even (1=odd, 0=even)
- `n & (n-1)` → removes lowest set bit; `n & (n-1) == 0` → power of 2
- `n & (-n)` → isolates lowest set bit
- `n ^ n = 0`; `n ^ 0 = n` — XOR trick for finding unique element
- `n << k` = multiply by 2^k; `n >> k` = divide by 2^k
- `1 << k` = bit mask for position k
- `n | (1<<k)` = set bit k; `n & ~(1<<k)` = clear bit k; `n ^ (1<<k)` = toggle bit k

## Cheatsheet

| Task | Code |
|------|------|
| Is even? | `(n & 1) == 0` |
| Is odd? | `(n & 1) == 1` |
| Is power of 2? | `n > 0 && (n & (n-1)) == 0` |
| Count set bits | `Integer.bitCount(n)` |
| Remove lowest set bit | `n & (n-1)` |
| Isolate lowest set bit | `n & (-n)` |
| Check bit k | `(n >> k) & 1` |
| Set bit k | `n \| (1 << k)` |
| Clear bit k | `n & ~(1 << k)` |
| Toggle bit k | `n ^ (1 << k)` |

## Common Mistakes

1. `1 << 31` overflows `int` — use `1L << 31` for long shifts
2. `~n` for int gives `-(n+1)` due to two's complement — understand this
3. `>>` vs `>>>`: `>>` is arithmetic (sign-preserving), `>>>` is logical (fills 0s)
4. Operator precedence: `n & 1 == 0` → parsed as `n & (1 == 0)` — always add parentheses

## Interview Notes

- Find single non-duplicate: XOR all elements → remaining is the answer
- Find two non-duplicate elements: XOR all, find a differing bit, partition and XOR
- Number of bits to flip to convert A to B: `Integer.bitCount(A ^ B)`
- Reverse bits: `Integer.reverse(n)`
- Missing number in 0..n: XOR all indices and values
