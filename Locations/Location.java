package Locations;

import Items.Inventory;
import Items.Item;

import java.util.Objects;

public abstract class Location {
    public String name;
    private Inventory inventory;
    public Location(String name) {
        this.name = name;
        this.inventory = new Inventory();
    }
    public void inventoryRemoveItem(Item item){
        inventory.removeItem(item);
    }
    public void inventoryAddItem(Item item){
        inventory.addItem(item);
    }
    public String getName() {
        return name;
    }
    //override toString, equals and hashCode methods
    @Override
    public String toString() {
        return name;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Location location = (Location)o;
        return Objects.equals(name, location.name);
    }
    @Override
    public int hashCode() {
        return name.hashCode();
    }
}