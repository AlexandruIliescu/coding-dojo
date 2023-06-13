package practice.cleanCode;

public class LSP {
}

abstract class Shape {
    abstract double calculateArea();
}

class Circle extends Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    double calculateArea() {
        return Math.PI * radius * radius;
    }
}

class Rectangle extends Shape {
    private double length;
    private double width;

    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    @Override
    double calculateArea() {
        return length * width;
    }
}

class Triangle extends Shape {
    private double base;
    private double height;

    public Triangle(double base, double height) {
        this.base = base;
        this.height = height;
    }

    @Override
    double calculateArea() {
        return 0.5 * base * height;
    }
}

// Client code example
class ExampleClientLsp {
    static void printArea(Shape shape) {
        double area = shape.calculateArea();
        System.out.println("Area: " + area);
    }

    public static void main(String[] args) {
        Shape circle = new Circle(5.0);
        printArea(circle);

        Shape rectangle = new Rectangle(3.0, 4.0);
        printArea(rectangle);

        Shape triangle = new Triangle(6.0, 2.0);
        printArea(triangle);
    }
}

