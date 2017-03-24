package Model;

/**
 * Created by Addison on 3/24/2017.
 */
public enum RoomLayout {
    BARGAINSUITE ((byte)002),
    FAMILYSUITE ((byte)016),
    JUNIORSUITE ((byte)012),
    STANDARDSUITE ((byte)024),
    EXECUTIVESUITE ((byte)124);

    // single 8 bit integer that stores all data about the room layout
    // 100's place = hot tub in room (1: Yes, 2: No)
    // 10's place = wifi-quality  (0: None, 1: Standard, 2: Excellent)
    // 1's place = suggested maximum room occupancy
    private byte roomData;

    RoomLayout(byte roomData) {
        this.roomData = roomData;
    }

    public boolean hasHotTub() {
        return roomData >= 100;
    }

    public boolean hasWifi() {
        return (roomData % 100) >= 10;
    }

    public boolean hasExcellentWifi() {
        return (roomData % 100) >= 20;
    }

    public int getMaximumRoomOccupancy() {
        return (roomData % 10);
    }

}
