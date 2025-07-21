/**
 * 
 * Decorator Design Pattern Example
 * This example demonstrates the Decorator Design Pattern
 * to add additional functionalities to coffee objects
 * without modifying their structure.
 * 
 */

interface Coffee {
    String getDescription();
    double cost();
}

class SimpleCoffee implements Coffee {
    @Override
    public String getDescription() {
        return "Simple Coffee";
    }

    @Override
    public double cost() {
        return 2.0;
    }
}

class Espresso implements Coffee {
    @Override
    public String getDescription() {
        return "Espresso";
    }

    @Override
    public double cost() {
        return 3.0;
    }
}

class ColdCoffee implements Coffee {
    @Override
    public String getDescription() {
        return "Cold Coffee";
    }

    @Override
    public double cost() {
        return 2.5;
    }
}

class CoffeeDecorator implements Coffee {
    protected Coffee coffee;

    public CoffeeDecorator(Coffee coffee) {
        this.coffee = coffee;
    }

    @Override
    public String getDescription() {
        return coffee.getDescription();
    }

    @Override
    public double cost() {
        return coffee.cost();
    }
}

class MilkDecorator extends CoffeeDecorator {
    public MilkDecorator(Coffee coffee) {
        super(coffee);
    }

    @Override
    public String getDescription() {
        return coffee.getDescription() + ", Milk";
    }

    @Override
    public double cost() {
        return coffee.cost() + 0.5;
    }
}

class SugarDecorator extends CoffeeDecorator {
    public SugarDecorator(Coffee coffee) {
        super(coffee);
    }

    @Override
    public String getDescription() {
        return coffee.getDescription() + ", Sugar";
    }

    @Override
    public double cost() {
        return coffee.cost() + 0.2;
    }
}

class WhippedCreamDecorator extends CoffeeDecorator {
    public WhippedCreamDecorator(Coffee coffee) {
        super(coffee);
    }

    @Override
    public String getDescription() {
        return coffee.getDescription() + ", Whipped Cream";
    }

    @Override
    public double cost() {
        return coffee.cost() + 0.7;
    }
}

public class DecoratorDP {
    public static void main(String[] args) {
        Coffee coffee = new SimpleCoffee();
        System.out.println(coffee.getDescription() + " $" + coffee.cost());

        coffee = new MilkDecorator(coffee);
        System.out.println(coffee.getDescription() + " $" + coffee.cost());

        coffee = new SugarDecorator(coffee);
        System.out.println(coffee.getDescription() + " $" + coffee.cost());

        coffee = new WhippedCreamDecorator(coffee);
        System.out.println(coffee.getDescription() + " $" + coffee.cost());

        Coffee espresso = new Espresso();
        espresso = new MilkDecorator(espresso);
        System.out.println(espresso.getDescription() + " $" + espresso.cost());

        Coffee coldCoffee = new ColdCoffee();
        coldCoffee = new SugarDecorator(coldCoffee);
        coldCoffee = new WhippedCreamDecorator(coldCoffee);
        System.out.println(coldCoffee.getDescription() + " $" + coldCoffee.cost());
    }
}
