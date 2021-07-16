import fileIO.FileDirectoryUtil;
import fileIO.IOUtil;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ContactsManagerApp {
    public static void main(String[] args) {
        init();
    }

    public static void init() {
        // Try to create the directory
        Path path = FileDirectoryUtil.getPath("src", "database");

        FileDirectoryUtil.tryCreateDirectory(path);

        // Try to create the file
        path = Paths.get(path.toString(), "Contacts.txt");
        FileDirectoryUtil.tryCreateFile(path);

        // Print out the final location of the file
        System.out.println(path.toAbsolutePath());

        // Try to print the contents of the file BEFORE we write
        IOUtil.tryPrintContents(path);

        //Try to write to the file
        IOUtil.tryWriteToFile(getContent(), path);

        // Try to print the contents of the file AFTER we write
        IOUtil.tryPrintContents(path);

    }

    public static List<String> getContent(){
        List<String> contentToWrite = new ArrayList<>();
        contentToWrite.add("This is a new line!");
        contentToWrite.add("Another ONE!");
        contentToWrite.add("AGAIN!");

        return contentToWrite;
    }
}
