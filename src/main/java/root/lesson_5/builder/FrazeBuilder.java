package root.lesson_5.builder;

import java.util.Random;

public class FrazeBuilder {

    private static final int MIN_FRAZE = 1;
    private static final int MAX_FRAZE = 20;
    private static final String SPACE = " ";
    private static final String TAB = "\t";
    private static final String NEXT = "\n";
    private static final Random RANDOM = new Random();
    private final TenseBuilder tenseBuilder;

    public FrazeBuilder(TenseBuilder tenseBuilder) {
        this.tenseBuilder = tenseBuilder;
    }

    public String getFraze() {
        StringBuilder fraze = new StringBuilder().append(TAB);
        int length = MIN_FRAZE + RANDOM.nextInt(MAX_FRAZE);
        for (int i = 0; i < length; i++) {
            fraze
                    .append(tenseBuilder.getTense())
                    .append(SPACE);
        }
        return fraze
                .append(NEXT)
                .toString();
    }
}
