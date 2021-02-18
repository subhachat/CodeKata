package poc.basic;

import javax.swing.*;
import javax.swing.plaf.synth.SynthSpinnerUI;
import javax.swing.text.html.Option;
import java.util.InputMismatchException;
import java.util.Optional;
import java.util.Scanner;

/**
 * This switch function is available since Java 12
 */
public class RunNewSwitch {
    public static void main(String[] args) {
        System.out.println("----------------");
        System.out.print("Enter the choice: ");
        Scanner entryPoint = new Scanner(System.in);
        try {
            Optional<Integer> choice = Optional.of(entryPoint.nextInt());

            String season = switch (choice.get()) {
                case 1 -> "Spring";
                case 2 -> "Summer";
                case 3 -> "Fall";
                case 4 -> "Winter";
                //default -> "Invalid choice";
                default -> {
                    System.out.println("An invalid choice - no season can be found!");
                    yield "None found";
                }
            };
            System.out.println("The current season is = " + season);
        }
        catch(InputMismatchException ex){
            System.out.println("--Input type mismatch--");
        }
        catch(NullPointerException ex){
            System.out.println("--No Input provided--");
        }
    }
}
