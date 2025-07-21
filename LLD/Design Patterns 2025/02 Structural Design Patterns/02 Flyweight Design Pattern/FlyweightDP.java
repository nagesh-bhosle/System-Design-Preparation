/**
 * Flyweight Design Pattern Example
 * This example demonstrates the Flyweight Design Pattern
 * to minimize memory usage by sharing objects.
 * It uses a Circle interface and a ConcreteCircle class
 * to represent circles of different colors and radii.
 * The CircleFactory class manages the
 * creation and sharing of Circle objects.
 * The main method demonstrates
 * the functionality of the Flyweight pattern.
 * 
 */


import java.util.*;
import java.lang.*;
import java.io.*;

interface Circle {
    void draw();
}

class ConcreteCircle implements Circle {
    private String color;
    private int radius;

    public ConcreteCircle(String color, int radius) {
        this.color = color;
        this.radius = radius;
    }

    @Override
    public void draw() {
        System.out.println("Drawing a " + color + " circle with radius " + radius);
    }
}

class CircleFactory {
    private Map<String, Circle> circleMap = new HashMap<>();

    public Circle getCircle(String color, int radius) {
        String key = color + radius;
        if (!circleMap.containsKey(key)) {
            circleMap.put(key, new ConcreteCircle(color, radius));
        }
        return circleMap.get(key);
    }
}

public class FlyweightDP {
    public static void main(String[] args) {
        CircleFactory circleFactory = new CircleFactory();

        Circle redCircle = circleFactory.getCircle("Red", 5);
        redCircle.draw();

        Circle blueCircle = circleFactory.getCircle("Blue", 10);
        blueCircle.draw();

        Circle anotherRedCircle = circleFactory.getCircle("Red", 5);
        anotherRedCircle.draw();

        // Check if both red circles are the same instance
        System.out.println("Are both red circles the same instance? " + (redCircle == anotherRedCircle));
    }
}
