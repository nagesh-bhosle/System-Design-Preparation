/**
 * Memento Design Pattern Example
 * This example demonstrates the Memento Design Pattern
 * using a simple text editor.
 * The TextEditor class allows writing text,
 * saving its state,
 * and restoring to a previous state.
 * The Caretaker class manages the saved states (mementos).
 * The Memento class encapsulates the state of the TextEditor.
 * This pattern is useful for implementing undo functionality.
 */

import java.util.*;
import java.io.*;
import java.lang.*;

class Memento {
    private String state;

    public Memento(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }
}

class TextEditor {
    private String content="";
    private Memento memento;

    public void write(String text) {
        content += text;
    }

    public Memento save() {
        memento = new Memento(content);
        return memento;
    }

    public void restore(Memento memento) {
        this.memento = memento;
        this.content = memento.getState();
    }

    public String getContent() {
        return content;
    }
}

class Caretaker {
    private List<Memento> mementos = new ArrayList<>();

    public void addMemento(Memento memento) {
        mementos.add(memento);
    }

    public Memento getMemento(int index) {
        return mementos.get(index);
    }
}

public class MementoDP {
    public static void main(String[] args) {
        TextEditor editor = new TextEditor();
        Caretaker caretaker = new Caretaker();

        editor.write("Hello, ");
        caretaker.addMemento(editor.save());

        editor.write("world!");
        caretaker.addMemento(editor.save());

        System.out.println("Current Content: " + editor.getContent());

        editor.restore(caretaker.getMemento(0));
        System.out.println("Restored Content: " + editor.getContent());
    }
}