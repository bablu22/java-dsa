# OOP — Revision Notes

## Quick Revision Points

- 4 pillars: Encapsulation, Inheritance, Polymorphism, Abstraction
- `private` fields + `public` getters/setters = Encapsulation
- `extends` = Inheritance (single parent only)
- Method overloading = compile-time polymorphism
- Method overriding = runtime polymorphism
- `abstract class` can have state and concrete methods; `interface` cannot have state
- A class can `implement` multiple interfaces but `extend` only one class
- `this` = current object; `super` = parent class

## Common Mistakes

1. Forgetting `super(...)` as the first line in a subclass constructor when parent has no default constructor
2. Using `==` to compare objects instead of `.equals()`
3. Overriding without `@Override` — typo in method name goes undetected
4. Making fields `public` instead of `private` — breaks encapsulation
5. Confusing `static` method (class-level) with instance method (object-level)
6. Calling an overridden method via a parent reference — runtime polymorphism applies, so the child's version runs

## Interview Notes

- **IS-A vs HAS-A:** Inheritance = IS-A; Composition = HAS-A. Prefer composition over inheritance.
- Interface vs abstract class: use interface for a contract (capability); use abstract class for shared implementation.
- **SOLID principles** (know these): Single Responsibility, Open/Closed, Liskov Substitution, Interface Segregation, Dependency Inversion
- Upcasting: `Animal a = new Dog()` — always safe (implicit)
- Downcasting: `Dog d = (Dog) a` — requires explicit cast, may throw `ClassCastException`
- `instanceof` before downcasting: `if (a instanceof Dog d) { ... }` (Java 16+ pattern matching)
