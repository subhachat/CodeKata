package designpattern.adapter.accharger;

public class ContinentalCharger implements BS546 {
    private boolean isPolarised;
    private boolean isFused;
    private String shapeOfPin;
    private char ratingGroup;
    private int amperage;

    public ContinentalCharger(int amperage) {
        if (amperage > 12) {
            this.ratingGroup = 'M';
        } else {
            this.ratingGroup = 'D';
        }
        this.amperage = amperage;
        this.shapeOfPin = "round";
        this.isPolarised = false;
        this.isFused = false;
    }

    @Override
    public void charge() {
        System.out.println("Charging with amp = "
                + this.amperage + ", rating group = "
                + this.ratingGroup);
    }

    @Override
    public char getRatingGroup() {
        return this.ratingGroup;
    }

}
