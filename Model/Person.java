package Model;

/**
 * This abstract class provides basic functionality for both the Guest and Employee classes
 */
public abstract class Person {
    protected String firstName;
    protected String lastName;
    protected String eMailAddress;
    protected String phoneNumber;

    public Person(String firstName, String lastName, String eMailAddress, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.eMailAddress = eMailAddress;
    }

    // Getter methods

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }

    public String getEMailAddress() {
        return eMailAddress;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    // Setter methods

    public void setEMailAddress(String eMailAddress) {
        this.eMailAddress = eMailAddress;
    }

    public void setFirstName(String firstName) {this.firstName = firstName; }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

}
