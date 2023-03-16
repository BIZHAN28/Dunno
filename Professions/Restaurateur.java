package Professions;

import Items.Furniture;
import Items.Wallet;
import Locations.Restaurant;
import Locations.Room;

public class Restaurateur extends Profession {
    private Restaurant restaurant;
    public Restaurateur(Wallet wallet) {
        super(ProfessionsTypes.RESTAURATEUR, wallet);
    }
    public void setRestaurant(Restaurant restaurant){
        this.restaurant = restaurant;
    }
    public void order(String something){
        System.out.println("хозяйка велела " + something);
    }
    public void addRoom(Room room){
        restaurant.addRoom(room);
        System.out.println("хозяйка добавила " + room.getName());
    }

    public void improveRoom(Room room, int impLength, int impWidth){
        room.setLength(room.getLength()+impLength);
        room.setWidth(room.getWidth()+impWidth);
        System.out.println("хозяйка увеличила " + room.getName());
    }
    public void addFurniture(Furniture furniture){
        System.out.println("Хозяйка добавила " + furniture.getName() + " в ресторан");
        restaurant.inventoryAddItem(furniture);
    }
    void addFurniture(Furniture furniture, String roomName) {
        restaurant.getRoom(roomName).inventoryAddItem(furniture);
    }
}
