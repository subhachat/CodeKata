package designpattern.bridge.pattern;

import java.awt.*;

public class Canvas extends designpattern.bridge.notmanageable.Canvas {
    public void paint(Graphics graphics) {
        System.out.println("Using this--->");
        Square square = new Square(new RedColorShape());
        Circle circle = new Circle(new BlueColorShape());
        Triangle triangle = new Triangle(new GreenColorShape());

        square.draw(graphics);
        circle.draw(graphics);
        triangle.draw(graphics);
    }
}
