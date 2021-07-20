package fileIO;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileDirectoryUtil {

    public static void tryCreateDirectory(Path pathToCreate) {

        if (!doesPathExist(pathToCreate)) {
            try {
                Files.createDirectory(pathToCreate);
            } catch (IOException e) {
                System.out.println("Could not create the directory at: ");
                System.out.println(pathToCreate.toAbsolutePath());
            }
        }
    }

    public static void tryCreateFile(Path path) {

        if (!doesPathExist(path)) {
            try {
                Files.createFile(path);
            } catch (IOException e) {
                System.out.println("Could not create file at: " + path.toAbsolutePath());
            }
        }
    }

    public static Path getPath(String filepath) {
        return Paths.get(filepath);
    }

    public static boolean doesPathExist(Path path) {
        return Files.exists(path);
    }
}
