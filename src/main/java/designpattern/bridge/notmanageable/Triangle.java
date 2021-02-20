package designpattern.bridge.notmanageable;

import java.awt.*;


public abstract class Triangle implements Shape {
    private int sideA;
    private int sideB;
    private int sideC;
    private double area;

    public Triangle(int sideA, int sideB, int sideC) {
        if ((sideA + sideB <= sideC) || (sideA + sideC <= sideB) || (sideB + sideC <= sideA)) {
            System.out.println("Impossible triangle formation");
        }
    }

    public double getArea() {
        return this.area;
    }

    public void draw(Graphics graphics) {
        graphics.fillPolygon(new int[]{20, 30, 40}, new int[]{40, 60, 80}, 3);
    }

    private enum TriangleType {Equilateral, Isosceles, Scalene}
}
