package designpattern.adapter.pricecalc;

public class TruckPriceCalculator implements PriceCalculator {
    private static double depreciation = 8.5d;
    private static double averagePrice = 5000.8d;
    private int age;
    private double mileage;

    public TruckPriceCalculator(int age, double mileage) {
        this.age = age;
        this.mileage = mileage;
    }

    @Override
    public double calculatePrice() {
        double finalValue = TruckPriceCalculator.averagePrice;
        finalValue -= (finalValue * (TruckPriceCalculator.depreciation / 100) + (75 * (mileage / 5000))); // every 5000 miles reduce 75 USD from the list price
        if (finalValue < 1200) {
            System.out.println("Calculation is off the chart! Fix it!!!");
        }
        return Math.floor(finalValue);
    }
}
