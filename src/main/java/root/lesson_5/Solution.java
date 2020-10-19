package root.lesson_5;

import root.lesson_5.builder.FrazeBuilder;
import root.lesson_5.builder.TenseBuilder;
import root.lesson_5.builder.WordBuilder;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.UUID;

import static root.lesson_5.utils.TextWriterUtils.*;

public class Solution {

    private static final String DIVIDER = "/";

    public void getFiles(String path, int n, int size, String[] words, int probability) {
        cleanDir(path);
        FrazeBuilder frazeBuilder = getFrazeBuilder(words, probability);
        for (int i = 0; i < n; i++) {
            File file = createFile(path);
            boolean stop = false;
            while (!stop) {
                String fraze = frazeBuilder.getFraze();
                if (size - getSizeInBites() < fraze.length()) {
                    flush();
                    stop = true;
                }
                writeStringToFile(fraze, file);
            }
        }
    }

    private File createFile(String path) {
        //WARNING:  Be careful with while loops!!!
        //          Bad experience!!!
        File file = new File(path + DIVIDER + getRandomName());
        while (file.exists()) {
            file = new File(path + DIVIDER + getRandomName());
        }
        //WARNING:  Always surround you're code!!!
        //          Remember that java should provide save constructions!!
        //          Do not crush you code by you're self.
        try {
            boolean success = file.createNewFile();
            if (success) {
                System.out.println("File with name " + file.getName() + " created!!");
            }
        } catch (IOException e) {
            System.out.println("Oops, can't create this file");
        }
        return file;
    }

    private FrazeBuilder getFrazeBuilder(String[] words, int probability) {
        //WARNING:  Do not do so!!!
        //          Bad experience!!!
        //          USE Constructor an inject there!!
        return new FrazeBuilder(
                new TenseBuilder(
                        new WordBuilder(Arrays.asList(words.clone()), probability)
                ));
    }

    private String getRandomName() {
        return UUID.randomUUID().toString() + ".txt";
    }
}
