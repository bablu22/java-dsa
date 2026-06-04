# Conditional Statements — Revision Notes

## Quick Revision Points

- `if-else-if` ladder: only the first matching branch runs
- `switch` works with `int`, `char`, `String`, `enum` — NOT `long`, `float`, `double`
- Missing `break` in `switch` causes fall-through to the next case
- `default` in `switch` is optional but always recommended
- Short-circuit: `&&` stops at first `false`; `||` stops at first `true`
- Ternary `(cond) ? a : b` is an expression, not a statement — it returns a value

## Common Mistakes

1. Forgetting `break` in `switch` → unintended fall-through bugs
2. Using `=` (assignment) instead of `==` (comparison) inside `if` condition
3. Comparing `String` with `==` instead of `.equals()` in `switch` or `if`
4. Nested ternaries are hard to read — prefer `if-else` for complex logic
5. Not handling the `default` case in `switch` — leads to silent bugs

## Interview Notes

- Find max of two numbers: `int max = (a > b) ? a : b;`
- Absolute value without library: `int abs = (n < 0) ? -n : n;`
- Pattern: use early return (`if (invalid) return`) to flatten nested ifs — called "guard clauses"
- In competitive programming, switch on characters is common for vowel/consonant checks
