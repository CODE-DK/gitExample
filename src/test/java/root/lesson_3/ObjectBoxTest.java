package root.lesson_3;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class ObjectBoxTest {

    private ObjectBox<Object> objectBox;
    private Object marker = new Object();

    @Before
    public void init() {

        List<Object> objects = new ArrayList<>();

        objects.add(new Object());
        objects.add(new Object());
        objects.add(new Object());
        objects.add(new Object());
        objects.add(marker);

        objectBox = new ObjectBox<>(objects);
    }

    @Test
    public void addObject() {
        final Object x = new Object();
        objectBox.addObject(x);

        assertEquals(6, objectBox.size());
    }

    @Test
    public void deleteObject() {
        objectBox.deleteObject(marker);

        assertEquals(4, objectBox.size());
    }

    @Test
    public void dump() {
        System.out.println(objectBox.dump());

        assertNotNull(objectBox.dump());
    }

    @Test
    public void hashCodeTest() {
        int hashCode = objectBox.hashCode();
        objectBox.addObject(new Object());

        assertEquals(hashCode, objectBox.hashCode());
    }
}