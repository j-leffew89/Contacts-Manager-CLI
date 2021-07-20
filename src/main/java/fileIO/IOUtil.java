package fileIO;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class IOUtil {

    public static List<String> tryReadFromFile(Path path) {
        try {
            return Files.readAllLines(path);
        } catch (IOException e) {
            System.out.println("Unable to read" +
                    " contents of the file at: " + path.toAbsolutePath());
            return null;
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
