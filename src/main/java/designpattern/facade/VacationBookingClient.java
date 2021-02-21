package designpattern.facade;

import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;

public class VacationBookingClient {
    private static final Logger logger;

    static {
        logger = Logger.getLogger(VacationBookingClient.class.getName());

        System.setProperty("java.util.logging.SimpleFormatter.format",
                //"[%1$tF %1$tT] [%4$-7s] %5$s %n");
                "[%1$tF %1$tl:%1$tM:%1$tS.%1$tL] [%4$-6s] %5$s %n");
    }

    public static void main(String... args) {
        LocalDate fromDate = LocalDate.of(2021, 6, 24);
        LocalDate toDate = LocalDate.of(2021, 6, 30);

        /*Flight flightBooking = new Flight("Lufthansa");
        flightBooking.bookCombined(fromDate, toDate);

        CarRental carRental = new CarRental("Ford Mustang");
        carRental.leaseCar(fromDate, toDate);

        Hotel hotel = new Hotel("Ceceilia");
        hotel.reserve(fromDate, toDate);*/

        VacationBookingFacade facade = new VacationBookingFacade();
        logger.log(Level.INFO, "Yay! Going for a holiday");
        facade.bookVacationPackage(fromDate, toDate);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            logger.log(Level.INFO, "Thread sleep is interrupted!", e.getMessage());
        }
        logger.log(Level.INFO, "Sad! The holidays are over");
        facade.endOfVacation();
    }
}
