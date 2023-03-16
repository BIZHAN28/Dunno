package Items;

import java.util.Objects;

public class Dish extends Item {
    public String name;
    private boolean isSalted=false;
    private boolean isCooked=false;
    public Dish(String name, boolean isSalted, boolean isCooked, int cost) {
        super(name, cost);
        this.name = name;
        this.isSalted = isSalted;
        this.isCooked = isCooked;
    }
    public String getName() {
        return name;
    }
    public boolean isSalted() {
        return isSalted;
    }
    public boolean isCooked() {
        return isCooked;
    }
    public void setSalted(boolean salted) {
        isSalted = salted;
    }
    public void setCooked(boolean cooked) {
        isCooked = cooked;
    }
    public void cook() {
        isCooked = true;
    }
    public void salt() {
        isSalted = true;
    }

    //override toString, equals and hashCode methods
    //override toString hashCode and equals methods
    @Override
    public String toString() {
        return "Items.Dishes{" +
                "name='" + name + '\'' +
                ", isSalted=" + isSalted +
                ", isCooked=" + isCooked +
                '}';
    }
    @Override
    public int hashCode() {
        return name.hashCode() + (isSalted ? 1 : 0) + (isCooked ? 1 : 0);
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dish dish = (Dish)o;
        return isSalted == dish.isSalted &&
                isCooked == dish.isCooked &&
                Objects.equals(name, dish.name);
    }

}
