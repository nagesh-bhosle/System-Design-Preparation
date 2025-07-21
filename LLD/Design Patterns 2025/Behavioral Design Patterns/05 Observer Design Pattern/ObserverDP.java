/** 
 * Observer Design Pattern Example
 * This example demonstrates the Observer Design Pattern where job seekers can subscribe to a job portal to receive updates on new job postings.
 * The JobPortal acts as the subject that notifies observers (JobSeekers) about new job posts.
 * Each JobSeeker receives updates when a new job post is made.
 * This pattern is useful for implementing a publish-subscribe mechanism.
 * It allows for loose coupling between the subject and observers, promoting flexibility and scalability.
 * 
 */

import java.util.*;
import java.lang.*;
import java.io.*;

class JobPost {
    private String title;
    private String description;

    public JobPost(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }
}

interface Observer {
    void update(JobPost jobPost);
}

class JobSeeker implements Observer {
    private String name;

    public JobSeeker(String name) {
        this.name = name;
    }

    @Override
    public void update(JobPost jobPost) {
        System.out.println(name + " received job post: " + jobPost.getTitle() + " - " + jobPost.getDescription());
    }
}

interface Observable {
    void registerObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers(JobPost jobPost);
}

class JobPortal implements Observable {
    private List<Observer> observers = new ArrayList<>();

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(JobPost jobPost) {
        for (Observer observer : observers) {
            observer.update(jobPost);
        }
    }
}

public class ObserverDP {
    public static void main(String[] args) {
        JobPortal jobPortal = new JobPortal();
        
        JobSeeker john = new JobSeeker("John");
        JobSeeker jane = new JobSeeker("Jane");
        
        jobPortal.registerObserver(john);
        jobPortal.registerObserver(jane);
        
        JobPost jobPost1 = new JobPost("Software Engineer", "Looking for a skilled software engineer.");
        jobPortal.notifyObservers(jobPost1);
        
        jobPortal.removeObserver(jane);
        
        JobPost jobPost2 = new JobPost("Data Scientist", "Seeking an experienced data scientist.");
        jobPortal.notifyObservers(jobPost2);
    }
}

