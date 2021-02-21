package designpattern.facade.challenge;

public class Clutch implements FunctionalModule<Boolean> {
    boolean isPressed;

    public Clutch() {
        isPressed = Boolean.FALSE; // when Object initializes, no clutch-down
    }

    @Override
    public void engage(Boolean isPressed) {
        this.isPressed = isPressed.booleanValue();
        System.out.println("Clutch Pressed -> " + this.isPressed);
    }
}
