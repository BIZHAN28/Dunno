package Professions;

import Humans.Human;
import Items.Item;
import Items.Wallet;
import Locations.Location;

public class Deliveryman extends Profession{
    public Deliveryman(Wallet wallet) {
        super(ProfessionsTypes.DELIVERYMAN, wallet);
    }
    void deliver(Item item, Location fromLoc, Location toLoc){
        fromLoc.inventoryRemoveItem(item);
        toLoc.inventoryAddItem(item);
    }
    void deliver(Item item, Location fromLoc, Human toHuman){
        fromLoc.inventoryRemoveItem(item);
        toHuman.receiveItem(item);
    }
}
