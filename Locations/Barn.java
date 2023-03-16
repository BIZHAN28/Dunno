package Locations;

import Items.Inventory;

public class Barn extends Location{
    private Inventory inventory;
    public Barn(String name, Inventory inventory) {
        super(name);
        this.inventory = inventory;
    }

}
