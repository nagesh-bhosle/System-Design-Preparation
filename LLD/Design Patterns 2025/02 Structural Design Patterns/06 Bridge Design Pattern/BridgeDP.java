interface Color {
    String getColor();
}

class Red implements Color {
    @Override
    public String getColor() {
        return "Red";
    }
}

class Blue implements Color {
    @Override
    public String getColor() {
        return "Blue";
    }
}

class Green implements Color {
    @Override
    public String getColor() {
        return "Green";
    }
}

class Yellow implements Color {
    @Override
    public String getColor() {
        return "Yellow";
    }
}

abstract class Shape {
    protected Color color;

    public Shape(Color color) {
        this.color = color;
    }

    abstract String draw();
}

class Circle extends Shape {
    public Circle(Color color) {
        super(color);
    }

    @Override
    String draw() {
        return "Drawing Circle in " + color.getColor();
    }
}

class Square extends Shape {
    public Square(Color color) {
        super(color);
    }

    @Override
    String draw() {
        return "Drawing Square in " + color.getColor();
    }
}

class Rectangle extends Shape {
    public Rectangle(Color color) {
        super(color);
    }

    @Override
    String draw() {
        return "Drawing Rectangle in " + color.getColor();
    }
}

public class BridgeDP {
    public static void main(String[] args) {
        Shape circle = new Circle(new Red());
        System.out.println(circle.draw());

        Shape square = new Square(new Blue());
        System.out.println(square.draw());

        Shape rectangle = new Rectangle(new Green());
        System.out.println(rectangle.draw());

        Shape anotherCircle = new Circle(new Yellow());
        System.out.println(anotherCircle.draw());
    }
}

