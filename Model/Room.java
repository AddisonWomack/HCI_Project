package Model;

import java.util.ArrayList;
import java.util.Date;

/**
 * This class represents an individual Room within the hotel.
 */
public class Room {
    private Guest guest;
    private Employee checkedInBy;
    private String roomNumber;
    private int floorNumber;
    private RoomLayout roomLayout;
    private ArrayList<Amenity> amenityList;
    private ArrayList<RoomIssue> problemHistory;
    private RoomStatus status;
    
    /*
        id is name of the room, (eg. 201A, 304B, etc)
        
    */
    public Room(String id, int floor, RoomLayout rl) {
        guest = null;
        checkedInBy = null;
        roomNumber = id;
        floorNumber = floor;
        roomLayout = rl;
        amenityList = new ArrayList<Amenity>();
        problemHistory = new ArrayList<RoomIssue>();
        status = RoomStatus.OPEN;
    }
    
    public void setID(String id) {
    	roomNumber = id;
    }
    
    public String getID() {
    	return roomNumber;
    }
    
    public void setFloor(int floor) {
    	floorNumber = floor;
    }
    
    public int getFloor() {
    	return floorNumber;
    }

    public void addAmenity(Amenity a) {
        amenityList.add(a);
    }
    
    public ArrayList<Amenity> getAmenities() {
        return amenityList;
    }

    // adds a Room Issue to this rooms history and potentially closes the room for Maintenance
    public void addProblem(RoomIssue ri, boolean isSevere) {
        problemHistory.add(ri);
        if(isSevere)
            status = RoomStatus.MAINTENANCE;
    }
    
    public void resolveIssue() {
    	for(RoomIssue ri : problemHistory) {
    		if (ri.isOngoing)
    			ri.isOngoing = false;
    		ri.resolve(new Date());
    	}
    	if (problemHistory.isEmpty()) status = RoomStatus.OPEN;
    }
    
    public void setLayout(RoomLayout rl) {
        roomLayout = rl;
    }

    // extra details about Room can be found within the layout class
    public RoomLayout getLayout() {
        return roomLayout;
    }
    
    public ArrayList<RoomIssue> getIssues(){
    	return problemHistory;
    }
    
    public boolean isOpen() {
    	return status == RoomStatus.OPEN;
    }
    
    public void openRoom() {
        status = RoomStatus.OPEN;
    }

    // checks this room's guest out of it
    public void checkOut() {
        guest.clearRoom(this);
        guest = null;
        checkedInBy = null;
        if (status != RoomStatus.MAINTENANCE) status = RoomStatus.OPEN;
    }
    
    public boolean checkIn(Guest g, Employee e) {
        if (status == RoomStatus.OPEN) {
            guest = g;
            checkedInBy = e;
            status = RoomStatus.OCCUPIED;
            return true;
        } else {
            return false;
        }
    }
    
    public String toString() {
        String s = "OPEN";
        if(status == RoomStatus.MAINTENANCE)
            s = "MAINTENANCE";
        else if(status == RoomStatus.OCCUPIED)
            s = "OCCUPIED";
        return roomNumber + "    " + s + "    " + "Capacity: " + roomLayout.getMaximumRoomOccupancy();
    }
}
