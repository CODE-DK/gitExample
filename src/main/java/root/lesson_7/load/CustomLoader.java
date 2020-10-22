package root.lesson_7.load;

import java.util.Optional;

public interface CustomLoader {
    Optional<Object> loadByName(String className);
}
