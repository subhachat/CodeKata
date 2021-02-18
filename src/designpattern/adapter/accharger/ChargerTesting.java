package designpattern.adapter.accharger;

public class ChargerTesting {
    public static void main(String... args) {

        BS546 charger1 = new ContinentalCharger(15);
        UkAdapter adapter1 = new UkAdapter(charger1);
        chargeIt(adapter1);

        BS546 charger2 = new ContinentalCharger(8);
        UkAdapter adapter2 = new UkAdapter(charger2);
        chargeIt(adapter2);

        BS1363 charger3 = new UkStdCharger();
        chargeIt(charger3);
    }

    public static void chargeIt(BS1363 charger) {
        charger.charge13A();
    }
}
