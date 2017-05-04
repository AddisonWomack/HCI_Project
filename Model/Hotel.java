package Model;

import javax.swing.*;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.HashMap;

/**
 * This class is the primary model that is viewed by the View and edited by the Controller
 * it represents the entirety of the hotel.
 */
public class Hotel {
    private String name;
    private String address;
    private String phoneNumber;
    private HashMap<String,Employee> employees;
    private HashMap<String,Guest> guests;
    private HashMap<GregorianCalendar,ArrayList<Reservation>> reservations;
    private HashMap<String, Room> rooms;
    private int numberOfVacantRooms;
    // A list of the objects that are listening for updates
    private ArrayList<Listener> listeners;
    private Employee currentEmployee;

    // default constructor
    public Hotel() {
        name = null;
        address = null;
        phoneNumber = null;
        employees = new HashMap<>();
        guests = new HashMap<>();
        reservations = new HashMap<>();
        rooms = new HashMap<>();
        listeners = new ArrayList<>();
        numberOfVacantRooms = 0;
        currentEmployee = null;
    }

    // initializer constructor
    public Hotel(String name, String address, String phoneNumber) {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        employees = new HashMap<>();
        guests = new HashMap<>();
        reservations = new HashMap<>();
        rooms = new HashMap<>();
        numberOfVacantRooms = 0;
        listeners = new ArrayList<>();
        currentEmployee = null;
    }

    ///////////////////////////////////
    // Getter methods
    ///////////////////////////////////
    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public int getNumberOfVacantRooms() {
        return numberOfVacantRooms;
    }

    public ArrayList<Room> getRooms() {
        ArrayList<Room> roomList = new ArrayList<>();
        rooms.values().forEach(r -> roomList.add(r));
        return roomList;
    }

    public ArrayList<Employee> getEmployeesList() {
        ArrayList<Employee> employeeList = new ArrayList<>();
        employees.values().forEach(e -> employeeList.add(e));
        return employeeList;
    }

    // returns list of reservations made
    public HashMap<GregorianCalendar, ArrayList<Reservation>> getReservations() {
        return reservations;
    }

    public ArrayList<Reservation> getReservationsByDate(int year, int month, int day) {
    	GregorianCalendar greg = new GregorianCalendar(year, month, day);
    	ArrayList<Reservation> alr = new ArrayList<Reservation>();
    	for (GregorianCalendar gc: reservations.keySet()) {
    		for (Reservation r: reservations.get(gc)) {
    			if ((greg.after(gc) || greg.equals(gc)) && (greg.equals(gc) || greg.before(r.getEnd()))) {
    				alr.add(r);
    			}
    		}
    	}
    	return alr;
    }

    // returns employees
    public HashMap<String,Employee> getEmployees() {
        return employees;
    }

    // returns a specific employee
    public Employee getEmployee(String eMail) {
        return employees.get(eMail);
    }

    // returns guests
    public HashMap<String,Guest> getGuests() {
        return guests;
    }

    // returns a specific guest
    public Guest getGuest(String eMail) {
        return guests.get(eMail);
    }

    // returns the current employee
    public Employee getCurrentEmployee() {
        return  currentEmployee;
    }
    
    // Gets a room based on a string - needed for roomList
    public Room getRoom(String identifier) {
    	String key = "";
    	int index = 0;
    	while(identifier.charAt(index) != ' ') {
    		key = key + identifier.charAt(index);
    		index++;
    	}
    	return rooms.get(key);
    }

    ////////////////////
    // Setter Methods
    ////////////////////

    public void setName(String name) {
        this.name = name;
        notifyListeners();
    }

    public void setAddress(String address) {
        this.address = address;
        notifyListeners();
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        notifyListeners();
    }

    public void login (String eMail, String password) {
        try {
            if (employees.get(eMail).matchPassword(password)) {
                currentEmployee = employees.get(eMail);
                notifyListeners();
            } else {
                System.out.println("password incorrect");
            }
        } catch (Exception e) {
            System.out.println("employee not found");
        }
    }

    public void logout () {
        this.currentEmployee = null;
        notifyListeners();
    }

    public boolean shutDown(String password) {
        if (password.equals("I understand that I am shutting down the hotel")) {
            rooms.clear();
            reservations.clear();
            guests.clear();
            notifyListeners();
            return true;
        } else {
            return false;
        }
    }

