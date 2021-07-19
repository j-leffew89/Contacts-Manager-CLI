package ConsoleManager;

import contacts.Contact;

import java.util.List;
import java.util.Scanner;

public class ConsoleUIProvider {

    //ToDo: make static
    Input input = new Input();

    Scanner scanner;

    public ConsoleUIProvider() {
        this.scanner = new Scanner(System.in);
    }

    public void printMainMenu() {
        System.out.println(
                "1. View contacts.\n" +
                        "2. Add a new contact.\n" +
                        "3. Search a contact by name.\n" +
                        "4. Delete an existing contact.\n" +
                        "5. Sort Contact list by name.(A-Z)\n" +
                        "6. Exit.\n" +
                        "Enter an option (1, 2, 3, 4, 5 or 6):");
        String userInput = scanner.nextLine();
        List<Contact> contactsList = input.getContacts();
        switch (userInput) {
            case "1":
                printContacts(contactsList);
                break;
            case "2":
                printAddNewContactMenu(contactsList);
                System.out.println(contactsList);
                break;
            case "3":
                printSearchNewContactMenu(contactsList);
                break;
            case "4":
                printDeleteNewContactMenu();
                break;
            case "5":
                printSortedContactList(contactsList);
                break;
            case "6":
                return;
            default:
                System.out.println("Invalid option");
        }
        printMainMenu();
    }

    private void printSortedContactList(List<Contact> contactsList) {
        contactsList.sort(new Contact());
        printContacts(contactsList);
    }

    public void printAddNewContactMenu(List<Contact> contactsList) {
        System.out.println("Enter full name: ");
        String fullName = scanner.nextLine();

        System.out.println("Enter phone number: ");
        String phoneNumber = scanner.nextLine();

        Contact contact = new Contact(fullName, phoneNumber);
        contactsList.add(contact);
        input.addNewContact(contact);
    }

    public void printSearchNewContactMenu(List<Contact> contactsList) {
        System.out.println("Enter full name: ");
        String fullName = scanner.nextLine();

        System.out.println(input.searchByName(fullName, contactsList));
    }

    public void printDeleteNewContactMenu() {
        System.out.println("Enter full name: ");
        String fullName = scanner.nextLine();

        if (input.deleteByName(fullName)) {
            System.out.println("Contact deleted successfully!");
        }
        System.out.println(input.deleteByName(fullName));

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
        if (trimmedPhoneNumber.length() == 7) {
            return trimmedPhoneNumber.substring(0, 3) + "-" + trimmedPhoneNumber.substring(3, 7);
        } else {
            return trimmedPhoneNumber.substring(0, 3) + "-" + trimmedPhoneNumber.substring(3, 6) + "-"
                    + trimmedPhoneNumber.substring(6);
        }
    }

}
