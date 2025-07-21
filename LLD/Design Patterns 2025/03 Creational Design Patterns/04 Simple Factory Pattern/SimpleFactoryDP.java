/**
 * Simple Factory Design Pattern Example
 * This example demonstrates the Simple Factory Design Pattern
 * which is used to create objects without exposing the instantiation logic
 * to the client.
 * In this case, we create a factory for different types of doors.
 * The factory method `createDoor` takes a string parameter
 * indicating the type of door to create.
 * The client code uses this factory to create doors
 * without needing to know the details of the door classes.
 * The pattern is simple and effective for scenarios
 * where the creation logic is straightforward
 * and does not require complex configurations.
 * 
 */

interface Door {
    void open();
    void close();
}

class WoodenDoor implements Door {
    @Override
    public void open() {
        System.out.println("Opening a wooden door.");
    }

    @Override
    public void close() {
        System.out.println("Closing a wooden door.");
    }
}

class IronDoor implements Door {
    @Override
    public void open() {
        System.out.println("Opening an iron door.");
    }

    @Override
    public void close() {
        System.out.println("Closing an iron door.");
    }
}

class DoorFactory {
    public static Door createDoor(String type) {
        if (type.equalsIgnoreCase("wooden")) {
            return new WoodenDoor();
        } else if (type.equalsIgnoreCase("iron")) {
            return new IronDoor();
        }
        throw new IllegalArgumentException("Unknown door type: " + type);
    }
}

public class SimpleFactoryDP {
    public static void main(String[] args) {
        Door woodenDoor = DoorFactory.createDoor("wooden");
        woodenDoor.open();
        woodenDoor.close();

        Door ironDoor = DoorFactory.createDoor("iron");
        ironDoor.open();
        ironDoor.close();
    }
}
