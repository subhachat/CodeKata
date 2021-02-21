package designpattern.decorator.challenge;

import java.util.logging.Level;
import java.util.logging.Logger;

public class PizzaOrderingApp {
    private static final Logger logger;

    static {
        logger = Logger.getLogger(PizzaOrderingApp.class.getName());
        System.setProperty("java.util.logging.SimpleFormatter.format",
                //"[%1$tF %1$tT] [%4$-7s] %5$s %n");
                "[%1$tF %1$tl:%1$tM:%1$tS.%1$tL] [%4$-7s] %5$s %n");
    }

    public static void main(String... args) {
        Pizza hawaiianPizza = new HawaiianPizza(new BasePizza());
        Pizza margheritaPizza = new MargheritaPizza(new BasePizza());
        order(hawaiianPizza);
        order(margheritaPizza);
        Pizza stuffedCrustHawaiianPizza = new StuffedCrustPizza(hawaiianPizza);
        order(stuffedCrustHawaiianPizza);
    }

    public static void order(Pizza pizza) {
        logger.log(Level.INFO, "You have ordered a "
                + pizza.getName()
                + ", crust ->" + pizza.getCrust()
                + ", toppings ->" + pizza.getToppings());

    }
}
