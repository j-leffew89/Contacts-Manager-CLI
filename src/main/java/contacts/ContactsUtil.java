package contacts;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import fileIO.FileDirectoryUtil;
import fileIO.IOUtil;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ContactsUtil {

    static final String PATH = "src/main/java/database";
    static final String FILENAME = "Contacts.json";
    static final String FULLPATH = "src/main/java/database/Contacts.json";

    public static List<Contact> getContactsFromFile() {
        Path path = Paths.get(FULLPATH);
        List<String> content = IOUtil.tryReadFromFile(path);
        List<Contact> contacts = new ArrayList<>();

        assert content != null;
        if (!content.isEmpty()) {
            contacts = new Gson().fromJson(content.get(0), new TypeToken<List<Contact>>() {
            }.getType());
        }

        return contacts;
    }

    public static void addNewContactToFile(List<Contact> contactList) {
        //create directory
        Path path = FileDirectoryUtil.getPath(PATH);
        FileDirectoryUtil.tryCreateDirectory(path);

        //create file
        path = Paths.get(path.toString(), FILENAME);
        FileDirectoryUtil.tryCreateFile(path);

        List<String> contactStringList = new ArrayList<>();
        String contactString = new Gson().toJson(contactList);
        contactStringList.add(contactString);
        IOUtil.tryWriteToFile(contactStringList, path);
    }

    public static void addNewContactToFile(List<Contact> contactList, Contact newContact) {
        contactList.add(newContact);
        addNewContactToFile(contactList);
    }

    public static List<Contact> searchByName(String fullName, List<Contact> contactsList) {
        List<Contact> searchList = new ArrayList<>();
        for (Contact contact : contactsList) {
            if (contact.getFullName().toLowerCase().contains(fullName.toLowerCase())) {
                searchList.add(contact);
            }
        }
        return searchList;
    }

    public static boolean deleteByNameFromFile(String fullName, List<Contact> contactsList) {
        if (contactsList.removeIf(contact -> contact.getFullName().equals(fullName))) {
            addNewContactToFile(contactsList);
            return true;
        } else {
            return false;
        }
    }
}
