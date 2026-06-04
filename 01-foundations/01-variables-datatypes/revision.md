# Variables & Data Types — Revision Notes

## Quick Revision Points

- 8 primitive types: byte, short, int, long, float, double, char, boolean
- Default values: numeric → 0, boolean → false, reference → null
- `int` is 4 bytes; `long` needs `L` suffix (e.g. `100L`)
- `char` is a 16-bit unsigned integer — can add/subtract characters
- Autoboxing converts primitive ↔ wrapper class automatically
- `String` is immutable; `StringBuilder` is mutable and more efficient for
  building strings

## Common Mistakes

1. Integer overflow — use `long` when multiplying large `int` values
2. Comparing `Integer` objects with `==` instead of `.equals()` — `==` compares
   references
3. Forgetting `L` suffix on long literals larger than `Integer.MAX_VALUE`
4. Dividing two ints and expecting a double: `5 / 2 = 2` not `2.5` — cast first:
   `(double) 5 / 2`

## Interview Notes

- Know `Integer.MAX_VALUE = 2^31 - 1 = 2,147,483,647` and
  `Integer.MIN_VALUE = -2^31`
- Common trick: use `long` to avoid overflow in problems involving sums of array
  elements
- `char` arithmetic: `'a' - 'a' = 0`, `'z' - 'a' = 25` — used in frequency
  arrays
- Frequency array pattern: `int[] freq = new int[26]` for lowercase letters
