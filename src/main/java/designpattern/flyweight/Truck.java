package designpattern.flyweight;

public class Truck implements Vehicle {
    private final String name;
    private final int[] geoLocation;

    public Truck(String name) {
        this.name = name;
        geoLocation = new int[2];
    }

    @Override
    public String getType() {
        return VehicleType.Truck.name();
    }

    @Override
    public int[] getLocation() {
        return this.geoLocation;
    }

    @Override
    public void setLocation(int latitude, int longitude) {
        geoLocation[0] = latitude;
        geoLocation[1] = longitude;
    }
}
