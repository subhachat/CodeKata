package designpattern.flyweight.pattern;

import designpattern.flyweight.Car;
import designpattern.flyweight.Truck;
import designpattern.flyweight.Vehicle;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class VehicleFactory {
    private static final Map<Integer, Vehicle> vehicles = new HashMap<>();

    public static Vehicle getVehicle(Integer type) {
        Objects.requireNonNull(type);
        if (vehicles.containsKey(type)) {
            return vehicles.get(type);
        } else {
            Vehicle newVehicle = (type.intValue() == 0) ? new Car("Mazda") : new Truck("Mercedes");
            vehicles.put(type, newVehicle);
            return newVehicle;
        }
    }
}
