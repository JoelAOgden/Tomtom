package dungeon.loader.primitives;

public class RoomPrimitive {

    public final String roomName;
    public final String northDoor;
    public final String eastDoor;
    public final String southDoor;
    public final String westDoor;

    public RoomPrimitive(String roomName, String northDoor, String eastDoor, String southDoor, String westDoor) {
        this.roomName = roomName;
        this.northDoor = northDoor;
        this.eastDoor = eastDoor;
        this.southDoor = southDoor;
        this.westDoor = westDoor;
    }

}
