package contacts;

import java.util.Comparator;
import java.util.Objects;

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

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String toString(){
        return fullName + ":" + phoneNumber;
    }

    @Override
    public int compare(Contact c1, Contact c2) {
        return c1.getFullName().compareToIgnoreCase(c2.getFullName());
    }
}
