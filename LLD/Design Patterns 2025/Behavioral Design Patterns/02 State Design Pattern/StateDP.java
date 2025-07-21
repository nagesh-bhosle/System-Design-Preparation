/* * State Design Pattern Example: Coffee Machine
 * This example demonstrates the State Design Pattern by simulating a coffee machine
 * that can be in different states: Idle, Selecting, and Dispensing.
 */

interface CoffeeMachineState
{
    void insertCoin();
    void selectCoffee();
    void dispenseCoffee();
}

class IdleState implements CoffeeMachineState
{
    private CoffeeMachine coffeeMachine;

    public IdleState(CoffeeMachine coffeeMachine) {
        this.coffeeMachine = coffeeMachine;
    }

    @Override
    public void insertCoin() {
        System.out.println("Coin inserted. You can now select a coffee.");
        coffeeMachine.setState(coffeeMachine.getReadyState());
    }

    @Override
    public void selectCoffee() {
        System.out.println("Please insert a coin first.");
    }

    @Override
    public void dispenseCoffee() {
        System.out.println("Please insert a coin and select a coffee first.");
    }
}

class SelectingState implements CoffeeMachineState
{
    private CoffeeMachine coffeeMachine;

    public SelectingState(CoffeeMachine coffeeMachine) {
        this.coffeeMachine = coffeeMachine;
    }

    @Override
    public void insertCoin() {
        System.out.println("Coin already inserted. Please select a coffee.");
    }

    @Override
    public void selectCoffee() {
        System.out.println("Coffee selected. Dispensing now...");
        coffeeMachine.setState(coffeeMachine.getDispensingState());
    }

    @Override
    public void dispenseCoffee() {
        System.out.println("Please select a coffee first.");
    }
}

class DispensingState implements CoffeeMachineState
{
    private CoffeeMachine coffeeMachine;

    public DispensingState(CoffeeMachine coffeeMachine) {
        this.coffeeMachine = coffeeMachine;
    }

    @Override
    public void insertCoin() {
        System.out.println("Please wait, coffee is being dispensed.");
    }

    @Override
    public void selectCoffee() {
        System.out.println("Please wait, coffee is being dispensed.");
    }

    @Override
    public void dispenseCoffee() {
        System.out.println("Coffee dispensed. Enjoy your drink!");
        coffeeMachine.setState(coffeeMachine.getIdleState());
    }
}

class CoffeeMachine
{
    private CoffeeMachineState idleState;
    private CoffeeMachineState selectingState;
    private CoffeeMachineState dispensingState;

    private CoffeeMachineState currentState;

    public CoffeeMachine() {
        idleState = new IdleState(this);
        selectingState = new SelectingState(this);
        dispensingState = new DispensingState(this);
        currentState = idleState; // Initial state
    }

    public void setState(CoffeeMachineState state) {
        currentState = state;
    }

    public CoffeeMachineState getIdleState() {
        return idleState;
    }

    public CoffeeMachineState getReadyState() {
        return selectingState;
    }

    public CoffeeMachineState getDispensingState() {
        return dispensingState;
    }

    public void insertCoin() {
        currentState.insertCoin();
    }

    public void selectCoffee() {
        currentState.selectCoffee();
    }

    public void dispenseCoffee() {
        currentState.dispenseCoffee();
    }
}

public class StateDP
{
    public static void main(String[] args) {
        CoffeeMachine coffeeMachine = new CoffeeMachine();

        coffeeMachine.insertCoin(); // Should transition to selecting state
        coffeeMachine.selectCoffee(); // Should transition to dispensing state
        coffeeMachine.dispenseCoffee(); // Should dispense coffee and return to idle state

        coffeeMachine.insertCoin(); // Should allow another selection
    }
}