package designpattern.decorator.challenge;

public class Cheese implements Topping {
    private static final String name = "Cheese";

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}
