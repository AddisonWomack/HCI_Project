package Model;

import java.util.ArrayList;

/**
 * Created by Addison on 3/24/2017.
   Mostly built by Peter on 3/25/2017
        -functionality changed slightly
          -no longer worried about cost/requests
          -should be just about when the room is reserved and what room is reserved
          -that way, the hotel can update what rooms are taken by checking the reservation list
 */
public class Reservation {
    private Guest reservee;
    private Date start;
    private Date end;
    private Room reserved;
    private Employee completedBy;
    
    public Reservation(Date s, Date e, Room r, Guest g, Employee e) {
        start = s;
        end = e;
        reservee = g;
        completedBy = e;
        reserved = r;
    }
    
    public Date getStart() {
        return start;
    }
    
    public Date getEnd() {
        return end;
    }
    
    public Room getRoom() {
        return reserved;
    }
    
    public Guest getGuest() {
        return reservee;
    }
    
    public Employee getEmployee() {
        return completedBy;
    }
    
    public void changeDates(Date s, Date e) {
        start = s;
        end = e;
    }
    
    public void changeRoom(Room r) {
        reserved = r;
    }
}
