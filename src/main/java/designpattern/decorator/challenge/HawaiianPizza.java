package designpattern.decorator.challenge;

import java.util.List;
import java.util.Objects;

public class HawaiianPizza implements Pizza {

    private static final String name = "Hawaiian Pizza";
    private final Pizza pizzaBase;

    public HawaiianPizza(Pizza pizzaBase) {
        this.pizzaBase = pizzaBase;
        this.pizzaBase.addTopping(new Ham());
        this.pizzaBase.addTopping(new Pineapple());
    }

    @Override
    public void addTopping(Topping topping) {
        Objects.requireNonNull(topping);
        this.pizzaBase.addTopping(topping);
    }

    @Override
    public List<Topping> getToppings() {
        return this.pizzaBase.getToppings();
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getCrust() {
        return this.pizzaBase.getCrust();
    }
}
