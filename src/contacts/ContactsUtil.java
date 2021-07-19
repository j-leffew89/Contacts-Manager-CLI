package contacts;

import fileIO.FileDirectoryUtil;
import fileIO.IOUtil;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ContactsUtil {

    public static List<Contact> getContacts() {
        Path path = Paths.get("src", "database", "Contacts.txt");
        List<String> content = IOUtil.tryReadFromFile(path);
        List<Contact> contacts = new ArrayList<>();
        assert content != null;
        for (String s : content) {
            if (!s.isEmpty()) {
                String[] arr = s.split(":");
                Contact contact = new Contact(arr[0], arr[1]);
                contacts.add(contact);
            }
        }
        return contacts;
    }

    public static void addNewContactToFile(Contact contact) {
        //create directory
        Path path = FileDirectoryUtil.getPath("src", "database");
        FileDirectoryUtil.tryCreateDirectory(path);

        //create file
        path = Paths.get(path.toString(), "Contacts.txt");
        FileDirectoryUtil.tryCreateFile(path);

        IOUtil.tryAppendToFile(contact.toString(), path);
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

    public static String searchByName(String fullName, List<Contact> contactsList) {
        for (String s : convertContactListToStringList(contactsList)) {
            if (s.contains(fullName)) {
                return s;
            }
        }
        return null;
    }

    public static boolean deleteByName(String fullName) {
        Path path = Paths.get("src", "database", "Contacts.txt");
        List<String> content = IOUtil.tryReadFromFile(path);
        assert content != null;
        for (String s : content) {
            if (s.contains(fullName)) {
                content.remove(s);
                addContactsToFile(content);
                return true;
            }
        }
        return false;
    }

    public static List<String> convertContactListToStringList(List<Contact> contacts) {
        List<String> contactList = new ArrayList<>();
        for (Contact contact : contacts) {
            contactList.add(contact.toString());
        }
        return contactList;
    }

}
