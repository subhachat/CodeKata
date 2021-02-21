package designpattern.facade;

import java.time.LocalDate;
import java.util.Objects;

public class Flight {
    private final String name;
    private boolean isSeatAvailable;
    private Journey journeyType;

    public Flight(String name) {
        this.name = name;
        isSeatAvailable = true;
    }

    public void bookCombined(LocalDate from, LocalDate to) {
        //validate the dates
        Objects.requireNonNull(from);
        Objects.requireNonNull(to);
        if (from.isAfter(to)) {
            System.out.println("ERROR::{From} date can't be after {To} date. Try again!");
            return;
        }
        bookSingleTrip(from, Journey.Outbound);
        bookSingleTrip(to, Journey.Return);
    }

    public void bookSingleTrip(LocalDate date, Journey journeyType) {
        Objects.requireNonNull(date);
        isSeatAvailable = false;
        System.out.println(journeyType.name() + " Flight is booked on " + date + " in " + this.name);
    }

    public void cancel() {
        isSeatAvailable = true;
        System.out.println("Cancellation is completed");
    }

    public boolean isSeatAvailable() {
        return isSeatAvailable;
    }

    private enum Journey {Outbound, Return}
}
