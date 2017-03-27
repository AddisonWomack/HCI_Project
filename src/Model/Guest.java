package src.Model;

import java.util.ArrayList;

/**
 * Created by Addison on 3/24/2017.
   Filled in a bit by Peter on 3/26/17
 */
public class Guest extends Person {

    /* To Do:
     * List of Reservations reservations
     * List of Rooms checkedInRooms */
    private ArrayList<Room> checkedIn;
    private ArrayList<Reservation> history;

    public Guest(String firstName, String lastName, String eMailAddress, String phoneNumber){
        super(firstName, lastName, eMailAddress, phoneNumber);
        checkedIn = new ArrayList<Room>();
        history = new ArrayList<Reservation>();
    }
    
    public void addRoom(Room r) {
        checkedIn.add(r);
    }
    
    public void addReservation(Reservation r) {
        history.add(r);
    }
    
    public void clearRoom(Room r) {
        checkedIn.clear();
        history.clear();
    }
    
    public ArrayList<Reservation> getHistory() {
        return history;
    }
    
    public ArrayList<Room> getRoomsCheckedIn() {
        return checkedIn;
    }
}
