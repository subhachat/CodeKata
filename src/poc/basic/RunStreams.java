package poc.basic;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RunStreams {

    public static void main(String[] args) {
        // Arrays
        String[] entryArray = new String[]{"tic", "toc", "toe"};
        Stream<String> entryStream = Arrays.stream(entryArray);//since Java 8

        // Lists
        List<String> shoppingList = List.of("apple", "banana", "milk", "coffee", "waffle");//since Java 9
        Stream<String> itemStream = shoppingList.stream();

        // Streams
        Stream<String> checkStream = Stream.of("do this", "do that");

        // Printing items::For loop in one-statement
        System.out.println("----------------");
        entryStream.forEach(System.out::println); //Now that Stream is iterated, {entryStream} can not be used further
        System.out.println("----------------");
        itemStream.forEach(System.out::println); //Now that Stream is iterated, {itemStream} can not be used further
        System.out.println("----------------");
        checkStream.forEach(System.out::println); //Now that Stream is iterated, {checkStream} can not be used further

        // Parallel processing using Streams
        System.out.println("----------------");
        shoppingList.parallelStream().forEach(System.out::println);

        // Match
        System.out.println("----------------");
        boolean isMilkOnList = shoppingList.stream().anyMatch(item -> item.contains("milk"));
        boolean isPearOnList = shoppingList.stream().anyMatch(item -> item.contains("pear"));
        System.out.println("Is milk on List? -" + isMilkOnList);
        System.out.println("Is pear on List? -" + isPearOnList);

        // Filter (to extract a sublist etc.)
        System.out.println("----------------");
        Stream<String> essentialStream = shoppingList.stream().filter(item -> (item.contains("ff") || item.contains("pp")));
        essentialStream.forEach(System.out::println);

        // Map (modification of entries in list
        System.out.println("----------------");
        List<Integer> numbersList = List.of(1, 2, 3, 4, 5);
        Stream<Integer> sqrdNumberStream = numbersList.parallelStream().map(number -> number * number); //"parallel" disrupts the order
        sqrdNumberStream.forEach(System.out::println);

        // Collect(or)
        System.out.println("----------------");
        List<Integer> numbersList2 = List.of(9, 12, 31);
        List<Integer> sqrdNumberList = numbersList2.parallelStream().map(number -> number * number).collect(Collectors.toList());
        sqrdNumberList.forEach(System.out::println);

    }
}
