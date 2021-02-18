package poc.basic;

import java.util.Optional;
import java.util.stream.IntStream;

public class PalindromeChecker {
    public static boolean isPalindrome(String input) {
        Optional<String> inputValue = Optional.of(input);
        if (inputValue.isPresent()) {
            StringBuilder original = new StringBuilder(inputValue.get()
                    .replaceAll("/|-|\\*", "")
                    .toLowerCase());
            //System.out.println(strBuilder);
            StringBuilder reversed = new StringBuilder(original).reverse();
            //System.out.println("----");
            //System.out.println(altStrBuilder);
            return (reversed.toString().equals(original.toString()));
        }
        return false;
    }

    public static boolean isPalindrome2(String input) {
        Optional<String> inputValue = Optional.of(input);
        if (inputValue.isPresent()) {
            StringBuilder original = new StringBuilder(inputValue.get()
                    .replaceAll("/|-|\\*", "")
                    .toLowerCase());
            return IntStream.range(0, original.length() / 2)
                    .allMatch(index ->
                            original.charAt(index) == original.charAt(original.length() - index - 1)
                    );
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome("civic"));
        System.out.println("~~~~~~~");
        System.out.println(isPalindrome("racecar"));
        System.out.println("~~~~~~~");
        System.out.println(isPalindrome("02/02/2020"));
        System.out.println("~~~~~~~");
        System.out.println(isPalindrome("02-02-2020"));
        System.out.println("~~~~~~~");
        System.out.println(isPalindrome2("02*02*2020"));
        System.out.println("~~~~~~~");
        System.out.println(isPalindrome2("swims"));
        System.out.println("~~~~~~~");
        System.out.println(isPalindrome("wifi"));
        System.out.println("~~~~~~~");
        System.out.println(isPalindrome2("maDAm"));
    }
}
