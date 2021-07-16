package contacts;

import fileIO.FileDirectoryUtil;
import fileIO.IOUtil;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ContactsUtil {

    public static List<Contact> viewContacts() {
        Path path = Paths.get("src", "database", "Contacts.txt");
        List<String> content = IOUtil.tryReadFromFile(path);
        List<Contact> contacts = new ArrayList<>();
        for (String s : content) {
            if (!s.isEmpty()) {
                String[] arr = s.split(":");
                Contact contact = new Contact(arr[0], arr[1]);
                contacts.add(contact);
            }
        }
        return contacts;
    }

    public static void addNewContactToFile(String fullName, String phoneNumber) {
        List<String> contacts = new ArrayList<>();
        String contact = fullName + " : " + phoneNumber;
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

    public static void printContacts(List<Contact> contacts) {
        System.out.println(addPadding("Name")
                + addPadding("Phone Number"));
        System.out.println("-".repeat(57));
        for (Contact contact : contacts) {
            System.out.println(addPadding(contact.getFullName())
                    + addPadding(formatPhoneNumber(contact.getPhoneNumber())));
        }
    }

    private static String addPadding(String word) {
        int givenLength = 20;
        String paddedWord = "";
        if (word.length() < givenLength) {
            int length = givenLength - word.length();
            paddedWord = " ".repeat(5) + word;
            paddedWord = paddedWord + " ".repeat(length);
            paddedWord = paddedWord + "|";
            paddedWord = paddedWord + " ".repeat(5);
        }
        return paddedWord;
    }

    private static String formatPhoneNumber(String phoneNumber) {
        String trimmedPhoneNumber = phoneNumber.trim();
        String formattedPhoneNumber = "";
        if (trimmedPhoneNumber.length() == 7) {
            formattedPhoneNumber = trimmedPhoneNumber.substring(0, 3) + "-" + trimmedPhoneNumber.substring(3, 7);
        }else{
            formattedPhoneNumber = trimmedPhoneNumber.substring(0, 3) + "-" + trimmedPhoneNumber.substring(3, 6) + "-"
                    + trimmedPhoneNumber.substring(8);
        }
        return formattedPhoneNumber;
    }

}
