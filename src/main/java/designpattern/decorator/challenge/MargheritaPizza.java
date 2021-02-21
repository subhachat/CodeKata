package designpattern.decorator.challenge;

import java.util.List;
import java.util.Objects;

public class MargheritaPizza implements Pizza {
    private static final String name = "Margherita Pizza";
    private final Pizza pizzaBase;

    public MargheritaPizza(Pizza pizzaBase) {
        this.pizzaBase = pizzaBase;
        this.pizzaBase.addTopping(new Cheese());
        this.pizzaBase.addTopping(new CherryTomato());
    }

    @Override
    public List<Topping> getToppings() {
        return pizzaBase.getToppings();
    }

    @Override
    public void addTopping(Topping topping) {
        Objects.requireNonNull(topping);
        this.pizzaBase.addTopping(topping);
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
