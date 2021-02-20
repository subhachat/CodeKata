package designpattern.bridge.notmanageable;

import java.awt.*;

public abstract class Square implements Shape {
    protected int side;
    protected double area;

    Square(int side) {
        this.side = side;
        this.area = side * side;
    }

    public double getArea() {
        return this.area;
    }

    @Override
    public void draw(Graphics graphics) {
        graphics.fillRect(10, 15, this.side, this.side);
    }
}
