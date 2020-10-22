package root.lesson_7.insert;

import java.util.Optional;

public class CodeInserterImpl implements CodeInserter{

    private static final String DIVIDER = ";";

    @Override
    public Optional<String> insert(String source, String code) {
        if (source.contains(DIVIDER)) {
            return Optional.of(source.replace(DIVIDER, "{" + code + "}"));
        }
        return Optional.empty();
    }
}
