package ConsoleManager;

import contacts.Contact;
import contacts.ContactsUtil;

import java.util.List;

public class Input {

    public List<Contact> getContacts() {
        return ContactsUtil.getContacts();
    }

    public void addNewContact(Contact contact) {
        ContactsUtil.addNewContactToFile(contact);
    }

    public String searchByName(String fullName, List<Contact> contactsList) {
        return ContactsUtil.searchByName(fullName, contactsList);
    }

    public boolean deleteByName(String fullName) {
        return ContactsUtil.deleteByName(fullName);
    }
}
