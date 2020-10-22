package root.lesson_6;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;

import static java.util.concurrent.Executors.newFixedThreadPool;

public class MathExecutor {

    private static final Map<Integer, BigInteger> CACHE = new ConcurrentHashMap<>();
    private final List<Integer> nums;

    public MathExecutor(List<Integer> nums) {
        this.nums = nums;
    }

    public Map<Integer, BigInteger> calcFacts() {
        ExecutorService executor = newFixedThreadPool(100);
        nums.forEach(num -> executor.submit(() -> {
            if (CACHE.containsKey(num)) {
                return;
            }
            BigInteger fact = BigInteger.ONE;
            for (int i = 1; i <= num; i++) {
                fact = fact.multiply(BigInteger.valueOf(i));
            }
            CACHE.put(num, fact);
        }));
        executor.shutdown();
        return CACHE;
    }
}
