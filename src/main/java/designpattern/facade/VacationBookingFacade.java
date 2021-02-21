package designpattern.facade;

import java.time.LocalDate;
import java.util.Objects;
import java.util.Scanner;

public class VacationBookingFacade {
    Flight flightBooking;
    CarRental carRental;
    Hotel hotel;

    public void bookVacationPackage(LocalDate fromDate, LocalDate toDate) {
        System.out.println("Enter Airlines name for booking ->");
        Scanner scanner = new Scanner(System.in);
        String flightName = scanner.next();
        System.out.println("Enter Car name for booking ->");
        String carName = scanner.next();
        System.out.println("Enter Hotel name for booking ->");
        String hotelName = scanner.next();

        flightBooking = new Flight(flightName);
        flightBooking.bookCombined(fromDate, toDate);

        carRental = new CarRental(carName);
        carRental.leaseCar(fromDate, toDate);

        hotel = new Hotel(hotelName);
        hotel.reserve(fromDate, toDate);
    }

    public void endOfVacation() {
        Objects.requireNonNull(carRental);
        Objects.requireNonNull(hotel);
        carRental.returnCar();
        hotel.checkout();
    }
}
