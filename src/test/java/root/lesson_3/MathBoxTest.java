package root.lesson_3;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class MathBoxTest {

    private MathBox<Integer> mathBox;

    @Before
    public void init() {
        List<Integer> integerList = new ArrayList<>();
        integerList.add(5);
        integerList.add(7);
        integerList.add(13);
        integerList.add(11);
        integerList.add(17);
        integerList.add(-2);
        integerList.add(-9);

        mathBox = new MathBox<>(integerList);
    }

    @Test
    public void summator() {
        assertEquals(42, mathBox.summator(), 0.001);
    }

    @Test
    public void splitter() {
        double before = mathBox.summator();
        mathBox.splitter(2);

        assertNotEquals(before, mathBox.summator());
    }

    @Test
    public void addObject() {
        for (int i = 0; i < 10; i++) {
            mathBox.addObject(i % 2 == 0 ? i : -i);
        }
        assertEquals(46, mathBox.summator(), 0.001);
    }

    @Test
    public void deleteInt() {
        assertEquals(42, mathBox.summator(), 0.001);

        mathBox.addObject(10);
        assertEquals(52, mathBox.summator(), 0.001);

        assertTrue(mathBox.deleteInt(10));
        assertEquals(42, mathBox.summator(), 0.001);
    }

    @Test
    public void hashCodeTest() {
        int hashCode = mathBox.hashCode();
        mathBox.addObject(123456);

        assertEquals(hashCode, mathBox.hashCode());
    }
}