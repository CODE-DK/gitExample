package root.lesson_3;

import java.util.*;

public class ObjectBox<T> {

    private static final Random RANDOM = new Random();
    private int hashCode = -1;
    protected final Set<T> store = new HashSet<>();

    public ObjectBox(List<T> store) {
        this.store.addAll(store);
    }

    public void addObject(T obj) {
        store.add(obj);
    }

    public void deleteObject(T obj) {
        store.remove(obj);
    }

    public String dump() {
        return store.toString();
    }

    public int size() {
        return store.size();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ObjectBox<?> objectBox = (ObjectBox<?>) o;
        return Objects.equals(store, objectBox.store);
    }

    @Override
    public int hashCode() {
        if (hashCode == -1) {
            hashCode = RANDOM.nextInt();
        }
        return hashCode;
    }

    @Override
    public String toString() {
        return "ObjectBox{" +
                "store=" + store +
                '}';
    }
}
