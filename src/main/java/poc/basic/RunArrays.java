package poc.basic;

import java.util.Arrays;

public class RunArrays {
    public static void main(String[] args) {
        int[] firstArray; // Declare
        int[] secondArray = new int[5]; // Allocate
        int[] thirdArray = {1, 2, 3, 4, 5}; // Declare, Allocate, Initialize

        int[] evenNumberArray = {2, 4, 6, 8, 10, 11}; // index 5 is 11, not a fit
        int[] oddNumberArray = {1, 3, 5, 12, 9, 7}; // index 3 is 12, not a fit

        int copyOfItemFromEvenArray = evenNumberArray[5];
        int copyOfItemFromOddArray = oddNumberArray[3];

        evenNumberArray[5] = copyOfItemFromOddArray;
        oddNumberArray[3] = copyOfItemFromEvenArray;
        System.out.println(Arrays.toString(evenNumberArray));
        System.out.println(Arrays.toString(oddNumberArray));
    }
}
