package designpattern.adapter.pricecalc;

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
