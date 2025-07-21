/**
 * 
 * Singleton Design Pattern Example
 * This implementation ensures that only one instance of the Singleton class
 * is created, even in a multithreaded environment.
 * It uses double-checked locking to ensure thread safety
 * and lazy initialization.
 * 
 */

class Singleton {
    // Volatile keyword ensures visibility of changes across threads
    private static volatile Singleton instance;

    // Private constructor prevents instantiation from other classes
    private Singleton() {
        // Initialization code here
    }

    // Public method to provide access to the instance with synchronization
    public static Singleton getInstance() {
        if (instance == null) {  // First check (no locking)
            synchronized (Singleton.class) { // Thread-safe block
                if (instance == null) {  // Second check (with locking)
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }

    // Example method to demonstrate functionality
    public void showMessage() {
        System.out.println("Hello from Singleton! Thread: " + Thread.currentThread().getName());
    }
}

public class SingletonDP {
    public static void main(String[] args) {
        // Create multiple threads to test thread-safe Singleton
        Runnable task = () -> {
            Singleton singleton = Singleton.getInstance();
            singleton.showMessage();
        };

        // Launch 5 threads to simulate multithreading access
        Thread t1 = new Thread(task, "Thread-1");
        Thread t2 = new Thread(task, "Thread-2");
        Thread t3 = new Thread(task, "Thread-3");
        Thread t4 = new Thread(task, "Thread-4");
        Thread t5 = new Thread(task, "Thread-5");

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
    }
}
