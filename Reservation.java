package Model;

import java.util.ArrayList;

/**
 * Created by Addison on 3/24/2017.
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
