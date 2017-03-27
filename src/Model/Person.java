package src.Model;

/**
 * Created by Addison on 3/24/2017.
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

    public void setEMailAddress(String eMailAddress) {
        this.eMailAddress = eMailAddress;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

}
