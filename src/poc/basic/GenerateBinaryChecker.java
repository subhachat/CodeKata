package poc.basic;

import java.util.stream.IntStream;

public class GenerateBinaryChecker {

    private static void printBinaryNumbers(int range){
        if(range < 1){
            System.out.println("Nothing to print!");
            return;
        }
        IntStream.range(1,range+1).forEach(num -> {
            System.out.println(Integer.toBinaryString(num));
        });
    }

    public static void main(String[] args){
        printBinaryNumbers(6);
        System.out.println("-------");
        printBinaryNumbers(-8);
        System.out.println("-------");
        printBinaryNumbers(2);
    }
}
