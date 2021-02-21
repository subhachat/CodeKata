package designpattern.decorator.challenge;

import java.util.List;

public interface Pizza {
    List<Topping> getToppings();

    void addTopping(Topping topping);

    String getName();

    String getCrust();
}
