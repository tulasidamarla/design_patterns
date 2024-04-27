# Decorator design pattern
- The decorator pattern is a structural design pattern that lets you attach new behaviors to objects by encapsulating
  these objects inside wrapper classes that contain these behaviors.
- Decorator uses composition over inheritance to achieve this.
- Let's see an example of designing a system that dynamically changing nature of coffee orders.
- Let us understand the problem with inheritance.
```java
public class Beverage {
    public double cost() {
        return 1.00;
    }
}

public class BeverageWithMilk extends Beverage {
    public double cost() {
        return super.cost() + 0.50;
    }
}

public class BeverageWithMilkAndSugar extends BeverageWithMilk {
    public double cost() {
        return super.cost() + 0.25;
    }
}

// ... and an explosion of classes
```
- If there were only a handful of combinations and no additional condiments could ever be added, 
  this design is a good choice. 
- But condiments change and this approach will create a combinatorial explosion of classes, leading to very inflexible design.
- `Solution`
  - The decorator pattern provides with a more dynamic and flexible approach.
  - It allows to add and modify attributes and behaviors at runtime.
  - It favors composition over inheritance, because it offers more flexibility.
- `Design and Implementation`
  - `Component (abstract class or interface)`: This is the abstract class or interface that `both the abstract 
    decorator and concrete component` will implement/extend.
  - `ConcreteComponent:` This is the concrete implementation which extends the component class and will provide an 
    implementation to all the methods of the Component. 
  - `Decorator(abstract class):` This is the base decorator class, which will be extended by the concrete decorators.
    It consists of a HAS-A reference to the Component class/interface.
  - `ConcreteDecorator:` The concrete decorators will be the ones providing a concrete implementation to the base 
    abstract decorators. They can be added dynamically at runtime and they override the base decorators behavior.

<img src="../../images/decorator.avif" height=300 width=400>

- Here is the implementation design UML for the Coffee example.

<img src="../../images/decorator_implementation.avif" height=300 width=400>

- Here is the complete code.
```java
//Component
abstract class Beverage {
  abstract double cost();
  abstract String description();
}

//Concrete implemenations
class DarkRoast extends Beverage {
  @Override
  public double cost() {
    return 3.45;
  }

  @Override
  public String description() {
    return "Dark Roast";
  }
}

class LightRoast extends Beverage {

  @Override
  public double cost() {
    return 3.45;
  }

  @Override
  public String description() {
    return "Light Roast";
  }
}

//Decorator
abstract class BeverageDecorator extends Beverage {

  protected Beverage beverage;

  public BeverageDecorator(Beverage beverage) {
    this.beverage = beverage;
  }
}

// Concrete Decorators
class EspressoDecorator extends BeverageDecorator {

  public EspressoDecorator(Beverage beverage) {
    super(beverage);
  }

  @Override
  public double cost() {
    return 0.5 + beverage.cost();
  }

  @Override
  public String description() {
    return beverage.description() + ", Espresso";
  }
}

class CreamDecorator extends BeverageDecorator {

  public CreamDecorator(Beverage beverage) {
    super(beverage);
  }

  @Override
  public double cost() {
    return 0.3 + beverage.cost();
  }

  @Override
  public String description() {
    return beverage.description() + ", Cream";
  }
}

class FoamDecorator extends BeverageDecorator {

  public FoamDecorator(Beverage beverage) {
    super(beverage);
  }

  @Override
  public double cost() {
    return 0.2 + beverage.cost();
  }

  @Override
  public String description() {
    return beverage.description() + ", Foam";
  }
}

//Client or Test class

class Main {

  public static void main(String[] args) {
    Beverage beverage = new FoamDecorator(
            new CreamDecorator(new EspressoDecorator(new LightRoast()))
    );
    System.out.println(beverage.description()); // Light Roast, Espresso, Cream, Foam
    System.out.println(beverage.cost()); // 4.45
  }
}
```
## Limitations and Pitfalls
- `Might violate interface segregation principle`
  - The decorator pattern requires the decorated component and the decorator itself to adhere to the same interface.
  - If the interface is broad and has methods that the decorator does not need, the decorator will be forced to 
    implement all these methods, which is a violation of the interface segregation principle.
- `Increases complexity`
  - A new decorator adds a new layer of abstraction, which can make the code harder to understand.

# Use Cases
- `Point of Sale Systems:` Point of sale systems can make use of the decorator design pattern to compute the 
  cost of the overall purchase, with discounts and add-ons etc.
- `Graphical User Interfaces:` The decorator pattern is very common when adding visual or behavior functionalities 
  to GUI components dynamically. For ex, making a window scrollable, adding borders, colors and modifying fonts, 
  etc all can be achieved through decorators.
- `Middleware in Web Development:`Implementing middleware to augment request and response objects in web frameworks 
  by adding functionalities like authentication, authorization, logging and error handling.
  - Examples:
    - `Servlet Filters:` Filters can be used to perform tasks such as authentication, logging, compression, and caching.
      Each filter typically implements the javax.servlet.Filter interface, which defines a doFilter() method. Each 
      decorator filter implements the javax.servlet.Filter interface and delegates the doFilter() method to the 
      wrapped filter, adding its own logic before or after the delegation.
    - `Spring Interceptors:` Interceptors are used for tasks such as logging, security, transaction management, and 
      internationalization. Interceptors in Spring MVC typically implement the org.springframework.web.servlet.HandlerInterceptor 
      interface, which defines preHandle(), postHandle(), and afterCompletion() methods. Each interceptor decorator 
      implements the HandlerInterceptor interface and delegates the methods to the wrapped interceptor, adding its 
      own logic before or after the delegation.

## What we achieve
- `Open/Closed Principle:` It is easy to add new features using decorator.
- `Composition over Inheritance:` The decorator enhances flexibility as decorators using composition.
- `Single Responsibility Principle:` Each decorator class is responsible for adding or altering a specific aspect 
  or behavior of a component.