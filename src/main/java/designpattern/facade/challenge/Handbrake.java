package designpattern.facade.challenge;

public class Handbrake implements FunctionalModule<Boolean> {
    boolean isPressed;

    public Handbrake() {
        this.isPressed = Boolean.FALSE; // when Object initializes, no break-down
    }

    @Override
    public void engage(Boolean isPressed) {
        this.isPressed = isPressed.booleanValue();
        System.out.println("Break Pressed -> " + this.isPressed);
    }
}
