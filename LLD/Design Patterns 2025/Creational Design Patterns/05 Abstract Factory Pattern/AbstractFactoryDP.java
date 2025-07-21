/**
 * Abstract Factory Design Pattern Example
 * This example demonstrates the Abstract Factory pattern
 * which provides an interface for creating families of related or dependent objects
 * without specifying their concrete classes.
 * In this case, we create doors and their fitting experts.
 * The pattern allows for easy extension and modification of the door types and fitting experts.
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

interface DoorFittingExpert {
    void fitDoor(Door door);
}

class Carpenter implements DoorFittingExpert {
    @Override
    public void fitDoor(Door door) {
        System.out.println("Fitting a wooden door.");
    }
}

class Welder implements DoorFittingExpert {
    @Override
    public void fitDoor(Door door) {
        System.out.println("Fitting an iron door.");
    }
}

interface DoorFactory {
    Door makeDoor();
    DoorFittingExpert makeFittingExpert();
}

class WoodenDoorFactory implements DoorFactory {
    @Override
    public Door makeDoor() {
        return new WoodenDoor();
    }

    @Override
    public DoorFittingExpert makeFittingExpert() {
        return new Carpenter();
    }
}

class IronDoorFactory implements DoorFactory {
    @Override
    public Door makeDoor() {
        return new IronDoor();
    }

    @Override
    public DoorFittingExpert makeFittingExpert() {
        return new Welder();
    }
}

public class AbstractFactoryDP {
    public static void main(String[] args) {
        DoorFactory woodenDoorFactory = new WoodenDoorFactory();
        Door woodenDoor = woodenDoorFactory.makeDoor();
        DoorFittingExpert carpenter = woodenDoorFactory.makeFittingExpert();
        
        woodenDoor.open();
        carpenter.fitDoor(woodenDoor);
        woodenDoor.close();

        System.out.println();

        DoorFactory ironDoorFactory = new IronDoorFactory();
        Door ironDoor = ironDoorFactory.makeDoor();
        DoorFittingExpert welder = ironDoorFactory.makeFittingExpert();
        
        ironDoor.open();
        welder.fitDoor(ironDoor);
        ironDoor.close();
    }
}



