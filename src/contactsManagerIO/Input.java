package contactsManagerIO;

import contacts.Contacts;
import contacts.ContactsUtil;
import fileIO.FileDirectoryUtil;
import fileIO.IOUtil;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Input {
    Scanner scanner;

    public Input() {
        this.scanner = new Scanner(System.in);
    }
    //showMainMenu

    public void showMenu() {
        System.out.println(
                "1. View contacts.\n" +
                        "2. Add a new contact.\n" +
                        "3. Search a contact by name.\n" +
                        "4. Delete an existing contact.\n" +
                        "5. Exit.\n" +
                        "Enter an option (1, 2, 3, 4 or 5):");
        String userInput = scanner.nextLine();

        switch (userInput) {
            case "1":
                ContactsUtil.printContacts(ContactsUtil.viewContacts());
                break;
            case "2":
                addNewContact();
                break;
            case "3":
                searchByName();
                break;
            case "4":
                deleteByName();
                break;
            case "5":
                return;
            default:
                System.out.println("Invalid option");
        }
        showMenu();
    }

    //create New contact
    public void addNewContact() {
        System.out.println("Enter full name: ");
        String fullName = scanner.nextLine();

        System.out.println("Enter phone number: ");
        String phoneNumber = scanner.nextLine();

        ContactsUtil.addNewContactToFile(fullName, phoneNumber);
    }

    //Search
    public void searchByName() {
        System.out.println("Enter full name: ");
        String fullName = scanner.nextLine();

        System.out.println(ContactsUtil.searchByName(fullName));
    }


    //Delete
    public void deleteByName() {
        System.out.println("Enter full name: ");
        String fullName = scanner.nextLine();

        System.out.println(ContactsUtil.deleteByName(fullName));
    }
}
