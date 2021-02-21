package designpattern.decorator.challenge;

public class Ham implements Topping {
    private static final String name = "Ham";

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}
