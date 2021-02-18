package poc.basic;

import java.util.Optional;
import java.util.Scanner;

public class RunOptionals {

    public static void main (String[] args){
        Optional<String> firstName = Optional.of("Subhadip");
        Optional<String> middleName = Optional.empty();
        Optional<String> lastName = Optional.of("Chatterjee");

        /*Scanner entryPoint = new Scanner(System.in);
        System.out.println("Enter the middle name!!");
        String entryViaCLI = entryPoint.next();

        if (middleName.isEmpty()){
            middleName = Optional.of(entryViaCLI);
        }*/

        if (middleName.isPresent()){
            System.out.println("Welcome, "+middleName.get());
        } else {
            System.out.println("System doesn't recognize any entry");
        }

        StringBuilder strBld = new StringBuilder();
        strBld.append(firstName.orElse("-")).append(' ')
                .append(middleName.orElse("-")).append(' ')
                .append(lastName.orElse("-"));

        System.out.println("Hi "+strBld.toString());
    }
}
