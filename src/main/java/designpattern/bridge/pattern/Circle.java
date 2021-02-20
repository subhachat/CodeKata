package designpattern.bridge.pattern;

import designpattern.bridge.notmanageable.Shape;

import java.awt.*;

public class Circle implements Shape {

    ColorShape colorShape;

    public Circle(ColorShape colorShape) {
        this.colorShape = colorShape;
    }

    @Override
    public void draw(Graphics graphics) {
        this.colorShape.setColor(graphics);
        graphics.fillOval(75, 50, 50, 50);
    }
}
