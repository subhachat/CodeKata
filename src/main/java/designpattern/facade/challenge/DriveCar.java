package designpattern.facade.challenge;

import java.util.logging.Level;
import java.util.logging.Logger;

public class DriveCar {
    private static final Logger logger;

    static {
        logger = Logger.getLogger(DriveCar.class.getName());

        System.setProperty("java.util.logging.SimpleFormatter.format",
                //"[%1$tF %1$tT] [%4$-7s] %5$s %n");
                "[%1$tF %1$tl:%1$tM:%1$tS.%1$tL] [%4$-6s] %5$s %n");
    }

    public static void main(String... args) {
        Car car = new Car("Ford Mustang");
        logger.log(Level.INFO, "Going to Arman's house");
        car.start();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            logger.log(Level.INFO, "Thread sleep is interrupted!", e.getMessage());
        }
        logger.log(Level.INFO, "Need to hurry up");
        car.accelerate();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            logger.log(Level.INFO, "Thread sleep is interrupted!", e.getMessage());
        }
        logger.log(Level.INFO, "Stopping at Arman's house");
        car.stop();
    }
}
