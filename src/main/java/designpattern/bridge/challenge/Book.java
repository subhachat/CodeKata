package designpattern.bridge.challenge;

public interface Book {
    void checkout();

    void returnBook();

    String getName();

    Status getAvailability();

    enum Status {AVAILABLE, ON_LOAN}
}
