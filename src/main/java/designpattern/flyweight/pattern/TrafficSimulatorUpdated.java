package designpattern.flyweight.pattern;

import designpattern.flyweight.Vehicle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TrafficSimulatorUpdated {
    static List<Vehicle> vehicles;
    static Logger logger;

    static {
        vehicles = new ArrayList<>();
        logger = Logger.getLogger(TrafficSimulatorUpdated.class.getName());
        System.setProperty("java.util.logging.SimpleFormatter.format",
                //"[%1$tF %1$tT] [%4$-7s] %5$s %n");
                "[%1$tF %1$tl:%1$tM:%1$tS.%1$tL] [%4$-6s] %5$s %n");
    }

    public static void main(String... args) {
        Thread createVehicle = new Thread(
                () -> {
                    createVehicleAtRandom();
                }
        );
        Thread removeVehicle = new Thread(
                () -> {
                    removeVehicle();
                }
        );
        createVehicle.setName("CREATE");
        removeVehicle.setName("REMOVE");

        // Scheduling entries and exit from Traffic
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
        executor.scheduleAtFixedRate(createVehicle, 0, 2, TimeUnit.SECONDS);
        executor.scheduleAtFixedRate(removeVehicle, 5, 2, TimeUnit.SECONDS);
    }

    public static void createVehicleAtRandom() {
        Random random = new Random();
        int nextInt = random.nextInt(2); // values within 2
        Vehicle vehicle = VehicleFactory.getVehicle(nextInt);
        vehicle.setLocation(random.nextInt(1000), random.nextInt(1000));
        logger.log(Level.INFO, "A new " + vehicle.getType()
                + " is added in Traffic, Reg.No. -> " + vehicle.hashCode()
                + ", location ->" + Arrays.toString(vehicle.getLocation()));
        vehicles.add(vehicle);
    }

    public static void removeVehicle() {
        Vehicle removedOne = vehicles.remove(0);
        logger.log(Level.INFO, "A " + removedOne.getType()
                + ", Reg.No. -> " + removedOne.hashCode()
                + " is removed from Traffic, location ->" + Arrays.toString(removedOne.getLocation()));
    }
}
