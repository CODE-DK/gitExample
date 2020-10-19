package root.lesson_5.builder;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class TenseBuilderTest {

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
    public void getTense() {
        WordBuilder wordBuilder = new WordBuilder(WORDS, 50);
        TenseBuilder tenseBuilder = new TenseBuilder(wordBuilder);
        for (int i = 0; i < 1_000_000; i++) {
            String tense = tenseBuilder.getTense();
            //Starts with UPPER case
            assertTrue(tense.substring(0, 1).matches("[A-Z]"));
            //Contains only lower case or ',' and spaces
            assertTrue(tense.substring(1, tense.length() - 1).matches("[a-z, ]+") || tense.length() == 2);
            //End with '.|!|?'
            assertTrue(tense.substring(tense.length() - 1).matches("[.!?]"));
        }
    }
}