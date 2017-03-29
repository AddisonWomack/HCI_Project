package Model;

import java.util.ArrayList;

/**
 * This class represents a Guest that is staying at the hotel
 */
public class Guest extends Person {

    private ArrayList<Room> checkedIn;
    private ArrayList<Reservation> reservations;

    public Guest(String firstName, String lastName, String eMailAddress, String phoneNumber){
        super(firstName, lastName, eMailAddress, phoneNumber);
        checkedIn = new ArrayList<>();
        reservations = new ArrayList<>();
    }

    // adds a room to this Guest's checkedIn rooms
    public void addRoom(Room r) {
        checkedIn.add(r);
    }

    // adds a reservation to this Guest's reservations
    public void addReservation(Reservation r) {
        reservations.add(r);
    }

    // clears the Guest's two ArrayLists
    public void clearRoom(Room r) {
        checkedIn.clear();
        reservations.clear();
    }

    public ArrayList<Reservation> getReservations() {
        return reservations;
    }
    
    public ArrayList<Room> getRoomsCheckedIn() {
        return checkedIn;
    }
}
