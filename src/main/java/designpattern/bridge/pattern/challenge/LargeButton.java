package designpattern.bridge.pattern.challenge;

public class LargeButton extends Button {
    TypeOfButton typeOfButton;

    LargeButton(TypeOfButton typeOfButton) {
        super(Size.LARGE);
        this.typeOfButton = typeOfButton;
    }

    @Override
    void draw() {
        this.typeOfButton.draw();
        System.out.println("Size of button is ->" + this.size);
    }
}
