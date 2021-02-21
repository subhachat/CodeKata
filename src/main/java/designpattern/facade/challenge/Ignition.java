package designpattern.facade.challenge;

public class Ignition implements FunctionalModule<Boolean> {
    boolean isOn;

    public Ignition() {
        isOn = Boolean.FALSE; // when Object initializes, no key-on
    }

    @Override
    public void engage(Boolean isOn) {
        this.isOn = isOn;
        System.out.println("Ignition ON -> " + isOn);
    }
}
