package designpattern.decorator.challenge;

import java.util.List;
import java.util.Objects;

public class StuffedCrustPizza implements Pizza {
    private final Pizza pizzaBase;
    private final String crust = "Stuffed Crust";

    public StuffedCrustPizza(Pizza pizzaBase) {
        this.pizzaBase = pizzaBase;
        pizzaBase.addTopping(new Cheese());
    }

    @Override
    public List<Topping> getToppings() {
        return this.pizzaBase.getToppings();
    }

    @Override
    public void addTopping(Topping topping) {
        Objects.requireNonNull(topping);
        this.pizzaBase.addTopping(topping);
    }

    @Override
    public String getName() {
        return "Stuffed crust " + this.pizzaBase.getName();
    }

    @Override
    public String getCrust() {
        return this.crust;
    }
}
