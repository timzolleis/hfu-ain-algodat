package task3;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TextAnalyzerTest {

    @Test
    void getWordLengths() {
        final String[] words = {"apple", "banana", "cherry"};
        final TextAnalyzer textAnalyzer = new TextAnalyzer();
        final List<Integer> wordLengths = textAnalyzer.getWordLengths(words);
        assertEquals(5, wordLengths.get(0));
        assertEquals(6, wordLengths.get(1));
        assertEquals(6, wordLengths.get(2));
    }

    @Test
    void getCharacterOccurrences() {
        final String[] words = {"apple", "banana", "cherry"};
        final TextAnalyzer textAnalyzer = new TextAnalyzer();
        final var characterOccurrences = textAnalyzer.getCharacterOccurrences(words);
        assertEquals(4, characterOccurrences.get("A"));
        assertEquals(2, characterOccurrences.get("P"));
        assertEquals(1, characterOccurrences.get("L"));
        assertEquals(2, characterOccurrences.get("E"));
    }
}