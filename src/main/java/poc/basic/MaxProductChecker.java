package poc.basic;

import java.util.Arrays;
import java.util.Objects;
import java.util.stream.IntStream;

public class MaxProductChecker {

    public static void findMaxProductInArray(int... input) {
        if (input != null && input.length < 2) {
            System.out.println("Not enough entries!");
            return;
        }
        Arrays.sort(Objects.requireNonNull(input));
        boolean hasNegative = Arrays.stream(input).anyMatch(item -> item < 0);
        int size = input.length;
        int maxProduct = (input[size - 1] * input[size - 2]);
        if (hasNegative) {
            int lowerEnd = input[0] * input[1];
            if (maxProduct < lowerEnd) {
                maxProduct = lowerEnd;
            }
        }
        System.out.println("Max Product value = " + maxProduct);
    }

    public static void findMaxProductInArray2(int... input) { // This has a bug due to use of "abs" function
        IntStream absElements = Arrays.stream(input).parallel().map(Math::abs).sorted();
        int[] moderated = absElements.toArray();
        int size = moderated.length;
        System.out.println("The max product = " + (moderated[size - 1] * moderated[size - 2]));
    }

    public static void main(String[] args) {
        findMaxProductInArray2(5, 3, 2, 5, 7, 0);
        findMaxProductInArray(-2, -1, -3, 4, -8, 0);
        findMaxProductInArray(-20, -10, 3, 9, -8);
        findMaxProductInArray(-2, 0, 3, 9, -15);
    }
}
