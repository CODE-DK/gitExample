package root.lesson_5;

import org.junit.Before;
import org.junit.Test;
import root.lesson_5.utils.TextReaderUtils;

import java.io.File;
import java.util.Set;

public class SolutionTest {

    private static final int PROBABILITY = 50;
    private static final int FILE_SIZE = 5000;
    private static final int NUM_OF_FILES = 10;
    private static final String OUT_PATH = "src/main/resources/lesson_5/out";
    private static final String TEXT_RES = "src/main/resources/lesson_5/text.txt";

    private String[] wordsArr;

    @Before
    public void init() {
        Set<String> words = TextReaderUtils.getWordsFromFile(new File(TEXT_RES));
        wordsArr = words.toArray(new String[0]);
    }

    @Test
    public void getFiles() {
        Solution solution = new Solution();
        solution.getFiles(OUT_PATH, NUM_OF_FILES, FILE_SIZE, wordsArr, PROBABILITY);
    }
}