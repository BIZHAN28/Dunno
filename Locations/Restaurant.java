package Locations;

import Items.Inventory;

import java.util.HashMap;
import java.util.Map;

public class Restaurant extends Location {
    // Rooms List
    private final Map<String, Room> rooms = new HashMap<>();
    private final Inventory inventory;
    public Restaurant(String name, Inventory inventory) {
        super(name);
        this.inventory = inventory;
    }
    public void addRoom(Room room) {
        rooms.put(room.getName(),room);
    }
    public void removeRoom(Room room) {
        rooms.remove(room.getName());
    }
    public Room getRoom(String name) {
        return rooms.get(name);
    }
}
