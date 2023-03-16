package Items;

public class Table extends Furniture{
    private Inventory inventory = new Inventory();
    public Table(String name, int cost){
        super(name, cost);
    }

    public void place(Item item){
        inventory.addItem(item);
    }
    public void take(Item item){
        inventory.removeItem(item);
    }
    public Item getItem(String itemName){
        return inventory.getItem(itemName);
    }
}
