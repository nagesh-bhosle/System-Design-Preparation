/**
 * Proxy Design Pattern Example
 * This example demonstrates the Proxy Design Pattern where a proxy class controls access to a real subject class.
 * In this case, the proxy is used to manage access to a lab door.
 * The proxy adds additional functionality such as access control and logging.
 * The real subject is the LabDoor class.
 * The proxy class is LabDoorProxy.
 * The main method demonstrates the use of the proxy.
 * The output will show the additional functionality provided by the proxy.
 * 
 */

interface Door {
    void open();
    void close();
}

class LabDoor implements Door {
    @Override
    public void open() {
        System.out.println("Lab door is now open.");
    }

    @Override
    public void close() {
        System.out.println("Lab door is now closed.");
    }
}

class LabDoorProxy implements Door {
    private LabDoor labDoor;

    public LabDoorProxy() {
        this.labDoor = new LabDoor();
    }

    @Override
    public void open() {
        System.out.println("Checking access rights...");
        labDoor.open();
    }

    @Override
    public void close() {
        System.out.println("Logging door closure...");
        labDoor.close();
    }
}

public class ProxyDP {
    public static void main(String[] args) {
        Door labDoor = new LabDoorProxy();
        labDoor.open();
        labDoor.close();
    }
}
