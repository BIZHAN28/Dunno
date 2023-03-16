package Humans;

import Items.Item;
import Items.Wallet;
import Locations.Location;
import Professions.Waiter;

import java.util.List;

public interface Speakable {
    public void demand(String thing, Human human);
    public void discussLocation(Location location, List<Human> humans);
    public void tell(String words, List<Human> humans);
    public void negotiate(String words, Human human);
}
