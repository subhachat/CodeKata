package designpattern.composite.pattern.challenge;

public interface Book {
    void checkout();

    void returnBook();

    String getName();

    Status getAvailability();

    enum Status {AVAILABLE, ON_LOAN}
}
