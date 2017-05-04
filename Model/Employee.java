package Model;

/**
 * This class represents a hotel employee that can be made into an administrator
 */
public class Employee extends Person {
    // boolean field represents whether or not the employee is an administrator
    private boolean isAdmin;
    private String password;

    public Employee(String firstName, String lastName, String eMailAddress, String phoneNumber, String password) {
        super(firstName, lastName, eMailAddress, phoneNumber);
        isAdmin = false;
        this.password = password;
    }

    // modifies administrator field of employee
    public void setAdmin(boolean isAdmin) {
        this.isAdmin = isAdmin;
    }

    // sets employee password
    public void setPassword(String password) {this.password = password; }

    // determines if password matches
    public boolean matchPassword (String password) {
        return (this.password.equals(password));
    }

    // returns whether or not this employee is an admin
    public boolean isAdmin() {
        return isAdmin;
    }

    // returns employees password
    public String getPassword() {
        return password;
    }
}
