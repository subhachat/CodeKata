package algorithms.bubblesort;

import java.util.Arrays;

public class RunBubbleSort {

    public static void main(String... args) {
        //Prep. an array of integer
        int[] dataToSort = {10, 2, 8, 6, 7, 3};
        //pass it to the sort function
        sort(dataToSort);
        //print the output
        System.out.println(Arrays.toString(dataToSort));
    }

    private static void sort(int[] input) {
        //Sort operation
        for (int outerCounter = input.length - 1; outerCounter > 0; outerCounter--) {
            int largestNumber = 0;
            for (int innerCounter = 0; innerCounter < outerCounter; innerCounter++) {
                if (input[innerCounter] > input[innerCounter + 1]) {
                    largestNumber = input[innerCounter];
                    input[innerCounter] = input[innerCounter + 1]; // value swaps
                    input[innerCounter + 1] = largestNumber; // next number becomes largest
                }
            }
        }
    }
}
