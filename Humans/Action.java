package Humans;

import Items.Dish;
import Items.Table;
import Locations.Location;

public interface Action {
    public void goTo(Location location);
    public void eat(Dish dish);
    public void sit(Table table);


}
