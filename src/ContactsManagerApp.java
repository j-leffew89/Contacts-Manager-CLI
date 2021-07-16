import contacts.ContactsUtil;
import contactsManagerIO.Input;
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

        Input input = new Input();
        input.showMenu();

    }
}