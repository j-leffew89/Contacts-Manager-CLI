package fileIO;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class IOUtil {


    public static void tryPrintContents(Path path) {
        IOUtil.printFileContents(Objects.requireNonNull(IOUtil.tryReadFromFile(path)));
    }

    public static List<String> tryReadFromFile(Path path) {
        try {
            return Files.readAllLines(path);
        } catch (IOException e) {
            System.out.println("Unable to read" +
                    " contents of the file at: " + path.toAbsolutePath());
            return null;
        }
    }

    public static void printFileContents(List<String> contents) {
        for (String line : contents) {
            System.out.println(line);
        }
    }

    public static void tryAppendToFile(List<String> content, Path path) {
        try {
            Files.write(path, content, StandardOpenOption.APPEND);
        } catch (IOException e) {
            System.out.println("Could not write to file at: " + path.toAbsolutePath());
        }
    }

    public static void tryAppendToFile(String contactString, Path path) {
        try {
            List<String> content = new ArrayList<>();
            content.add(contactString);

            Files.write(path, content, StandardOpenOption.APPEND);
        } catch (IOException e) {
            System.out.println("Could not write to file at: " + path.toAbsolutePath());
        }
    }

    public static void tryWriteToFile(List<String> content, Path path) {
        try {
            Files.write(path, content);
        } catch (IOException e) {
            System.out.println("Could not write to file at: " + path.toAbsolutePath());
        }
    }
}
