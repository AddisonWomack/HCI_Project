import Model.Hotel;
import Model.RoomLayout;
import View.*;

/**
 * This class contains the main method, which launches the hotel management system
 */
public class Driver {
    public static void main(String[] args) {
        Hotel model = new Hotel("Raptor Resort Hotel", "1000 Sridhar Street", "1234567890");

        model.addGuest("Jamie", "Ferguson", "Piptendo@ou.edu", "0987654321");

        model.addEmployee("Addison", "Womack", "addison.womack@ou.edu",
                "4054965830", "password");

        model.addRoom("100", 1, RoomLayout.EXECUTIVESUITE);
        model.addRoom("101", 1, RoomLayout.BARGAINSUITE);
        model.addRoom("102", 1, RoomLayout.BARGAINSUITE);
        model.addRoom("103", 1, RoomLayout.STANDARDSUITE);
        model.addRoom("104", 1, RoomLayout.FAMILYSUITE);
        model.addRoom("105", 1, RoomLayout.JUNIORSUITE);
        model.addRoom("106", 1, RoomLayout.STANDARDSUITE);
        model.addRoom("107", 1, RoomLayout.STANDARDSUITE);
        model.addRoom("108", 1, RoomLayout.JUNIORSUITE);
        model.addRoom("109", 1, RoomLayout.FAMILYSUITE);
        model.addRoom("200", 2, RoomLayout.EXECUTIVESUITE);
        model.addRoom("201", 2, RoomLayout.EXECUTIVESUITE);
        model.addRoom("202", 2, RoomLayout.EXECUTIVESUITE);
        model.addRoom("203", 2, RoomLayout.EXECUTIVESUITE);
        model.addRoom("204", 2, RoomLayout.EXECUTIVESUITE);
        model.addRoom("205", 2, RoomLayout.EXECUTIVESUITE);
        model.addRoom("206", 2, RoomLayout.EXECUTIVESUITE);
        model.addRoom("207", 2, RoomLayout.EXECUTIVESUITE);
        model.addRoom("208", 2, RoomLayout.EXECUTIVESUITE);
        model.addRoom("209", 2, RoomLayout.EXECUTIVESUITE);



        model.addReservation(2014,3,14, 2014,3,17,
                RoomLayout.EXECUTIVESUITE,"Piptendo@ou.edu","addison.womack@ou.edu");

        model.checkInGuest("Piptendo@ou.edu","addison.womack@ou.edu","100");

        model.checkOutGuest("Piptendo@ou.edu","100");

        model.getEmployee("addison.womack@ou.edu").setAdmin(true);

        HotelFrame view = new HotelFrame(model);

        view.setVisible(true);

    }
}
