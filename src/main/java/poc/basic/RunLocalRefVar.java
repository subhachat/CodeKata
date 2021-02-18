package poc.basic;

import java.util.List;

/**
 * Java still remains a statically typed language, once a data type is assigned
 * it can't be changed
 */
public class RunLocalRefVar {
    public static void main(String[] args){
        var orderedFoodItems = List.of("pizza", "garlic bread"); //"var" - since Java 10
        var total = 38.23;

        //orderedFoodItems.add(10); can't add an Integer to a List of String

    }
}
