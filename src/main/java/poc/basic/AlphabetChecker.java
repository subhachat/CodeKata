package poc.basic;

import java.util.regex.Pattern;
import java.util.stream.IntStream;

public class AlphabetChecker {
    static final String REGEX_VOWELS = "[aeiouyAEIOUY]";
    static final String VOWELS = "aeiouy";

    public static void printCountOfVowelsConsonants(String input) {
        Pattern patternVowel = Pattern.compile(REGEX_VOWELS);
        StringBuilder strBuilder = new StringBuilder(input);
        IntStream alphabetStream = strBuilder.chars()
                .parallel().filter(ch -> {
                    return Character.isAlphabetic(ch);
                });
        IntStream vowelStream = strBuilder.chars()
                .parallel().filter(ch -> {
                    return patternVowel.matcher(Character.toString(ch)).matches();
                });
        long countOfVowels = vowelStream.count();
        long countOfConsonants = alphabetStream.count() - countOfVowels;
        System.out.println("The text has "
                + countOfVowels + " vowels, " + countOfConsonants + " consonants");
    }

    public static void printCountOfVowelsConsonants2(String input) {
        StringBuilder strBuilder = new StringBuilder(input.toLowerCase());
        long countOfAlphabets = strBuilder.chars().filter(Character::isAlphabetic).count();
        long countOfVowels = strBuilder.chars().filter(ch -> {
            return (VOWELS.indexOf(ch) > -1);
        }).count();
        System.out.println("The text has "
                + countOfVowels + " vowels, " + (countOfAlphabets - countOfVowels) + " consonants");
    }

    public static void main(String[] args) {
        printCountOfVowelsConsonants("HellO");
        printCountOfVowelsConsonants2("HellO1");
        printCountOfVowelsConsonants("there is A quiET Mouse");
        printCountOfVowelsConsonants2("I am HappY    ");
    }
}
