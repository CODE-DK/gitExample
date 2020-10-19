package root.lesson_5.utils;

import org.junit.Test;
import root.lesson_5.exceptions.FileNotSupportedException;

import java.io.File;
import java.util.Set;

public class TextReaderTest {

    @Test(expected = FileNotSupportedException.class)
    public void getWordsFromFile_WhenFormatNotSupport() {
        File file = new File("/somePath/someFileName.html");
        TextReaderUtils.getWordsFromFile(file);
    }

    @Test
    public void getWordsFromFile_WhenFormatSupport() {
        File file = new File("src/main/resources/lesson_5/text.txt");
        Set<String> words = TextReaderUtils.getWordsFromFile(file);
        System.out.println(words);
    }
}