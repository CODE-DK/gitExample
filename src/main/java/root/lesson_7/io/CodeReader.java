package root.lesson_7.io;

import java.util.Optional;

public interface CodeReader {
    Optional<String> readFromConsole();

    Optional<String> readFromSource(String source);
}
