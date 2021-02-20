package designpattern.bridge.pattern.challenge;

public class MainButtonChecker {

    public static void main(String... args) {
        Button smallCheckbox = new SmallButton(new Checkbox());
        smallCheckbox.draw();
        System.out.println("--------");
        Button largeListbox = new LargeButton(new Listbox());
        largeListbox.draw();

    }
}
