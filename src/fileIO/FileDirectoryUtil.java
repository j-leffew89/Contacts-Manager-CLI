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
        } else {
            System.out.println("The path at: " + pathToCreate.toAbsolutePath() + " already exist.");
        }
    }

    public static void tryCreateFile(Path path) {

        if (!doesPathExist(path)) {
            try {
                Files.createFile(path);
            } catch (IOException e) {
                System.out.println("Could not create file at: " + path.toAbsolutePath());
            }
        } else {
            System.out.println("The file at: " + path.toAbsolutePath() + " already exists.");
        }
    }

    public static Path getPath(String parentDirectory, String fileName) {
        return Paths.get(parentDirectory, fileName);
    }

    public static boolean doesPathExist(Path path) {
        return Files.exists(path);
    }
}
