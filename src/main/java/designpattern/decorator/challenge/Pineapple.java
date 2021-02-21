package designpattern.decorator.challenge;

public class Pineapple implements Topping {
    private static final String name = "Pineapple";

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}
