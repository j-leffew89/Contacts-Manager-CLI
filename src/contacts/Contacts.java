package contacts;

import java.util.Objects;

public class Contacts {

    private Person person;
    private String phoneNumber;

    public Contacts(Person person, String phoneNumber) {
        this.person = person;
        this.phoneNumber = phoneNumber;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contacts contacts = (Contacts) o;
        return Objects.equals(person, contacts.person) && Objects.equals(phoneNumber, contacts.phoneNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(person, phoneNumber);
    }
}
