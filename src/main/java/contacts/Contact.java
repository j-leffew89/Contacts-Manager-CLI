package contacts;

import java.util.Comparator;

public class Contact implements Comparator<Contact> {

    private String fullName;
    private String phoneNumber;

    public Contact(String fullName, String phoneNumber) {
        this.fullName = fullName;
        this.phoneNumber = phoneNumber;
    }

    public Contact() {
    }

    public String getFullName() {
        return fullName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String toString() {
        return fullName + ":" + phoneNumber;
    }

    @Override
    public int compare(Contact c1, Contact c2) {
        return c1.getFullName().compareToIgnoreCase(c2.getFullName());
    }
}
