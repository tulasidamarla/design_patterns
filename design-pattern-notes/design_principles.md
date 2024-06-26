# DRY
- DRY stands for don't repeat yourself
- DRY means don't write duplicate code.
- Violation of DRY leads to WET(wasting everyone's time).
  - If a change is required, it needs be done at all locations.
- Use abstraction and write a sepearte method for duplicate code.

# KISS
- KISS stands for keep it simple and stupid.
- KISS principle suggests to do the following.
  - A method should have single type of task.
  - A method should be small.
  - If the method gets larger, break it into smaller methods.
- KISS principle has the following advantages.
  - Makes the function focused on single task.
  - Easier to understand.
  - Easier to change.
  - More robust and don't fail often.

# YAGNI
- YAGNI stands for you are not gonna need it.
- It suggests to not implement a fuctionality until needed.
  - To accommodate future requirements, don't include unnecessary code.
- Violation of this principle has the following disadvantages.
  - Cost of delay
  - Cost to carry
  - Cost to repair

# SLAP
- SLAP stands for single level abstraction principle.
- It means a function should have single responsibility.
- Violation of SLAP has many disadvantages.
  - Hard to read, test, debug, maintain and reuse.
  - Contains many reasons to change
  - Low cohesion and high coupling
  - Difficult to optimize

# SOLID
- SOLID design principle is a combination of 5 sub-principles.

## Single responsibility principle
- S in SOLID stands for Single responsibility.
- It means that a class should have one reason to change.

## Open/Closed principle
- Open closed principle stands for a class should be open for extension 
  but closed for modification.
  - For ex, if a super class has generic functionality and can be 
    extended in a sub class type if needed. The super class functionality should require no modification to accommodate this change.
- So, don't write specialized code in a generic class. This is a violation 
  of Open/Closed principle as it calls for modification whenever new subtype is needed.

## Liskov Substitution principle
- A class can be replaced by its sub-class.
- This means that subclasses should behave in such a way that they can be 
  used as drop-in replacements for their parent classes.
- The principle helps in designing inheritance hierarchies in a way that 
  promotes flexibility, extensibility, and maintainability of the codebase.
- To adhere to LSP, subclasses should follow the following rules:
  - The signature of methods in the subclass should match the signature of 
    methods in the superclass.
  - The preconditions (requirements) of methods in the superclass should  
    be at least as strong in the subclass.
  - The postconditions (guarantees) of methods in the superclass should be 
    at least as weak in the subclass.
  - Invariants of the superclass should be preserved in the subclass.
- For ex:
  - The `Bird` class has fly method.
  - The `Sparrow` can extend `Bird`.
  - When another `Bird` like `Ostrich` extends `Bird` it is violation of LSP, because it can't fly..
  - To fix the issue, Let's create another class `FlyingBird` which extends `Bird`.
  - Now `Sparrow` extends `FlyingBird` and `Ostrich` extends `Bird`.

## Interface segregation principle

- The key idea behind the Interface Segregation Principle is to minimize the dependencies between components 
  in a system and to prevent clients from being burdened with unnecessary or irrelevant functionality. 
- This leads to more modular, cohesive, and maintainable code.
- The key points of principle are
  - Client-specific interfaces: Interfaces should be designed to cater to the specific needs of the clients  
    that use them. Each client should have its own interface that provides only the methods it needs.
  - No "fat" interfaces: Avoid creating large, monolithic interfaces that include methods unrelated to the 
    client's requirements. Instead, aim for lean, focused interfaces that contain only the methods required by each client.
  - Interface segregation: Interfaces should be segregated based on the roles or responsibilities of the 
    clients that use them. This promotes loose coupling between components and allows for greater flexibility and maintainability. 
- To apply the Interface Segregation Principle effectively, consider the following strategies:
  - Identify the different clients or consumers of your interfaces.
  - Design interfaces that are tailored to the specific needs of each client.
  - Avoid coupling clients to interfaces they do not use.
  - Refactor existing interfaces to adhere to the principle, if necessary.
  - Use composition or delegation to provide clients with the functionality they need, rather than   
    inheritance or inheritance-based interfaces.
- For ex:
  - A `Worker` interface has two methods `work` and `sleep`.
  - A `Human` class can implement the interface `Worker`, because it needs both the methods.
  - A `Robot` class doesn't need to implement `sleep`, it requires only `work` method.
  - This is a violation of the principle. To avoid this, create a seperate interface for `sleep`, so that 
    this can be implemented by the clients who need it.

# Dependency inversion principle
- The Dependency Inversion Principle suggests that
  - `Abstractions should not depend on concrete implementations:` High-level modules or components (such as 
    business logic) should depend on abstract interfaces or classes rather than on specific implementations of those interfaces or classes.
  - `Concrete implementations should depend on abstractions:` Lower-level modules or components (such as 
    database access or external services) should depend on the same abstract interfaces or classes. This allows different implementations of these interfaces to be easily swapped in without affecting the higher-level components.
    
