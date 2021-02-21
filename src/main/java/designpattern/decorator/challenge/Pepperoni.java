package designpattern.decorator.challenge;

public class Pepperoni implements Topping {
    private static final String name = "Pepperoni";

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}
