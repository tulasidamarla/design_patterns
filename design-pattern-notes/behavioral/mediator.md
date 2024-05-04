# Mediator design pattern

- The mediator pattern defines an object that encapsulates how a set of objects interact.
- The mediator design pattern is a way to structure interactions between a bunch of objects in your code. 
- It introduces a mediator object that acts as a central hub for communication. 
- Objects don't talk to each other directly, instead, they send messages to the mediator, and the mediator then figures out how to 
  handle those messages and potentially notify other objects.
- `Advantages`
  - Loose Coupling: By using a mediator, objects don't need to know about each other's implementation details. This makes the code 
    more flexible and easier to maintain.
  - Centralized Communication Logic: The mediator becomes the single point of control for how objects interact. This can simplify 
    reasoning about how different parts of your code work together.
- Here's a basic example to illustrate the concept:
  - A chat room application with two types of objects: User and ChatRoom. Without the mediator pattern, a User object 
    might send a message directly to another User object in the same chat room.
```java
class User {
  public void sendMessage(String message, User recipient) {
    // Send message directly to recipient
  }
}
```
- The above approach has some drawbacks. To add functionality like private messages or notifications, user class needs to be modified 
  to handle those scenarios.
- Let's introduce a ChatRoom object as the mediator:

```java
class ChatRoom {
  private List<User> users;

  public void sendMessage(String message, User sender) {
    for (User user : users) {
      if (user != sender) {
        user.receiveMessage(message, sender);
      }
    }
  }

  public void addUser(User user) {
    users.add(user);
  }
}

class User {
  private ChatRoom chatRoom;

  public User(ChatRoom chatRoom) {
    this.chatRoom = chatRoom;
    chatRoom.addUser(this);
  }

  public void sendMessage(String message) {
    chatRoom.sendMessage(message, this);
  }

  public void receiveMessage(String message, User sender) {
    // Display message
  }
}
```

- In this example, the User objects only know about the ChatRoom object. They send messages through the chat room, which then iterates 
  through all the users and delivers the message. 
- This makes it easier to add new features like private messages by modifying the ChatRoom class to handle those scenarios without 
  changing the User class.
- The mediator pattern is useful when you have complex interactions between multiple objects and want to improve the maintainability 
  and flexibility of your code.
- For additional information refer <a href="https://en.wikipedia.org/wiki/Mediator_pattern">mediator_pattern_wiki</a>