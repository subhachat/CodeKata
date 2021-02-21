package designpattern.facade.challenge;

public class Accelerator implements FunctionalModule<Boolean> {
    boolean isPressed;

    public Accelerator() {
        this.isPressed = Boolean.FALSE; // when Object initializes, no acceleration
    }

    @Override
    public void engage(Boolean isPressed) {
        this.isPressed = isPressed.booleanValue();
    }
}
