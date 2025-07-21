/**
 * Factory Pattern Example
 * This example demonstrates the Factory Design Pattern
 * which is used to create objects without specifying the exact class of object that will be created.
 * In this case, we create different types of interviewers.
 * The Factory Pattern allows for flexibility and scalability in code.
 * It is particularly useful when the exact type of object to be created is determined at runtime.
 * This code is a simple implementation of the Factory Pattern in Java.
 * It includes an interface for interviewers and concrete classes for different types of interviewers.
 * The factory class is responsible for creating the appropriate interviewer based on the input type.
 * 
 */

interface Interviewer {
    void askQuestions();
}

class DeveloperInterviewer implements Interviewer {
    @Override
    public void askQuestions() {
        System.out.println("Asking about design patterns, data structures, and algorithms.");
    }
}

class ManagerInterviewer implements Interviewer {
    @Override
    public void askQuestions() {
        System.out.println("Asking about team management and project delivery.");
    }
}

class InterviewerFactory {
    public static Interviewer getInterviewer(String type) {
        if (type == null) {
            return null;
        }
        if (type.equalsIgnoreCase("DEVELOPER")) {
            return new DeveloperInterviewer();
        } else if (type.equalsIgnoreCase("MANAGER")) {
            return new ManagerInterviewer();
        }
        return null;
    }
}

public class FactoryP {
    public static void main(String[] args) {
        Interviewer developer = InterviewerFactory.getInterviewer("DEVELOPER");
        developer.askQuestions();

        Interviewer manager = InterviewerFactory.getInterviewer("MANAGER");
        manager.askQuestions();
    }
}

