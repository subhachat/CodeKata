package designpattern.facade.challenge;

public class Car {
    private final Ignition ignition;
    private final Handbrake handbrake;
    private final Accelerator accelerator;
    private final Clutch clutch;
    private final GearStick gearStick;

    private final String name;
    private boolean isInMotion;

    public Car(String name) {
        this.name = name;
        this.handbrake = new Handbrake();
        this.accelerator = new Accelerator();
        this.clutch = new Clutch();
        this.ignition = new Ignition();
        this.gearStick = new GearStick(accelerator);
        this.isInMotion = Boolean.FALSE;
    }

    public void start() {
        if (!isInMotion) {
            ignition.engage(Boolean.TRUE);
            clutch.engage(Boolean.TRUE);
            handbrake.engage(Boolean.FALSE);
            gearStick.engage(1);
            isInMotion = Boolean.TRUE;
        } else {
            System.out.println("WARNING:: Attempt is made to start when car is already in motion");
        }
        System.out.println("Car has started");
    }

    public void accelerate() {
        if (isInMotion) {
            gearStick.engage(gearStick.currentGear + 1);
            System.out.println("....Vrrrooooommmm....");
        } else {
            System.out.println("WARNING:: Attempt is made to accelerate when car is not in motion");
        }
    }

    public void stop() {
        if (isInMotion) {
            handbrake.engage(Boolean.TRUE);
            gearStick.engage(0);
            ignition.engage(Boolean.FALSE);
            System.out.println("Car has stopped");
        } else {
            System.out.println("WARNING:: Car is already idle!");
        }
    }
}
