# Chain of responsibility
- The Chain of responsibility pattern transform particular behaviors into stand alone objects called handlers.
- The Chain of Responsibility allows an object to pass a request along a chain of handlers. 
- Each handler in the chain has the opportunity to process the request(optionally can pass to next handler) or pass it on to the next 
  handler in the chain.
- This pattern decouples the sender of a request from its receiver.
- `Components`
  - `Handler:` This is the base interface (or abstract class) that defines the operation (handle) for processing a request. 
  - `Concrete Handler:` These classes extend the Handler interface and implement the handle method with their specific processing 
    logic.
  - `setSuccessor:` This method (optional) allows a handler to define the next handler in the chain.
  - `Client:` This object initiates the request and sends it to the first object in the chain.
- `How it works`
  - `Operators`
    - Each operator is a concrete handler and can decide whether to pass the request further or not.
    - Operators contain actual code and are self-contained.
    - Operators usually are immutable. They accept all data at once through constructor.
  - `Handler`  
    - Operators implement the handler interface. 
    - Handler usually contains a single method for handling requests, typically named handleRequest.
    - Chaining next handler logic usually present inside the concrete handlers.
    - Sometimes, Handlers also contain an additional method for assigning next handler. This scenario occurs when client wants to 
        create a pipeline(chaining of handlers) by themselves.
    - `Base Handler`
    - If there is any boiler plate code that is common for all handlers, that can be written in this base handler abstract class.
  - `Client`
    - Client composes the chain of handlers.
    - This can be done once or dynamically depending on the application's business logic.
    - The request that client composes can be sent to any handler in the chain, not necessarily the first handler.

- `UML Class diagram`

<img src="../../images/chain_of_responsibility.png" height=400 width=400>  

- `Example`
  - Let's take a scenario of Customer care center request. The process starts with an ivr(robot), followed by a general executive and 
    then followed by request specific exective.
  - Another example is an authentication app. A user must pass several checks in an order.
    - Validate username to verify if user exists, Validate password and Validate permissions or roles to access something.
    - If not valid, the app has to redirect the user to sign-in again.

- `Benefits:`
  - `Decoupled Request Handling:` Objects don't need to know the exact handler responsible for their request. They simply send it to the first handler in the chain.
  - `Flexible Request Processing:` New handlers can be added without modifying existing code.
  - `Centralized Request Handling Logic:` Separates request handling logic from core object functionalities.
