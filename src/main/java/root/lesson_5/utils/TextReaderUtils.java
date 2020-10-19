package root.lesson_5.utils;

import root.lesson_5.exceptions.FileNotSupportedException;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

import static java.util.Arrays.stream;

public class TextReaderUtils {

    private static final Set<String> WORDS = new HashSet<>();
    private static final String DIVIDER = "[\\W]";
    private static final String WORD_REGEX = "[a-zA-Z]+";

    private TextReaderUtils() {
        //use always for util classes
    }

    public static Set<String> getWordsFromFile(File file) {
        if (!isFormatSupport(file.getName())) {
            throw new FileNotSupportedException("Format not supported");
        }
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file)))) {
            WORDS.clear();
            reader.lines().forEach(line -> stream(line.split(DIVIDER))
                    .filter(str -> str.matches(WORD_REGEX))
                    .map(String::toLowerCase)
                    .forEach(WORDS::add));
        } catch (IOException e) {
            System.out.println("Oops, looks like IOException produced during file reading :(");
        }
        return WORDS;
    }

    private static boolean isFormatSupport(String fileName) {
        return fileName.matches(".+(.txt|.md)$");
    }
}
