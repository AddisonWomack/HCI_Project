package Model;

/**
 * Created by Addison on 3/24/2017.
   Filled in a bit by Peter on 3/26/17
 */
public class Guest extends Person {

    /* To Do:
     * List of Reservations reservations
     * List of Rooms checkedInRooms */
    private List<Room> checkedIn;
    private List<Reservation> history;

    public Guest(String firstName, String lastName, String eMailAddress, String phoneNumber){
        super(firstName, lastName, eMailAddress, phoneNumber);
        checkedIn = new List<Room>();
        history = new List<Reservation>();
    }
    
    public void addRoom(Room r) {
        checkedIn.add(r);
    }
    
    public void addReservation(Reservation r) {
        history.add(r);
    }
    
    public void clearRoom(Room r) {
        remove(Room r); //does this work? needs help
    }
    
    public List<Reservation> getHistory() {
        return history;
    }
    
    public List<Room> getRoomsCheckedIn() {
        return checkedIn;
    }
}
