package root.lesson_2;

import java.util.List;

public interface MegaSort {

    <T extends Comparable<T>> void sort(List<T> list);
}
