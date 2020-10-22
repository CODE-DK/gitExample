package root.lesson_7.load;

import java.lang.reflect.InvocationTargetException;
import java.util.Optional;

public class CustomLoaderImpl implements CustomLoader {

    @Override
    public Optional<Object> loadByName(String className) {
        try {
            return Optional.of(Class.forName(className).getDeclaredConstructor().newInstance());
        } catch (InstantiationException
                | IllegalAccessException
                | InvocationTargetException
                | NoSuchMethodException
                | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }
}
