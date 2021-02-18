package designpattern.adapter.pricecalc;

public class CarPriceCalculator implements PriceCalculator {
    private double depreciation = 2.5d; // 2.5% YoY
    private int age;
    private String model;

    public CarPriceCalculator(String model, int age) {
        this.age = age;
        this.model = model.toLowerCase();
    }

    private double getRetailPrice(String model) {
        switch (model.toLowerCase()) {
            case "ford", "gm" -> {
                return 3000.5d;
            }
            case "nissan" -> {
                return 4200.8d;
            }
            default -> {
                return 2500.5d;
            }
        }
    }

    @Override
    public double calculatePrice() {
        double finalValue = getRetailPrice(this.model);
        switch (this.model) {
            case "ford", "gm", "nissan" -> {
                ; //no change in depreciation
            }
            default -> {
                this.depreciation = 3.0d; // 3.0% YoY
            }
        }

        for (int counter = 0; counter < this.age; counter++) {
            finalValue -= (finalValue * (this.depreciation / 100));
        }
        return Math.ceil(finalValue); // value in USD
    }
}
