package designpattern.bridge.notmanageable;

import java.awt.*;

public class GreenTriangle extends Triangle {
    public GreenTriangle(int sideA, int sideB, int sideC) {
        super(sideA, sideB, sideC);
    }

    @Override
    public void draw(Graphics graphics) {
        graphics.setColor(Color.GREEN);
        super.draw(graphics);
    }
}
