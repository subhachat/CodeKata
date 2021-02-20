package designpattern.bridge.pattern;

import designpattern.bridge.notmanageable.Shape;

import java.awt.*;

public class Triangle implements Shape {

    ColorShape colorShape;

    public Triangle(ColorShape colorShape) {
        this.colorShape = colorShape;
    }

    @Override
    public void draw(Graphics graphics) {
        int[] x = {200, 250, 150};
        int[] y = {50, 100, 100};
        int n = 3;
        this.colorShape.setColor(graphics);
        graphics.fillPolygon(x, y, n);
    }
}
