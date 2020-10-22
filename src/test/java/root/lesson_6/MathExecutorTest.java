package root.lesson_6;

import org.junit.Test;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

import static org.junit.Assert.assertTrue;

public class MathExecutorTest {

    private static final Random RANDOM = new Random();
    private static final int BOUND = 1_000;

    @Test
    public void invokeAll() {
        List<Integer> nums = new ArrayList<>();
        for (int i = 0; i < BOUND; i++) {
            nums.add(RANDOM.nextInt(BOUND));
        }
        MathExecutor executor = new MathExecutor(nums);
        Map<Integer, BigInteger> facts = executor.calcFacts();

        nums.forEach(num -> System.out.println(num + ": " + facts.get(num)));

        facts.keySet().forEach(k -> assertTrue(nums.contains(k)));
    }
}