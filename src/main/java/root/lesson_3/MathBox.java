package root.lesson_3;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MathBox<T extends Number> extends ObjectBox<T> {

    public MathBox(List<T> store) {
        super(store);
    }

    public double summator() {
        double sum = 0d;
        for (T elem : store) {
            sum += elem.doubleValue();
        }
        return sum;
    }

    @SuppressWarnings({"unchecked", "WrapperTypeMayBePrimitive"})
    public void splitter(int val) {
        Set<T> newStore = new HashSet<>();
        for (T elem : store) {
            Double res = elem.doubleValue() / val;
            newStore.add((T) res);
        }
        store.addAll(newStore);
    }

    @SuppressWarnings("SuspiciousMethodCalls")
    public boolean deleteInt(Integer val) {
        return store.remove(val);
    }

    @Override
    @SuppressWarnings({"SingleStatementInBlock", "ConstantConditions"})
    public void addObject(T obj) {
        if (obj instanceof Number) {
            super.addObject(obj);
        } else {
            throw new InvalidParamException("Can't add not Number class!!!");
        }
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
