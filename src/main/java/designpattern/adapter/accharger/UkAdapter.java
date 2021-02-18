package designpattern.adapter.accharger;

public class UkAdapter implements BS1363 {

    private BS546 charger;

    public UkAdapter(BS546 charger) {
        this.charger = charger;
    }

    @Override
    public void charge13A() {
        if (this.charger.getRatingGroup() == 'M') {
            this.charger.charge();
        } else {
            System.out.println(this.charger.getRatingGroup() + "-> Unsupported Amperage");
        }
    }
}
