package poc.basic;

import java.util.List;
import java.util.stream.Collectors;

public class RunStringNormalization {
    public static void main(String[] args) {
        String panda = "   Panda";
        String fish = "  fish  ";
        String horse = "Horse  ";
        String cat = "CAT";
        String nothing = "    ";

        List<String> animalsList = List.of(panda, fish, horse, cat, nothing);

        System.out.println("----Not Normalized----");
        animalsList.stream().forEach(System.out::println);
        System.out.println("----------------");

        // trimmed style 1
        System.out.println("----Trimmed Style 1----");
        animalsList.stream().forEach(entry -> System.out.println(entry.trim()));
        System.out.println("----------------");

        // trimmed style 2
        System.out.println("----Trimmed Style 2----");
        List<String> trimmedList = animalsList.stream()
                .map(entry -> entry.trim())
                .collect(Collectors.toList());
        trimmedList.forEach(System.out::println);
        System.out.println("----------------");

        // remove the empty string
        System.out.println("----Trimmed Style 3----");
        List<String> trimmedList2 = trimmedList.stream()
                .filter(entry -> !entry.isEmpty())
                .collect(Collectors.toList());
        trimmedList2.forEach(System.out::println);
        System.out.println("----------------");

        // and normalize
        System.out.println("----Trimmed Style 4----");
        List<String> trimmedList3 = trimmedList2.stream()
                .map(entry -> entry.toLowerCase())
                .collect(Collectors.toList());
        trimmedList3.forEach(System.out::println);
        System.out.println("----------------");
    }
}
