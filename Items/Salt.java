package Items;

import Professions.Profession;
import Professions.ProfessionsTypes;

public class Salt extends Item {
    private int weight;
    private boolean raw;
    public Salt(int weight, boolean raw, int cost) {
        super("соль", cost);
        this.weight = weight;
        this.raw = raw;
    }
    public Salt( int weight, int cost) {
        super("соль", cost);
        this.weight = weight;
        this.raw = false;
    }
    public void setWeight(int weight){
        this.weight = weight;
    }
    public int getWeight(){
        return weight;
    }
    public void setRaw(boolean raw){
        this.raw = raw;
    }
    //override equals, hashCode and toString methods
    @Override
    public String toString() {
        return "Items.Salt{" +
                "weight=" + weight +
                ", raw=" + raw +
                '}';
    }
    @Override
    public int hashCode() {
        return weight * (raw ? 2 : 1);
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Salt salt = (Salt)o;
        return weight == salt.weight &&
                raw == salt.raw;
    }
}

