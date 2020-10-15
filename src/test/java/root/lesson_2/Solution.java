package root.lesson_2;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Solution {

    private static final int ELEMENTS = 10000;
    private static final Random RANDOM = new Random();
    private static final String STR = "gaksdghflasdjhvkljsafvasfklghfsdkljghsadfkljsafkjhgkljsafhgkjsdahfljkasdghlasdhgkldsahgkasfghksdk";

    @Test
    public void MergeSort() {
        List<Person> persons = getPersons();
        MegaSort megaSort = new MergeSortImpl();
        System.out.println("BEFORE");
        persons.forEach(System.out::println);
        megaSort.sort(persons);
        System.out.println("AFTER");
        persons.forEach(System.out::println);
    }

    @Test
    public void QuickSort(){
        List<Person> persons = getPersons();
        MegaSort megaSort = new QuickSortImpl();
        System.out.println("BEFORE");
        persons.forEach(System.out::println);
        megaSort.sort(persons);
        System.out.println("AFTER");
        persons.forEach(System.out::println);
    }

    private List<Person> getPersons() {
        List<Person> people = new ArrayList<>();
        for (int i = 0; i < ELEMENTS; i++) {
            people.add(new Person(
                    RANDOM.nextInt(100),
                    RANDOM.nextBoolean() ? Sex.MAN : Sex.WOMAN,
                    nextString(RANDOM.nextInt(STR.length() - 10))
            ));
        }
        return people;
    }

    private String nextString(int startIndex) {
        return STR.substring(startIndex);
    }
}
