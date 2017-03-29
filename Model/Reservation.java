package Model;

import java.util.GregorianCalendar;

/**
 * This class represents a reservation made by a future hotel guest
 */
public class Reservation {
    private Guest reservee;
    private GregorianCalendar start;
    private GregorianCalendar end;
    private RoomLayout requestedLayout;
    private Employee completedBy;
    
    public Reservation(GregorianCalendar start, GregorianCalendar end, RoomLayout requestedLayout,
                       Guest guest, Employee employee) {
        this.start = start;
        this.end = end;
        reservee = guest;
        completedBy = employee;
        this.requestedLayout = requestedLayout;
    }
    
    public GregorianCalendar getStart() {
        return start;
    }
    
    public GregorianCalendar getEnd() {
        return end;
    }
    
    public RoomLayout getRequestedLayout() {
        return requestedLayout;
    }
    
    public Guest getGuest() {
        return reservee;
    }
    
    public Employee getEmployee() {
        return completedBy;
    }
    
    public void changeDates(GregorianCalendar s, GregorianCalendar e) {
        start = s;
        end = e;
    }
    
    public void setRequestedLayout(RoomLayout requestedLayout) {
        this.requestedLayout = requestedLayout;
    }
}
