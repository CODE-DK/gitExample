package root.lesson_7.io;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Objects;
import java.util.Optional;
import java.util.Scanner;

public class CodeReaderImpl implements CodeReader {

    @Override
    public Optional<String> readFromConsole() {
        final StringBuilder builder = new StringBuilder();
        try (final Scanner scanner = new Scanner(System.in)) {
            final String str = scanner.nextLine();
            while (!Objects.equals("", str)) {
                builder.append(str);
            }
        }
        return Optional.of(builder.toString());
    }

    @Override
    public Optional<String> readFromSource(String source) {
        final StringBuilder builder = new StringBuilder();
        try {
            Files.readAllLines(Paths.get(source)).forEach(builder::append);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Optional.of(builder.toString());
    }
}
