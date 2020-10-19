package root.lesson_5.builder;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class WordBuilderTest {

    private static final List<String> WORDS = new ArrayList<>();

    @Before
    public void init() {
        WORDS.add("some");
        WORDS.add("else");
        WORDS.add("if");
        WORDS.add("for");
        WORDS.add("maybe");
        WORDS.add("reason");
        WORDS.add("builder");
        WORDS.add("generator");
        WORDS.add("idea");
        WORDS.add("java");
        WORDS.add("maven");
    }

    @Test
    public void getWord() {
        WordBuilder wordBuilder = new WordBuilder(WORDS, 100);
        for (int i = 0; i < 1_000_000; i++) {
            String word = wordBuilder.getWord();
            assertTrue(WORDS.contains(word));
        }
        wordBuilder = new WordBuilder(WORDS, 0);
        for (int i = 0; i < 1_000_000; i++) {
            String word = wordBuilder.getWord();
            assertTrue(word.length() > 0 && word.length() < 16);
            assertFalse(WORDS.contains(word));
        }
    }
}