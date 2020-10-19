package root.lesson_5.builder;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class FrazeBuilderTest {

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
    public void getFraze() {
        WordBuilder wordBuilder = new WordBuilder(WORDS, 50);
        TenseBuilder tenseBuilder = new TenseBuilder(wordBuilder);
        FrazeBuilder frazeBuilder = new FrazeBuilder(tenseBuilder);
        for (int i = 0; i < 100_000; i++) {
            String fraze = frazeBuilder.getFraze();
            //Starts with TAB because it fraze captain!
            assertTrue(fraze.substring(0, 1).matches("[\t]"));
            //Contains dif tense
            String[] tenseness = fraze
                    .replaceAll("[\\W]", "")
                    .split("[.!?]");
            assertTrue(tenseness.length > 0 && tenseness.length < 21);
            //Go to next in end if fraze
            assertTrue(fraze.substring(fraze.length() - 1).matches("[\n]"));
        }
    }
}