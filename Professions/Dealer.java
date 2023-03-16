package Professions;

import Items.Inventory;
import Items.Item;
import Items.Salt;
import Items.Wallet;

public class Dealer extends Profession {
    private final Inventory inventory;
    public Dealer(Wallet wallet, Inventory inventory) {
        super(ProfessionsTypes.DEALER, wallet);
        this.inventory = inventory;
    }
    public Dealer(Wallet wallet, Inventory inventory, ProfessionsTypes p) {
        super(p, wallet);
        this.inventory = inventory;
    }
    private boolean hasItem(Item item){
        return inventory.hasItem(item);
    }
    public boolean sell(Item item, int cost, String dealerName, String clientName){
        inventory.removeItem(item);
        work(cost);
        System.out.println(dealerName + " продал " + item.getName() + " " + clientName);
        return true;
    }
    public boolean sell(Salt salt, int weight, int cost, String dealerName, String clientName){
        if (hasItem(salt)) {
            salt.setWeight(salt.getWeight() - weight);
            if (salt.getWeight() == 0) {
                inventory.removeItem(salt);
            }
            work(cost);
            System.out.println(dealerName + " продал " + salt.getName() + " " + clientName);
            return true;
        }
        else {
            return false;
        }

    }
}
