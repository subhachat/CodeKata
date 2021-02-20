package designpattern.bridge.pattern;

import designpattern.bridge.notmanageable.Shape;

import java.awt.*;

public class Square implements Shape {
    ColorShape colorShape;

    public Square(ColorShape colorShape) {
        this.colorShape = colorShape;
    }

    @Override
    public void draw(Graphics graphics) {
        this.colorShape.setColor(graphics);
        graphics.fillRect(5, 50, 50, 50);
    }
}
