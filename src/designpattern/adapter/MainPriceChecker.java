package designpattern.adapter;

import java.util.Objects;

public class MainPriceChecker {

    public static void main(String... args) {
        PriceCalculator vehicle1 = new CarPriceCalculator("Ford", 10);
        printPrice(vehicle1);
        PriceCalculator vehicle2 = new TruckPriceCalculator(6, 75000);
        printPrice(vehicle2);
        PriceCalculator vehicle3 = new TruckPriceCalculator(10, 175000);
        printPrice(vehicle3);

        UkPriceCalculator vehicle1InUk = new UkPriceCalculator("Ford", 3);
        PriceAdapter ukPriceAdapter = new PriceAdapter(vehicle1InUk);
        printPrice(ukPriceAdapter);
    }

    public static void printPrice(PriceCalculator vehicle) {
        Objects.requireNonNull(vehicle);
        System.out.println("The price of the vehicle is -> " + vehicle.calculatePrice());
    }
}
