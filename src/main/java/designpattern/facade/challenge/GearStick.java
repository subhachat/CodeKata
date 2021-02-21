package designpattern.facade.challenge;

public class GearStick implements FunctionalModule<Integer> {

    int currentGear;
    Accelerator accelerator;

    public GearStick(Accelerator accelerator) {
        this.currentGear = 0; // 0= neutral
        accelerator.engage(Boolean.FALSE); // to be safe
        this.accelerator = accelerator;
    }

    @Override
    public void engage(Integer currentGear) {
        if (currentGear.intValue() > this.currentGear) {
            this.accelerator.engage(Boolean.TRUE);
        } else {
            this.accelerator.engage(Boolean.FALSE);
        }
        this.currentGear = currentGear.intValue();
        System.out.println("Gear engaged -> " + this.currentGear
                + ", Accelerator pressed ->" + this.accelerator.isPressed);
    }
}
