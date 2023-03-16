package Locations;

import Items.Inventory;
import Items.Item;

public class Room {
    private String name;
    private int length;
    private int width;
    private Inventory inventory;
    public Room(String name, int length, int width, Inventory inventory) {
        this.name = name;
        this.length = length;
        this.width = width;
        this.inventory = inventory;
    }
    public void setLength(int length){
        this.length = length;
    }
    public int getLength(){
        return length;
    }
    public void setWidth(int width){
        this.width = width;
    }
    public int getWidth(){
        return width;
    }
    public void inventoryAddItem(Item item){
        inventory.addItem(item);
    }
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Locations.Room{" +
                "name=" + name +
                "length=" + length +
                ", width=" + width +
                ", inventory=" + inventory +
                '}';
    }
    @Override
    public int hashCode() {
        return name.hashCode() + length + width + inventory.hashCode();
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Room room = (Room)o;
        return name.equals(room.name) &&
                length == room.length &&
                width == room.width &&
                inventory.equals(room.inventory);
    }

}
