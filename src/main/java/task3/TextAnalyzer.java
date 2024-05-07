package task3;

import java.util.*;

public class TextAnalyzer {

    public static void main(final String[] args) {
        if (args.length == 0) {
            System.out.println("No arguments provided");
            return;
        }
        final TextAnalyzer textAnalyzer = new TextAnalyzer();
        final List<Integer> lengths = textAnalyzer.getWordLengths(args);
        final Map<String, Integer> occurrences = textAnalyzer.getCharacterOccurrences(args);
        lengths.forEach(System.out::println);
        occurrences.forEach((key, value) -> System.out.println(key + ": " + value));
    }

    public List<Integer> getWordLengths(final String[] words) {
        final List<Integer> wordLengths = new ArrayList<>();
        Arrays.stream(words).forEach(word -> wordLengths.add(word.length()));
        return wordLengths;
    }

    public Map<String, Integer> getCharacterOccurrences(final String[] words) {
        final Map<String, Integer> characterOccurrences = new HashMap<>();
        Arrays.stream(words).forEach(word -> {
            final String[] characters = word.split("");
            Arrays.stream(characters).forEach(character -> {
                final String key = String.valueOf(TextAnalyzer.ToUppercase(character.charAt(0)));
                characterOccurrences.put(key, characterOccurrences.getOrDefault(key, 0) + 1);
            });
        });
        return characterOccurrences;
    }

    private static char ToUppercase(final char c) {
        if (c >= 'a' && c <= 'z') {
            return (char) (c - 32);
        }
        return c;
    }
}
