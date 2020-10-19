package root.lesson_5.builder;

import java.util.List;
import java.util.Random;

public class WordBuilder {

    private static final String SYMBOLS = "llahdfkjashdfkllkjhasdkfadslvDJLLKVJkjhvkajsdnvkndsksNVKJNKDVNSDVNKJDSnfkjaNS";
    private static final Random RANDOM = new Random();
    private static final int MIN_PROBABILITY = 0;
    private static final int MAX_PROBABILITY = 100;
    private static final int MIN_LENGTH = 1;
    private static final int MAX_LENGTH = 15;

    private final List<String> words;
    private final int probability;

    public WordBuilder(List<String> words, int probability) {
        this.probability = probability;
        this.words = words;
    }

    public String getWord() {
        final int bounds = RANDOM.nextInt(MAX_PROBABILITY);
        if (bounds < optimize(probability)) {
            return words.get(RANDOM.nextInt(words.size()));
        }
        return generateWord();
    }

    private String generateWord() {
        final String begin = SYMBOLS.substring(MIN_LENGTH + RANDOM.nextInt(SYMBOLS.length() - MIN_LENGTH));
        return begin.length() > MAX_LENGTH
                ? begin.substring(0, MAX_LENGTH)
                : begin;
    }

    private int optimize(int probability) {
        probability = probability > -1 ? probability : MIN_PROBABILITY;
        probability = probability < 101 ? probability : MAX_PROBABILITY;
        return probability;
    }
}
