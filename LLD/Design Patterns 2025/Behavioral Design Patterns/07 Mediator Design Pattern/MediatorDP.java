/**
 * Mediator Design Pattern Example
 * This example demonstrates the Mediator Design Pattern by implementing a simple chat application.
 * The ChatMediator interface defines methods for sending messages and adding users.
 * The ChatMediatorImpl class implements the mediator logic, allowing users to communicate without knowing about each other directly.
 * The User class represents a participant in the chat, capable of sending and receiving messages.
 * The main method sets up the chat environment and demonstrates message passing.
 * This pattern promotes loose coupling between components, making the system easier to maintain and extend.
 * 
 */

import java.util.*;
import java.lang.*;
import java.io.*;

interface ChatMediator {
    void sendMessage(String message, User user);
    void addUser(User user);
}

class ChatMediatorImpl implements ChatMediator {
    private List<User> users;

    public ChatMediatorImpl() {
        this.users = new ArrayList<>();
    }

    @Override
    public void sendMessage(String message, User user) {
        for (User u : users) {
            // Don't send the message to the user who sent it
            if (u != user) {
                u.receive(message);
            }
        }
    }

    @Override
    public void addUser(User user) {
        this.users.add(user);
    }
}

class User {
    private String name;
    private ChatMediator mediator;

    public User(String name, ChatMediator mediator) {
        this.name = name;
        this.mediator = mediator;
    }

    public void send(String message) {
        System.out.println(this.name + ": Sending Message=" + message);
        mediator.sendMessage(message, this);
    }

    public void receive(String message) {
        System.out.println(this.name + ": Received Message=" + message);
    }
}

public class MediatorDP {
    public static void main(String[] args) {
        ChatMediator mediator = new ChatMediatorImpl();

        User user1 = new User("Alice", mediator);
        User user2 = new User("Bob", mediator);
        User user3 = new User("Charlie", mediator);

        mediator.addUser(user1);
        mediator.addUser(user2);
        mediator.addUser(user3);

        user1.send("Hello everyone!");
        user2.send("Hi Alice!");
        user3.send("Good morning!");
    }
}
