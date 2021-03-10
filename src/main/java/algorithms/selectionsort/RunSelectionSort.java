package algorithms.selectionsort;

import java.util.Arrays;

public class RunSelectionSort {

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
        for (int i = 0; i < input.length - 1; i++) {
            int minIndex = i;
            for (int j = i+1; j < input.length; j++) {
                if (input[j] < input[minIndex]) {
                    minIndex = j;
                }
            }
            int tmp = input[minIndex];
            input[minIndex] = input[i];
            input[i] = tmp;
        }
    }
}
