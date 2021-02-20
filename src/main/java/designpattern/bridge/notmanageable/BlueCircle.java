package designpattern.bridge.notmanageable;

import java.awt.*;

public class BlueCircle extends Circle {
    BlueCircle(String color, int radius) {
        super(color, radius);
    }

    @Override
    public void draw(Graphics graphics) {
        graphics.setColor(Color.BLUE);
        super.draw(graphics);
    }
}
