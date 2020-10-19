package root.lesson_5.builder;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static java.util.Arrays.asList;

public class TenseBuilder {

    private static final int MIN_WORDS = 1;
    private static final int MAX_WORDS = 15;
    private static final List<String> END_SYMBOL = asList(".", "!", "?");
    private static final List<String> DIVIDER = asList(", ", " ");
    private static final Random RANDOM = new Random();
    private final WordBuilder wordBuilder;

    public TenseBuilder(WordBuilder wordBuilder) {
        this.wordBuilder = wordBuilder;
    }

    public String getTense() {
        StringBuilder tense = new StringBuilder();
        getWords().forEach(word -> {
            word = word + getDivider();
            tense.append(word);
        });
        return applyRules(tense.toString());
    }

    private String applyRules(String tense) {
        tense = removeLastSymbol(tense);
        return tense.substring(0, 1).toUpperCase()
                + tense.substring(1).toLowerCase()
                + getEndSymbol();
    }

    private String removeLastSymbol(String tense) {
        tense = tense.trim();
        if (tense.endsWith(",")) {
            tense = tense.substring(0, tense.length() - 1);
        }
        return tense;
    }

    private List<String> getWords() {
        int length = MIN_WORDS + RANDOM.nextInt(MAX_WORDS);
        List<String> words = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            words.add(wordBuilder.getWord());
        }
        return words;
    }

    private String getDivider() {
        int index = RANDOM.nextInt(DIVIDER.size());
        return DIVIDER.get(index);
    }

    private String getEndSymbol() {
        int index = RANDOM.nextInt(END_SYMBOL.size());
        return END_SYMBOL.get(index);
    }
}
