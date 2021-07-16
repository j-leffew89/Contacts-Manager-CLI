package contacts;

import fileIO.FileDirectoryUtil;
import fileIO.IOUtil;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ContactsUtil {

    public static void viewContacts() {
        Path path = FileDirectoryUtil.getPath("src", "database");
        path = Paths.get(path.toString(), "Contacts.txt");
        IOUtil.tryPrintContents(path);
    }

    public static void addNewContactToFile(String fullName, String phoneNumber) {
        List<String> contacts = new ArrayList<>();
        String contact = fullName + " " + phoneNumber;
        contacts.add(contact);

        //create directory
        Path path = FileDirectoryUtil.getPath("src", "database");
        FileDirectoryUtil.tryCreateDirectory(path);

        //create file
        path = Paths.get(path.toString(), "Contacts.txt");
        FileDirectoryUtil.tryCreateFile(path);

        IOUtil.tryAppendToFile(contacts, path);
        IOUtil.tryPrintContents(path);
    }

    public static void addContactsToFile(List<String> contacts) {
        //create directory
        Path path = FileDirectoryUtil.getPath("src", "database");
        FileDirectoryUtil.tryCreateDirectory(path);

        //create file
        path = Paths.get(path.toString(), "Contacts.txt");
        FileDirectoryUtil.tryCreateFile(path);

        IOUtil.tryWriteToFile(contacts, path);
        IOUtil.tryPrintContents(path);
    }

    public static String searchByName(String fullName) {
        Path path = Paths.get("src", "database", "Contacts.txt");
        List<String> content = IOUtil.tryReadFromFile(path);
        for (String s : content) {
            if (s.contains(fullName)) {
                return s;
            }
        }
        return "WIP";
    }

    public static boolean deleteByName(String fullName) {
        Path path = Paths.get("src", "database", "Contacts.txt");
        List<String> content = IOUtil.tryReadFromFile(path);
        for (String s : content) {
            if (s.contains(fullName)) {
                content.remove(s);
                addContactsToFile(content);
                return true;
            }
        }
        return false;
    }


    //addContactToFile
    //editContactToFile
    //deleteContactToFile
    //searchContactToFile

}
