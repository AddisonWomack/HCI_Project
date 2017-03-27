package src.Model;

import java.util.ArrayList;

/**
 * Created by Addison on 3/24/2017.
   Filled in by Peter on 3/25/17
       -added variables laid out in UML diagram
       -added getters and setters where appropriate
 */
public class Room {
    private Guest guest;
    private Employee checkedInBy;
    private String roomNumber;
    private int floorNumber;
    private RoomLayout roomLayout;
    //private List<Amenities> amenityList;
    private ArrayList<RoomIssue> problemHistory;
    //private RoomStatus status;
    
    /*
        id is name of the room, (eg. 201A, 304B, etc)
        
    */
    public Room(String id, int floor, RoomLayout rl) {
        guest = null;
        checkedInBy = null;
        roomNumber = id;
        floorNumber = floor;
        roomLayout = rl;
        //amenityList = new ArrayList<Amenities>();
        problemHistory = new ArrayList<RoomIssue>();
        //status = RoomStatus.CLOSED;
    }
    
    public void changeName(String id, int floor) {
        roomNumber = id;
        floorNumber = floor;
    }

    /*
    public void addAmenity(Amenity a) {
        amenityList.add(a);
    }
    
    public List<Amenities> getAmenities() {
        return amenityList;
    }

    */

    public void addProblem(RoomIssue ri, boolean isSevere) {
        problemHistory.add(ri);
        //if(isSevere)
            //status = RoomStatus.CLOSED;
    }
    
    public void setLayout(RoomLayout rl) {
        roomLayout = rl;
    }
    
    public RoomLayout getLayout() {
        return roomLayout;
    }
    
    public void openRoom() {
        //status = RoomStatus.OPEN;
    }
    
    public void checkOut(Guest g, Employee e) {
        guest = g;
        checkedInBy = e;
        //status = RoomStatus.OCCUPIED; //is this the right syntax?
    }
    
    public void checkIn() {
        guest = null;
        checkedInBy = null;
        //status = RoomStatus.OPEN;
    }
}
