package designpattern.adapter.accharger;

public class UkStdCharger implements BS1363 {
    private boolean isFused;
    private String shapeOfPin;
    private int amperage;

    public UkStdCharger() {
        this.amperage = 13;
        this.isFused = true;
        this.shapeOfPin = "rectangular";
    }

    @Override
    public void charge13A() {
        System.out.println("Charging with UkStdCharger, amp = " + this.amperage);
    }
}
