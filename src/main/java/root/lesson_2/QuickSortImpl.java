package root.lesson_2;

import java.util.List;

public class QuickSortImpl implements MegaSort {

    @Override
    public <T extends Comparable<T>> void sort(List<T> list) {
        quickSort(list, 0, list.size() - 1);
    }

    private <T extends Comparable<T>> void quickSort(List<T> array, int low, int high) {
        if (array.size() == 0) return;
        if (low >= high) return;
        int middle = low + (high - low) / 2;
        T ref = array.get(middle);
        int i = low, j = high;
        while (i <= j) {
            while (array.get(i).compareTo(ref) < 0) {
                i++;
            }
            while (array.get(j).compareTo(ref) > 0) {
                j--;
            }
            if (i <= j) {
                T temp = array.get(i);
                array.set(i, array.get(j));
                array.set(j, temp);
                i++;
                j--;
            }
        }
        if (low < j) quickSort(array, low, j);
        if (high > i) quickSort(array, i, high);
    }
}
