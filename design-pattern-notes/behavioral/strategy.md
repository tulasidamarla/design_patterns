# Strategy design pattern

- The Strategy is a behavioural pattern that is used to define a family of algorithms that can be choosen at runtime.
- The client code can change the behavior of a given context at runtime, allowing for greater flexibility.

## Motivation
- Imagine that we are programming behavior for a house. 
- Houses can have all kinds of doors for ex, external doors, safe deposit doors, closet doors, sliding doors etc.
- All these doors share common attributes and behaviors. For ex, every door has some kind of locking and unlocking mechanism even if the 
  exact functionality might differ.
- One possible solution is to use inheritance. For ex, If Door is our base class, we can just extend our base functionality in our 
  specialized door classes. This is not a bad strategy to begin with, as we can reuse what we need and add new functionality as needed.
- Now let's say that we decide that different doors can be opened different types of ways.
  - For example, sliding doors will slide open and close, closet doors can also slide open and close. External doors can be revolving.
- In addition, each door can be made out of a different material, and have different colors.
- `Problem`
  - If most subclasses have to override many of Door's methods, then having a Door superclass don't benefit much. The class Door does not  
    tell us much about doors because all of the doors have significantly different implementation.
  - Even if we have a separate subclass for every type of Door, we are starting to lose the benefit of inheritance.
  - Also, each time we want to add a new feature, a change in Door may affect all the classes in the inheritance hierarchy resulting in 
    tight coupling.  
  - Flexibility is also lost. For ex, to create a custom safe deposit door, which locks using a keycard, made out of titanium, and has no 
    windows, we need a class `SafeDepositDoorKeyCardTitaniumNoWindows`, because the behavior of our given Door type is decided at compile time. We can't change this Door to be password protected at runtime.
- `Solution1`
  - Create `Lockable` interface and implement lock() and unlock() in sub-classes. 
  - This approach doesn't allow code reuse.
  - Imagine if there are twenty different implementation and if there is a consistent change required, then every sub-class need to be 
    modified.
- `Solution2`
  - The strategy design pattern "Encapsulate What Varies".
  - THis design identifies parts of the applications that vary and separate them from what stays constant.
  - Alter lock() and unlock() code every time for a new type of Door. So, we can implement and extend this behavior however we like, 
    without affecting the rest of the application.
  - `Identifying`
    - `Varying`
      - Door opening and closing behavior
      - Door locking and unlocking
    - `Constant`
      - size and dimensions. so, we can keep this in Door class.
  - By delegating these varying behaviors using the Strategy pattern, our main Door class does not need to worry about the 
    specifics.        

## Components
- `Context (Navigator Class)`
  - Instead of determining behavior directly or through a series of conditions, delegate the responsibility to the strategy it is provided.
  - This allows the Context to change its behavior dynamically by swapping out its strategy.
- `Strategy Interface`
  - The blueprint that ensures consistency across all strategies. We have two strategies Openable with open/close methods and a Lockable 
    strategy with lock/unlock methods.
- `Concrete Strategies`
  - These classes implement the strategy interface, defining the specific behavior or algorithm.
  - The client will choose which concrete strategy to use and pass it to the context.
- `Client`
  - The Client interacts with the Context and decides which Concrete Strategy to use.
  - It's the Client's responsibility to create strategy objects and pass them to the Context.
  - The Client can change the strategy dynamically based on certain conditions or preferences without needing to modify the Context or 
    Strategy classes themselves.
- The UML class diagram below demonstrates the strategy design pattern.

<img src="../../images/strategy.avif" height=300 width=400>

- The java code below demonstrates classic strategy design pattern.
```java
interface Lockable {
  void lock();
  void unlock();
}

class NonLocking implements Lockable {

  public void lock() {
    System.out.println("Door does not lock - ignoring");
  }

  public void unlock() {
    System.out.println("Door cannot unlock because it cannot lock");
  }
}

class Password implements Lockable {

  public void lock() {
    System.out.print("Door locked using password!");
  }

  public void unlock() {
    System.out.print("Door unlocked using password!");
  }
}

class KeyCard implements Lockable {

  public void lock() {
    // ...
  }

  public void unlock() {
    //...
  }
}

interface Openable {
  void open();
  void close();
}

class Standard implements Openable {

  public void open() {
    System.out.println("Pushing door open");
  }

  public void close() {
    System.out.println("Pulling door closed");
  }
}

class Revolving implements Openable {

  public void open() {
    //..
  }

  public void close() {
    //..
  }
}
class Sliding implements Openable {

  public void open() {
    //..
  }

  public void close() {
    //..
  }
}

abstract class Door {

  private Lockable lockBehavior;
  private Openable openBehavior;

  public void setLockBehavior(Lockable l) {
    this.lockBehavior = l;
  }

  public void setOpenBehavior(Openable o) {
    this.openBehavior = o;
  }

  public void performLock() {
    lockBehavior.lock();
  }

  public void performUnlock() {
    lockBehavior.unlock();
  }

  public void performOpen() {
    openBehavior.open();
  }

  public void performClose() {
    openBehavior.close();
  }

  public float getDimensions() {
    return 5;
  }
}

class ClosetDoor extends Door {
  //...
}

class ExternalDoor extends Door {
  //...
}

class SafeDepositDoor extends Door {
  //...
}

class SlidingDoor extends Door {
  //...
}

class Main {
  static void main(String[] args) {
    Door c;

    c = new ClosetDoor();
    c.setOpenBehavior(new Standard());
    c.setLockBehavior(new NonLocking());

    c.performOpen();
    c.performClose();

    c.performLock();
    c.performUnlock();

    // upgrade the door to a password protected door
    c.setLockBehavior(new Password());
    c.performLock();
    c.performUnlock();
  }
}
```
# Alternate solutions
- A common alternative to the strategy pattern is to simply pass in an inline / lambda function, which allows us to extend the behavior of 
  a method or class.
