package contactsManagerIO;

import java.util.List;

public class Output {
// TODO: Change list of string to list of contacts
    public void printContacts(List<String> contacts){

        for (String contact : contacts) {
            System.out.println(contact);
        }

    }

}
