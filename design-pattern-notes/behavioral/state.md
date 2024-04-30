# State design pattern

- The state design pattern allows an object to change its behavior when its internal state changes.
- Let's take an example of a mobile device to explain this.
  - A mobile power button and home button.
  - The actions the power button perform vary based on the condition(state) in which the phone is in.
    - state1: When the phone is locked and display not on, pressing the power button turn the display on.
    - state2: when the phone display is on and locked, pressing the power button will unlock the phone.
    - state3: when the phone is unlocked, pressing the power button will lock the phone.
    - state4: when the phone is on, pressing home and power button will power off the phone.
- At any given moment there are finite no of states. In every unique state, the program behaves differently.
- A state can switch the program to another one state or not switch at all.
- The switching rules(transitions) are predetermined and finite.
  - For ex, from display off state a phone can go in to Locked state.
  - From locked state a phone can go to unlocked state or power off state.
  - From unlocked state a phone can go to locked state or power off state.
- `Components`
  - `Context:` The object that changes states. In the above example, it is Phone.
    - This call holds the State object along with other methods as shown below.
  - `State` This is an interface (or abstract class) that defines the operations that can be performed on an object in a particular state. For ex, 
    clicking on home button and clicking on power button.
  - `Concrete State:` These are classes that implement the State interface and provide specific implementations for the operations based on the state 
    they represent. For ex, OffState(Display off), ReadyState, LockedState and PowerOffState.

    
      
```java
class Phone{
    private State state;
    Phone(State state){
        state = new OffState(this);
    }

    public void setState(State state){
        this.state = state;
    }

    Public String lock(){
        return "Locking phone and turn off the screen";
    }

    Public String home(){
        return "Going to home screen";
    }

    Public String unlock(){
        return "Unlocking the phone to home";
    }

    Public String turnOn(){
        return "Turning the phone on, device is still locked";
    }
}

abstract class State(){
    protected Phone phone;
    public State(Phone phone){
        this.phone = phone;
    }

    abstract String onHome();
    abstract String onPowerButton();
}

class OffState extends State{
    public State(Phone phone){
        super(phone);
    }

    @Override
    public String onHome(){
        phone.setState(new LockedState());
        return phone.turnOn();
    }
 
    @Override 
    public String onPowerButton(){
        phone.setState(new LockedState());
        return phone.turnOn();
    }
}

class ReadyState extends State{
    public State(Phone phone){
        super(phone);
    }

    @Override
    public String onHome(){
        return phone.home();
    }
 
    @Override 
    public String onPowerButton(){
        phone.setState(new OffState());
        return phone.lock();
    }
}

class LockedState extends State{
    public State(Phone phone){
        super(phone);
    }

    @Override
    public String onHome(){
        phone.setState(new ReadyState());
        return phone.unlock();
    }
 
    @Override 
    public String onPowerButton(){
        phone.setState(new OffState());
        return phone.lock();
    }
}

// To simulate this behavior, here is the test code.
public static void main(String[] args){
    Phone phone = new Phone();
    JButton home = new JButton("Home");
    home.addActionListener(e -> phone.state.onHome());
    JButton power = new JButton("Power");
    power.addActionListener(e -> phone.state.onPowerButton());
}
```
- Please see the below UML class diagram for state design pattern.

<img src="../../images/state.png" height=300 width=400>

- `Summary:`
  - State pattern extracts each behavior to a seperate class and let the context delegate to the corresponding state class instead of primitive if-else 
    logic.
- Advantages
  - `Single Responsibility principle:` Each state is organized into a seperate class.
  - `Open-Closed Principle:` Ability to introduce new states without changing existing states.

## State vs Strategy

- Similarities
  - We can consider State is an extension of Strategy as both patterns are based on composition.
  - Both change the behavior of the context by delegating some work to helper objects.
- Differences
  - Though both change the behavior of the context, Concrete strategies are independent and unaware of each other, where as States are dependent and can 
    jump from one state to other.
  - Strategy pattern has multiple strategy implementations, but they all achieve same behavior. For ex, Differnt sorting strategies achieve sorting 
    behavior only, whereas State pattern is all about different behaviors depending on state.

