package Items;

public abstract class Item {
    private final String name;
    private int cost;
    public Item(String name, int cost) {
        this.name = name;
        this.cost = cost;
    }
    public void setCost(int cost){
        this.cost = cost;
    }

    public int getCost() {
        return cost;
    }

    public String getName(){
        return name;
    }
}