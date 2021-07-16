package contacts;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

public class ContactsUtil {

    public static List<Contacts> getSampleContacts() {
        List<Contacts> contacts = new ArrayList<>();

        Contacts contact = new Contacts("Jesse Sosa", "1234567890");
        Contacts contact1 = new Contacts("Prachi Phatak", "1234567890");
        contacts.add(contact);
        contacts.add(contact1);
        return contacts;
    }

    public static List<String> getContactAsStringArr() {
        List<Contacts> contactsList = getSampleContacts();
        List<String> contentToWrite = new ArrayList<String>();

        for (Contacts contacts : contactsList) {
            String contactString = contacts.getFullName() +
                    " " + contacts.getPhoneNumber();
            contentToWrite.add(contactString);
        }

        return contentToWrite;
    }

    //addContactToFile
    //editContactToFile
    //deleteContactToFile
    //searchContactToFile

}
