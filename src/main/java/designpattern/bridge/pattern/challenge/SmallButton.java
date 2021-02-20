package designpattern.bridge.pattern.challenge;

public class SmallButton extends Button {

    TypeOfButton typeOfButton;

    public SmallButton(TypeOfButton typeOfButton) {
        super(Size.SMALL);
        this.typeOfButton = typeOfButton;
    }

    @Override
    void draw() {
        this.typeOfButton.draw();
        System.out.println("Size of button is ->" + this.size);
    }
}
