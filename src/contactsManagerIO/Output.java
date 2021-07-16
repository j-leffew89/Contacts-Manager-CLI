package contactsManagerIO;

import java.util.List;

public class Output {

    public void printContacts(List<String> contacts){

        for (String contact : contacts) {
            System.out.println(contact);
        }

    }

}
