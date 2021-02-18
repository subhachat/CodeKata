package poc.basic;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RunWordChecker {
    //private static final String REGEX_WORD = "(\\w+)((\\s+)|([,.;-_!\\?]))";
    private static final String REGEX_WORD = "(\\w+)(\\s*)";
    private static final Set<String> commonWordsSet
            = Set.of("the", "a", "or", "an", "it", "and", "but", "is", "are",
            "of", "on", "to", "was", "were", "in", "that", "i", "your", "his",
            "their", "her", "you", "me", "they", "at", "be");

    private static void findMostRepeatedWord(String input) {
        final Map<String, Integer> wordCountMap = new HashMap<>();
        Matcher matcher = Pattern.compile(REGEX_WORD).matcher(input);
        while (matcher.find()) {
            String word = matcher.group().toLowerCase().trim();
            if (commonWordsSet.contains(word)) {
                continue; //ignore the common words from the text
            }
            if (wordCountMap.containsKey(word)) {
                wordCountMap.put(word, wordCountMap.get(word) + 1); //if a word repeats add to it's count of occurrence
            } else {
                wordCountMap.putIfAbsent(word, 1); //if a word appears for the first time, set count = 1
            }
        }
        System.out.println("word checker->" + wordCountMap);

        final int[] maxOccurrence = {0}; //a reference value to check max occurrence
        final String[] mostRepeatedWord = {""};
        //Note - Map doesn't guarantee the order of the words, as they appear on
        wordCountMap.forEach((key, value) -> {
            if (value > maxOccurrence[0]) {
                maxOccurrence[0] = value;
                mostRepeatedWord[0] = key;
            }
        });
        System.out.println("Most repeated word is -> " + mostRepeatedWord[0]);
    }

    public static void main(String[] args) {
        findMostRepeatedWord("John writes about this, and John writes about that, abc-def _pqr feg;nmo");
        findMostRepeatedWord("We organise what we write into sentences and paragraphs. A paragraph begins on a new line within the text and there is often a blank line between paragraphs. A paragraph usually contains more than one sentence and it is usually about one topic.");
    }
}
