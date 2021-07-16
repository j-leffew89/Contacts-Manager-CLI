package contactsManagerIO;

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

    public void showMenu(){
        System.out.println(
                "1. View contacts.\n" +
                "2. Add a new contact.\n" +
                "3. Search a contact by name.\n" +
                "4. Delete an existing contact.\n" +
                "5. Exit.\n" +
                "Enter an option (1, 2, 3, 4 or 5):");
        String userInput = scanner.nextLine();

        switch (userInput){
            case "1":
                Path path = FileDirectoryUtil.getPath("src", "database");
                path = Paths.get(path.toString(), "Contacts.txt");
                IOUtil.tryPrintContents(path);
                showMenu();
                break;
            case "2":
                //Create directory
                Path path1 = FileDirectoryUtil.getPath("src", "database");
                FileDirectoryUtil.tryCreateDirectory(path1);

                //create file
                path1 = Paths.get(path1.toString(), "Contacts.txt");
                FileDirectoryUtil.tryCreateFile(path1);

                IOUtil.tryWriteToFile(ContactsUtil.getContactAsStringArr(), path1);
                IOUtil.tryPrintContents(path1);
                showMenu();
                break;
            case "5":
                return;
            default:
                System.out.println("Invalid option");
                showMenu();
        }

    }

    //create New contact



    //Search






    //Delete

}
