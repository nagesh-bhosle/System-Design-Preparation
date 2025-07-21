/**
 * Visitor Design Pattern Example
 * This example demonstrates the Visitor Design Pattern by implementing different animal behaviors.
 * The Visitor pattern allows adding new operations to existing object structures without modifying them.
 * It is useful for operations that need to be performed on a set of objects with different types.
 * In this example, we have different animal types and a visitor that performs actions based on the animal type.
 * 
 */

interface Animal
{
    void accept(AnimalVisitor visitor);
}

interface AnimalVisitor
{
    void visit(Dog dog);
    void visit(Cat cat);
    void visit(Bird bird);
}

class Dog implements Animal
{
    @Override
    public void accept(AnimalVisitor visitor) {
        visitor.visit(this);
    }
}

class Cat implements Animal
{
    @Override
    public void accept(AnimalVisitor visitor) {
        visitor.visit(this);
    }
}

class Bird implements Animal
{
    @Override
    public void accept(AnimalVisitor visitor) {
        visitor.visit(this);
    }
}

class AnimalSoundVisitor implements AnimalVisitor
{
    @Override
    public void visit(Dog dog) {
        System.out.println("Dog barks");
    }

    @Override
    public void visit(Cat cat) {
        System.out.println("Cat meows");
    }

    @Override
    public void visit(Bird bird) {
        System.out.println("Bird chirps");
    }
}

public class VisitorDP {
    public static void main(String[] args) {
        Animal dog = new Dog();
        Animal cat = new Cat();
        Animal bird = new Bird();

        AnimalVisitor soundVisitor = new AnimalSoundVisitor();

        dog.accept(soundVisitor); // Output: Dog barks
        cat.accept(soundVisitor); // Output: Cat meows
        bird.accept(soundVisitor); // Output: Bird chirps
    }
}
