package practice.design_patterns.factory2;

public class MainFactory {

    public static void main(String[] args) {
        ShapeFactory shapeFactory = new ShapeFactory();

        Shape circle = shapeFactory.createShape("circle");
        circle.draw();

        Shape square = shapeFactory.createShape("square");
        square.draw();

        Shape triangle = shapeFactory.createShape("triangle");
        triangle.draw();
    }
}