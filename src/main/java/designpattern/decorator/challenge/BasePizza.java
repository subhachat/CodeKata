package designpattern.decorator.challenge;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class BasePizza implements Pizza {
    private static final String name = "Pizza Base";
    private final List<Topping> toppings;
    private final String crust = "Thin Crust";

    BasePizza() {
        toppings = new ArrayList<>();
    }

    BasePizza(List<Topping> toppings) {
        Objects.requireNonNull(toppings);
        this.toppings = toppings;
    }

    public void addTopping(Topping topping) {
        Objects.requireNonNull(topping);
        toppings.add(topping);
        //System.out.println("Topping " + topping.getName() + " is added");
    }

    @Override
    public List<Topping> getToppings() {
        return this.toppings;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getCrust() {
        return this.crust;
    }
}
