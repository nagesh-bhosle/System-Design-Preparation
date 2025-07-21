/**
 * 
 * Command Design Pattern Example
 * This example demonstrates the Command Design Pattern
 * using a simple Bulb control system.
 * The Bulb can be turned ON or OFF,
 * and commands can be executed, undone, and redone.
 * 
 */

import java.util.*;
import java.lang.*;
import java.io.*;

class Bulb {
    public void turnOn() {
        System.out.println("Bulb is turned ON");
    }

    public void turnOff() {
        System.out.println("Bulb is turned OFF");
    }
}

interface Command
{
    void execute();
    void undo();
    void redo();
}

class TurnOn implements Command {
    private Bulb bulb;

    public TurnOn(Bulb bulb) {
        this.bulb = bulb;
    }

    @Override
    public void execute() {
        bulb.turnOn();
    }

    @Override
    public void undo() {
        bulb.turnOff();
    }

    @Override
    public void redo() {
        execute();
    }
}

class TurnOff implements Command {
    private Bulb bulb;

    public TurnOff(Bulb bulb) {
        this.bulb = bulb;
    }

    @Override
    public void execute() {
        bulb.turnOff();
    }

    @Override
    public void undo() {
        bulb.turnOn();
    }

    @Override
    public void redo() {
        execute();
    }
}

class RemoteControl {
    private List<Command> commandHistory = new ArrayList<>();
    private int currentCommandIndex = -1;

    public void executeCommand(Command command) {
        command.execute();
        commandHistory.add(command);
        currentCommandIndex++;
    }

    public void undo() {
        if (currentCommandIndex >= 0) {
            Command command = commandHistory.get(currentCommandIndex);
            command.undo();
            currentCommandIndex--;
        }
    }

    public void redo() {
        if (currentCommandIndex + 1 < commandHistory.size()) {
            currentCommandIndex++;
            Command command = commandHistory.get(currentCommandIndex);
            command.redo();
        }
    }
}

public class CommandDP {
    public static void main(String[] args) {
        Bulb bulb = new Bulb();
        RemoteControl remote = new RemoteControl();

        Command turnOn = new TurnOn(bulb);
        Command turnOff = new TurnOff(bulb);

        remote.executeCommand(turnOn);
        remote.executeCommand(turnOff);
        remote.undo();
        remote.redo();
    }
}
