/**
 * Prototype Design Pattern Example
 * 
 * This example demonstrates the Prototype Design Pattern,
 * which allows for the creation of new objects by copying existing ones.
 *  
 * In this example, we have a Shape class that can be cloned,
 * and two concrete implementations: Circle and Rectangle.
 * * The ShapeCache class holds a cache of shapes and provides a method to retrieve cloned shapes.
 * 
 */

abstract class Shape implements Cloneable {
    private String id;
    protected String type;

    abstract void draw();

    public String getType() {
        return type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

class Circle extends Shape {
    public Circle() {
        type = "Circle";
    }

    @Override
    void draw() {
        System.out.println("Drawing a Circle");
    }
}

class Rectangle extends Shape {
    public Rectangle() {
        type = "Rectangle";
    }

    @Override
    void draw() {
        System.out.println("Drawing a Rectangle");
    }
}

class ShapeCache {
    private static java.util.Map<String, Shape> shapeMap = new java.util.HashMap<>();

    public static void loadCache() {
        Circle circle = new Circle();
        circle.setId("1");
        shapeMap.put(circle.getId(), circle);

        Rectangle rectangle = new Rectangle();
        rectangle.setId("2");
        shapeMap.put(rectangle.getId(), rectangle);
    }

    public static Shape getShape(String shapeId) {
        Shape cachedShape = shapeMap.get(shapeId);
        try {
            return (Shape) cachedShape.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }
}

public class PrototypeDP {
    public static void main(String[] args) {
        ShapeCache.loadCache();

        Shape clonedCircle = ShapeCache.getShape("1");
        System.out.println("Shape : " + clonedCircle.getType());
        clonedCircle.draw();

        Shape clonedRectangle = ShapeCache.getShape("2");
        System.out.println("Shape : " + clonedRectangle.getType());
        clonedRectangle.draw();
    }
}



