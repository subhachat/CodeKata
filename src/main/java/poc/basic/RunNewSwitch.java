package poc.basic;

import java.util.Calendar;
import java.util.InputMismatchException;
import java.util.Optional;
import java.util.Scanner;

/**
 * This switch function is available since Java 12
 */
public class RunNewSwitch {
    public static void main(String[] args) {
        System.out.println(findDay(8,5,2015));
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
    public static String findDay(int month, int day, int year) {
        if (year < 2000 || year > 3000) {
            return "";
        }
        Calendar calendar = Calendar.getInstance();
        System.out.println("Calendar date->"+calendar.getTime());
        calendar.set(year, month-1, day); //month starts from 0
        System.out.println("Calendar date->"+calendar.getTime());
        String dayOfWeek = switch(calendar.get(Calendar.DAY_OF_WEEK)) {
            case 1 -> "SUNDAY";
            case 2 -> "MONDAY";
            case 3 -> "TUESDAY";
            case 4 -> "WEDNESDAY";
            case 5 -> "THURSDAY";
            case 6 -> "FRIDAY";
            case 7 -> "SATURDAY";
            default -> "";
        };
        return dayOfWeek;
    }
}
