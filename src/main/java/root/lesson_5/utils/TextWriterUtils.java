package root.lesson_5.utils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import static java.util.Arrays.stream;

public class TextWriterUtils {

    private static final int CHAR_SIZE = 2;
    private static int size = 0;

    public static void writeStringToFile(String str, File file) {
        size += str.length();
        try (FileWriter writer = new FileWriter(file, true)) {
            writer.write(str);
        } catch (IOException e) {
            System.out.println("Oops, I can't write to this file :(");
        }
    }

    @SuppressWarnings({"ConstantConditions", "ResultOfMethodCallIgnored"})
    public static void cleanDir(String path) {
        //WARNING:  Not for production!!!
        //          Example only!!
        File dir = new File(path);
        if (dir.isDirectory()) {
            stream(dir.listFiles()).forEach(File::delete);
        }
    }

    public static int getSizeInBites() {
        return size * CHAR_SIZE;
    }

    public static void flush() {
        size = 0;
    }
}
