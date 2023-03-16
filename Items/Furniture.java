package Items;

import java.util.Objects;

public class Furniture extends Item {
    private String name;
    public Furniture(String name, int cost) {
        super(name, cost);
        this.name = name;
    }

    public String getName() {
        return name;
    }
    //override toString hashCode and equals methods
    @Override
    public String toString() {
        return "Items.Furniture{" +
                "name='" + name + '\'' +
                '}';
    }
    @Override
    public int hashCode() {
        return name.hashCode();
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Furniture furniture = (Furniture)o;
        return Objects.equals(name, furniture.name);
    }
}
