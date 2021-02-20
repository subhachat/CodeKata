package designpattern.bridge.notmanageable;

import java.awt.*;

public class RedSquare extends Square {
    RedSquare(int side) {
        super(side);
    }

    @Override
    public void draw(Graphics graphics) {
        graphics.setColor(Color.RED);
        super.draw(graphics);
    }
}
