package ConsoleManager;

import contacts.Contact;
import contacts.ContactsUtil;

import java.util.List;

public class Input {

    public List<Contact> getContacts() {
        return ContactsUtil.getContactsFromFile();
    }

    public void addSampleContactList(List<Contact> sampleContactList){
        ContactsUtil.addNewContactToFile(sampleContactList);
    }

    public boolean addNewContact(List<Contact> contactList, Contact newContact) {
        for (Contact contact : contactList) {
            if (newContact.getFullName().equals(contact.getFullName())) {
                return false;
            }
        }
        contactList.add(newContact);
        ContactsUtil.addNewContactToFile(contactList);
        return true;
    }

    public void overWriteContact(List<Contact> contactList, Contact contact) {
        if (ContactsUtil.deleteByNameFromFile(contact.getFullName(), contactList)) {
            ContactsUtil.addNewContactToFile(contactList, contact);
        }
    }

    public List<Contact> searchByName(String fullName, List<Contact> contactsList) {
        return ContactsUtil.searchByName(fullName, contactsList);
    }

    public boolean deleteByName(String fullName, List<Contact> contactsList) {
        return ContactsUtil.deleteByNameFromFile(fullName, contactsList);
    }
}
