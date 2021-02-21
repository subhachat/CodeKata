package designpattern.facade;

import java.time.LocalDate;
import java.util.Objects;

public class Hotel {
    private final String name;
    private boolean isRoomAvailable;

    public Hotel(String name) {
        this.name = name;
        isRoomAvailable = true;
    }

    public void reserve(LocalDate from, LocalDate to) {
        //usual date validation
        Objects.requireNonNull(from);
        Objects.requireNonNull(to);
        if (from.isAfter(to)) {
            System.out.println("ERROR::{From} date can't be after {To} date. Try again!");
        }
        isRoomAvailable = false;
        System.out.println("Room is booked from " + from + ", to " + to + ", in Hotel " + this.name);
    }

    public void checkout() {
        isRoomAvailable = true;
        System.out.println("Checkout is completed from Hotel " + this.name);
    }

    public boolean isRoomAvailable() {
        return this.isRoomAvailable;
    }

}
