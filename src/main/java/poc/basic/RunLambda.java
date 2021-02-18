package poc.basic;

import java.util.ArrayList;
import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntPredicate;
import java.util.function.Supplier;

public class RunLambda {
    public static void main(String[] args){
        ArrayList<String> students = new ArrayList<>();
        students.add("Bobby");
        students.add("Charlie");
        students.add("Julie");
        students.add("Pompei");
        System.out.println("----------------");
        System.out.println("---- TYPE 1 ----");
        students.forEach(student -> System.out.println(student)); //imperative pattern, reduce the boilerplate code

        // Consumer (a type of lambda function that takes input, but no output)
        System.out.println("----------------");
        System.out.println("---- TYPE 2 ----");
        Consumer<String> printName = name -> System.out.println(name);
        students.forEach(printName);

        // Function (has both inout and output)
        System.out.println("----------------");
        System.out.println("---- TYPE 3 ----");
        Function<Integer,Integer> square = number -> number * number;
        System.out.println(square.apply(8));

        // Predicate (a lambda expression that returns true or false)
        // different Type based on what input to predicate
        System.out.println("----------------");
        System.out.println("---- TYPE 4 ----");
        IntPredicate isOddNumber = number -> !(number % 2 == 0);
        System.out.println(isOddNumber.test(21));

        // Supplier (a lambda function that takes no input, but produces output)
        System.out.println("----------------");
        System.out.println("---- TYPE 5 ----");
        Supplier<Integer> randomNumberUnder20 = () -> {
            Random dial = new Random();
            return dial.nextInt(20)+1;
        };
        System.out.println(randomNumberUnder20.get());



    }
}
