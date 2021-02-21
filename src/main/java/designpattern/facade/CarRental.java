package designpattern.facade;

import java.time.LocalDate;
import java.util.Objects;

public class CarRental {
    private final String name;
    private boolean isCarAvailable;

    public CarRental(String name) {
        this.name = name;
        isCarAvailable = true;
    }

    public void leaseCar(LocalDate from, LocalDate to) {
        //usual date validation
        Objects.requireNonNull(from);
        Objects.requireNonNull(to);
        if (from.isAfter(to)) {
            System.out.println("ERROR::{From} date can't be after {To} date. Try again!");
        }
        isCarAvailable = false;
        System.out.println(this.name + " is booked from " + from + ", to " + to);
    }

    public void returnCar() {
        isCarAvailable = true;
        System.out.println(this.name + " has been Returned to company");
    }

    public boolean isCarAvailable() {
        return isCarAvailable;
    }
}
