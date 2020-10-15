package root.lesson_2;

import java.util.Collections;
import java.util.List;

public class MergeSortImpl implements MegaSort {

    @Override
    public <T extends Comparable<T>> void sort(List<T> list) {
        Collections.sort(list);
    }
}
