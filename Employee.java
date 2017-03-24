package Model;

/**
 * Created by Addison on 3/24/2017.
 */
public class Employee extends Person {
    private boolean isAdmin;

    public Employee(String firstName, String lastName, String eMailAddress, String phoneNumber) {
        super(firstName, lastName, eMailAddress, phoneNumber);
        isAdmin = false;
    }
}
