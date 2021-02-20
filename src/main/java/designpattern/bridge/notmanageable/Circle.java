package designpattern.bridge.notmanageable;

import java.awt.*;

public abstract class Circle implements Shape {
    private final String color;
    private final int radius;
    private final double area;

    Circle(String color, int radius) {
        this.color = color;
        this.radius = radius;
        this.area = Math.ceil(2 * Math.PI * radius);
    }

    public String getColor() {
        return color;
    }

    public int getRadius() {
        return radius;
    }

    public double getArea() {
        return this.area;
    }

    public void draw(Graphics graphics) {
        graphics.fillOval(50, 75, this.getRadius(), this.getRadius());
    }
}
