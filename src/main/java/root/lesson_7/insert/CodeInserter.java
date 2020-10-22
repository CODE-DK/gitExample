package root.lesson_7.insert;

import java.util.Optional;

public interface CodeInserter {

    Optional<String> insert(String source, String code);
}