- Difference b/w classic strategy and Lambda functions.
  - Both the Strategy Pattern and passing lambda functions can be used to achieve similar goals, but they differ in their approach and 
    usage.
  - `How they work`  
    - `Strategy`
      - The Strategy Pattern is a design pattern that defines a family of algorithms, encapsulates each algorithm as an object (strategy), 
        and makes them interchangeable.
      - It typically involves creating a hierarchy of strategy interfaces or abstract classes, each representing a different algorithm, and 
        providing concrete implementations for each strategy.
      - The client explicitly selects and injects the desired strategy object into the context or invoker. This allows the client to switch 
        between different strategies at runtime.
      - The Strategy Pattern promotes code reusability and maintainability by encapsulating algorithms in separate classes, making it 
        easier to add new strategies or modify existing ones without modifying the client code.  
    - `Lambdas`
      - These are anonymous functions that can be used to implement functional interfaces, such as Runnable, Comparator, or custom 
        functional interfaces.
      - They provide a concise and inline way to define behavior without the need to create separate classes for each algorithm.
      - This can lead to more compact and readable code, especially for short and simple algorithms.
      - They reduce the amount of boilerplate code required for defining and using strategies.
      - They eliminate the need to create explicit strategy classes, interfaces, and implementations.
  - `Differences`
    - `Flexibility:`
      - The Strategy Pattern offers more flexibility and extensibility, as it allows for a clear separation between the context/invoker and 
        the strategies.
      - Lambda expressions offer flexibility, they are often used for simpler scenarios where strategies are shortlived or straightforward.
    - `Abstraction Level:`
      - The Strategy Pattern works at a higher level of abstraction, with explicit strategy interfaces or classes representing algorithms.
      - The Lambda functions operates at a lower level of abstraction, directly manipulating behavior through anonymous functions.
    - `Readability and Maintainability:`
      - The Strategy Pattern, with its explicit classes and interfaces, provides a more structured and self-documenting approach to 
        managing algorithms.
      - Excessive use of lambda expressions without proper context or documentation may reduce code readability and maintainability.

## Limitations and Pitfalls
- When a class has a behavior that can be realized in multiple ways, the use of the strategy pattern is a good candidate solution.
- `Limitations`
  - `Increased number of classes`
    - Every new strategy usually requires a new interface, which means it requires a new concrete strategy class.
  - `Over engineering`
    - It's tempting to use the strategy pattern wherever there's a hint of varying behavior, but sometimes a simpler solution like 
      conditional logic might be more appropriate.
    - Implementing the strategy pattern in places where it's not truly needed can make the design unnecessarily complex.  

## Use Cases
- `Payment Processing Systems` - any system where users can choose to pay with credit card, PayPal, Bitcoin etc.
- `Travel Routes` We can customize our routes when traveling. For example, we might choose a route without highways, the shortest route, 
  or the fastest route. Each of these routes have different strategies.
- `Shipping Options` - Each shipping method has its own category and its own strategy for determining cost and delivery time.  

## Assignment

```java
class Person {
    private String lastName;
    private int age;
    private boolean isMarried;

    public Person(String lastName, int age, boolean isMarried) {
        this.lastName = lastName;
        this.age = age;
        this.isMarried = isMarried;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public boolean isMarried() {
        return isMarried;
    }
}

interface PersonFilter {
    boolean apply(Person person);
}

class AdultFilter implements PersonFilter {
    public boolean apply(Person person){
        if(person.getAge() >= 18){
            return true;
        }
        return false;
    }
    // Implement Adult filter
}

class SeniorFilter implements PersonFilter {
    public boolean apply(Person person){
        if(person.getAge() >= 65){
            return true;
        }
        return false;
    }
    // Implement Senior filter
}

class MarriedFilter implements PersonFilter {
    public boolean apply(Person person){
        if(person.isMarried()){
            return true;
        }
        return false;
    }
    // Implement Married filter
}

class PeopleCounter {
    private PersonFilter filter;

    public void setFilter(PersonFilter filter) {
        this.filter = filter;
    }

    public int count(List<Person> people) {
        int count = 0;
        for(Person person: people){
            if(filter.apply(person)){
                count += 1;
            }
        }
        return count;
    }
}
//Test

class Main{
    public static void main(String[] args){
        List<Person> people = Arrays.asList(
        new Person("Doe", 20, false),
        new Person("Smith", 30, true),
        new Person("Old", 70, true)
        );

        PeopleCounter counter = new PeopleCounter();

        counter.setFilter(new AdultFilter());
        counter.count(people); // Adult count: 3

        counter.setFilter(new SeniorFilter());
        counter.count(people); // Senior count: 1

        counter.setFilter(new MarriedFilter());
        counter.count(people); // Married count: 2
    }
}
```
