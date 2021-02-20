package designpattern.bridge.notmanageable;

import javax.swing.*;

public class Canvas extends JPanel {

    public static void main(String... args) {
        //Create a canvas to draw on
        JFrame frame = new JFrame();
        frame.setSize(400, 400);
        frame.add(new Canvas());
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    /*public void paint(Graphics graphics) {
        System.out.println("Parent canvas--->");
        Square square = new RedSquare(20);
        Circle circle = new BlueCircle("blue", 20);
        Triangle triangle = new GreenTriangle(4, 5, 7);

        square.draw(graphics);
        circle.draw(graphics);
        triangle.draw(graphics);
    }*/
}
