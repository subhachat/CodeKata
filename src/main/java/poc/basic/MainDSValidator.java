package poc.basic;

import java.util.*;

public class MainDSValidator {
    public static void main(String... args) {
        //reverseArray(new int[]{2, 3, 4, 1});
        int[][] input = {
                {1, 1, 1, 0, 0, 0},
                {0, 1, 0, 0, 0, 0},
                {1, 1, 1, 0, 0, 0},
                {0, 0, 2, 4, 4, 0},
                {0, 0, 0, 2, 0, 0},
                {0, 0, 1, 2, 4, 0}
        };

        int[][] input2 = {
                {-9, -9, -9, 1, 1, 1},
                {0, -9, 0, 4, 3, 2},
                {-9, -9, -9, 1, 2, 3},
                {0, 0, 8, 6, 6, 0},
                {0, 0, 0, -2, 0, 0},
                {0, 0, 1, 2, 4, 0}
        };
        System.out.println("Max Hour Glass sum = " + hourglassSum(input));
        System.out.println("========");
        System.out.println("Max Hour Glass sum = " + hourglassSum(input2));
    }

    public static int[] reverseArray(int[] a) {
        int[] tmp = new int[a.length];
        for (int counter = 0; counter < a.length; counter++) {
            tmp[counter] = a[a.length - counter - 1];
        }
        return tmp;
    }

    public static int hourglassSum(int[][] arr) {
        List<Integer> storeAll3x3sum = new ArrayList<>();
        //List<int[][]> storeAll3x3 = new ArrayList<>();
        for (int row = 0; row < 4; row++) {
            for (int column = 0; column < 4; column++) {
                int _3x3sum = 0;
                int[][] tmpHourGlassArray = new int[3][3]; //int[row][column]
                int x = 0;
                for (int hourGlassRow = row; hourGlassRow <= row + 2; hourGlassRow++) {
                    int y = 0;
                    for (int hourGlassCol = column; hourGlassCol <= column + 2;
                         hourGlassCol++) {
                        if (!(x == 1 && (y == 0 || y == 2))) {
                            tmpHourGlassArray[x][y] =
                                    arr[hourGlassRow][hourGlassCol];
                            _3x3sum += arr[hourGlassRow][hourGlassCol];
                        }
                        y++;
                    }
                    x++;
                }
                //storeAll3x3.add(tmpHourGlassArray);
                storeAll3x3sum.add(_3x3sum);
            }
        }
        Collections.sort(storeAll3x3sum, Comparator.reverseOrder());
        //storeAll3x3.stream().forEach(each3x3 -> System.out.println(Arrays
        // .deepToString(each3x3)));
        //System.out.println("3x3sum -> "+storeAll3x3sum);
        // After reverse sorting, the first element is the highest sum
        return storeAll3x3sum.get(0);
    }
}