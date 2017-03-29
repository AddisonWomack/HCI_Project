package Model;

/**
 * This class represents a hotel employee that can be made into an administrator
 */
public class Employee extends Person {
    // boolean field represents whether or not the employee is an administrator
    private boolean isAdmin;

    public Employee(String firstName, String lastName, String eMailAddress, String phoneNumber) {
        super(firstName, lastName, eMailAddress, phoneNumber);
        isAdmin = false;
    }

    // modifies administrator field of employee
    public void setAdmin(boolean isAdmin) {
        this.isAdmin = isAdmin;
    }

}
