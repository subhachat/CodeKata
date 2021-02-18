package designpattern.adapter;

public class PriceAdapter implements PriceCalculator{
    private UkPriceCalculator ukPriceCalculator;

    public PriceAdapter(UkPriceCalculator ukPriceCalculator){
        this.ukPriceCalculator = ukPriceCalculator;
    }
    @Override
    public double calculatePrice() {
        return ukPriceCalculator.getPrice();
    }
}
