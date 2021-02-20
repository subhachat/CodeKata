package designpattern.bridge.pattern.challenge;

public abstract class Button {
    protected Size size;

    Button(Size size) {
        this.size = size;
        System.out.println("A Button is created");
    }

    abstract void draw();

    protected enum Size {SMALL, MEDIUM, LARGE}
}
