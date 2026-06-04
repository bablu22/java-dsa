# Functions & Methods — Revision Notes

## Quick Revision Points

- Java is **pass-by-value** — primitives are copied; object references are copied (not the object)
- Method overloading: same name, different parameter types or counts
- `static` methods: called on class, no object needed
- Instance methods: called on an object, can access `this`
- Recursion needs a base case — without it → `StackOverflowError`
- `void` return type means no value is returned; use plain `return;` for early exit

## Common Mistakes

1. Expecting a primitive to change after being passed to a method — it won't (pass-by-value)
2. Overloading by return type alone — won't compile
3. Recursion without base case → infinite recursion → stack overflow
4. Calling an instance method without creating an object first
5. Shadow variable: declaring a local variable with the same name as a parameter hides the outer one

## Interview Notes

- "Pass by value or reference?" → Java is always pass-by-value. For objects, the reference is passed by value.
- Recursion vs iteration trade-off: recursion uses O(n) stack space; iteration uses O(1)
- Pure function = same input always gives same output, no side effects — preferred in functional programming
- Method signature = name + parameter types (not return type)
- `Math.max`, `Math.min`, `Math.abs` are used constantly in DSA — know them
