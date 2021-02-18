package designpattern.adapter.pricecalc;

public class UkPriceCalculator {
    private String model;
    private int age;
    private static double averageValue = 2500.50d;

    public UkPriceCalculator(String model, int age){
        this.model = model.toLowerCase();
        this.age = age;
    }

    public int getPrice(){
        double depreciation;
        switch(this.model){
            case "ford" -> depreciation = 3.5d;
            case "gm" -> depreciation = 3.2d;
            case "nissan" -> depreciation = 2.8d;
            case "bmw" -> depreciation = 3.8d;
            default -> depreciation = 2.5d;
        }
        double finalValue = averageValue - (averageValue*(depreciation/100)) - (this.age*45);
        return (int)finalValue; //price is GBP
    }

}
