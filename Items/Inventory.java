package Items;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Inventory {
    List<Item> items = new ArrayList<Item>();
    public Inventory() {}
    public void addItem(Item item) {
        items.add(item);
    }
    public void removeItem(Item item) {
        items.remove(item);
    }
    public Item getItem(String name) {
        for (Item item : items) {
            if (Objects.equals(item.getName(), name)) {
                return item;
            }
        }
        return null;
    }
    public List<Item> getItems() {
        return items;
    }
    public boolean hasItem(Item item){return items.contains(item);}
    //override toString(), hashCode() and equals() methods
    @Override
    public String toString() {
        return "Items.Inventory{" +
                "items=" + items +
                '}';
    }
    @Override
    public int hashCode() {
        return items.hashCode();
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Inventory inventory = (Inventory)o;
        return items.equals(inventory.items);
    }
}