    public void reportIssue(String rID, RoomIssue issue, boolean isSevere) {
        getRoom(rID).addProblem(issue,isSevere);
        notifyListeners();
    }

    public void resolveRoomIssues(String rID) {
        Room r = getRoom(rID);
        r.resolveIssue();
        r.openRoom();
        notifyListeners();
    }

    // adds an employee to the hotel
    public void addEmployee(String firstName, String lastName, String eMail, String phoneNumber, String password) {
        Employee employee = new Employee(firstName,lastName,eMail,phoneNumber, password);
        employees.put(eMail,employee);
        notifyListeners();
    }

    // adds a room to the hotel
    public void addRoom(String ID, int floorNumber, RoomLayout layout) {
        Room room = new Room(ID, floorNumber, layout);
        this.rooms.put(ID, room);
        numberOfVacantRooms++;
        notifyListeners();
    }
    
    // adds THIS room to the hotel
    public void addRoom(Room r) {
		this.rooms.put(r.getID(), r);
		numberOfVacantRooms++;
		notifyListeners();
	}

	public void updateEmployee(String originalEmail, String first, String last, String email, String phoneNumber, boolean isAdmin) {
        try {
            Employee old = employees.get(originalEmail);
            Employee temp = new Employee(first,last,email,phoneNumber, old.getPassword());
            temp.setAdmin(isAdmin);
            employees.remove(originalEmail);
            employees.put(email, temp);
            notifyListeners();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,
                    "Unable to edit Employee " + first + " " + last,
                    "Employee Edit Failure", JOptionPane.ERROR_MESSAGE);
        }
    }

	public void fireEmployee(String eMail) {
        try {
            employees.remove(eMail);
            notifyListeners();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,
                    "Unable to Delete Employee " + eMail,
                    "Employee Deletion Failure", JOptionPane.ERROR_MESSAGE);
        }
    }
     
    // removes a room from the hotel
    public void removeRoom(Room r) {
    	if(r.isOpen())
    		numberOfVacantRooms--;
    	rooms.remove(r.getID());
    	notifyListeners();
    }

    // adds a guest to the hotel
    public void addGuest(String firstName, String lastName, String eMail, String phoneNumber) {
        Guest guest = new Guest(firstName, lastName, eMail, phoneNumber);
        guests.put(eMail,guest);
        notifyListeners();
    }

    // adds a reservation to the hotel
    public void addReservation(int startYear, int startMonth, int startDay, int endYear, int endMonth, int endDay,
                               RoomLayout requestedLayout, String guestEMail, String employeeEmail) {

        GregorianCalendar start = new GregorianCalendar(startYear, startMonth, startDay);
        GregorianCalendar end = new GregorianCalendar(endYear, endMonth, endDay);

        Reservation reservation = new Reservation(start, end, requestedLayout,
                guests.get(guestEMail), employees.get(employeeEmail));
        if (reservations.containsKey(start)) { // key/arrayList for start date already exists
            reservations.get(start).add(reservation);
        } else { // key/arrayList for start date does not exist and needs to be created
            ArrayList<Reservation> reservationList = new ArrayList<>();
            reservationList.add(reservation);
            reservations.put(start, reservationList);
        }
        notifyListeners();
    }

    // checks a guest into the hotel
    public void checkInGuest(String guestEMail, String employeeEMail, String roomID) {

        Guest guest = guests.get(guestEMail);
        Employee currentEmployee = employees.get(employeeEMail);

        rooms.get(roomID).checkIn(guest,currentEmployee);
        guest.getReservations().clear();
        notifyListeners();

    }

    // checks a guest out of the hotel
    public void checkOutGuest(String guestEmail, String roomID) {
        Guest guest = guests.get(guestEmail);
        numberOfVacantRooms += guest.getRoomsCheckedIn().size();
        rooms.get(roomID).checkOut();
        guests.remove(guest);
        notifyListeners();
    }

    // Method that adds Listener inheriting objects to the Models Listener list
    public void addListener( final Listener listener )
    {
        listeners.add( listener );
    }

    // Method that instructs all of the listeners within the list of listeners to update
    private void notifyListeners()
    {
        listeners.forEach(l -> l.updated());
    }

}
