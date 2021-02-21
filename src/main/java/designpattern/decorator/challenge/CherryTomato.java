package designpattern.decorator.challenge;

public class CherryTomato implements Topping {
    private static final String name = "Cherry Tomato";

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}
