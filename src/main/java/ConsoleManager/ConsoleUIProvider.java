package ConsoleManager;

import contacts.Contact;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConsoleUIProvider {

    //ToDo: make static
    Input input = new Input();

    Scanner scanner;

    public ConsoleUIProvider() {
        this.scanner = new Scanner(System.in);
        printWelcomeMessage();
    }

    public void printMainMenu() {

        System.out.println(
                "\n" +
                        "1. View contacts.\n" +
                        "2. Add a new contact.\n" +
                        "3. Search a contact by name.\n" +
                        "4. Delete an existing contact.\n" +
                        "5. Sort Contact list by name.(A-Z)\n" +
                        "6. Create Oberon Contact List\n" +
                        "7. Create Hogwarts Contact List\n" +
                        "8. Exit.\n\n" +
                        "Enter an option (1, 2, 3, 4, 5, 6, 7 or 8):");
        String userInput = scanner.nextLine();
        List<Contact> contactsList = input.getContacts();
        switch (userInput) {
            case "1":
                printContacts(contactsList);
                break;
            case "2":
                printAddNewContactMenu(contactsList);
                break;
            case "3":
                printSearchNewContactMenu(contactsList);
                break;
            case "4":
                printDeleteNewContactMenu(contactsList);
                break;
            case "5":
                printSortedContactList(contactsList);
                break;
            case "6":
                createSampleContactList();
                break;
            case "7":
                createHogwartsContactList();
                break;
            case "8":
                printThankYouMessage();
                return;
            default:
                System.out.println("Invalid option");
        }
        printMainMenu();
    }

    private void createHogwartsContactList() {
        List<Contact> sampleContactList = new ArrayList<>();
        sampleContactList.add(new Contact("Albus Dumbledore", "1111110"));
        sampleContactList.add(new Contact("Harry Potter", "7777777"));
        sampleContactList.add(new Contact("Harry James Potter", "7777700"));
        sampleContactList.add(new Contact("Harry Lily Potter", "7777701"));
        sampleContactList.add(new Contact("Hermione Granger", "1111112"));
        sampleContactList.add(new Contact("Ron Weasley", "1111113"));
        sampleContactList.add(new Contact("Rubes Hagrid ", "1111114"));
        sampleContactList.add(new Contact("Draco Malloy", "1111115"));
        sampleContactList.add(new Contact("Lord Voldemort", "1111116"));
        sampleContactList.add(new Contact("Luna Lovegood", "1111117"));
        sampleContactList.add(new Contact("Neville Longbottom", "1111119"));
        input.addSampleContactList(sampleContactList);
        System.out.println("Mischief managed!");
    }

    private void createSampleContactList() {
        List<Contact> sampleContactList = new ArrayList<>();
        sampleContactList.add(new Contact("Prachi Phatak", "1111111111"));
        sampleContactList.add(new Contact("Jesse", "1111111122"));
        sampleContactList.add(new Contact("Jesse S", "1111111123"));
        sampleContactList.add(new Contact("Jesse Sosa", "1111111124"));
        sampleContactList.add(new Contact("Casey Edwards", "1111111113"));
        sampleContactList.add(new Contact("Christopher", "1111111114"));
        sampleContactList.add(new Contact("Laura Ruiz-Roehrs", "1111111110"));
        sampleContactList.add(new Contact("Corey Shaw", "1111111115"));
        sampleContactList.add(new Contact("Diamond Meredith", "1111111116"));
        sampleContactList.add(new Contact("Demetrio Tovar", "1111111117"));
        sampleContactList.add(new Contact("Richard Lara", "1111111118"));
        sampleContactList.add(new Contact("Jordy", "1111111111"));
        sampleContactList.add(new Contact("Tristan", "1111111111"));
        sampleContactList.add(new Contact("Dorian", "1111111111"));
        input.addSampleContactList(sampleContactList);
        System.out.println("Oberon Cohort Created!");
    }

    private void printWelcomeMessage() {
        System.out.println(
                "*******************************************************************************************\n" +
                "--------------------------------- Welcome to ContactZilla ---------------------------------\n" +
                "*******************************************************************************************");
    }

    private void printThankYouMessage() {
        System.out.println(
                "***************************** Thank you for visiting ContactZilla *****************************");
    }

    private void printSortedContactList(List<Contact> contactsList) {
        contactsList.sort(new Contact());
        printContacts(contactsList);
    }

    public void printAddNewContactMenu(List<Contact> contactList) {
        System.out.println("Enter full name: ");
        String fullName = scanner.nextLine();

        System.out.println("Enter phone number: ");
        String phoneNumber = scanner.nextLine();

        Contact contact = new Contact(fullName, phoneNumber);
        if (input.addNewContact(contactList, contact)) {
            System.out.println("Contact added successfully!");
        } else {
            printOverwriteMenu(contact, contactList);

        }
    }

    private void printOverwriteMenu(Contact contact, List<Contact> contactList) {
        System.out.printf("There's already a contact named %s. Do you want to overwrite it? (Yes/No)\n",
                contact.getFullName());
        String overWrite = scanner.nextLine();
        if (overWrite.equalsIgnoreCase("yes")) {
            input.overWriteContact(contactList, contact);
        } else if (overWrite.equalsIgnoreCase("no")) {
            return;
        } else {
            printOverwriteMenu(contact, contactList);
        }
    }

    public void printSearchNewContactMenu(List<Contact> contactsList) {
        System.out.println("Enter full name: ");
        String fullName = scanner.nextLine();

        printContacts(input.searchByName(fullName, contactsList));
    }

    public void printDeleteNewContactMenu(List<Contact> contactsList) {
        System.out.println("Enter full name: ");
        String fullName = scanner.nextLine();

        if (input.deleteByName(fullName, contactsList)) {
            System.out.println("Contact deleted successfully!");
        } else {
            System.out.println("Contact not found!!");
        }
    }

    public static void printContacts(List<Contact> contacts) {
        if (contacts.isEmpty()) {
            System.out.println("No contact found!");
            return;
        }
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
