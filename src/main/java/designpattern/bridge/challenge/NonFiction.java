package designpattern.bridge.challenge;

import java.util.logging.Level;
import java.util.logging.Logger;

public class NonFiction implements Book {
    private static final Logger logger = Logger.getLogger(NonFiction.class.getName());
    private final String name;
    private boolean isAPlay;
    private Status availability = Status.AVAILABLE;

    public NonFiction(String name) {
        this.name = name;
    }

    public boolean isAPlay() {
        return isAPlay;
    }

    public void setAPlay(boolean APlay) {
        isAPlay = APlay;
    }

    @Override
    public void checkout() {
        if (availability == Status.AVAILABLE) {
            logger.log(Level.INFO, Thread.currentThread().getName() + "<> " + this.name + " Checked out");
            availability = Status.ON_LOAN;
        } else {
            logger.log(Level.INFO, Thread.currentThread().getName() + "<> " + this.name + " is already on loan!");
        }
    }

    @Override
    public void returnBook() {
        if (availability == Status.ON_LOAN) {
            logger.log(Level.INFO, Thread.currentThread().getName() + "<> " + this.name + " returned");
            availability = Status.AVAILABLE;
        } else {
            logger.log(Level.INFO, Thread.currentThread().getName() + "<> " + this.name + " is already available!");
        }
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public Status getAvailability() {
        return this.availability;
    }
}
